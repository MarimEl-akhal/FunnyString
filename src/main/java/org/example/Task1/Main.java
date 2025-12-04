package org.example.Task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringFunifier funnyString = new StringFunifier();
        IParsing parsing = new Parsing();
        funnyString.setParsing(parsing);
        funnyString.setStringOperation(new StringOperation());


        funnyString.setBoringString(in.nextLine());
        funnyString.setStartIndexList(parsing.parseListOfIndexToken(in.nextLine()));
        funnyString.setEndIndexList(parsing.parseListOfIndexToken(in.nextLine()));
        funnyString.setOperations(parsing.parseListOfOperationToken(in.nextLine()));


        //System.out.println("getFunnyRanges() => " + funnyString.getFunRanges());
        System.out.println("getFunnyString() => " + funnyString.getFunnyString());





    }
}
