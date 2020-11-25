package codingdojo;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static org.approvaltests.Approvals.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductServiceTest {
    @Test
    void validateAndAdd() {

        CombinationApprovals.verifyAllCombinations(this::doValidateAndAdd,
                new String[] {"", "Sample product", "Sample Queen Product"},
                new String[] {"", "Lipstick", "Eyeshadow", "Mascara", "Foundation", "Unknown", "Blusher"},
                new Double[] {-1D, 5D, 10D, 11D},
                new Double[] {10D, 11D, 21D, 26D},
                new Boolean[] {true, false}
        );
    }

    private String doValidateAndAdd(String name, String productType, double weight, double suggestedPrice, boolean packagingRecyclable) {
        ProductFormData productData = new ProductFormData(name,
                productType, weight, suggestedPrice, packagingRecyclable);
        FakeDatabase db = new FakeDatabase();
        ProductService sut = new ProductService(db);

        Response response = sut.validateAndAdd(productData);

        String responseAndProduct = response.toString();
        if (db.product != null) {
            responseAndProduct += " " + db.product.toString();
        }
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
