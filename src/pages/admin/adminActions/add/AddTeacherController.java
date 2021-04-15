package pages.admin.adminActions.add;

import database.UsersDatabase;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.sql.Statement;

public class AddTeacherController {

    public TextField getInputName;
    public TextField getInputId;
    public TextField getInput1st;
    public TextField getInput2nd;
    public TextField getInput3rd;
    public Label getOutput;

    public void onThirdClassClicked() throws SQLException {
        String name = getInputName.getText();
        String id = getInputId.getText();
        String first = getInput1st.getText();
        String second = getInput2nd.getText();
        String third = getInput3rd.getText();

        saveToDatabase(name, id, first, second, third);
    }

    private void saveToDatabase(String name, String id, String first, String second, String third) throws SQLException {
        Statement statement = new UsersDatabase().getStatement();
        String values = "VALUES " + "('" + name + "','" + id + "','" + first + "','" + second + "','"  + third + "')";

        String newRecordStatement = "INSERT INTO users " + " (name, ID, firstClass, secondClass, thirdClass)" + values;

        statement.executeUpdate(newRecordStatement);

        getOutput.setVisible(true);
        getOutput.setText("Record Saved");
    }
}
