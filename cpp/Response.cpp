#include "Response.h"

#include <utility>

Response::Response(int productId, int statusCode, std::string message) : productId(productId), statusCode(statusCode), message(std::move(message)) {

}

std::string Response::to_string() {
    std::string result;
    result.append("Response{productId=");
    result.append(std::to_string(productId));
    result.append(", statusCode=");
    result.append(std::to_string(statusCode));
    result.append(", message='");
    result.append(message);
    result.append("'}");
    return  result;
}


