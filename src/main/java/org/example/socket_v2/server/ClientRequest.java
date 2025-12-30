package org.example.socket_v2.server;

import org.example.IParsing;
import org.example.Parsing;
import org.example.StringFunifier;
import org.example.database.DataBaseManager;
import org.example.entity.FunnyStringEntity;
import org.example.entity.OperationRangeEntity;
import org.example.factory.FactoryDependency;

import java.sql.SQLException;


public class ClientRequest {
    private final IParsing parsing;
    private final StringFunifier funnyString;
    private final DataBaseManager dbManager;

    public ClientRequest() {
        this.parsing = FactoryDependency.getDependency(Parsing.class);
        this.funnyString = FactoryDependency.getDependency(StringFunifier.class);
        this.dbManager = FactoryDependency.getDependency(DataBaseManager.class);
    }

    public void chooseClientOperation(String boringString,String startIndices,String endIndices ,String operations) throws SQLException {

        String stringFunny = "";
        String funRange = "";

        ClientOption option = null;

        // this  to edit because option null no read  client option

        switch (option) {
            case FUNRANGE:
                FunnyStringEntity funnyStringEntity = new FunnyStringEntity();
                OperationRangeEntity operationRange = new OperationRangeEntity();
                funnyString.getFunRanges(boringString, parsing.parseListOfIndexToken(startIndices), parsing.parseListOfIndexToken(endIndices));
                dbManager.insert(funnyStringEntity);
                dbManager.insert(operationRange);
                break;
//            case FUNNYSTRING:
//                funnyString.getFunnyString(boringString, parsing.parseListOfIndexToken(startIndices), parsing.parseListOfIndexToken(endIndices), parsing.parseListOfOperationToken(operations));
//                dbManager.insertFunnyString(boringString, null, stringFunny);
//                dbManager.insertOperationRange(parsing.parseListOfIndexToken(startIndices), parsing.parseListOfIndexToken(endIndices), parsing.parseListOfOperationToken(operations));
//                break;
//
//                    case GET_FUNRANGE:
//                        id = get id;
//                        createFunStringEntity
//                                dbManager.get(FunStringEntity);
//                        send to user the data;
        }

    }
}
