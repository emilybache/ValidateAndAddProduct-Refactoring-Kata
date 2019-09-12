#include <ProductFormData.h>
#include <ProductService.h>
#include "doctest.h"
#include "ApprovalTests.hpp"
#include "FakeDatabase.h"

TEST_CASE ("test_validate_and_add") {
    auto productData = new ProductFormData("Sample product", "Lipstick", 5, 10, false);
    auto db = new FakeDatabase();
    auto sut = new ProductService(db);

    Response response = sut->validateAndAdd(productData);

    std::string responseAndProduct;
    responseAndProduct.append(response.to_string());
    responseAndProduct.append(" ");
    responseAndProduct.append(db->product->to_string());

    Approvals::verify(responseAndProduct);
}