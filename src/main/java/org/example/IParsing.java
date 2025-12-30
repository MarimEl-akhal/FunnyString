package org.example;

import org.example.operator.Operation;

import java.util.List;

public interface IParsing {
    public List<Integer> parseListOfIndexToken(String tokenIndex);

    public List<Operation> parseListOfOperationToken(String token);

    public void completeParsing(String startIndices, String endIndices, String operations);

}
