package org.example.strategy.input;


import java.io.BufferedReader;
import java.io.IOException;


public class BufferReaderStrategy implements InputStrategy {
    private final BufferedReader reader;

    public BufferReaderStrategy(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public String read() throws IOException {
        return reader.readLine();
    }
}

//
//
//public class BufferReaderStrategy implements InputStrategy {
//    private BufferedReader reader;
//
//    public BufferReaderStrategy() throws IOException {
//        this.reader = new BufferedReader(new InputStreamReader(new Client2().getClientSocket().getInputStream()));
//    }
//
//    @Override
//    public String read() throws IOException {
//        return reader.readLine();
//    }
//}
