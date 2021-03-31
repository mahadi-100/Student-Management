package database;

import java.sql.*;

public class DatabaseConnection {
    private final ResultSet result;

    public DatabaseConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/school_management";
        String username = "root";
        String password = "@6242@mha";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        result = statement.executeQuery("SELECT * FROM users");
    }

    public ResultSet getResult() {
        return result;
    }
}
