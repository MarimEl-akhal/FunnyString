package org.example.factory;

import org.example.entity.OperationRangeEntity;

import java.io.IOException;

public class OperationRangeEntityFactory implements BaseFactory<OperationRangeEntity> {
    private OperationRangeEntity operationRange;

    @Override
    public OperationRangeEntity createInstance() {
        if (operationRange == null) {
            operationRange = new OperationRangeEntity();
        }
        return operationRange;
    }
}
