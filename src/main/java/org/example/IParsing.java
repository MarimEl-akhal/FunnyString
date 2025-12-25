package org.example;

import java.util.List;

public interface IParsing {
    public List<Integer> parseListOfIndexToken(String tokenIndex);

    public List<Operation> parseListOfOperationToken(String token);

}
