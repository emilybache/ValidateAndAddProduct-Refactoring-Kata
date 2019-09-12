#ifndef VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_IDATABASE_H
#define VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_IDATABASE_H


#include "Product.h"

class IDatabase {

public:
    IDatabase() = default;

    virtual int storeProduct(Product *product) = 0;
};


#endif //VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_IDATABASE_H
