package org.example.Task1;

import java.util.Arrays;

public class StringOperator {

    private String reverse(String input) {
        String rev = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            rev += input.charAt(i);
        }
        return rev;
    }

    private String upperCase(String input) {
        return input.toUpperCase();
    }

    private String lowerCase(String input) {
        return input.toLowerCase();
    }

    private String sort(String input) {
        char[] ch = input.toCharArray();
        Arrays.sort(ch);
        String sorted = "";
        for (char c : ch) sorted += c;
        return sorted;
    }

    private String runLengthEncoding(String input) {
        String comp = "";
        for (int i = 0; i < input.length(); i++) {
            int count = 1;
            while (i < input.length() - 1
                    && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++;
            }

            comp += input.charAt(i) + "" + count;
        }
        return comp;
    }

    public String applyOperation(Operations op, String input) {
        return switch (op) {
            case Operations.REVERSE -> reverse(input);
            case Operations.UPPERCASE -> upperCase(input);
            case Operations.LOWERCASE -> lowerCase(input);
            case Operations.SORT -> sort(input);
            case Operations.COMPRESSION -> runLengthEncoding(input);

            default -> throw new IllegalStateException("Unexpected value: " + op);
        };
    }


}
