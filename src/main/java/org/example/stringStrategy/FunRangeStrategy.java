package org.example.stringStrategy;

import org.example.StringFunifier;
import org.example.database.DataBaseManager;
import org.example.dto.request.FunRangeRequest;
import org.example.dto.response.FunRangeResponse;
import org.example.entity.FunnyStringEntity;
import org.example.entity.OperationRangeEntity;
import org.example.factory.FactoryDependency;
import org.example.mapper.FunRangeMapper;
import org.example.parsingg.IParsing;
import org.example.parsingg.Parsing;
import org.example.socket_v2.server.ClientOption;
import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;
import java.util.List;

public class FunRangeStrategy extends RouterStrategy<FunRangeRequest, FunRangeResponse> {

    private final IParsing parsing;
    private final StringFunifier funnyString;
    private final DataBaseManager dbManager;
    private final FunRangeMapper mapper;

    private FunRangeRequest funRangeRequest;

    private FunnyStringEntity funnyStringEntity;


    public FunRangeStrategy() {
        this.parsing = FactoryDependency.getDependency(Parsing.class);
        this.funnyString = FactoryDependency.getDependency(StringFunifier.class);
        this.dbManager = FactoryDependency.getDependency(DataBaseManager.class);
        this.mapper = FactoryDependency.getDependency(FunRangeMapper.class);

    }

    @Override
    public FunRangeRequest setInput(InputStrategy inputStrategy) throws IOException {
        String boringString = inputStrategy.read();
        String start = inputStrategy.read();
        String end = inputStrategy.read();

        funRangeRequest = new FunRangeRequest();

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

        saveFunnyStringEntityData(boringString, funRange);
        long funny_Id = dbManager.getFunnyId();


        FunRangeResponse response = mapper.toResponse(funnyStringEntity, funny_Id);

        saveOperationRangeEntityData(startList, endList, funny_Id);

        return response;
    }

    @Override
    public void sendOutPutMessage(FunRangeResponse response, OutputStrategy outputStrategy) {
        outputStrategy.print("FunnyId: " + response.getFunnyId());
        outputStrategy.print("BoringString: " + response.getBoringString());
        outputStrategy.print("FunRange: " + response.getFunRangeString());
    }

    @Override
    public ClientOption getOptionName() {
        return ClientOption.FUNRANGE;
    }

    private void saveFunnyStringEntityData(String boringString, String funRange) {
        funnyStringEntity = new FunnyStringEntity();
        funnyStringEntity.setBoringString(boringString);
        funnyStringEntity.setFunRange(funRange);

        dbManager.insert(funnyStringEntity);
    }

    private void saveOperationRangeEntityData(List<Integer> startList, List<Integer> endList, long id) {

        OperationRangeEntity operationRangeEntity = new OperationRangeEntity();

        for (int i = 0; i < startList.size(); i++) {
            operationRangeEntity.setStartIndex(startList.get(i));
            operationRangeEntity.setEndIndex(endList.get(i));
        }
        operationRangeEntity.setFunnyStringId(id);
        dbManager.insert(operationRangeEntity);

    }
}
