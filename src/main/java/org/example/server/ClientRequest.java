package org.example.server;


import org.example.server.factory.dependency.FactoryDependency;
import org.example.io.method.input.BufferReaderStrategy;
import org.example.io.method.input.InputStrategy;
import org.example.io.method.output.OutputStrategy;
import org.example.io.method.output.PrintWriterStrategy;
import org.example.server.service.Router;

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

    private final Router router;

    public ClientRequest(Socket socket) throws IOException {

        // the output that is connected to client
        this.out = new PrintWriter(socket.getOutputStream(), true);
        // Takes input from the client socket
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.router = FactoryDependency.getDependency(Router.class);

    }

    public void executeClientRequest() throws SQLException, IOException, InvocationTargetException, InstantiationException, IllegalAccessException {
        InputStrategy input = new BufferReaderStrategy(in);
        OutputStrategy output = new PrintWriterStrategy(out);
        router.execute(input, output);

    }
}

