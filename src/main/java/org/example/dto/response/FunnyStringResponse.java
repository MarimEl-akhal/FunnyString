package org.example.dto.response;

public class FunnyStringResponse {
    private long funnyId;
    private String boringString;
    private String funnyString;


    public long getFunnyId() {
        return funnyId;
    }

    public void setFunnyId(long funnyId) {
        this.funnyId = funnyId;
    }

    public String getBoringString() {
        return boringString;
    }

    public void setBoringString(String boringString) {
        this.boringString = boringString;
    }

    public String getFunnyString() {
        return funnyString;
    }

    public void setFunnyString(String funnyString) {
        this.funnyString = funnyString;
    }
}
