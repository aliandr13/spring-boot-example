package by.it.academy.spring.boot.example.repository;

import by.it.academy.spring.boot.example.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();

    @Modifying
    @Query(value = "delete from Product p  where p.id = :productId", nativeQuery = false)
    void deleteById(@Param("productId") Long productId);

}
