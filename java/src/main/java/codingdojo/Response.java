package codingdojo;

/**
 * Sent to the client to indicate whether the new product was added successfully.
 */
public class Response {
    private final int productId;
    private final int statusCode;
    private final String errorMessage;

    public Response(int productId, int statusCode, String errorMessage) {

        this.productId = productId;
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public int getProductId() {
        return productId;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "Response{" +
                "productId=" + productId +
                ", statusCode=" + statusCode +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
