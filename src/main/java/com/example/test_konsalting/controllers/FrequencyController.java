package com.example.test_konsalting.controllers;

import com.example.test_konsalting.services.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/frequency")
public class FrequencyController {

    private final FrequencyService frequencyService;

    @Autowired
    public FrequencyController(FrequencyService frequencyService) {
        this.frequencyService = frequencyService;
    }

    @GetMapping("/count")
    public ResponseEntity<?> countCharacterFrequency(@RequestParam("input") String input) {
        if (input == null || input.isEmpty()) {
            Map<String, String> errorResponse = Collections.singletonMap("error", "Вы ввели пустую строку");
            return ResponseEntity.badRequest().body(errorResponse);
        }
        Map<Character, Integer> frequencyMap = frequencyService.countCharacterFrequency(input);
        return ResponseEntity.ok(frequencyMap);
    }


}