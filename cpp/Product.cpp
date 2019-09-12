#include "Product.h"

#include <utility>

Product::Product(std::string name) : name(std::move(name)) {
}

std::string Product::to_string() {
    std::string result;
    result.append("Product{");
    result.append("name='");
    result.append(name);
    result.append("\'");
    result.append(", type='");
    result.append(type);
    result.append("\'");
    result.append(", weight=");
    result.append(std::to_string(weight));
    result.append(", family=");
    result.append(std::to_string(family));
    result.append(", range=");
    result.append(std::to_string(range));
    result.append("}");
    return result;
}
