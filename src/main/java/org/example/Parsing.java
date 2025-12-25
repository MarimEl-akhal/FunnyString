package org.example;

import java.util.*;

public class Parsing implements IParsing  {
    private final String charSplit = "\\s*,\\s*";

    @Override
    public  List<Integer> parseListOfIndexToken(String tokenIndex) {
        List<Integer> inputList = new ArrayList<>();
        String[] Index = tokenIndex.split(charSplit);
        for (String e : Index) {
            if (!e.isEmpty())
                inputList.add(Integer.parseInt(e));
        }
        return inputList;
    }

    @Override
    public List<Operation> parseListOfOperationToken(String token) {
        List<Operation> opList = new ArrayList<>();
        String[] operation = token.replace("\"", "").split(charSplit);
        for (String s : operation) {
            if (!s.isEmpty()) {
                try {
                    Operation op = Operation.valueOf(s.toUpperCase());
                    opList.add(op);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        return opList;
    }
}
