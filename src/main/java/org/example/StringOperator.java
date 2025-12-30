package org.example.operator;

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

    public String applyOperation(Operation op, String input) {
        return switch (op) {
            case REVERSE -> reverse(input);
            case UPPERCASE -> upperCase(input);
            case LOWERCASE -> lowerCase(input);
            case SORT -> sort(input);
            case COMPRESSION -> runLengthEncoding(input);

        };
    }


}
