package org.example.inputOutputSystem.output;

public class PrintStanderStrategy implements OutputStrategy {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
