package codingdojo;

import org.junit.jupiter.api.Test;

import static org.approvaltests.Approvals.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductServiceTest {
    @Test
    void validateAndAdd() {
        // Arrange
        String name = "Sample product";
        String productType = "Lipstick";
        double weight = 5D;
        double suggestedPrice = 10D;
        boolean packagingRecyclable = false;

        // Act
        String responseAndProduct = doValidateAndAdd(name, productType, weight, suggestedPrice, packagingRecyclable);

        // Assert
        verify(responseAndProduct);
    }

    private String doValidateAndAdd(String name, String productType, double weight, double suggestedPrice, boolean packagingRecyclable) {
        ProductFormData productData = new ProductFormData(name,
                productType, weight, suggestedPrice, packagingRecyclable);
        FakeDatabase db = new FakeDatabase();
        ProductService sut = new ProductService(db);

        Response response = sut.validateAndAdd(productData);

        String productString = "";
        if (db.product != null) {
            productString = db.product.toString();
        }
        String responseAndProduct = response.toString() + " " + productString;
        return responseAndProduct;
    }

    class FakeDatabase extends DatabaseAccess {
        private Product product;

        @Override
        public int storeProduct(Product product) {
            this.product = product;
            return 1;
        }
    }

}
