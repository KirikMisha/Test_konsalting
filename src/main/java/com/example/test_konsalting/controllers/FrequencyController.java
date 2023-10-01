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
        // Проверяем, является ли строка пустой
        if (input == null || input.isEmpty()) {
            // Возвращаем ошибку с соответствующим статусом
            Map<String, String> errorResponse = Collections.singletonMap("error", "Вы ввели пустую строку");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        // Вызываем сервисный метод для подсчета частоты символов
        Map<Character, Integer> frequencyMap = frequencyService.countCharacterFrequency(input);

        // Возвращаем успешный результат с частотой символов
        return ResponseEntity.ok(frequencyMap);
    }


}