package codingdojo;

/**
 * Sent to the client to indicate whether the new product was added successfully.
 */
public class Response {
    private final int productId;
    private final int statusCode;
    private final String message;

    public Response(int productId, int statusCode, String message) {

        this.productId = productId;
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getProductId() {
        return productId;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "productId=" + productId +
                ", statusCode=" + statusCode +
                ", message='" + message + '\'' +
                '}';
    }
}
