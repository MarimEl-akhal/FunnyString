package org.example.dto.request;

public class FunRangeRequest {
    private String boringString;
    private String startIndices;
    private String endIndices;
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

    public String getFunnyId() {
        return funnyId;
    }

    public void setFunnyId(String funnyId) {
        this.funnyId = funnyId;
    }
}
