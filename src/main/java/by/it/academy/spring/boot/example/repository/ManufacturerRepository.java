package by.it.academy.spring.boot.example.repository;

import by.it.academy.spring.boot.example.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}