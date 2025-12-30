package org.example.dto;

import org.example.operator.Operation;

import java.util.List;

public class OperationRangeEntityRequest {
    private List<Integer> startIndex;
    private List<Integer> endIndex;
    private List<Operation> operation;
}