namespace Validation
{
    internal class ProductFormData
    {
        public string Name { get; }
        public string Type { get; }
        public double Weight { get; }
        public double SuggestedPrice { get; }
        public bool PackagingRecyclable { get; }

        public ProductFormData(string name, string type, double weight, double suggestedPrice, bool packagingRecyclable)
        {
            Name = name;
            Type = type;
            Weight = weight;
            SuggestedPrice = suggestedPrice;
            PackagingRecyclable = packagingRecyclable;
        }
    }
}