namespace Validation
{
    public class Response
    {
        public int ProductId { get; }
        public int StatusCode { get; }
        public string Message { get; }

        public Response(int productId, int statusCode, string message)
        {
            ProductId = productId;
            StatusCode = statusCode;
            Message = message;
        }

        public override string ToString()
        {
            return "Response{" +
                   "productId=" + ProductId +
                   ", statusCode=" + StatusCode +
                   ", message='" + Message + '\'' +
                   '}';
        }
    }
}