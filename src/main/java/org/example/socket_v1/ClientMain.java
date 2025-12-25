package org.example.socket_v1;

import java.io.IOException;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        Client client = new Client("127.0.0.1",5000);
    }
}
//abbccCDdBCCcc
//1, 5, 7, 11
//3, 5, 10, 12
//"REVERSE", "UPPERCASE", "SORT", "COMPRESSION"

//ccchHJKkklmlmmml
//1, 5, 7, 11, 13
//3, 5, 10, 12, 14
//"REVERSE", "UPPERCASE", "SORT", "LOWERCASE", "COMPRESSION"