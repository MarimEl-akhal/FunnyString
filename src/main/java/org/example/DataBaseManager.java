package org.example.database;

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
            String columns = String.join(",",columnNames);
            String questionMarks = String.join(",", "?".repeat(values.size()).split(""));
            String insertQuery = "INSERT INTO " + tableName + "(" + columns + ") VALUES (" + questionMarks + ")";
            System.out.println(insertQuery);
            PreparedStatement preparedStatement = getConnection().prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
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
//
//    public void insertFunnyString(String boringString, String funRange, String funnyString) throws SQLException {
//        String strQuery = "INSERT INTO funny_string (boringString,funRanges,funnyString) VALUES (?,?,?)";
//        PreparedStatement pstmt = getConnection().prepareStatement(strQuery, Statement.RETURN_GENERATED_KEYS);
//
//        pstmt.setString(1, boringString);
//        pstmt.setString(2, funRange);
//        pstmt.setString(3, funnyString);
//        pstmt.executeUpdate();
//
//        ResultSet generatedKeys = pstmt.getGeneratedKeys();
//        if (generatedKeys.next()) {
//            funnyId = generatedKeys.getInt(1);
//        }
//
//    }
//
//    public void insertOperationRange(List<Integer> startIndexList, List<Integer> endIndexList, List<Operation> operationsList) throws SQLException {
//
//        String range_operator = "INSERT INTO operation_range (funny_id,start_Index,end_Index,operation) VALUES (?,?,?,?)";
//        PreparedStatement stmt = getConnection().prepareStatement(range_operator);
//
//
//        for (int i = 0; i < startIndexList.size(); i++) {
//            stmt.setInt(1, funnyId);
//            stmt.setInt(2, startIndexList.get(i));
//            stmt.setInt(3, endIndexList.get(i));
//            stmt.setString(4, operationsList.get(i).name());
//            stmt.executeUpdate();
//        }
//
//        closeConnection();
//    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection is closed");
            }
        } catch (SQLException e) {
            System.out.println("Closing Connection failed");
        }
    }


}
