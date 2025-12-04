package org.example.Task1;

import java.util.List;

public interface IStringOperation {
    public String reverse(String input, int start, int end);

    public String upperCase(String input, int start, int end);

    public String lowerCase(String input, int start, int end);

    public String sort(String input, int start, int end);

    public String runLengthEncoding(String input, int start, int end);

    public String applyOperation(String op, String input, int start, int end);


//    String applyOperatio(String op, String input, int start, int end);
}
