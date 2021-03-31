package database;

import java.sql.*;

public class DatabaseConnection {
    private final ResultSet result;
    private final Statement statement;

    public DatabaseConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/school_management";
        String username = "root";
        String password = "@6242@mha";

        Connection connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
        result = statement.executeQuery("SELECT * FROM users");
    }

    public ResultSet getResult() {
        return result;
    }

    public Statement getStatement() {
        return statement;
    }
}
