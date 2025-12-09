package org.example.Task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        IParsing parsing = new Parsing();

        String boringString = in.nextLine();
        String startIndices = in.nextLine();
        String endIndices = in.nextLine();
        String operations = in.nextLine();

        // id, output funnyString, output funRanges

        StringFunifier funnyString = new StringFunifier();


        System.out.println(boringString);
        System.out.println(funnyString.getFunRanges(boringString,
                parsing.parseListOfIndexToken(startIndices),
                parsing.parseListOfIndexToken(endIndices))
        );
        System.out.println(funnyString.getFunnyString(boringString,
                parsing.parseListOfIndexToken(startIndices),
                parsing.parseListOfIndexToken(endIndices),
                parsing.parseListOfOperationToken(operations)));

    }
}
