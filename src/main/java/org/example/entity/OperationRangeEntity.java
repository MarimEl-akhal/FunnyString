package org.example.entity;

public class OperationRangeEntity {
    private long id;
    private long startIndex;
    private long endIndex;
    private String operation;

    //foreign key
    private long funnyStringId;
}

/*CREATE TABLE operation_range (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    startIndex INT NOT NULL,
    endIndex INT NOT NULL,
    operation VARCHAR(50) NOT NULL,
    funnyStringId BIGINT NOT NULL,
    FOREIGN KEY (funnyStringId) REFERENCES funny_string(id) ON DELETE CASCADE
);
*/
