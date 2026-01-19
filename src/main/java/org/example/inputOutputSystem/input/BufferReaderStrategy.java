package org.example.inputOutputSystem.input;


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
