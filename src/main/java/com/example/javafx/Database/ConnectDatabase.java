//package com.example.javafx.Database;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//    public class ConnectDatabase {
//        private static final String URL = "jdbc:postgresql://localhost:5432/library_db";
//        private static final String USER = "postgres";
//        private static final String PASSWORD = "pov123@num";
//        public static Connection connectionDB(){
//            try{
//                Class.forName("org.sqlite.JDBC");
//
//                return DriverManager.getConnection(URL);
//            } catch (SQLException | ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//        }
//}

package com.example.javafx.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    private static final String URL = "jdbc:postgresql://localhost:5432/library_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "pov123@num";

    public static Connection connectionDB() {
        try {
            // Load PostgreSQL Driver
            Class.forName("org.postgresql.Driver");

            // Return connection with username & password
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("❌ Database connection failed: " + e.getMessage(), e);
        }
    }
}
