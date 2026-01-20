package org.example.server.factory.dependency.list.base.factory;

import java.util.List;

public interface ListBaseFactory<T> {
    List<T> createInstance();
}
