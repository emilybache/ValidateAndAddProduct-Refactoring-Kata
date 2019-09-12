#ifndef VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_PRODUCTFORMDATA_H
#define VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_PRODUCTFORMDATA_H


#include <string>

class ProductFormData {

public:
    ProductFormData(std::string name, std::string type, float weight, float suggestedPrice, bool packagingRecyclable);

    std::string name;
    std::string type;
    float weight;
    float suggestedPrice;
    bool packagingRecyclable;
};


#endif //VALIDATE_AND_ADD_PRODUCT_REFACTORING_KATA_PRODUCTFORMDATA_H
