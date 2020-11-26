#include <ProductFormData.h>
#include <ProductService.h>
#include "doctest.h"
#include "ApprovalTests.hpp"
#include "FakeDatabase.h"

static string doValidateAndAdd(const string &name, const string &productType, int weight, int suggestedPrice,
                               bool packagingRecyclable);

TEST_CASE ("test_validate_and_add")
{
    const std::string name = "Sample product";
    const std::string productType = "Lipstick";
    int weight = 5;
    int suggestedPrice = 10;
    bool packagingRecyclable = false;
    string responseAndProduct = doValidateAndAdd(name, productType, weight, suggestedPrice, packagingRecyclable);

    Approvals::verify(responseAndProduct);
}

static string doValidateAndAdd(const string &name, const string &productType, int weight, int suggestedPrice,
                               bool packagingRecyclable) {
    auto productData = new ProductFormData(name, productType, weight, suggestedPrice, packagingRecyclable);
    auto db = new FakeDatabase();
    auto sut = new ProductService(db);

    Response response = sut->validateAndAdd(productData);

    std::string responseAndProduct;
    responseAndProduct.append(response.to_string());
    if (db->product) {
        responseAndProduct.append(" ");
        responseAndProduct.append(db->product->to_string());
    }
    return responseAndProduct;
}
