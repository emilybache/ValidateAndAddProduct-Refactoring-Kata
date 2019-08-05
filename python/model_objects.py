from enum import Enum


class Product:
    def __init__(self, name,
                 product_type=None, weight=None, product_family=None, product_range=None):
        self.name = name
        self.product_type = product_type
        self.weight = weight
        self.product_family = product_family
        self.product_range = product_range


    def __repr__(self) -> str:
        return f"Product(name='{self.name}',"\
               f" type='{self.product_type}',"\
               f" weight={self.weight},"\
               f" family={self.product_family},"\
               f" range={self.product_range}'"\
               ")"


class ProductFamily(Enum):
    EYES = 1
    LASHES = 2
    LIPS = 3
    SKIN = 4


class ProductRange(Enum):
    BUDGET = 1
    PROFESSIONAL = 2
    QUEEN = 3
