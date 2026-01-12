package org.example.stringStrategy;

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

public class StringFunifierIdRetrieverStrategy extends StringFunifierStrategy<StringFunifierRetrieverRequest, StringFunifierRetrieverResponse> {
    private final DataBaseManager dbManager;
    private final StringFunifierRetrieverMapper mapper;

    private StringFunifierRetrieverRequest stringFunifierRequest;

    private FunnyStringEntity funnyStringEntity;


    public StringFunifierIdRetrieverStrategy() {
        this.dbManager = FactoryDependency.getDependency(DataBaseManager.class);
        this.mapper = FactoryDependency.getDependency(StringFunifierRetrieverMapper.class);
    }


    @Override
    public StringFunifierRetrieverRequest setInput(InputStrategy inputStrategy) throws IOException {
        String id = inputStrategy.read();
        stringFunifierRequest = new StringFunifierRetrieverRequest();
        stringFunifierRequest.setId(id);
        return  stringFunifierRequest;
    }

    @Override
    public StringFunifierRetrieverResponse executeScenario(StringFunifierRetrieverRequest request) {
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

    @Override
    public void sendOutPutMessage(StringFunifierRetrieverResponse response, OutputStrategy outputStrategy) {
        outputStrategy.print("FunnyId: " + response.getFunnyId());
        outputStrategy.print("BoringString: " + response.getBoringString());
        outputStrategy.print("FunRange: " + response.getFunRangeString());
        outputStrategy.print("FunnyString: " + response.getFunnyString());
    }

    @Override
    public ClientOption getOptionName() {
        return ClientOption.GET_FUNRANGEBYID;
    }
}
