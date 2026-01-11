package org.example.entity;

public class FunnyStringEntity {

    private long id;
    private String boringString;
    private String funnyString;
    private String funRange;

    public long getId() {
        return id;
    }

    public String getFunRange() {
        return funRange;
    }

    public void setFunRange(String funRange) {
        this.funRange = funRange;
    }

    public String getFunnyString() {
        return funnyString;
    }

    public void setFunnyString(String funnyString) {
        this.funnyString = funnyString;
    }

    public String getBoringString() {
        return boringString;
    }

    public void setBoringString(String boringString) {
        this.boringString = boringString;
    }

}


//CREATE TABLE funnystringentity (
//    id BIGINT AUTO_INCREMENT PRIMARY KEY,
//    boringString TEXT NOT NULL,
//    funnyString TEXT,
//    funRange TEXT
//);
