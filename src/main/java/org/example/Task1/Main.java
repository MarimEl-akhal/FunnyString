package org.example.Task1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringFunifier  funnyString = new StringFunifier();
        funnyString.setBoringString(in.nextLine());
        funnyString.setStartIndex(in.nextLine());
        funnyString.setEndIndex(in.nextLine());


        System.out.println(funnyString.getFunnyString());



    }
}
