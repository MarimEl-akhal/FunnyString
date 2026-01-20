package org.example.server.mapper;

import org.example.server.dto.response.StringFunifierRetrieverResponse;
import org.example.server.entity.FunnyStringEntity;

public class StringFunifierRetrieverMapper {

    public StringFunifierRetrieverResponse toResponse(FunnyStringEntity funnyStringEntity, long id) {
        StringFunifierRetrieverResponse response = new StringFunifierRetrieverResponse();
        response.setFunnyId(id);
        response.setBoringString(funnyStringEntity.getBoringString());
        response.setFunRangeString(funnyStringEntity.getFunRange());
        response.setFunnyString(funnyStringEntity.getFunnyString());

        return response;
    }

    public StringFunifierRetrieverResponse toResponseFail(long id) {
        StringFunifierRetrieverResponse response = new StringFunifierRetrieverResponse();
        response.setFunnyId(id);
        response.setBoringString("No data Found for id " + id);
        response.setFunRangeString("No data Found for id " + id);
        response.setFunnyString("No data Found for id " + id);

        return response;
    }
}