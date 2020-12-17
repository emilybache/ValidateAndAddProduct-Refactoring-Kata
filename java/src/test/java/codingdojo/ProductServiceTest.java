package codingdojo;

import org.junit.jupiter.api.Test;

import static org.approvaltests.Approvals.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductServiceTest {
    @Test
    void validateAndAdd() {
        // Arrange
        ProductFormData productData = new ProductFormData("Sample product",
                "Lipstick", 5D, 10D, false);
        FakeDatabase db = new FakeDatabase();
        ProductService sut = new ProductService(db);

        // Act
        Response response = sut.validateAndAdd(productData);

        // Assert
        String responseAndProduct = response.toString() + " " + db.product.toString();
        verify(responseAndProduct);

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
