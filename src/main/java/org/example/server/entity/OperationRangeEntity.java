package org.example.server.entity;

public class OperationRangeEntity {
    private int startIndex;
    private int endIndex;
    private String operation;
    //foreign key
    private long funnyStringId;

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setFunnyStringId(long funnyStringId) {
        this.funnyStringId = funnyStringId;
    }
}
//
//CREATE TABLE operationrangeentity (
//    id BIGINT AUTO_INCREMENT PRIMARY KEY,
//    startIndex INT NOT NULL,
//    endIndex INT NOT NULL,
//    operation text,
//    funnyStringId BIGINT NOT NULL,
//    FOREIGN KEY (funnyStringId) REFERENCES funnystringentity(id) ON DELETE CASCADE
//);
//
