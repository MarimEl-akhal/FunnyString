package org.example;

import java.sql.*;
import java.util.List;

import static org.example.DataBaseConnection.getConnection;

public class JdbcStatementLogic {

    private final DataBaseConnection dbConnection;

    public JdbcStatementLogic() {
        this.dbConnection = FactoryDependency.getDependency(DataBaseConnection.class);
    }

    public void Input_Output_Strings(String boringString, String funRanges, String funnyString, List<Integer> startIndexList, List<Integer> endIndexList, List<Operations> operationsList) throws SQLException {
        String strQuery = "INSERT INTO STRINGS (boringString,funRanges,funnyString) VALUES (?,?,?)";
        PreparedStatement pstmt = getConnection().prepareStatement(strQuery, Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, boringString);
        pstmt.setString(2, funRanges);
        pstmt.setString(3, funnyString);
        pstmt.executeUpdate();
        ResultSet generatedKeys = pstmt.getGeneratedKeys();
        int stringId = 0;
        if (generatedKeys.next()) {
            stringId = generatedKeys.getInt(1);
        }

        String range_operator = "INSERT INTO stringreangesandoperations (string_id,startIndex,endIndex,operation) VALUES (?,?,?,?)";
        PreparedStatement stmt = getConnection().prepareStatement(range_operator);


        for (int i = 0; i < startIndexList.size(); i++) {
            stmt.setInt(1, stringId);
            stmt.setInt(2, startIndexList.get(i));
            stmt.setInt(3, endIndexList.get(i));
            stmt.setString(4, operationsList.get(i).name());
            stmt.executeUpdate();
        }

    }


}
