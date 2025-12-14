package org.example;

import java.sql.*;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        IParsing parsing = new Parsing();
        StringFunifier funnyString = new StringFunifier();
        JdbcStatementLogic jdbcStatementLogic = new JdbcStatementLogic();

        while (true) {
            String boringString = in.nextLine();
            String startIndices = in.nextLine();
            String endIndices = in.nextLine();
            String operations = in.nextLine();

            List<Integer> startList = parsing.parseListOfIndexToken(startIndices);
            List<Integer> endList = parsing.parseListOfIndexToken(endIndices);
            List<Operations> opsList = parsing.parseListOfOperationToken(operations);


            String funRanges = funnyString.getFunRanges(boringString, startList, endList);
            String stringFunny = funnyString.getFunnyString(boringString, startList, endList, opsList);

            jdbcStatementLogic.Input_Output_Strings(boringString, startList, endList, opsList, funRanges, stringFunny);


            System.out.println("Inserted into database successfully.");
            System.out.println("boring String : " + boringString);
            System.out.println("Fun Ranges: " + funRanges);
            System.out.println("Funny String: " + stringFunny);
        }

    }
}

