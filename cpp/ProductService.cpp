#include "ProductService.h"
#include "ProductFormData.h"
#include "Product.h"

ProductService::ProductService(IDatabase * database) : db(database) {

}

Response ProductService::validateAndAdd(ProductFormData *productData) {
    if (productData->name.empty())
    {
        return Response(0, -2, "Missing Name");
    }

    if (productData->type.empty())
    {
        return Response(0, -2, "Missing Type");
    }

    auto product = new Product(productData->name);
    product->type = ("Unknown");

    if ("Eyeshadow" == (productData->type) || "Mascara" == (productData->type))
    {
        product->type = (productData->type);
        product->family = ProductFamily::EYES;
        if ("Eyeshadow" == (productData->type) && product->name.find("Queen") != std::string::npos)
        {
            product->range = (ProductRange::QUEEN);
        }
    }

    product->range = (ProductRange::BUDGET);
    if (productData->packagingRecyclable)
    {
        product->range = (ProductRange::PROFESSIONAL);
    }

    if ("Foundation" == (productData->type))
    {
        if (productData->suggestedPrice > 10)
        {
            product->range = (ProductRange::PROFESSIONAL);
        }
    }

    if ("Lipstick" == (productData->type))
    {
        product->type = (productData->type);
        product->family = (ProductFamily::LIPS);
        if (productData->suggestedPrice > 10)
        {
            product->range = (ProductRange::PROFESSIONAL);
        }

        if (productData->suggestedPrice > 20)
        {
            if (productData->weight > 0 && productData->weight < 10)
            {
                return Response(0, -1, "Error - failed quality check for Queen Range");
            }

            product->range = (ProductRange::QUEEN);
        }
    }

    if ("Mascara" == (productData->type))
    {
        product->family = (ProductFamily::LASHES);
        if (productData->suggestedPrice > 15)
        {
            product->range = (ProductRange::PROFESSIONAL);
        }

        if (productData->suggestedPrice > 25 && productData->packagingRecyclable)
        {
            product->range = (ProductRange::QUEEN);
        }
    }

    if (productData->weight < 0)
    {
        return Response(0, -3, "Weight error");
    }

    product->weight = (productData->weight);

    if ("Blusher" == (productData->type) || "Foundation" == (productData->type))
    {
        product->type = (productData->type);
        product->family = (ProductFamily::SKIN);
        if ("Blusher" == (productData->type) && productData->weight > 10)
        {
            return Response(0, -3, "Error - weight too high");
        }
    }

    if (!productData->packagingRecyclable && product->range == ProductRange::QUEEN)
    {
        return Response(0, -1, "Error - failed quality check for Queen Range");
    }

    if ("Unknown" == (product->type))
    {
        return Response(0, -1, "Unknown product type " + productData->type);
    }

    return Response(db->storeProduct(product), 0, "Product Successfully Added");

}
