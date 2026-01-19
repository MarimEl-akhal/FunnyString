package org.example.stringTokenToListParsing;

import org.example.stringFunifierOperator.Operation;

import java.util.List;

public interface IParsing {
    List<Integer> parseListOfIndexToken(String tokenIndex);

    List<Operation> parseListOfOperationToken(String token);

    void completeParsing(String startIndices, String endIndices, String operations);

}
