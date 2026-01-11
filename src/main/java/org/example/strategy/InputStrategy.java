package org.example.strategy;

import java.io.IOException;

public interface InputStrategy {
    String read() throws IOException;
}


//public static String readInputWithBufferReader(BufferedReader reader) throws IOException {
//    return reader.readLine();
//}
//
//public static String readInputWithScanner(Scanner scanner){
//    return scanner.nextLine();
//}
