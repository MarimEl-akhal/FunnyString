package org.example.strategy.output;

public class PrintStanderStrategy implements OutputStrategy {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
