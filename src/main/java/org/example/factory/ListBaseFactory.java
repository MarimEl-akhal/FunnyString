package org.example.factory;

import java.util.List;

public interface ListBaseFactory<T> {
    List<T> createInstance();
}
