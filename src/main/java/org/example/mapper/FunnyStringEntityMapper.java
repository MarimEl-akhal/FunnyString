package org.example.mapper;

import org.example.dto.StringFunifierResponse;
import org.example.entity.FunnyStringEntity;

public class FunnyStringEntityMapper {

    public StringFunifierResponse toResponse(FunnyStringEntity funnyStringEntity) {
        StringFunifierResponse response = new StringFunifierResponse();
        response.setFunnyId(funnyStringEntity.getId());
        response.setBoringString(funnyStringEntity.getBoringString());
        response.setFunnyString(funnyStringEntity.getFunnyString());
        response.setFunRange(funnyStringEntity.getFunRange());

        return response;
    }

//    public FunnyStringEntity toEntity(StringFunifierResponse funnyStringEntityRequest) {
//        FunnyStringEntity funnyStringEntity = new FunnyStringEntity();
//        funnyStringEntity.setBoringString(funnyStringEntityRequest.getBoringString());
//        funnyStringEntity.setFunnyString(funnyStringEntityRequest.getFunnyString());
//        funnyStringEntity.setFunRange(funnyStringEntityRequest.getFunRange());
//
//        return funnyStringEntity;
//    }
}
