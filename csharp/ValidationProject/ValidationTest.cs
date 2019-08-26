using System;
using System.Collections.Generic;
using System.Text;
using Xunit;
using ApprovalTests;
using ApprovalTests.Combinations;
using ApprovalTests.Reporters;

namespace Validation
{
    [UseReporter(typeof(DiffReporter))]
    public class ValidationTest
    {
        [Fact]
        void ValidateAndAdd() {
            
            CombinationApprovals.VerifyAllCombinations(DoValidateAndAdd,
                new string[]{"", "Sample product", "Sample Queen product"},
                new string[]{"", "Lipstick", "Eyeshadow", "Mascara", "Blusher", "Foundation", "Unknown"},
                new double[]{-1D, 5D, 11D},
                new double[]{10D, 11D, 21D, 26D},
                new bool[]{false, true});

        }

        private string DoValidateAndAdd(string name, string type, double weight, double suggestedPrice,
            bool packagingRecyclable)
        {
            var productData = new ProductFormData(name,
                type, weight, suggestedPrice, packagingRecyclable);
            var db = new FakeDatabase();
            var sut = new ProductService(db);

            // Act
            var response = sut.ValidateAndAdd(productData);

            // Assert
            var productString = "";
            if (db.Product != null)
            {
                productString = db.Product.ToString();
            }

            var responseAndProduct = response + " " + productString;
            return responseAndProduct;
        }
    }
}
