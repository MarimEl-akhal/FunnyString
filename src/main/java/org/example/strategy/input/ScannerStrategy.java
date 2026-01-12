package org.example.strategy.input;

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


//public class ScannerStrategy implements InputStrategy {
//    private Scanner scanner;
//
//    public ScannerStrategy() {
//        this.scanner = new Scanner(System.in);
//    }
//
//    @Override
//    public String read() {
//        return scanner.nextLine();
//    }
//}
