package org.example.server.dto.request;

public class FunnyStringRequest {
    private String boringString;
    private String startIndices;
    private String endIndices;
    private String operations;

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


}
