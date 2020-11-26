#include <ProductFormData.h>
#include <ProductService.h>
#include "doctest.h"
#include "ApprovalTests.hpp"
#include "FakeDatabase.h"

static string doValidateAndAdd(const string &name, const string &productType, int weight, int suggestedPrice,
                               bool packagingRecyclable);

TEST_CASE ("test_validate_and_add")
{
    CombinationApprovals::verifyAllCombinations(doValidateAndAdd,
                                                std::vector<std::string> {"", "Sample product", "Sample Queen Product"},
                                                std::vector<std::string> {"", "Lipstick", "Eyeshadow", "Mascara", "Foundation", "Unknown", "Blusher"},
                                                std::vector<float> {-1, 5, 10, 11},
                                                std::vector<float> {10, 11, 21, 26},
                                                std::vector<bool> {true, false}
                                                );
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
