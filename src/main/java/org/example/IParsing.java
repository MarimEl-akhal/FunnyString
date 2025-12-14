package org.example;

import java.util.List;

public interface IParsing {
    public List<Integer> parseListOfIndexToken(String tokenIndex);

    public List<Operations> parseListOfOperationToken(String token);

}
