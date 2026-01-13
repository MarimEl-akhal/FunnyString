package org.example.factory;

import java.io.IOException;

public interface BaseFactory<T> {
    T createInstance() ;
}
