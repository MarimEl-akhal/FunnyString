package org.example.mapper;

import org.example.dto.StringFunifierResponse;
import org.example.entity.FunnyStringEntity;

public class FunnyStringEntityMapper {

    public StringFunifierResponse toResponse(FunnyStringEntity funnyStringEntity, long id) {
        StringFunifierResponse response = new StringFunifierResponse();
        response.setFunnyId(id);
        response.setBoringString(funnyStringEntity.getBoringString());
        response.setFunnyString(funnyStringEntity.getFunnyString());
        response.setFunRange(funnyStringEntity.getFunRange());

        return response;
    }

    public StringFunifierResponse toResponseFail(long id) {
        StringFunifierResponse response = new StringFunifierResponse();
        response.setFunnyId(id);
        response.setBoringString("No data Found for id " + id);
        response.setFunRange("No data Found for id " + id);
        response.setFunnyString("No data Found for id " + id);

        return response;
    }
}
