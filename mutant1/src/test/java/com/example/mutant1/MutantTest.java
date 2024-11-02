package com.example.mutant1;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import service1.MutantService;

@SpringBootTest
class Mutants {

    @Autowired
    private MutantService service;

    @Test
    void contextLoads() {
    }
}
