using System;
using System.Collections.Generic;
using System.Text;
using Xunit;
using ApprovalTests;
using ApprovalTests.Reporters;

namespace Validation
{
    [UseReporter(typeof(DiffReporter))]
    public class ValidationTest
    {
        [Fact]
        void ValidateAndAdd() {
            // Arrange
            var productData = new ProductFormData("Sample product",
                "Lipstick", 5D, 10D, false);
            var db = new FakeDatabase();
            var sut = new ProductService(db);

            // Act
            var response = sut.ValidateAndAdd(productData);

            // Assert
            var productString = "";
            if (db.Product != null) {
                productString = db.Product.ToString();
            }
            var responseAndProduct = response + " " + productString;
            Approvals.Verify(responseAndProduct);

        }

    }
}
