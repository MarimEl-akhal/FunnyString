package org.example.mapper;

import org.example.dto.response.FunRangeResponse;
import org.example.entity.FunnyStringEntity;

public class FunRangeMapper {

    public FunRangeResponse toResponse(FunnyStringEntity funnyStringEntity, long id) {
        FunRangeResponse response = new FunRangeResponse();
        response.setFunnyId(id);
        response.setBoringString(funnyStringEntity.getBoringString());
        response.setFunRangeString(funnyStringEntity.getFunRange());

        return response;
    }

}
