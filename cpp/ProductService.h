#ifndef VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_PRODUCTSERVICE_H
#define VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_PRODUCTSERVICE_H


#include "Response.h"
#include "IDatabase.h"
#include "ProductFormData.h"

class ProductService {

public:
    explicit ProductService(IDatabase *database);

    Response validateAndAdd(ProductFormData *productData);

private:
    IDatabase *db;
};


#endif //VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_PRODUCTSERVICE_H
