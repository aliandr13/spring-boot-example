package by.it.academy.spring.boot.example.service;

import by.it.academy.spring.boot.example.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    void deleteProduct(Long id);

    Product createProduct(Product product);

    Product updateProduct(Product product);


}
