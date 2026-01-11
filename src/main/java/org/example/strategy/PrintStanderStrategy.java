package org.example.strategy;

public class PrintStanderStrategy implements OutputStrategy {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
