package org.example.server.mapper;

import org.example.server.dto.response.FunnyStringResponse;
import org.example.server.entity.FunnyStringEntity;

public class FunnyStringMapper {

    public FunnyStringResponse toResponse(FunnyStringEntity funnyStringEntity, long id) {
        FunnyStringResponse response = new FunnyStringResponse();
        response.setFunnyId(id);
        response.setBoringString(funnyStringEntity.getBoringString());
        response.setFunnyString(funnyStringEntity.getFunnyString());

        return response;
    }
}
