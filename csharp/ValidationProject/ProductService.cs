namespace Validation
{
    internal class ProductService
    {
        private readonly IDatabaseAccess _db;

        public ProductService(IDatabaseAccess db)
        {
            _db = db;
        }

        public Response ValidateAndAdd(ProductFormData productData)
        {
            if ("" == (productData.Name))
            {
                return new Response(0, -2, "Missing Name");
            }

            if ("" == (productData.Type))
            {
                return new Response(0, -2, "Missing Type");
            }

            Product product = new Product(productData.Name);
            product.Type = ("Unknown");

            if ("Eyeshadow" == (productData.Type) || "Mascara" == (productData.Type))
            {
                product.Type = (productData.Type);
                product.Family = (ProductFamily.EYES);
                if ("Eyeshadow" == (productData.Type) && product.Name.Contains("Queen"))
                {
                    product.Range = (ProductRange.QUEEN);
                }
            }

            product.Range = (ProductRange.BUDGET);
            if (productData.PackagingRecyclable)
            {
                product.Range = (ProductRange.PROFESSIONAL);
            }

            if ("Foundation" == (productData.Type))
            {
                if (productData.SuggestedPrice > 10)
                {
                    product.Range = (ProductRange.PROFESSIONAL);
                }
            }

            if ("Lipstick" == (productData.Type))
            {
                product.Type = (productData.Type);
                product.Family = (ProductFamily.LIPS);
                if (productData.SuggestedPrice > 10)
                {
                    product.Range = (ProductRange.PROFESSIONAL);
                }

                if (productData.SuggestedPrice > 20)
                {
                    if (productData.Weight > 0 && productData.Weight < 10)
                    {
                        return new Response(0, -1, "Error - failed quality check for Queen Range");
                    }

                    product.Range = (ProductRange.QUEEN);
                }
            }

            if ("Mascara" == (productData.Type))
            {
                product.Family = (ProductFamily.LASHES);
                if (productData.SuggestedPrice > 15)
                {
                    product.Range = (ProductRange.PROFESSIONAL);
                }

                if (productData.SuggestedPrice > 25 && productData.PackagingRecyclable)
                {
                    product.Range = (ProductRange.QUEEN);
                }
            }

            if (productData.Weight < 0)
            {
                return new Response(0, -3, "Weight error");
            }

            product.Weight = (productData.Weight);

            if ("Blusher" == (productData.Type) || "Foundation" == (productData.Type))
            {
                product.Type = (productData.Type);
                product.Family = (ProductFamily.SKIN);
                if ("Blusher" == (productData.Type) && productData.Weight > 10)
                {
                    return new Response(0, -3, "Error - weight too high");
                }
            }

            if (!productData.PackagingRecyclable && product.Range == ProductRange.QUEEN)
            {
                return new Response(0, -1, "Error - failed quality check for Queen Range");
            }

            if ("Unknown" == (product.Type))
            {
                return new Response(0, -1, "Unknown product type " + productData.Type);
            }

            return new Response(_db.storeProduct(product), 0, "Product Successfully Added");
        }
    }
}