package org.example.Task1;

import java.util.ArrayList;
import java.util.List;

public class StringFunifier {

    private String boringString;
    private List<Integer> startIndex;
    private List<Integer> endIndex;

    public String reverse(int start, int end) {
        String rev = "";
        for (int i = end; i >= start; i--) {
            rev += boringString.charAt(i);
        }
        return rev;
    }


    public String getFunnyString() {
        String funnyString = "";
        int index = 0;

        for (int i = 0; i < startIndex.size(); i++) {
            int start = startIndex.get(i);
            int end = endIndex.get(i);

            for (int j = index; j < start; j++) {
                funnyString += boringString.charAt(j);
            }

            funnyString += "(" + reverse(start, end) + ")";

            index = end + 1;

        }
        for (int j = index; j < boringString.length(); j++) {
            funnyString += boringString.charAt(j);
        }

        return funnyString;
    }


    public String getBoringString() {
        return boringString;
    }

    public void setBoringString(String boringString) {
        this.boringString = boringString;
    }

    public List<Integer> getStartIndex() {
        return startIndex;
    }

    public List<Integer> setStartIndex(String start) {
        this.startIndex = new ArrayList<>();
        String[] startIndx = start.replace(" ", "").split(",");
        for (String s : startIndx) {
            if (!s.isEmpty()) startIndex.add(Integer.parseInt(s));
        }
        return startIndex;
    }

    public List<Integer> getEndIndex() {
        return endIndex;
    }

    public List<Integer> setEndIndex(String end) {
        this.endIndex = new ArrayList<>();
        String[] endIndx = end.replace(" ", "").split(",");
        for (String e : endIndx) {
            if (!e.isEmpty()) endIndex.add(Integer.parseInt(e));
        }
        return endIndex;
    }
}


