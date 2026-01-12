package org.example.abstraction;

import org.example.database.DataBaseManager;
import org.example.dto.StringFunifierRequest;
import org.example.dto.StringFunifierResponse;
import org.example.entity.FunnyStringEntity;
import org.example.factory.FactoryDependency;
import org.example.mapper.FunnyStringEntityMapper;
import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class StringFunifierIdRetrieverStrategy implements Strategy {
    private final DataBaseManager dbManager;
    private final FunnyStringEntityMapper mapper;

    private StringFunifierRequest stringFunifierRequest;

    private FunnyStringEntity funnyStringEntity;

    public StringFunifierIdRetrieverStrategy() {
        this.dbManager = FactoryDependency.getDependency(DataBaseManager.class);
        this.mapper = FactoryDependency.getDependency(FunnyStringEntityMapper.class);
    }

    @Override
    public void setInput(InputStrategy inputStrategy) throws IOException {
        String id = inputStrategy.read();
        stringFunifierRequest = new StringFunifierRequest();
        stringFunifierRequest.setFunnyId(id);
    }

    @Override
    public StringFunifierResponse executeScenario(StringFunifierRequest request) {
        long id = Long.parseLong(stringFunifierRequest.getFunnyId());
        try {
            funnyStringEntity = (FunnyStringEntity) dbManager.getById(id, FunnyStringEntity.class);
            if (funnyStringEntity == null) {
                throw new Error("No data found for id " + id);
            }

        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            System.err.println(e);
        }

        return mapper.toResponse(funnyStringEntity, id);
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

}
