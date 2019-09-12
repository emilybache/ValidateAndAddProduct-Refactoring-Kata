cmake_minimum_required(VERSION 3.4)
project(validate_and_add_product_refactoring_kata)

set(CMAKE_CXX_STANDARD 11)

add_executable(${PROJECT_NAME}
        ProductService.h ProductService.cpp
        ProductFormData.h ProductFormData.cpp
        Product.h Product.cpp
        Response.cpp Response.h
        IDatabase.h)

add_subdirectory(tests)
