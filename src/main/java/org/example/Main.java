package org.example;

import org.example.factory.FactoryDependency;
import org.example.inputOutputSystem.input.InputStrategy;
import org.example.inputOutputSystem.input.ScannerStrategy;
import org.example.inputOutputSystem.output.OutputStrategy;
import org.example.inputOutputSystem.output.PrintStanderStrategy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        Scanner sc = new Scanner(System.in);
        InputStrategy in = new ScannerStrategy(sc);
        OutputStrategy out = new PrintStanderStrategy();

        Router service = FactoryDependency.getDependency(Router.class);
        while (true) {
            service.execute(in, out);
        }


    }
}

