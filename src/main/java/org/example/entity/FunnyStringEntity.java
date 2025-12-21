package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class FunnyStringEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(nullable = false)
    private String boringString;

    private String funRangeString;


    private String funnyString;

    @OneToMany(mappedBy = "strings", cascade = CascadeType.ALL)
    private List<OperationRangeEntity> rangesAndOperations;
}
