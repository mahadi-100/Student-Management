package authentication.signup;

import database.DatabaseConnection;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Statement;

public class SignUpController {
    public PasswordField idAdminPassword;
    public TextField idUserName;
    public PasswordField idPassword;
    public Button idSubmit;
    public RadioButton idTeacher;
    public Label idStatus;

    public void onAdminPassClicked() {
        String adminPass = idAdminPassword.getText();

        String adminPassword = "624234";
        if(adminPass.equals(adminPassword)){
            idAdminPassword.setText("");

            idAdminPassword.setDisable(true);
            idUserName.setDisable(false);
            idPassword.setDisable(false);
            idSubmit.setDisable(false);
        }
    }


    public void onSubmitClicked() throws SQLException {
        String name = idUserName.getText();
        String password = idPassword.getText();

        String selection = "student";

        if(idTeacher.isSelected()){
            selection = "teacher";
        }

        Statement statement = new DatabaseConnection().getStatement();
        String values = "VALUES " + "('" + name + "','" + password + "','" + selection + "')";

        String newAccountStatement = "INSERT INTO users "
                                    + " (username, password, position)" + values;

        statement.executeUpdate(newAccountStatement);

        idUserName.setDisable(true);
        idPassword.setDisable(true);
        idSubmit.setDisable(true);
        idStatus.setText("Account created  ");
        idStatus.setTextFill(Color.DARKBLUE);
    }

    public void onCloseClicked() {
        Stage stage = (Stage) idSubmit.getScene().getWindow();
        stage.close();
    }
}
