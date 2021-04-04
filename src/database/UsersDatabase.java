package database;

import java.sql.*;

public class UsersDatabase {
    private final Statement statement;

    public UsersDatabase() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/school_management";
        String username = "root";
        String password = "@6242@mha";

        Connection connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
    }

    public ResultSet getResult(String dataBaseName) throws SQLException {
        return statement.executeQuery("SELECT * FROM " + dataBaseName);
    }

    public Statement getStatement() {
        return statement;
    }
}
