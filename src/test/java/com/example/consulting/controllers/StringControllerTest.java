package com.example.consulting.controllers;

import com.example.consulting.services.StringService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StringControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private StringService stringService;
    @Test
    void getSymbolsFrequency() throws Exception {
        String validInput = "dcbcabbddd";
        mockMvc.perform(get("/api/string/symbols-frequency")
                        .param("str", validInput))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.d").value(4))
                .andExpect(jsonPath("$.c").value(2))
                .andExpect(jsonPath("$.b").value(3))
                .andExpect(jsonPath("$.a").value(1))
                .andExpect(content().string("{\"d\":4,\"b\":3,\"c\":2,\"a\":1}"));
    }

    @Test
    public void testMissingParameter() throws Exception {
        mockMvc.perform(get("/api/string/symbols-frequency"))
                .andExpect(status().isBadRequest())
                .andExpect(status().reason("Required parameter 'str' is not present."));
    }
    @Test()
    public void testEmptyString() throws Exception {
        mockMvc.perform(get("/api/string/symbols-frequency")
                        .param("str", ""))
                .andExpect(status().isBadRequest())
                .andExpect(status().reason("String should not be empty!"));
    }
}