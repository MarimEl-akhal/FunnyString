package org.example.server.string.funifier.controller;

import org.example.server.service.StringFunifier;
import org.example.server.repository.DataBaseManager;
import org.example.server.dto.request.FunRangeRequest;
import org.example.server.dto.response.FunRangeResponse;
import org.example.server.entity.FunnyStringEntity;
import org.example.server.entity.OperationRangeEntity;
import org.example.server.factory.dependency.FactoryDependency;
import org.example.io.method.input.InputStrategy;
import org.example.io.method.output.OutputStrategy;
import org.example.server.mapper.FunRangeMapper;
import org.example.server.ClientOption;
import org.example.parser.ParserInterface;
import org.example.parser.Parser;

import java.io.IOException;
import java.util.List;

public class FunRangeStrategy implements RouterStrategyInterface<FunRangeRequest, FunRangeResponse> {

    private final ParserInterface parsing;
    private final StringFunifier funnyString;
    private final DataBaseManager dbManager;
    private final FunRangeMapper mapper;


    public FunRangeStrategy() {
        this.parsing = FactoryDependency.getDependency(Parser.class);
        this.funnyString = FactoryDependency.getDependency(StringFunifier.class);
        this.dbManager = FactoryDependency.getDependency(DataBaseManager.class);
        this.mapper = FactoryDependency.getDependency(FunRangeMapper.class);
    }


    @Override
    public ClientOption getOptionName() {
        return ClientOption.FUNRANGE;

    }

    @Override
    public FunRangeRequest mapInputToRequestBody(InputStrategy inputStrategy) throws IOException {
        String boringString = inputStrategy.read();
        String start = inputStrategy.read();
        String end = inputStrategy.read();

        FunRangeRequest funRangeRequest = new FunRangeRequest();

        funRangeRequest.setBoringString(boringString);
        funRangeRequest.setStartIndices(start);
        funRangeRequest.setEndIndices(end);

        return funRangeRequest;
    }

    @Override
    public FunRangeResponse executeScenario(FunRangeRequest request) {
        String boringString = request.getBoringString();
        List<Integer> startList = parsing.parseListOfIndexToken(request.getStartIndices());
        List<Integer> endList = parsing.parseListOfIndexToken(request.getEndIndices());

        String funRange = funnyString.getFunRanges(boringString, startList, endList);
        FunnyStringEntity funnyStringEntity = new FunnyStringEntity();
        funnyStringEntity.setBoringString(boringString);
        funnyStringEntity.setFunRange(funRange);

        dbManager.insert(funnyStringEntity);
        long funnyId = dbManager.getFunnyId();

        for (int i = 0; i < startList.size(); i++) {
            OperationRangeEntity operationRangeEntity = new OperationRangeEntity();
            operationRangeEntity.setStartIndex(startList.get(i));
            operationRangeEntity.setEndIndex(endList.get(i));
            operationRangeEntity.setFunnyStringId(funnyId);
            dbManager.insert(operationRangeEntity);
        }


        return mapper.toResponse(funnyStringEntity, funnyId);
    }

    @Override
    public void sendOutPutMessage(FunRangeResponse response, OutputStrategy outputStrategy) {
        outputStrategy.print("FunnyId: " + response.getFunnyId());
        outputStrategy.print("BoringString: " + response.getBoringString());
        outputStrategy.print("FunRange: " + response.getFunRangeString());
    }

}
