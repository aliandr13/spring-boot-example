package by.it.academy.spring.boot.example.controller.api;

import by.it.academy.spring.boot.example.model.Manufacturer;
import by.it.academy.spring.boot.example.model.dto.ManufacturerDto;
import by.it.academy.spring.boot.example.service.ManufacturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/manufacturers", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManufacturerController {

    private final ManufacturerService manufacturerService;


    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public List<Manufacturer> getAll() {
        return manufacturerService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Manufacturer create(@RequestBody ManufacturerDto dto) {
        return manufacturerService.create(dto);
    }

}
