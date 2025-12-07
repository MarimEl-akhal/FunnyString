//package org.example.Task1;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ParsingForDash implements IParsing {
//    private String charSplit = "\\s*-\\s*";
//
//    @Override
//    public List<Integer> parseListOfIndexToken(String tokenIndex) {
//        List<Integer> inputList = new ArrayList<>();
//        String[] Indx = tokenIndex.split(charSplit);
//        for (String e : Indx) {
//            if (!e.isEmpty() && isNumber(e))
//                inputList.add(Integer.parseInt(e));
//        }
//        return inputList;
//    }
//
//    @Override
//    public List<String> parseListOfOperationToken(String token) {
//        List<String> opList = new ArrayList<>();
//        String[] Indx = token.replace(" ", "").split(charSplit);
//        for (String e : Indx) {
//            if (!e.isEmpty()) opList.add(e);
//        }
//        return opList;
//    }
//
//    private boolean isNumber(String s) {
//        try {
//            Integer.parseInt(s);
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
//}
