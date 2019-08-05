package codingdojo;

public class ProductService {

    private DatabaseAccess db;

    public ProductService(DatabaseAccess db) {
        this.db = db;
    }

    /**
     * Processes new product form data, validates that it is correct.
     * If it is correct, add the new product to the database.
     */
    public Response validateAndAdd(ProductFormData productData) {
        if (productData.getName() == null || "".equals(productData.getName())) {
            return new Response(0, -2, "Missing Name");
        }
        if (productData.getType() == null || "".equals(productData.getType()) ) {
            return new Response(0, -2, "Missing Type");
        }
        Product product = new Product(productData.getName());
        product.setType("Unknown");

        if ("Eyeshadow".equals(productData.getType()) || "Mascara".equals(productData.getType())) {
            product.setType(productData.getType());
            product.setFamily(ProductFamily.EYES);
        }
        product.setRange(ProductRange.BUDGET);
        if (productData.isPackagingRecyclable()) {
            product.setRange(ProductRange.PROFESSIONAL);
        }

        if ("Lipstick".equals(productData.getType())) {
            product.setType(productData.getType());
            product.setFamily(ProductFamily.LIPS);
            if (productData.getSuggestedPrice() > 10) {
                product.setRange(ProductRange.PROFESSIONAL);
            } else if (productData.getSuggestedPrice() > 20) {
                if (productData.getWeight() < 10) {
                    return new Response(0, -1, "Error - failed quality check for Queen Range");
                }
                product.setRange(ProductRange.QUEEN);
            }
        }

        if ("Mascara".equals(productData.getType())) {
            product.setFamily(ProductFamily.LASHES);
            if (productData.getSuggestedPrice() > 15) {
                product.setRange(ProductRange.PROFESSIONAL);
            } else if (productData.getSuggestedPrice() > 25 && productData.isPackagingRecyclable()) {
                product.setRange(ProductRange.QUEEN);
            }
        }

        if (productData.getWeight() < 0) {
            return new Response(0, -3, "Weight error");
        }
        product.setWeight(productData.getWeight());

        if ("Blusher".equals(productData.getType()) || "Foundation".equals(productData.getType())) {
            product.setType(productData.getType());
            product.setFamily(ProductFamily.SKIN);
            if ("Foundation".equals(productData.getType()) && product.getName().contains("Queen")) {
                product.setRange(ProductRange.QUEEN);
            }
            if ("Blusher".equals(productData.getType()) && productData.getWeight() > 25) {
                return new Response(0, -3, "Error - weight too high");
            }
        }

        if (!productData.isPackagingRecyclable() && product.getRange() == ProductRange.QUEEN) {
            return new Response(0, -1, "Error - failed quality check for Queen Range");
        }

        if ("Unknown".equals(product.getType())) {
            return new Response(0, -1, "Unknown product type " + productData.getType());
        }

        return new Response(db.storeProduct(product), 0, "");
    }
}
