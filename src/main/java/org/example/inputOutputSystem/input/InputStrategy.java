package org.example.inputOutputSystem.input;

import java.io.IOException;

public interface InputStrategy {
    String read() throws IOException;
}
