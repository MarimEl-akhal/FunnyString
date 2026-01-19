package org.example.serverWithMultiClient;

import org.example.serverWithMultiClient.client.Client2;

public class ClientTest2 {
    public static void main(String[] args) {
        new Client2("127.0.0.1", 5001);
    }
}
