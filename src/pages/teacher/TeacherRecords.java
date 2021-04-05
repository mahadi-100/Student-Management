package pages.teacher;

import database.TeacherDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherRecords {
    private final ArrayList<TeacherInfos> teacherList = new ArrayList<>();

    public TeacherRecords() throws SQLException {
        ResultSet result = new TeacherDatabase().getResult("teacher_records");

        while(result.next()){
            teacherList.add(new TeacherInfos(
                    result.getString("name"), result.getString("ID"),
                    result.getString("firstClass"),
                    result.getString("secondClass"),
                    result.getString("thirdClass")
            ));
        }
    }

    public ArrayList<TeacherInfos> getList() {
        return teacherList;
    }
}
