package JDBC_CRUD.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    public static Connection getConnection(){

        String url="jdbc:mysql://localhost:3306/JDBC_DB";
        String userName="root";
        String passWord="R_ke5nz7";

        try {
            return DriverManager.getConnection(url,userName,passWord);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
