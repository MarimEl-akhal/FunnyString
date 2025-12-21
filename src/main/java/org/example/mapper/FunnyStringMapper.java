package org.example.mapper;

import org.example.dto.RequestData;
import org.example.dto.ResponseData;
import org.example.entity.FunnyStringEntity;
import org.springframework.stereotype.Component;


@Component
public class FunnyStringMapper {



    public FunnyStringEntity toEntity(RequestData request, String funRangeString, String funnyString){
        FunnyStringEntity strings = new FunnyStringEntity();
        strings.setBoringString(request.getBoringString());
        strings.setFunRangeString(funRangeString);
        strings.setFunnyString(funnyString);
        return strings;
    }

    public ResponseData toResponse(FunnyStringEntity strings) {
        ResponseData response = new ResponseData();
        response.setBoringString(strings.getBoringString());
        response.setFunRange(strings.getFunRangeString());
        response.setFunnyString(strings.getFunnyString());

        return response;
    }


}
