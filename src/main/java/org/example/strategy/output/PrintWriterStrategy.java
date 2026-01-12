package org.example.strategy.output;

import java.io.PrintWriter;

public class PrintWriterStrategy implements OutputStrategy {
    private final PrintWriter printWriter;

    public PrintWriterStrategy(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    @Override
    public void print(String message) {
        printWriter.println(message);
    }
}
