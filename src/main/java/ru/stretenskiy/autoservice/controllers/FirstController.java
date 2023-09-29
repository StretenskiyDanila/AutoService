package ru.stretenskiy.autoservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hi")
    public String getHi() {
        return "first/hi";
    }

    @GetMapping("/source")
    public String getHello() {
        return "first/hello";
    }
}
