namespace Validation
{
    internal class FakeDatabase : IDatabaseAccess
    {
        public Product Product { get; set; }
        public int storeProduct(Product product)
        {
            Product = product;
            return 0;
        }
    }
}