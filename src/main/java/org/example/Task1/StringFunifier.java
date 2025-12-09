package org.example.Task1;

import java.util.List;

public class StringFunifier {

    private StringOperator stringOperator;

    public StringFunifier(
    ) {
        this.stringOperator = Factory.getDependency(StringOperator.class);
    }

    public String getFunnyString(String boring, List<Integer> startIndexList, List<Integer> endIndexList, List<Operations> operations) {

        String funnyString = "";
        int index = 0;

        for (int i = 0; i < startIndexList.size(); i++) {
            int start = startIndexList.get(i);
            int end = endIndexList.get(i);
            Operations op = operations.get(i);

            for (int j = index; j < start; j++) {
                funnyString += boring.charAt(j);
            }

            funnyString += "(" + this.stringOperator.applyOperation(op, boring.substring(start, end + 1)) + ")";
            index = end + 1;
        }
        for (int j = index; j < boring.length(); j++) {
            funnyString += boring.charAt(j);
        }
        return funnyString;
    }

    public String getFunRanges(String boring, List<Integer> startIndexList, List<Integer> endIndexList) {

        String funnyRange = "";
        int index = 0;

        for (int i = 0; i < startIndexList.size(); i++) {
            int start = startIndexList.get(i);
            int end = endIndexList.get(i);
            for (int j = index; j < start; j++) {
                funnyRange += boring.charAt(j);
            }
            funnyRange += "(";
            for (int j = start; j <= end; j++) {
                funnyRange += boring.charAt(j);
            }
            funnyRange += ")";
            index = end + 1;
        }
        for (int j = index; j < boring.length(); j++) {
            funnyRange += boring.charAt(j);
        }

        return funnyRange;
    }

}
