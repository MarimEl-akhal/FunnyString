package org.example.Task1;

import java.util.List;

public class StringFunifier {

    private String boringString;

    private List<Integer> startIndexList;
    private List<Integer> endIndexList;
    private List<Operations> operations;
    private StringOperator stringOperator;

    public StringFunifier(
            String boringString,
            List<Integer> startIndexList,
            List<Integer> endIndexList,
            List<Operations> operations
    ) {
        this.boringString = boringString;
        this.startIndexList = startIndexList;
        this.endIndexList = endIndexList;
        this.operations = operations;

        this.stringOperator = Bringer.getStringOperator();

        if (this.startIndexList.size() != this.endIndexList.size()
                || this.operations.size() != this.startIndexList.size()) {
            throw new Error("Not allowed");
        }

    }

    public String getFunnyString() {
        String funnyString = "";
        int index = 0;

        for (int i = 0; i < startIndexList.size(); i++) {
            int start = startIndexList.get(i);
            int end = endIndexList.get(i);
            Operations op = operations.get(i);

            for (int j = index; j < start; j++) {
                funnyString += boringString.charAt(j);
            }

            funnyString += "(" + this.stringOperator.applyOperation(op, boringString.substring(start, end + 1)) + ")";
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

}

//ccchHJKkklmlmmml
//1, 5, 7, 11, 13
//3, 5, 10, 12, 14
//REVERSE, UPPERCASE, SORT, LOWERCASE, COMPRESSION
