package org.example.factory.basefactory;

public interface BaseFactory<T> {
    T createInstance();
}
