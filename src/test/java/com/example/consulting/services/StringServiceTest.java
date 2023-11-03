package com.example.consulting.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class StringServiceTest {
    private final StringService underTest = new StringService();

    @Test
    void calculateSymbolsFrequency() {
        String test = "aaaaabcccc";
        Map<Character,Integer> expected = new LinkedHashMap<>();
        expected.put('a',5);
        expected.put('c',4);
        expected.put('b',1);
        System.out.println(expected);
        Map<Character,Integer> provided = underTest.calculateSymbolsFrequency(test);
        System.out.println(provided);
        assertThat(expected).isEqualTo(provided);
        List<Map.Entry<Character, Integer>> expectedList = new ArrayList<>(expected.entrySet());
        List<Map.Entry<Character, Integer>> providedList = new ArrayList<>(provided.entrySet());
        assertThat(expectedList).isEqualTo(providedList);
    }

    @Test
    void calculateSymbolsFrequencyEmptyString() {
        String test = "";
        assertThatThrownBy(() -> underTest.calculateSymbolsFrequency(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        "String should not be empty!"
                );
    }

    @Test
    void calculateSymbolsFrequencyNullString() {
        assertThatThrownBy(() -> underTest.calculateSymbolsFrequency(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        "String should not be empty!"
                );
    }

    @Test
    void sortByValueDescending() {
        Map<Character,Integer> expected = new LinkedHashMap<>();
        expected.put('a',5);
        expected.put('c',4);
        expected.put('b',1);
        System.out.println(expected);
        Map<Character,Integer> provided = underTest.sortByValueDescending(expected);
        System.out.println(provided);
        assertThat(expected).isEqualTo(provided);
        List<Map.Entry<Character, Integer>> expectedList = new ArrayList<>(expected.entrySet());
        List<Map.Entry<Character, Integer>> providedList = new ArrayList<>(provided.entrySet());
        assertThat(expectedList).isEqualTo(providedList);
    }
}