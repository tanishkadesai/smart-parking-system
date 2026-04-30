package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/parking_db",
                    "root",
                    "root123"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        Connection con = getConnection();
        if (con != null) {
            System.out.println("✅ Connected to MySQL!");
        } else {
            System.out.println("❌ Connection Failed!");
        }
    }
}