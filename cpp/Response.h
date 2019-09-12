#ifndef VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_RESPONSE_H
#define VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_RESPONSE_H

#include <string>

class Response {
public:
    Response(int productId, int statusCode, std::string message);
    int productId;
    int statusCode;
    std::string message;

    std::string to_string();
};


#endif //VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_RESPONSE_H
