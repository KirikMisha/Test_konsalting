package com.example.test_konsalting;

import com.example.test_konsalting.services.FrequencyService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrequencyControllerTest {

    private FrequencyService service;

    @BeforeEach
    public void setUp() {
        this.service = new FrequencyService();
    }

    @Test
    @DisplayName("Test frequency count with a simple string")
    public void testCountCharacterFrequencySimpleString() {
        Map<Character, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put('a', 2);
        expectedResult.put('b', 2);
        expectedResult.put('c', 2);

        Map<Character, Integer> actualResult = this.service.countCharacterFrequency("aabbcc");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test frequency count with special characters")
    public void testCountCharacterFrequencyWithSpecialCharacters() {
        Map<Character, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put('@', 3);
        expectedResult.put('$', 2);

        Map<Character, Integer> actualResult = this.service.countCharacterFrequency("@@@$$");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test frequency count with mixed case characters")
    public void testCountCharacterFrequencyWithMixedCase() {
        Map<Character, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put('a', 2);
        expectedResult.put('A', 1);
        expectedResult.put('b', 3);

        Map<Character, Integer> actualResult = this.service.countCharacterFrequency("aabbbA");

        assertEquals(expectedResult, actualResult);
    }
}
