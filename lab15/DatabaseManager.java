package lab15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseManager {
    private final String URL = "jdbc:mysql://localhost:3306/login_app";
    private final String USER = "root";
    private final String PASSWORD = ""; // Өөрийн нууц үг эсвэл хоосон орхино

    public boolean authenticateUser(String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            boolean success = rs.next();
            rs.close();
            pst.close();
            con.close();
            return success;
        } catch (Exception e) {
            e.printStackTrace(); // Алдааг консольд хэвлэх
            return false;
        }
    }

    public boolean registerUser(String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pst = con.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            pst.setString(1, username);
            pst.setString(2, password);
            int rowsAffected = pst.executeUpdate();
            pst.close();
            con.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace(); // Алдааг консольд хэвлэх
            return false;
        }
    }
}