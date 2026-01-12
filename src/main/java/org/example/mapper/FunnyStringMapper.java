package org.example.mapper;

import org.example.dto.response.FunnyStringResponse;
import org.example.entity.FunnyStringEntity;

public class FunnyStringMapper {

    public FunnyStringResponse toResponse(FunnyStringEntity funnyStringEntity, long id) {
        FunnyStringResponse response = new FunnyStringResponse();
        response.setFunnyId(id);
        response.setBoringString(funnyStringEntity.getBoringString());
        response.setFunnyString(funnyStringEntity.getFunnyString());

        return response;
    }

    public FunnyStringResponse toResponseFail(long id) {
        FunnyStringResponse response = new FunnyStringResponse();
        response.setFunnyId(id);
        response.setBoringString("No data Found for id " + id);
        response.setFunnyString("No data Found for id " + id);

        return response;
    }
}
