package authentication.signup;

import database.DatabaseConnection;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Statement;

public class SignUpController {
    public TextField idUserName;
    public PasswordField idPassword;
    public Button idSubmit;
    public RadioButton idTeacher;
    public Label idStatus;

    public void onSubmitClicked() throws SQLException {
        String name = idUserName.getText();
        String password = idPassword.getText();
        String selection = "student";

        if(idTeacher.isSelected()){
            selection = "teacher";
        }

        saveDataToDatabase(name, password, selection);
    }

    private void saveDataToDatabase(String name, String password, String selection) throws SQLException {
        Statement statement = new DatabaseConnection().getStatement();
        String values = "VALUES " + "('" + name + "','" + password + "','" + selection + "')";

        String newAccountStatement = "INSERT INTO users "
                + " (username, password, position)" + values;

        statement.executeUpdate(newAccountStatement);

        changeAllControls();
    }

    private void changeAllControls() {
        idUserName.setDisable(true);
        idPassword.setDisable(true);
        idSubmit.setDisable(true);
        idStatus.setVisible(true);
        idStatus.setText("Account created  ");
        idStatus.setTextFill(Color.GREEN);
    }

    public void onCloseClicked() {
        Stage stage = (Stage) idSubmit.getScene().getWindow();
        stage.close();
    }
}
