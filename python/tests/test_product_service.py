from approvaltests import verify_all_combinations

from database import DatabaseAccess
from product_service import validate_and_add
from response import ProductFormData


class FakeDatabase(DatabaseAccess):
    def __init__(self):
        self.product = None

    def store_product(self, product):
        self.product = product
        return 1


def do_validate_and_add(name, product_type, weight, price, recyclable):
    product_data = ProductFormData(name, product_type, weight, price, recyclable)
    db = FakeDatabase()
    response = validate_and_add(product_data, db)
    return f"{response} {db.product}"


def test_validate_and_add():
    verify_all_combinations(do_validate_and_add,
                            [["", "Sample product", "Sample Queen product"],
                             ["", "Lipstick", "Eyeshadow", "Mascara", "Blusher", "Foundation", "Unknown"],
                             [-1, 5, 11],
                             [10, 11, 21, 26],
                             [False, True]
                             ]
                            )
