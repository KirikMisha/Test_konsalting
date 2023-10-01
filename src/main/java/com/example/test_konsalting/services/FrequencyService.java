package com.example.test_konsalting.services;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FrequencyService {

    public Map<Character, Integer> countCharacterFrequency(String input) {
        // Создаем пустой словарь для хранения частоты символов
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Проходим по каждому символу в строке
        for (char c : input.toCharArray()) {
            // Если символ уже есть в словаре, увеличиваем его частоту на 1
            // В противном случае, добавляем символ в словарь с частотой 1
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Сортируем результаты по убыванию частоты символов
        return frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}