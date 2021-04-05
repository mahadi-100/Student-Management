package pages.student;

import database.StudentDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentRecords {
    private final ArrayList<StudentInfo> studentList = new ArrayList<>();

    /**
     * all data of student been saved from the database.
     *
     * @throws SQLException connection failure
     */
    public StudentRecords() throws SQLException {
        ResultSet result = new StudentDatabase().getResult("student_records");

        while(result.next()){
            studentList.add(new StudentInfo(
                    result.getString("name"), result.getString("ID"),
                    result.getString("performance"), result.getString("attendance")
            ));
        }
    }

    /**
     * calling upon this method any class can access the student record database.
     *
     * @return student records from database in arrayList format.
     */
    public ArrayList<StudentInfo> getList() {
        return studentList;
    }
}
