package authentication.signup;

import database.UsersDatabase;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class SignUpController {
    public TextField idUserName;
    public PasswordField idPassword;
    public Button idSubmit;
    public RadioButton idTeacher;
    public Label idStatus;
    public TextField idFirstName;
    public TextField idLastName;
    public DatePicker idBirthDate;

    private LocalDate birthdate;

    /**
     * get user inputs and sent the data to another method to save them in database.
     *
     * @throws SQLException database connection failure
     */
    public void onSubmitClicked() throws SQLException {
        String userName = idUserName.getText();
        String password = idPassword.getText();
        String selection = "student";

        String firstName = idFirstName.getText();
        String lastName = idLastName.getText();
        String birthDate = birthdate.toString();

        if(idTeacher.isSelected()){
            selection = "teacher";
        }

        saveDataToDatabase(firstName, lastName, birthDate,  userName, password, selection);
    }


    /**
     * all six parameters add to the database.
     *
     * @param firstName first name of the new user
     * @param lastName last name of the user
     * @param birthDate birthDate of the user
     * @param userName unique name entered by user
     * @param password user given password.
     * @param selection position of the user (student/teacher)
     * @throws SQLException fail to connect with database
     */
    private void saveDataToDatabase(String firstName, String lastName, String birthDate,
                                    String userName, String password, String selection) throws SQLException {

        Statement statement = new UsersDatabase().getStatement();
        String values = "VALUES " + "('" + firstName + "','" + lastName + "','" + birthDate + "','"
                        + userName + "','" + password + "','" + selection + "')";

        String newAccountStatement = "INSERT INTO users " + " (firstName, lastName, birthDate, userName, password, selection)"
                                        + values;

        statement.executeUpdate(newAccountStatement);

        changeAllControls();
    }


    /**
     * to prevent user from spamming and creating multiple accounts at the same time
     * all buttons and input fields will be closed and no input
     * will be taken.
     */
    private void changeAllControls() {
        idUserName.setDisable(true);
        idPassword.setDisable(true);
        idFirstName.setDisable(true);
        idLastName.setDisable(true);
        idSubmit.setDisable(true);
        idStatus.setVisible(true);
        idStatus.setText("Account created  ");
        idStatus.setTextFill(Color.DARKBLUE);
    }

    /**
     * close the page and previous page will be highlighted.
     */
    public void onCloseClicked() {
        Stage stage = (Stage) idSubmit.getScene().getWindow();
        stage.close();
    }

    /**
     * get the birth date from the user and save it to birthday variable.
     */
    public void onDateClicked() {
        birthdate = idBirthDate.getValue();
    }
}
