package org.example.dto;

import org.example.operator.Operation;

import java.util.List;

public class OperationRangeEntityRequest {
    private List<Integer> startIndices;
    private List<Integer> endIndices;
    private List<Operation> operations;

    public List<Integer> getStartIndices() {
        return startIndices;
    }

    public void setStartIndices(List<Integer> startIndices) {
        this.startIndices = startIndices;
    }

    public List<Integer> getEndIndices() {
        return endIndices;
    }

    public void setEndIndices(List<Integer> endIndices) {
        this.endIndices = endIndices;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}