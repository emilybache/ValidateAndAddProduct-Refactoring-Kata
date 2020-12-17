package codingdojo;

/**
 * Received from the client with all the details of the new product to be added to the catalogue.
 */
public class ProductFormData {
    private final String name;
    private String type;
    private final double weight;
    private final double suggestedPrice;
    private final boolean packagingRecyclable;

    public ProductFormData(String name, String type, double weight,
                           double suggestedPrice, boolean packagingRecyclable) {

        this.name = name;
        this.type = type;
        this.weight = weight;
        this.suggestedPrice = suggestedPrice;
        this.packagingRecyclable = packagingRecyclable;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getSuggestedPrice() {
        return suggestedPrice;
    }

    public boolean  isPackagingRecyclable() {
        return packagingRecyclable;
    }
}
