package org.example.Task1;

import java.util.*;

public class Parsing implements IParsing {
    private String charSplit = "\\s*,\\s*";

    @Override
    public List<Integer> parseListOfIndexToken(String tokenIndex) {
        List<Integer> inputList = new ArrayList<>();
        String[] Indx = tokenIndex.split(charSplit);
        for (String e : Indx) {
            if (!e.isEmpty())
                inputList.add(Integer.parseInt(e));
        }
        return inputList;
    }

    @Override
    public List<Operations> parseListOfOperationToken(String token) {
        List<Operations> opList = new ArrayList<>();
        String[] operation = token.replace("\"", "").split(charSplit);
        for (String s : operation) {
            if (!s.isEmpty()) {
                Operations op = Operations.valueOf(s.toUpperCase());
                opList.add(op);
            }

        }
        return opList;
    }

//    private boolean isNumber(String s) {
//        try {
//            Integer.parseInt(s);
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
}
