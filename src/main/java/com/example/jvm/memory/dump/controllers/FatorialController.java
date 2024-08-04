package com.example.jvm.memory.dump.controllers;

import com.example.jvm.memory.dump.service.MemoryLeakSimulator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequiredArgsConstructor
public class FatorialController {

    private final MemoryLeakSimulator service;

    @GetMapping("/error")
    public void getError(){
        this.service.errorMemory();
    }

    @GetMapping("/factorial")
    public String getFatorial() {
        Random random = new Random();
        int numero = random.nextInt(20) + 1; // Gera um número aleatório entre 1 e 20
        long fatorial = calcularFatorial(numero);
        return "O fatorial de " + numero + " é " + fatorial;
    }

    private long calcularFatorial(int numero) {
        long resultado = 1;
        for (int i = 1; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }
}