package org.example;

import org.example.database.DataBaseManager;
import org.example.entity.FunnyStringEntity;
import org.example.entity.OperationRangeEntity;
import org.example.factory.FactoryDependency;
import org.example.operator.Operation;
import org.example.parsingg.IParsing;
import org.example.parsingg.Parsing;
import org.example.socket_v2.server.ClientOption;
import org.example.strategy.InputStrategy;
import org.example.strategy.OutputStrategy;
import org.example.strategy.PrintStanderStrategy;
import org.example.strategy.ScannerStrategy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        Scanner sc = new Scanner(System.in);
        InputStrategy in = new ScannerStrategy(sc);
        OutputStrategy out = new PrintStanderStrategy();

        Service service = FactoryDependency.getDependency(Service.class);

        service.execute(in,out);

    }
}

