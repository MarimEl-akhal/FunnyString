package org.example.socket_v2.server;


import org.example.Service;
import org.example.factory.FactoryDependency;
import org.example.strategy.BufferReaderStrategy;
import org.example.strategy.InputStrategy;
import org.example.strategy.OutputStrategy;
import org.example.strategy.PrintWriterStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.sql.SQLException;

public class ClientRequest {

    private final PrintWriter out;
    private final BufferedReader in;

    private final Service service;

    public ClientRequest(Socket socket) throws IOException {


        // the output that is connected to client
        this.out = new PrintWriter(socket.getOutputStream(), true);
        // Takes input from the client socket
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        this.service = FactoryDependency.getDependency(Service.class);


    }


    public void chooseClientOperation() throws SQLException, IOException, InvocationTargetException, InstantiationException, IllegalAccessException {

        InputStrategy input = new BufferReaderStrategy(in);
        OutputStrategy output = new PrintWriterStrategy(out);
        service.execute(input,output);

    }
}

