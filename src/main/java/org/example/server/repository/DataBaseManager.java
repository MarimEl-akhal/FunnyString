package org.example.server.repository;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseManager<T> implements DataBaseManagerInterface<T> {
    private static final String URL = "jdbc:mariadb://localhost:3306/funifier";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123";
    private static Connection connection;
    private long funnyId = 0;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println("DataBase is connection established.");
                return connection;
            } catch (SQLException e) {
                System.out.println("Start Connection failed");
                System.out.println(e.getMessage());
                return null;
            }
        }
    }

    public long getFunnyId() {
        return funnyId;
    }

    @Override
    public T getById(long id, Class<T> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        String tableName = clazz.getSimpleName();
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                T entity = clazz.getDeclaredConstructor().newInstance();
                for (Field field : clazz.getDeclaredFields()) {
                    field.setAccessible(true);
                    field.set(entity, rs.getObject(field.getName()));
                }
                return entity;
            }

        } catch (SQLException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void insert(T entity) {
        try {
            Class<?> c = entity.getClass();
            String tableName = c.getSimpleName();
            Field[] fields = c.getDeclaredFields();
            List<String> columnNames = new ArrayList<>();
            List<Object> values = new ArrayList<>();
            for (Field field : fields) {
                if (!field.getName().equals("id")) {
                    field.setAccessible(true);
                    columnNames.add(field.getName());
                    values.add(field.get(entity));
                }
            }

            String columns = String.join(",", columnNames);
            String questionMarks = String.join(",", "?".repeat(values.size()).split(""));
            String insertQuery = "INSERT INTO " + tableName + "(" + columns + ") VALUES (" + questionMarks + ")";

            PreparedStatement preparedStatement = getConnection().prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < values.size(); i++) {
                preparedStatement.setObject(i + 1, values.get(i));
            }

            preparedStatement.executeUpdate();

            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next()) {
                funnyId = keys.getLong(1);
            }

        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

}
