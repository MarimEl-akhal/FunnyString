package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.enumm.Operation;

@Entity
@Data
public class OperationRangeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;


    @Column(nullable = false)
    private int startIndex;

    @Column(nullable = false)
    private int endIndex;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Operation operate;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "string_id" )
    private FunnyStringEntity strings;


}
