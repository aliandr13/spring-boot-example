package by.it.academy.spring.boot.example.service.impl;

import by.it.academy.spring.boot.example.model.Manufacturer;
import by.it.academy.spring.boot.example.model.Product;
import by.it.academy.spring.boot.example.model.dto.CreateProductDTO;
import by.it.academy.spring.boot.example.repository.ProductRepository;
import by.it.academy.spring.boot.example.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public List<Product> getProductsByManufacturer(Long manufacturerId) {
        return repository.getProductsByManufacturer(Manufacturer.builder().id(manufacturerId).build());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Product createProduct(CreateProductDTO productDTO) {
        Product product1 = Product.builder()
                .model(productDTO.getModel())
                .price(productDTO.getPrice())
                .manufacturer(Manufacturer.builder().id(productDTO.getManufacturer()).build()).build();
        return repository.save(product1);
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }
}
