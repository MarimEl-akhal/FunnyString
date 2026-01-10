package org.example.dto;

import org.example.operator.Operation;

import java.util.List;

public class StringFunifierRequest {
    private String boringString;
    private String startIndices;
    private String endIndices;
    private String operations;
    private String funnyId;

    public String getBoringString() {
        return boringString;
    }

    public void setBoringString(String boringString) {
        this.boringString = boringString;
    }

    public String getStartIndices() {
        return startIndices;
    }

    public void setStartIndices(String startIndices) {
        this.startIndices = startIndices;
    }

    public String getEndIndices() {
        return endIndices;
    }

    public void setEndIndices(String endIndices) {
        this.endIndices = endIndices;
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public String getFunnyId() {
        return funnyId;
    }

    public void setFunnyId(String funnyId) {
        this.funnyId = funnyId;
    }
}