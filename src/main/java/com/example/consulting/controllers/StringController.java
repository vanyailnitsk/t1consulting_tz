package com.example.consulting.controllers;

import com.example.consulting.services.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

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
    public Map<Character,Integer> getSymbolsFrequency(@RequestParam("str") String str) {
        return stringService.calculateSymbolsFrequency(str);
    }
}
