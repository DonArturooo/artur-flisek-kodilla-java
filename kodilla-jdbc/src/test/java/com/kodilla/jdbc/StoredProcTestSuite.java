package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL = \"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";

        //When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement2.execute(sqlProcedureCall);
        ResultSet rs = statement.executeQuery(sqlCheckTable);

        // Then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rs.close();
        statement.close();
        statement2.close();
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER = 0";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckBestseller = "SELECT BOOK_ID FROM kodilla_course.rents where RENT_DATE >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH) GROUP BY BOOK_ID having COUNT(*) > 2";
        String sqlBooks = "SELECT * FROM BOOKS";
        //When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement2.execute(sqlProcedureCall);
        ResultSet bestsellerQueryResult = statement.executeQuery(sqlCheckBestseller);
        List<Integer> bestsellerIds = new ArrayList<>();
        if (bestsellerQueryResult.next()) {
            bestsellerIds.add(bestsellerQueryResult.getInt("BOOK_ID"));
        }
        ResultSet resultSet = statement.executeQuery(sqlBooks);
        //Then

        while (resultSet.next()) {
            if (bestsellerIds.contains(resultSet.getInt("BOOK_ID"))) {
                assertEquals(1, resultSet.getInt("BESTSELLER"));
            }
            else {
                assertEquals(0, resultSet.getInt("BESTSELLER"));
            }
        }
        bestsellerQueryResult.close();
        resultSet.close();
        statement.close();
        statement2.close();
    }
}
