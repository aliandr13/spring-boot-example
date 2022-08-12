package by.it.academy.spring.boot.example.service.impl;

import by.it.academy.spring.boot.example.model.Manufacturer;
import by.it.academy.spring.boot.example.model.dto.ManufacturerDto;
import by.it.academy.spring.boot.example.repository.ManufacturerRepository;
import by.it.academy.spring.boot.example.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer create(ManufacturerDto dto) {
        return manufacturerRepository.save(convert(dto));
    }

    private Manufacturer convert(ManufacturerDto dto) {
        return Manufacturer.builder()
                .name(dto.getName())
                .build();
    }
}
