#ifndef VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_FAKEDATABASE_H
#define VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_FAKEDATABASE_H


#include <Product.h>
#include <IDatabase.h>

class FakeDatabase : public IDatabase {
public:
    FakeDatabase() = default;

    int storeProduct(Product *aProduct) override;
    Product *product{};
};


#endif //VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_FAKEDATABASE_H
