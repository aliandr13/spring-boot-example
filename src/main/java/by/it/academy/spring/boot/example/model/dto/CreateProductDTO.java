package by.it.academy.spring.boot.example.model.dto;

import lombok.Data;

@Data
public class CreateProductDTO {
    private String manufacturer;
    private String model;
    private Double price;
}
