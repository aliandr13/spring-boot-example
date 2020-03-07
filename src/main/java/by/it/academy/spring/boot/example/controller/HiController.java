package by.it.academy.spring.boot.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @GetMapping(value = "/hi")
    public String sayHi() {
        return "Hi!!!";
    }

}
