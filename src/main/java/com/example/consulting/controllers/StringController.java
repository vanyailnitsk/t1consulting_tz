package com.example.consulting.controllers;

import com.example.consulting.services.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/string")
public class StringController {
    private final StringService stringService;

    @Autowired
    public StringController(StringService stringService) {
        this.stringService = stringService;
    }

    @GetMapping("/symbols-frequency")
    public Map<Character, Integer> getSymbolsFrequency(@RequestParam("str") String str) {
        return stringService.calculateSymbolsFrequency(str);
    }
}
