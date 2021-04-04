package pages.student;

import database.StudentDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentRecords {
    private static final ArrayList<StudentInfo> studentList = new ArrayList<>();

    public StudentRecords() throws SQLException {
        ResultSet result = new StudentDatabase().getResult("student_records");

        while(result.next()){
            studentList.add(new StudentInfo(
                    result.getString("name"), result.getString("ID"),
                    result.getString("performance"), result.getString("attendance")
            ));
        }
    }

    public ArrayList<StudentInfo> getStudentList() {
        return studentList;
    }
}
