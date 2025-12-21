package org.example.mapper;

import org.example.dto.ResponseData;
import org.example.entity.OperationRangeEntity;
import org.example.entity.FunnyStringEntity;
import org.example.enumm.Operation;
import org.springframework.stereotype.Component;


@Component
public class OperationRangeMapper {


    public OperationRangeEntity toEntity(int start , int end , Operation operations, FunnyStringEntity strings){
        OperationRangeEntity rangesAndOperations = new OperationRangeEntity();
        rangesAndOperations.setStartIndex(start);
        rangesAndOperations.setEndIndex(end);
        rangesAndOperations.setOperate(operations);
        rangesAndOperations.setStrings(strings);
        return rangesAndOperations;
    }


    public OperationRangeEntity toEntity2( int start , int end , FunnyStringEntity funnies){
        OperationRangeEntity rangesAndOperations = new OperationRangeEntity();
        rangesAndOperations.setStartIndex(start);
        rangesAndOperations.setEndIndex(end);
        rangesAndOperations.setStrings(funnies);
        return rangesAndOperations;
    }

    public ResponseData toResponse(OperationRangeEntity rangesAndOperations) {
        ResponseData response = new ResponseData();
        response.setBoringString(rangesAndOperations.getStrings().getBoringString());
        response.setFunRange(rangesAndOperations.getStrings().getFunRangeString());
        response.setFunnyString(rangesAndOperations.getStrings().getFunnyString());

        return response;
    }
}
