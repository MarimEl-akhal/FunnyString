package org.example.factory;

import org.example.socket_v2.server.ClientRequest;

import java.io.IOException;
import java.net.Socket;

public class ClientRequestFactory implements BaseFactory<ClientRequest> {
    private ClientRequest clientRequest;

    @Override
    public ClientRequest createInstance() throws IOException {
        if (clientRequest == null) {
            return new ClientRequest(new Socket());
        }
        return clientRequest;
    }
}
