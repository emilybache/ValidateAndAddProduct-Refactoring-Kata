from model_objects import Product, ProductFamily, ProductRange
from response import Response, ProductFormData


def validate_and_add(product_data: ProductFormData, db):
    if product_data.name == "":
        return Response(0, -2, "Missing Name")
    if product_data.product_type == "":
        return Response(0, -2, "Missing Type")

    product = Product(product_data.name)
    product.product_type = "Unknown"

    if "Eyeshadow" == product_data.product_type or "Mascara" == product_data.product_type:
        product.product_type = product_data.product_type
        product.product_family = ProductFamily.EYES
        if "Eyeshadow" == product_data.product_type and product.name.contains("Queen"):
            product.product_range = ProductRange.QUEEN

    product.range = ProductRange.BUDGET
    if product_data.packaging_recyclable:
        product.range = ProductRange.PROFESSIONAL

    if "Foundation" == product_data.product_type:
        if product_data.suggested_price > 10:
            product.range = ProductRange.PROFESSIONAL

    if "Lipstick" == product_data.product_type:
        product.product_type = product_data.product_type
        product.product_family = ProductFamily.LIPS

    if product_data.suggested_price > 10:
        product.range = ProductRange.PROFESSIONAL

    if product_data.suggested_price > 20:
        if 0 < product_data.weight < 10:
            return Response(0, -1, "Error - failed quality check for Queen Range")
        product.range = ProductRange.QUEEN

    if "Mascara" == product_data.product_type:
        product.product_family = ProductFamily.LASHES
        if product_data.suggested_price > 15:
            product.range = ProductRange.PROFESSIONAL

        if product_data.suggested_price > 25 and product_data.packaging_recyclable:
            product.range = ProductRange.QUEEN

    if product_data.weight < 0:
        return Response(0, -3, "Weight error")

    product.weight = product_data.weight

    if "Blusher" == product_data.product_type or "Foundation" == product_data.product_type:
        product.product_type = product_data.product_type
        product.product_family = ProductFamily.SKIN
        if "Blusher" == product_data.product_type and product_data.weight > 10:
            return Response(0, -3, "Error - weight too high")

    if not product_data.packaging_recyclable and product.range == ProductRange.QUEEN:
        return Response(0, -1, "Error - failed quality check for Queen Range")

    if "Unknown" == product.product_type:
        return Response(0, -1, f"Unknown product type {product_data.product_type}")

    return Response(db.store_product(product), 0, "Product Successfully Added")

