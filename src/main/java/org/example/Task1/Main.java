package org.example.Task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        IParsing parsing = new Parsing();

        String booringString = in.nextLine();
        String startIndices = in.nextLine();
        String endIndices = in.nextLine();
        String operations = in.nextLine();

        StringFunifier funnyString = new StringFunifier(
                booringString,
                parsing.parseListOfIndexToken(startIndices),
                parsing.parseListOfIndexToken(endIndices),
                parsing.parseListOfOperationToken(operations)
        );


        //System.out.println("getFunnyRanges() => " + funnyString.getFunRanges());
        System.out.println(funnyString.getBoringString());
        System.out.println(funnyString.getFunRanges());
        System.out.println(funnyString.getFunnyString());


    }
}
