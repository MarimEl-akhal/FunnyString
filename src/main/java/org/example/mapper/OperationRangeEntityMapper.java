package org.example.mapper;


import org.example.entity.OperationRangeEntity;
import org.example.entity.OperationRangeEntityRequest;
import org.example.factory.FactoryDependency;
import org.example.parsingg.Parsing;

import java.util.ArrayList;
import java.util.List;

public class OperationRangeEntityMapper {

    private final Parsing parsing;

    public OperationRangeEntityMapper() {
        this.parsing = FactoryDependency.getDependency(Parsing.class);
    }

//    public OperationRangeEntityRequest toRequest(OperationRangeEntity operationRangeEntity) {
//        OperationRangeEntityRequest operationRangeEntityRequest = new OperationRangeEntityRequest();
//        operationRangeEntityRequest.setStartIndex(operationRangeEntity.getStartIndex());
//
//        return OperationRangeEntityRequest;
//    }

    public List<OperationRangeEntity> toEntity(OperationRangeEntityRequest operationRangeEntityRequest, long funnyStringId) {
        List<OperationRangeEntity> operationRangeEntities = new ArrayList<>();

        for (int i = 0; i < operationRangeEntityRequest.getStartIndex().size(); i++) {
            OperationRangeEntity operationRangeEntity = new OperationRangeEntity();
            operationRangeEntity.setStartIndex(operationRangeEntityRequest.getStartIndex().get(i));
            operationRangeEntity.setEndIndex(operationRangeEntityRequest.getEndIndex().get(i));
            if (operationRangeEntityRequest.getOperation() != null) {
                operationRangeEntity.setOperation(operationRangeEntityRequest.getOperation().get(i).name());
            } else {
                operationRangeEntity.setOperation(null);
            }
            operationRangeEntity.setFunnyStringId(funnyStringId);

            operationRangeEntities.add(operationRangeEntity);
        }
        return operationRangeEntities;
    }

}
//funrange
//mksgdgudddddddddddddd
//1, 5, 7, 11, 13
//3, 5, 10, 12, 14
//"REVERSE", "UPPERCASE", "SORT", "LOWERCASE", "COMPRESSION"