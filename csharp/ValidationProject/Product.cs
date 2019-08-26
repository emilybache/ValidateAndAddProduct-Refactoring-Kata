namespace Validation
{
    public class Product
    {
        public string Name { get; }
        public string Type { get; set; }
        public ProductFamily Family { get; set; }
        public ProductRange Range { get; set; }
        public double Weight { get; set; }

        public Product(string name)
        {
            Name = name;
        }

        public override string ToString()
        {
            return "Product{" +
                   "name='" + Name + '\'' +
                   ", type='" + Type + '\'' +
                   ", weight=" + Weight +
                   ", family=" + Family +
                   ", range=" + Range +
                   '}';
        }
    }

    public enum ProductRange
    {
        QUEEN,
        BUDGET,
        PROFESSIONAL
    }

    public enum ProductFamily
    {
        EYES,
        LIPS,
        LASHES,
        SKIN
    }
}