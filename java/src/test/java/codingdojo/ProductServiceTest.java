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

        String toVerify = doValidateAndAdd(name, type, weight, price, recyclable);

        verify(toVerify);
    }

    private String doValidateAndAdd(String name, String type, double weight, double price, boolean recyclable) {
        ProductFormData productData = new ProductFormData(name, type, weight, price, recyclable);
        FakeDatabase db = new FakeDatabase();
        ProductService sut = new ProductService(db);
        Response response = sut.validateAndAdd(productData);
        String responseString = "Response("
                + response.getProductId() + ", "
                + response.getStatusCode() + ", "
                + response.getErrorMessage()
                + ")";
        String productString = "Product("
                + db.product.getName() + ", "
                + db.product.getType() + ", "
                + db.product.getWeight() + ", "
                + db.product.getFamily() + ", "
                + db.product.getRange()
                + ")";
        return responseString + " " + productString;
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
