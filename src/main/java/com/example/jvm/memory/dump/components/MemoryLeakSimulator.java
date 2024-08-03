package com.example.jvm.memory.dump.components;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@EnableScheduling
public class MemoryLeakSimulator {

    private List<byte[]> memoryHog = new ArrayList<>();
    private boolean execute = true;

    @Scheduled(fixedDelay = 999999999)
    public void init() {
        while (execute) {
            try {
                memoryHog.add(new byte[1024 * 1024]); // Aloca 1MB de memória repetidamente
            } catch (OutOfMemoryError e) {
                this.execute = false;
                System.out.println("Recovered from OutOfMemoryError, restarting allocation...");
                memoryHog.clear();
                System.out.println("OutOfMemoryError occurred!");
            }
        }
    }
}