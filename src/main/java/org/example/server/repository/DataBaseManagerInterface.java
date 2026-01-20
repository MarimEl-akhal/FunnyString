package org.example.server.repository;

import java.lang.reflect.InvocationTargetException;

public interface DataBaseManagerInterface<T> {
    T getById(long id, Class<T> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException;

    void insert(T entity);
}
