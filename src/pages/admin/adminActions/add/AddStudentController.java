package pages.admin.adminActions.add;

import database.UsersDatabase;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.sql.Statement;

public class AddStudentController {

    public TextField idInputAttendance;
    public Label idOutput;
    public TextField idInputPerformance;
    public TextField idInputId;
    public TextField idInputName;

    public void onAttendanceAction() throws SQLException {
        String name = idInputName.getText();
        String id = idInputId.getText();
        String performance = idInputPerformance.getText();
        String attendance = idInputAttendance.getText();

        String values = "VALUES " + "('" + name + "','" + id + "','" + performance + "','" + attendance + "')";
        String newStudentRecords = "INSERT INTO student_records " + " (name, ID, performance, attendance)" + values;

        Statement statement = new UsersDatabase().getStatement();
        statement.executeUpdate(newStudentRecords);

        idOutput.setVisible(true);
        idOutput.setText("Record added");
    }
}
