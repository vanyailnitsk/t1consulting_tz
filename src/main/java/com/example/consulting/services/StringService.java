package com.example.consulting.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StringService {
    public Map<Character, Integer> calculateSymbolsFrequency(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("String should not be empty!");
        }
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return sortByValueDescending(frequencyMap);
    }

    public Map<Character, Integer> sortByValueDescending(Map<Character, Integer> map) {
        return map.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
}
