project(tests)

add_executable(${PROJECT_NAME}
        product_service_test.cpp
        FakeDatabase.h FakeDatabase.cpp
        ../ProductFormData.h ../ProductFormData.cpp
        ../ProductService.h ../ProductService.cpp
        ../Product.h ../Product.cpp
        ../IDatabase.h
        ../Response.h ../Response.cpp
        main.cpp)

target_include_directories(
        ${PROJECT_NAME}
        PUBLIC
        ../third_party ..)

enable_testing()
add_test(NAME ${PROJECT_NAME}_test COMMAND ${PROJECT_NAME})