package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enumm.Operation;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestData {
    private String boringString;
    private List<Integer> startIndices;
    private List<Integer> endIndices;
    private List<Operation> operations;
    
}
