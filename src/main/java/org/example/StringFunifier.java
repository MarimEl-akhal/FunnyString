package org.example;

import java.util.List;

public class StringFunifier {

    private final StringOperator stringOperator;

    public StringFunifier(
    ) {
        this.stringOperator = FactoryDependency.getDependency(StringOperator.class);
    }

    public String getFunnyString(String boring, List<Integer> startIndexList, List<Integer> endIndexList, List<Operations> operations) {

        StringBuilder funnyString = new StringBuilder();
        int index = 0;

        for (int i = 0; i < startIndexList.size(); i++) {
            int start = startIndexList.get(i);
            int end = endIndexList.get(i);
            Operations op = operations.get(i);

            for (int j = index; j < start; j++) {
                funnyString.append(boring.charAt(j));
            }

            funnyString.append("(").append(this.stringOperator.applyOperation(op, boring.substring(start, end + 1))).append(")");
            index = end + 1;
        }
        for (int j = index; j < boring.length(); j++) {
            funnyString.append(boring.charAt(j));
        }
        return funnyString.toString();
    }

    public String getFunRanges(String boring, List<Integer> startIndexList, List<Integer> endIndexList ) {

        StringBuilder funnyRange = new StringBuilder();
        int index = 0;

        for (int i = 0; i < startIndexList.size(); i++) {
            int start = startIndexList.get(i);
            int end = endIndexList.get(i);
            for (int j = index; j < start; j++) {
                funnyRange.append(boring.charAt(j));
            }
            funnyRange.append("(");
            for (int j = start; j <= end; j++) {
                funnyRange.append(boring.charAt(j));
            }
            funnyRange.append(")");
            index = end + 1;
        }
        for (int j = index; j < boring.length(); j++) {
            funnyRange.append(boring.charAt(j));
        }

        return funnyRange.toString();
    }

}
