package org.example.abstraction;

import org.example.StringFunifier;
import org.example.database.DataBaseManager;
import org.example.dto.StringFunifierRequest;
import org.example.dto.StringFunifierResponse;
import org.example.entity.FunnyStringEntity;
import org.example.entity.OperationRangeEntity;
import org.example.factory.FactoryDependency;
import org.example.mapper.FunnyStringEntityMapper;
import org.example.parsingg.IParsing;
import org.example.parsingg.Parsing;
import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;
import java.util.List;

public class FunRangeStrategy implements Strategy {

    private final IParsing parsing;
    private final StringFunifier funnyString;
    private final DataBaseManager dbManager;
    private final FunnyStringEntityMapper mapper;

    private StringFunifierRequest stringFunifierRequest;

    private FunnyStringEntity funnyStringEntity;


    public FunRangeStrategy() {
        this.parsing = FactoryDependency.getDependency(Parsing.class);
        this.funnyString = FactoryDependency.getDependency(StringFunifier.class);
        this.dbManager = FactoryDependency.getDependency(DataBaseManager.class);
        this.mapper = FactoryDependency.getDependency(FunnyStringEntityMapper.class);

    }

    @Override
    public void setInput(InputStrategy inputStrategy) throws IOException {
        String boringString = inputStrategy.read();
        String start = inputStrategy.read();
        String end = inputStrategy.read();

        stringFunifierRequest = new StringFunifierRequest();

        stringFunifierRequest.setBoringString(boringString);
        stringFunifierRequest.setStartIndices(start);
        stringFunifierRequest.setEndIndices(end);


    }

    @Override
    public StringFunifierResponse executeScenario(StringFunifierRequest stringFunifierRequest) {
        String boringString = stringFunifierRequest.getBoringString();
        List<Integer> startList = parsing.parseListOfIndexToken(stringFunifierRequest.getStartIndices());
        List<Integer> endList = parsing.parseListOfIndexToken(stringFunifierRequest.getEndIndices());

        String funRange = funnyString.getFunRanges(boringString, startList, endList);

        saveFunnyStringEntityData(boringString, funRange);
        long funny_Id = dbManager.getFunnyId();


        StringFunifierResponse response = mapper.toResponse(funnyStringEntity, funny_Id);

        saveOperationRangeEntityData(startList, endList, funny_Id);

        return response;
    }

    @Override
    public void receiveOutPutMessage(OutputStrategy outputStrategy) {
        StringFunifierResponse response = executeScenario(stringFunifierRequest);
        outputStrategy.print("FunnyId: " + response.getFunnyId());
        outputStrategy.print("BoringString: " + response.getBoringString());
        outputStrategy.print("FunRange: " + response.getFunRange());
        outputStrategy.print("FunnyString: " + response.getFunnyString());
    }

    @Override
    public void run(InputStrategy inputStrategy, OutputStrategy outputStrategy) throws IOException {
        setInput(inputStrategy);
        executeScenario(stringFunifierRequest);
        receiveOutPutMessage(outputStrategy);
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
