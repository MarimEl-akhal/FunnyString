package org.example.factory.listBaseFactory;

import java.util.List;

public interface ListBaseFactory<T> {
    List<T> createInstance();
}
