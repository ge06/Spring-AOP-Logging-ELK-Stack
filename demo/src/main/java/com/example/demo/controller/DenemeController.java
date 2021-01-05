package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deneme")
public class DenemeController {

    @GetMapping
    public double getResult(@RequestParam(name = "x") double x, @RequestParam(name = "y") double y) {
        x= Double.parseDouble(null);
        return x/y;
    }
}
