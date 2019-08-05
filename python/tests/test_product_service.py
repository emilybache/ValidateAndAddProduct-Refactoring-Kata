from approvaltests import verify

from database import DatabaseAccess
from product_service import validate_and_add
from response import ProductFormData


class FakeDatabase(DatabaseAccess):
    def __init__(self):
        self.product = None

    def store_product(self, product):
        self.product = product
        return 1


def test_validate_and_add():
    # Arrange
    product_data = ProductFormData("Sample product", "Lipstick", 5, 10, False)
    db = FakeDatabase()

    # Act
    response = validate_and_add(product_data, db)

    # Assert
    response_and_product = f"{response} {db.product}"
    verify(response_and_product)
