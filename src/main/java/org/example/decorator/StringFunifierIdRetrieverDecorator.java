package org.example.decorator;

import org.example.database.DataBaseManager;
import org.example.dto.request.StringFunifierRetrieverRequest;
import org.example.dto.response.StringFunifierRetrieverResponse;
import org.example.entity.FunnyStringEntity;
import org.example.factory.FactoryDependency;
import org.example.mapper.StringFunifierRetrieverMapper;
import org.example.socket_v2.server.ClientOption;
import org.example.strategy.input.InputStrategy;
import org.example.strategy.output.OutputStrategy;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class StringFunifierIdRetrieverDecorator extends StringDecorator {
    private final DataBaseManager dbManager;
    private final StringFunifierRetrieverMapper mapper;

    private StringFunifierRetrieverRequest stringFunifierRequest;

    private FunnyStringEntity funnyStringEntity;


    public StringFunifierIdRetrieverDecorator(StringComponent routerStrategyStrategyDecorator) {
        super(routerStrategyStrategyDecorator);
        this.dbManager = FactoryDependency.getDependency(DataBaseManager.class);
        this.mapper = FactoryDependency.getDependency(StringFunifierRetrieverMapper.class);
    }


    @Override
    public String getOptionName() {
        super.getOptionName();
        return  ClientOption.GET_FUNRANGEBYID.name();
    }

    @Override
    public void run(InputStrategy inputStrategy, OutputStrategy outputStrategy) {
        super.run(inputStrategy, outputStrategy);
        try {
            StringFunifierRetrieverRequest request = setInput(inputStrategy);
            StringFunifierRetrieverResponse response = executeScenario(request);
            sendOutPutMessage(response, outputStrategy);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private StringFunifierRetrieverRequest setInput(InputStrategy inputStrategy) throws IOException {
        String id = inputStrategy.read();
        stringFunifierRequest = new StringFunifierRetrieverRequest();
        stringFunifierRequest.setId(id);
        return stringFunifierRequest;
    }


    private StringFunifierRetrieverResponse executeScenario(StringFunifierRetrieverRequest request) {
        long id = Long.parseLong(stringFunifierRequest.getId());
        try {
            funnyStringEntity = (FunnyStringEntity) dbManager.getById(id, FunnyStringEntity.class);
            if (funnyStringEntity == null) {
                return mapper.toResponseFail(id);
            }

        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            System.err.println(e);
        }

        return mapper.toResponse(funnyStringEntity, id);
    }


    private void sendOutPutMessage(StringFunifierRetrieverResponse response, OutputStrategy outputStrategy) {
        outputStrategy.print("FunnyId: " + response.getFunnyId());
        outputStrategy.print("BoringString: " + response.getBoringString());
        outputStrategy.print("FunRange: " + response.getFunRangeString());
        outputStrategy.print("FunnyString: " + response.getFunnyString());
    }


}
