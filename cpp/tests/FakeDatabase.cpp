#include "FakeDatabase.h"

int FakeDatabase::storeProduct(Product *aProduct) {
    product = aProduct;
    return 0;
}
