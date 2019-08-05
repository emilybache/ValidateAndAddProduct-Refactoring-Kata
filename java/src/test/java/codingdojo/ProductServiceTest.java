package codingdojo;

import org.junit.jupiter.api.Test;

import static org.approvaltests.Approvals.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductServiceTest {
    @Test
    void validateAndAdd() {
        String name = "Sample product";
        String type = "Lipstick";
        double weight = 5;
        double price = 10;
        boolean recyclable = false;

        ProductFormData productData = new ProductFormData(name, type, weight, price, recyclable);
        FakeDatabase db = new FakeDatabase();
        ProductService sut = new ProductService(db);
        Response response = sut.validateAndAdd(productData);
        String toVerify = "Response(" + response.getProductId() + ", " + response.getStatusCode() + ", " + response.getErrorMessage() + ")";

        verify(toVerify);
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
