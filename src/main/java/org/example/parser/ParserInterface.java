package org.example.parser;

import org.example.server.service.operator.Operation;

import java.util.List;

public interface ParserInterface {
    List<Integer> parseListOfIndexToken(String tokenIndex);

    List<Operation> parseListOfOperationToken(String token);

    void completeParsing(String startIndices, String endIndices, String operations);

}
