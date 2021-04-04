package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDatabase extends UsersDatabase{

    public StudentDatabase() throws SQLException {
        super();
    }

    @Override
    public ResultSet getResult(String dataBaseName) throws SQLException {
        return super.getResult(dataBaseName);
    }

    @Override
    public Statement getStatement() {
        return super.getStatement();
    }
}
