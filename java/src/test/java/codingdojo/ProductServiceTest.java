package codingdojo;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static org.approvaltests.Approvals.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductServiceTest {
    @Test
    void validateAndAdd() {
        CombinationApprovals.verifyBestCoveringPairs(this::doValidateAndAdd,
                new String [] {"Sample product", "", "Queen"},
                new String [] {"Lipstick", "", "Eyeshadow", "Foundation", "Mascara", "Blusher", "Unknown"},
                new Double [] {5D, 8D, 11D, -2D},
                new Double [] {10D, 11D, 21D, 26D},
                new Boolean [] {false, true});

    }

    private String doValidateAndAdd(String name, String lipstick, double weight, double suggestedPrice, boolean packagingRecyclable) {
        ProductFormData productData = new ProductFormData(name,
                lipstick, weight, suggestedPrice, packagingRecyclable);
        FakeDatabase db = new FakeDatabase();
        ProductService sut = new ProductService(db);

        // Act
        Response response = sut.validateAndAdd(productData);

        // Print
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
