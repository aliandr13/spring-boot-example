package by.it.academy.spring.boot.example.service;

import by.it.academy.spring.boot.example.model.Manufacturer;
import by.it.academy.spring.boot.example.model.dto.ManufacturerDto;

import java.util.List;

public interface ManufacturerService {

    List<Manufacturer> getAll();

    Manufacturer create(ManufacturerDto dto);
}
