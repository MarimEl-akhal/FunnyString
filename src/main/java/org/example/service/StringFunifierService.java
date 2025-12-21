package org.example.service;

import org.example.dto.RequestData;

import org.example.dto.ResponseData;
import org.example.entity.OperationRangeEntity;
import org.example.entity.FunnyStringEntity;
import org.example.enumm.Operation;

import org.example.mapper.OperationRangeMapper;
import org.example.mapper.FunnyStringMapper;
import org.example.repository.OperationRangeRepository;
import org.example.repository.FunnyStringRepository;

import org.springframework.stereotype.Service;


@Service
public class StringFunifierService {

    private final StringOperatorService stringOperatorService;

    private final FunnyStringRepository funnyStringRepository;

    private final OperationRangeRepository operationRangeRepository;

    private final FunnyStringMapper funnyStringMapper;

    private final OperationRangeMapper operationRangeMapper;

    public StringFunifierService(StringOperatorService stringOperatorService,
                                 OperationRangeRepository rangesAndOperationsRepository,
                                 FunnyStringRepository stringsRepository,
                                 FunnyStringMapper stringMapper,
                                 OperationRangeMapper operationRangeMapper
    ) {
        this.stringOperatorService = stringOperatorService;
        this.operationRangeRepository = rangesAndOperationsRepository;
        this.funnyStringRepository = stringsRepository;
        this.funnyStringMapper = stringMapper;
        this.operationRangeMapper = operationRangeMapper;
    }


    public ResponseData funniesString(RequestData requestData) {
        ResponseData funRanges = getFunRanges(requestData);
        ResponseData funnyString = getFunnyString(requestData);

        FunnyStringEntity funnyStringEntity = funnyStringMapper.toEntity(requestData, funRanges.getFunRange(), funnyString.getFunnyString());

        for (int i = 0; i < requestData.getStartIndices().size(); i++) {
            int start = requestData.getStartIndices().get(i);
            int end = requestData.getEndIndices().get(i);
            Operation operation = requestData.getOperations().get(i);

            OperationRangeEntity operationRange = operationRangeMapper.toEntity(start, end, operation, funnyStringEntity);

            operationRangeRepository.save(operationRange);
        }


        FunnyStringEntity savedFunnies = funnyStringRepository.save(funnyStringEntity);
        ResponseData response = funnyStringMapper.toResponse(savedFunnies);

        return new ResponseData(response.getBoringString(),response.getFunRange(), response.getFunnyString()) ;
    }


    public ResponseData getFunnyString(RequestData requestData) {

        FunnyStringEntity funnyStringEntity = new FunnyStringEntity();


        String boring = requestData.getBoringString();
        StringBuilder funnyString = new StringBuilder();
        int index = 0;


        for (int i = 0; i < requestData.getStartIndices().size(); i++) {
            int start = requestData.getStartIndices().get(i);
            int end = requestData.getEndIndices().get(i);
            Operation op = requestData.getOperations().get(i);


            for (int j = index; j < start; j++) {
                funnyString.append(boring.charAt(j));
            }

            funnyString.append("(").append(stringOperatorService.applyOperation(op, boring.substring(start, end + 1))).append(")");
            index = end + 1;

            operationRangeMapper.toEntity(start, end, op, funnyStringEntity);
//            operationRangeRepository.save();
        }
        for (int j = index; j < boring.length(); j++) {
            funnyString.append(boring.charAt(j));
        }


        funnyStringEntity = funnyStringMapper.toEntity(requestData, null, funnyString.toString());
        FunnyStringEntity savingFunniesString = funnyStringRepository.save(funnyStringEntity);

        return funnyStringMapper.toResponse(savingFunniesString);
    }


    public ResponseData getFunRanges(RequestData requestData) {

        FunnyStringEntity funnyStringEntity = new FunnyStringEntity();

        String boring = requestData.getBoringString();
        StringBuilder funnyRange = new StringBuilder();
        int index = 0;


        for (int i = 0; i < requestData.getStartIndices().size(); i++) {
            int start = requestData.getStartIndices().get(i);
            int end = requestData.getEndIndices().get(i);

            operationRangeMapper.toEntity2(start, end, funnyStringEntity);

//            operationRangeRepository.save(operationRange);


            for (int j = index; j < start; j++) {
                funnyRange.append(boring.charAt(j));
            }
            funnyRange.append("(");
            for (int j = start; j <= end; j++) {
                funnyRange.append(boring.charAt(j));
            }
            funnyRange.append(")");
            index = end + 1;
        }
        for (int j = index; j < boring.length(); j++) {
            funnyRange.append(boring.charAt(j));
        }


        funnyStringEntity = funnyStringMapper.toEntity(requestData, funnyRange.toString(), null);
        FunnyStringEntity savingFunniesString = funnyStringRepository.save(funnyStringEntity);

        return funnyStringMapper.toResponse(savingFunniesString);
    }


}
