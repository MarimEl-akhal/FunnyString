package org.example.Task1;

import java.util.ArrayList;
import java.util.List;

public class StringFunifier {

    private String boringString;
    private String startIndex;
    private String endIndex;
    private String operation;

    private IStringOperation stringOperation;
    private IParsing parsing;

    private List<Integer> startIndexList;
    private List<Integer> endIndexList;
    private List<String> operations;


    public String getFunnyString() {
        String funnyString = "";
        int index = 0;

        this.startIndexList = parsing.parseListOfIndexToken(startIndex);
        this.endIndexList = parsing.parseListOfIndexToken(endIndex);
        this.operations = parsing.parseListOfOperationToken(operation);


        for (int i = 0; i < startIndexList.size(); i++) {
            int start = startIndexList.get(i);
            int end = endIndexList.get(i);
            String op = operations.get(i);
            for (int j = index; j < start; j++) {
                funnyString += boringString.charAt(j);
            }
            funnyString += "(" + stringOperation.applyOperation(op, boringString, start, end) + ")";
            index = end + 1;
        }
        for (int j = index; j < boringString.length(); j++) {
            funnyString += boringString.charAt(j);
        }
        return funnyString;
    }

    public String getFunRanges() {

        String funnyRange = "";
        int index = 0;

        this.startIndexList = parsing.parseListOfIndexToken(startIndex);
        this.endIndexList = parsing.parseListOfIndexToken(endIndex);
        this.operations = parsing.parseListOfOperationToken(operation);

        for (int i = 0; i < startIndexList.size(); i++) {
            int start = startIndexList.get(i);
            int end = endIndexList.get(i);
            for (int j = index; j < start; j++) {
                funnyRange += boringString.charAt(j);
            }
            funnyRange += "(";
            for (int j = start; j <= end; j++) {
                funnyRange += boringString.charAt(j);
            }
            funnyRange += ")";
            index = end + 1;
        }
        for (int j = index; j < boringString.length(); j++) {
            funnyRange += boringString.charAt(j);
        }

        return funnyRange;
    }

    public String getBoringString() {
        return boringString;
    }

    public void setBoringString(String boringString) {
        this.boringString = boringString;
    }

    public void setStartIndex(String startIndex) {
        this.startIndex = startIndex;
    }

    public void setEndIndex(String endIndex) {
        this.endIndex = endIndex;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setStringOperation(IStringOperation stringOperation) {
        this.stringOperation = stringOperation;
    }

    public void setParsing(IParsing parsing) {
        this.parsing = parsing;
    }

    public void setStartIndexList(List<Integer> startIndexList) {
        this.startIndexList = startIndexList;
    }

    public void setEndIndexList(List<Integer> endIndexList) {
        this.endIndexList = endIndexList;
    }

    public void setOperations(List<String> operations) {
        this.operations = operations;
    }
}

//ccchHJKkklmlmmml
//1, 5, 7, 11, 13
//3, 5, 10, 12, 14
//REVERSE, UPPERCASE, SORT, LOWERCASE, COMPRESSION
