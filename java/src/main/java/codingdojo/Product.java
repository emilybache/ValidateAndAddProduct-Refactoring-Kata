package codingdojo;

public class Product {

    private String name;
    private String type;
    private double weight;
    private ProductFamily family;
    private ProductRange range;

    public Product(String name, String type, double weight, ProductFamily family, ProductRange range) {

        this.name = name;
        this.type = type;
        this.weight = weight;
        this.family = family;
        this.range = range;
    }

    public Product(String name) {

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public ProductFamily getFamily() {
        return family;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFamily(ProductFamily family) {
        this.family = family;
    }

    public ProductRange getRange() {
        return range;
    }

    public void setRange(ProductRange range) {
        this.range = range;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
