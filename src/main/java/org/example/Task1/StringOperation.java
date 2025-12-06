package org.example.Task1;

import java.util.Arrays;

public class StringOperation implements IStringOperation {

    @Override
    public String reverse(String input, int start, int end) {
        String rev = "";
        for (int i = end; i >= start; i--) {
            rev += input.charAt(i);
        }
        return rev;
    }

    @Override
    public String upperCase(String input, int start, int end) {
        String upperSubString = input.substring(start, end + 1).toUpperCase();
        return upperSubString;
    }

    @Override
    public String lowerCase(String input, int start, int end) {
        String lowerSubString = input.substring(start, end + 1).toLowerCase();
        return lowerSubString;
    }

    @Override
    public String sort(String input, int start, int end) {
        char[] ch = input.substring(start, end + 1).toCharArray();
        Arrays.sort(ch);
        String sorted = "";
        for (char c : ch) sorted += c;
        return sorted;
    }

    @Override
    public String runLengthEncoding(String input, int start, int end) {
        String sub = input.substring(start, end + 1);
        String comp = "";
        for (int i = 0; i < sub.length(); i++) {
            int count = 1;
            while (i < sub.length() - 1
                    && sub.charAt(i) == sub.charAt(i + 1)) {
                count++;
                i++;
            }

            comp += sub.charAt(i) + "" + count;
        }
        return comp;
    }

    @Override
    public String applyOperation(String op, String input, int start, int end) {
        return switch (op) {
            case "REVERSE" -> reverse(input, start, end);
            case "UPPERCASE" -> upperCase(input, start, end);
            case "LOWERCASE" -> lowerCase(input, start, end);
            case "SORT" -> sort(input, start, end);
            case "COMPRESSION" -> runLengthEncoding(input, start, end);
            default -> input.substring(start, end + 1);
        };
    }


}
