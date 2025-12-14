package org.example;

import java.util.Arrays;

public class StringOperator {

    private String reverse(String input) {
        StringBuilder rev = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            rev.append(input.charAt(i));
        }
        return rev.toString();
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
        StringBuilder sorted = new StringBuilder();
        for (char c : ch) sorted.append(c);
        return sorted.toString();
    }

    private String runLengthEncoding(String input) {
        StringBuilder comp = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int count = 1;
            while (i < input.length() - 1
                    && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++;
            }

            comp.append(input.charAt(i)).append(count);
        }
        return comp.toString();
    }

    public String applyOperation(Operations op, String input) {
        return switch (op) {
            case Operations.REVERSE -> reverse(input);
            case Operations.UPPERCASE -> upperCase(input);
            case Operations.LOWERCASE -> lowerCase(input);
            case Operations.SORT -> sort(input);
            case Operations.COMPRESSION -> runLengthEncoding(input);

        };
    }


}
