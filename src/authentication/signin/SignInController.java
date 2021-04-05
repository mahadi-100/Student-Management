package authentication.signin;

import database.UsersDatabase;
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

public class SignInController {

    public TextField idUserName;
    public PasswordField idPassword;
    public Label idStatus;

    /**
     * get name and password input from the user and send them
     * to another method for checking if user exist in database.
     *
     * @throws SQLException if database connection fail
     */
    public void onEnterClicked() throws SQLException {
        String userName = idUserName.getText();
        String passWord = idPassword.getText();

        checkIfUserAvailable(userName, passWord);
    }

    /**
     * use username and password to traverse through the database looking for
     * the user.if user exist then take action by calling another method.
     *
     * @param username is the name user gave
     * @param password is the password user gave
     * @throws SQLException database connection failure
     */
    private void checkIfUserAvailable(String username, String password) throws SQLException {
        ResultSet resultSet = new UsersDatabase().getResult("users");

        boolean userExist = false;
        String position = "student";
        while (resultSet.next()) {
            if (username.equals(resultSet.getString("username"))
                    && password.equals(resultSet.getString("password"))) {

                if (resultSet.getString("position").equals("teacher")) {
                    position = "teacher";
                } else if (resultSet.getString("position").equals("admin")) {
                    position = "admin";
                }
                userExist = true;
                break;
            }
        }

        actionUponUsersExistence(userExist, position);
    }

    /**
     * upon user's existence and user's position specific page will be shown and if no
     * user exist then just no user found will be shown as output.
     *
     * @param userExist the existence of the user true or false
     * @param position is the position of the user if he is teacher/admin/student
     */
    private void actionUponUsersExistence(boolean userExist, String position) {
        if (userExist)
            showThePageBasedOnPosition(position);
        else {
            idStatus.setVisible(true);
            idStatus.setTextFill(Color.RED);
            idStatus.setText("User not found");
        }
    }

    /**
     * position decides will fxml file will name and which title
     * will be sent to the goToSpecificPage method.
     *
     * @param position defines if user(teacher/student/admin)
     */
    private void showThePageBasedOnPosition(String position) {
        switch (position) {
            case "student":
                goToSpecificPage("student", "Student.fxml", "Student");
                break;
            case "admin":
                goToSpecificPage("admin", "Admin.fxml", "Admin");
                break;
            case "teacher":
                goToSpecificPage("teacher", "Teacher.fxml", "Teacher");
                break;
        }
        Stage stage = (Stage) idStatus.getScene().getWindow();
        stage.close();
    }

    /**
     * based on user positions different fxmlFile being called and
     * different pages will be shown.
     *
     * @param packageName is the package name where fxml files are located
     * @param fxmlFileName name of the fxml files those been called
     * @param title title of the stage.
     */
    private void goToSpecificPage(String packageName, String fxmlFileName, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/pages/" + packageName + "/" + fxmlFileName));

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * clicking new user button invoke the signUp.fxml file and show
     * the contents that signUp.fxml contains.
     *
     * @throws IOException fxml file can't load properly
     */
    public void onNewUserClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/authentication/signup/SignUp.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Sign Up");
        stage.setScene(new Scene(root));
        stage.show();
    }
}