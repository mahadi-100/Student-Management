package pages.admin.adminActions;

import database.UsersDatabase;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchController {
    public TextField idInput;
    public RadioButton idSelectStudent;
    public RadioButton idSelectTeacher;
    public Label idOutput;


    public void onNameInputClicked() throws SQLException {
        String name = idInput.getText();

        String position = "student";
        if(idSelectTeacher.isSelected()){
            position = "teacher";
        }

        if(position.equals("teacher")){
            searchToTeacherDatabase(name);
        }
        else {
            searchToStudentDatabase(name);
        }
    }

    private void searchToStudentDatabase(String name) throws SQLException {
        ResultSet resultSet = new UsersDatabase().getResult("student_records");

        while (resultSet.next()){
            if(name.equals(resultSet.getString("name"))){
                idOutput.setText("Name : " + resultSet.getString("name")
                        + "\nID: " + resultSet.getString("ID")
                        + "\nPerformance: " + resultSet.getString("performance")
                        + "\nAttendance: " + resultSet.getString("attendance"));
            }
        }
        idOutput.setVisible(true);
    }

    private void searchToTeacherDatabase(String name) throws SQLException {
        ResultSet resultSet = new UsersDatabase().getResult("teacher_records");

        while (resultSet.next()){
            if(name.equals(resultSet.getString("name"))){
                idOutput.setText("Name : " + resultSet.getString("name")
                                    + "\nID: " + resultSet.getString("ID")
                                    + "\nClasses: " + resultSet.getString("firstClass")
                                    + "\t" + resultSet.getString("secondClass")
                                    + "\t" + resultSet.getString("thirdClass"));
            }
        }
        idOutput.setVisible(true);
    }

}