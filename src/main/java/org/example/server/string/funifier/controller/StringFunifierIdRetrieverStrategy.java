package org.example.server.string.funifier.controller;

import org.example.server.repository.DataBaseManager;
import org.example.server.dto.request.StringFunifierRetrieverRequest;
import org.example.server.dto.response.StringFunifierRetrieverResponse;
import org.example.server.entity.FunnyStringEntity;
import org.example.server.factory.dependency.FactoryDependency;
import org.example.io.method.input.InputStrategy;
import org.example.io.method.output.OutputStrategy;
import org.example.server.mapper.StringFunifierRetrieverMapper;
import org.example.server.ClientOption;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class StringFunifierIdRetrieverStrategy implements RouterStrategyInterface<StringFunifierRetrieverRequest, StringFunifierRetrieverResponse> {
    private final DataBaseManager dbManager;
    private final StringFunifierRetrieverMapper mapper;

    private StringFunifierRetrieverRequest stringFunifierRequest;

    private FunnyStringEntity funnyStringEntity;


    public StringFunifierIdRetrieverStrategy() {
        this.dbManager = FactoryDependency.getDependency(DataBaseManager.class);
        this.mapper = FactoryDependency.getDependency(StringFunifierRetrieverMapper.class);
    }


    @Override
    public ClientOption getOptionName() {
        return ClientOption.GET_FUNRANGEBYID;
    }

    @Override
    public StringFunifierRetrieverRequest mapInputToRequestBody(InputStrategy inputStrategy) throws IOException {
        String id = inputStrategy.read();
        stringFunifierRequest = new StringFunifierRetrieverRequest();
        stringFunifierRequest.setId(id);
        return stringFunifierRequest;
    }


    @Override
    public StringFunifierRetrieverResponse executeScenario(StringFunifierRetrieverRequest request) {
        long id = Long.parseLong(request.getId());
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

    @Override
    public void sendOutPutMessage(StringFunifierRetrieverResponse response, OutputStrategy outputStrategy) {
        outputStrategy.print("FunnyId: " + response.getFunnyId());
        outputStrategy.print("BoringString: " + response.getBoringString());
        outputStrategy.print("FunRange: " + response.getFunRangeString());
        outputStrategy.print("FunnyString: " + response.getFunnyString());
    }


}
