#ifndef VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_PRODUCT_H
#define VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_PRODUCT_H


#include <string>


enum ProductFamily {
    EYES,
    LIPS,
    LASHES,
    SKIN
};

enum ProductRange {
    QUEEN,
    BUDGET,
    PROFESSIONAL
};

class Product {

public:
    explicit Product(std::string name);
    std::string name;
    std::string type;
    ProductFamily family;
    ProductRange range;
    float weight;
    std::string to_string();
};



#endif //VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_PRODUCT_H
