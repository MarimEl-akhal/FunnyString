//package org.example.factory;
//
//import org.example.socket_v2.server.ClientHandler;
//
//public class ClientHandlerFactory implements BaseFactory<ClientHandler> {
//    private ClientHandler clientHandler;
//
//    @Override
//    public ClientHandler createInstance() {
//        if (clientHandler == null) {
//            return new ClientHandler();
//        }
//        return clientHandler;
//    }
//}
