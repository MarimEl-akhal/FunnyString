package org.example.mapper;

import org.example.dto.FunnyStringEntityResponse;
import org.example.entity.FunnyStringEntity;

public class FunnyStringEntityMapper {

    public FunnyStringEntityResponse toRequest(FunnyStringEntity funnyStringEntity) {
        FunnyStringEntityResponse funnyStringEntityRequest = new FunnyStringEntityResponse();
        funnyStringEntityRequest.setBoringString(funnyStringEntity.getBoringString());
        funnyStringEntityRequest.setFunnyString(funnyStringEntity.getFunnyString());
        funnyStringEntityRequest.setFunRange(funnyStringEntity.getFunRange());

        return funnyStringEntityRequest;
    }

    public FunnyStringEntity toEntity(FunnyStringEntityResponse funnyStringEntityRequest) {
        FunnyStringEntity funnyStringEntity = new FunnyStringEntity();
        funnyStringEntity.setBoringString(funnyStringEntityRequest.getBoringString());
        funnyStringEntity.setFunnyString(funnyStringEntityRequest.getFunnyString());
        funnyStringEntity.setFunRange(funnyStringEntityRequest.getFunRange());

        return funnyStringEntity;
    }
}
