package authentication.signin;

import database.DatabaseConnection;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInController{

    public TextField idUserName;
    public PasswordField idPassword;
    public Label idStatus;

    public void onEnterClicked() throws SQLException {
        String userName = idUserName.getText();
        String passWord = idPassword.getText();

        checkIfUserAvailable(userName, passWord);
    }

    private void checkIfUserAvailable(String username, String password) throws SQLException {
        ResultSet resultSet = new DatabaseConnection().getResult();

        boolean userExist = false;
        String position = "student";
        while (resultSet.next()){
            if(username.equals(resultSet.getString("username"))
                    && password.equals(resultSet.getString("password"))){

                if(resultSet.getString("position").equals("teacher")){
                    position = "teacher";
                }
                else if(resultSet.getString("position").equals("admin")){
                    position = "admin";
                }
                userExist = true;
                break;
            }
        }

        actionUponUsersExistence(userExist, position);
    }

    private void actionUponUsersExistence(boolean userExist, String position) {
        if(userExist)
            showThePageBasedOnPosition(position);
        else{
            idStatus.setVisible(true);
            idStatus.setTextFill(Color.RED);
            idStatus.setText("User not found");
        }
    }

    private void showThePageBasedOnPosition(String position) {
        if (position.equals("student")){
            goToStudentPage();
        }
        else if (position.equals("admin")){
            goToAdminPage();
        }
        else{
            goToTeacherPage();
        }
    }

    private void goToTeacherPage() {
        //todo
    }

    private void goToAdminPage() {
        //todo
    }

    private void goToStudentPage() {
        //todo
    }

    public void onNewUserClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/authentication/signup/SignUp.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Sign Up");
        stage.setScene(new Scene(root));
        stage.show();
    }
}