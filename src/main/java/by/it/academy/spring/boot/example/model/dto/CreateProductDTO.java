package by.it.academy.spring.boot.example.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateProductDTO implements Serializable {
    private Long manufacturer;
    private String model;
    private Double price;
}
