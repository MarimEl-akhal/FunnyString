package org.example.io.method.input;

import java.io.IOException;

public interface InputStrategy {
    String read() throws IOException;
}
