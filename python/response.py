
class ProductFormData:

    def __init__(self, name, product_type, weight, suggested_price, packaging_recyclable):
        self.name = name
        self.product_type = product_type
        self.weight = weight
        self.suggested_price = suggested_price
        self.packaging_recyclable = packaging_recyclable


class Response:
    """Sent to the client to indicate whether the new product was added successfully."""

    def __init__(self, product_id, status_code, message):
        self.product_id = product_id
        self.status_code = status_code
        self.message = message

    def __repr__(self) -> str:
        return f"Response("\
               f"productId={self.product_id},"\
               f" statusCode={self.status_code}"\
               f" message='{self.message}'"\
               ')'

