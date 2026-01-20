package org.example.io.method.input;

import java.util.Scanner;

public class ScannerStrategy implements InputStrategy {
    private final Scanner scanner;

    public ScannerStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}