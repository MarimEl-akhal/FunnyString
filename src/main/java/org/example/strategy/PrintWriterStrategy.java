package org.example.strategy;

import java.io.PrintWriter;

public class PrintWriterStrategy implements OutputStrategy {
    private PrintWriter printWriter;

    public PrintWriterStrategy(PrintWriter printWriter){
        this.printWriter=printWriter;
    }

    @Override
    public void print(String message) {
        printWriter.println(message);
    }
}
