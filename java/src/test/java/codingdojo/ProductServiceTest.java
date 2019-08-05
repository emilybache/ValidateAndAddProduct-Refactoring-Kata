package codingdojo;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static org.approvaltests.Approvals.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductServiceTest {
    @Test
    void validateAndAdd() {

        CombinationApprovals.verifyAllCombinations(this::doValidateAndAdd,
                new String[]{"", "Sample product", "Sample Queen product"},
                new String[]{"", "Lipstick", "Eyeshadow", "Mascara", "Blusher", "Foundation", "Unknown"},
                new Double[]{-1D, 5D, 11D},
                new Double[]{10D, 11D, 21D, 26D},
                new Boolean[]{false, true}
                );
    }

    private String doValidateAndAdd(String name, String type, Double weight, Double price, Boolean recyclable) {
        ProductFormData productData = new ProductFormData(name, type, weight, price, recyclable);
        FakeDatabase db = new FakeDatabase();
        ProductService sut = new ProductService(db);
        Response response = sut.validateAndAdd(productData);
        String responseString = "Response("
                + response.getProductId() + ", "
                + response.getStatusCode() + ", "
                + response.getErrorMessage()
                + ")";
        String productString = "";
        if (db.product != null) {
            productString = "Product("
                    + db.product.getName() + ", "
                    + db.product.getType() + ", "
                    + db.product.getWeight() + ", "
                    + db.product.getFamily() + ", "
                    + db.product.getRange()
                    + ")";
        }
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
