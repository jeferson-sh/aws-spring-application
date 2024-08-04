package com.example.jvm.memory.dump.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Log4j2
public class MemoryLeakSimulator {

    private List<byte[]> memoryHog = new ArrayList<>();
    private boolean execute = true;


    public void errorMemory() {
        CompletableFuture.runAsync(() -> {
            while (execute) {
                try {
                    memoryHog.add(new byte[1024 * 1024]); // Aloca 1MB de memória repetidamente
                } catch (OutOfMemoryError e) {
                    this.execute = false;
                    log.error("Recovered from OutOfMemoryError, restarting allocation...");
                    memoryHog.clear(); // Libera a memória alocada
                    System.gc(); // Sugere a execução do coletor de lixo
                    log.error("OutOfMemoryError occurred!");
                }
            }
        });
    }
}