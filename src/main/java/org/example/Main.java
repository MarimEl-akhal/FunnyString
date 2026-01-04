package org.example;

import org.example.database.DataBaseManager;
import org.example.entity.FunnyStringEntity;
import org.example.entity.OperationRangeEntity;
import org.example.factory.FactoryDependency;
import org.example.operator.Operation;
import org.example.parsingg.IParsing;
import org.example.parsingg.Parsing;
import org.example.socket_v2.server.ClientOption;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner in = new Scanner(System.in);
        IParsing parsing = FactoryDependency.getDependency(Parsing.class);
        StringFunifier funnyString = FactoryDependency.getDependency(StringFunifier.class);
        DataBaseManager dbManager = FactoryDependency.getDependency(DataBaseManager.class);


        FunnyStringEntity funnyStringEntity = new FunnyStringEntity();

        OperationRangeEntity operationRange = new OperationRangeEntity();




        while (true) {
            ClientOption option = ClientOption.valueOf(in.nextLine().toUpperCase());
            switch (option) {
                case FUNRANGE: {
                    String boringString = in.nextLine();
                    String startIndices = in.nextLine();
                    String endIndices = in.nextLine();

                    List<Integer> startList = parsing.parseListOfIndexToken(startIndices);
                    List<Integer> endList = parsing.parseListOfIndexToken(endIndices);


                    String funRanges = funnyString.getFunRanges(boringString, startList, endList);

//                    FunnyStringEntity funnyStringEntity = null;
                    funnyStringEntity.setBoringString(boringString);
                    funnyStringEntity.setFunRange(funRanges);
                    dbManager.insert(funnyStringEntity);

                    long funny_Id = dbManager.getFunnyId();
//                    OperationRangeEntity operationRange = null;
                    for (int i = 0; i < startList.size(); i++) {
                        operationRange.setStartIndex(startList.get(i));
                        operationRange.setEndIndex(endList.get(i));
                    }
                    operationRange.setFunnyStringId(funny_Id);
                    dbManager.insert(operationRange);

                    System.out.println("Inserted into database successfully.");
                    System.out.println("boring String : " + funnyStringEntity.getBoringString());
                    System.out.println("Fun Ranges: " + funnyStringEntity.getFunRange());
                    System.out.println("Funny String: " + funnyStringEntity.getFunnyString());

                    break;
                }
                case FUNNYSTRING: {
                    String boringString = in.nextLine();
                    String startIndices = in.nextLine();
                    String endIndices = in.nextLine();
                    String operations = in.nextLine();

                    List<Integer> startList = parsing.parseListOfIndexToken(startIndices);
                    List<Integer> endList = parsing.parseListOfIndexToken(endIndices);
                    List<Operation> opsList = parsing.parseListOfOperationToken(operations);

                    String stringFunny = funnyString.getFunnyString(boringString, startList, endList, opsList);
//                    FunnyStringEntity funnyStringEntity = null;
                    funnyStringEntity.setBoringString(boringString);
                    funnyStringEntity.setFunnyString(stringFunny);
                    dbManager.insert(funnyStringEntity);

                    long funny_Id = dbManager.getFunnyId();

//                    OperationRangeEntity operationRange = null;
                    for (int i = 0; i < startList.size(); i++) {
                        operationRange.setStartIndex(startList.get(i));
                        operationRange.setEndIndex(endList.get(i));
                        operationRange.setOperation(opsList.get(i).name());
                    }
                    operationRange.setFunnyStringId(funny_Id);
                    dbManager.insert(operationRange);

                    System.out.println("Inserted into database successfully.");
                    System.out.println("boring String : " + funnyStringEntity.getBoringString());
                    System.out.println("Fun Ranges: " + funnyStringEntity.getFunRange());
                    System.out.println("Funny String: " + funnyStringEntity.getFunnyString());

                    break;
                }
                case GET_FUNRANGEBYID: {
                    long id = Long.parseLong(in.nextLine());
                    funnyStringEntity = (FunnyStringEntity) dbManager.getById(id, FunnyStringEntity.class);
                    if (funnyStringEntity == null) {
                        System.out.println("No data found for ID " + id);
                        return;
                    }

                    System.out.println("Inserted into database successfully.");
                    System.out.println("ID : " + funnyStringEntity.getId());
                    System.out.println("boring String : " + funnyStringEntity.getBoringString());
                    System.out.println("Fun Ranges: " + funnyStringEntity.getFunRange());
                    System.out.println("Funny String: " + funnyStringEntity.getFunnyString());

                }
            }


        }

    }
}

