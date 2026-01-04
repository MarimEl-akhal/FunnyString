package org.example.mapper;

import org.example.entity.FunnyStringEntity;
import org.example.entity.FunnyStringEntityRequest;

public class FunnyStringEntityMapper {

    public FunnyStringEntityRequest toRequest(FunnyStringEntity funnyStringEntity) {
        FunnyStringEntityRequest funnyStringEntityRequest = new FunnyStringEntityRequest();
        funnyStringEntityRequest.setBoringString(funnyStringEntity.getBoringString());
        funnyStringEntityRequest.setFunnyString(funnyStringEntity.getFunnyString());
        funnyStringEntityRequest.setFunRange(funnyStringEntity.getFunRange());

        return funnyStringEntityRequest;
    }

    public FunnyStringEntity toEntity(FunnyStringEntityRequest funnyStringEntityRequest) {
        FunnyStringEntity funnyStringEntity = new FunnyStringEntity();
        funnyStringEntity.setBoringString(funnyStringEntityRequest.getBoringString());
        funnyStringEntity.setFunnyString(funnyStringEntityRequest.getFunnyString());
        funnyStringEntity.setFunRange(funnyStringEntityRequest.getFunRange());

        return funnyStringEntity;
    }
}
