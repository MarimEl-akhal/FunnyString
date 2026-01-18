package org.example.factory.listbasefactory;

import java.util.List;

public interface ListBaseFactory<T> {
    List<T> createInstance();
}
