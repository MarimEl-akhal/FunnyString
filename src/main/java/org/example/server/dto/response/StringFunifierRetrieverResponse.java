package org.example.server.dto.response;

public class StringFunifierRetrieverResponse {
    private long funnyId;
    private String boringString;
    private String funRangeString;
    private String funnyString;

    public String getFunRangeString() {
        return funRangeString;
    }

    public void setFunRangeString(String funRangeString) {
        this.funRangeString = funRangeString;
    }

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
