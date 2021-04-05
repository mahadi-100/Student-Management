package authentication.signup;

import database.UsersDatabase;
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

    /**
     * get user inputs and sent the data to another method.
     *
     * @throws SQLException database connection failure
     */
    public void onSubmitClicked() throws SQLException {
        String name = idUserName.getText();
        String password = idPassword.getText();
        String selection = "student";

        if(idTeacher.isSelected()){
            selection = "teacher";
        }

        saveDataToDatabase(name, password, selection);
    }

    /**
     * user inputs(name, password, position) will be saved to database and
     * will create new user based on the inputs. user will have limited
     * access to database using their newly created account.
     *
     * @param name is user given name
     * @param password is user given password
     * @param selection is user's selection if he is teacher/ student
     * @throws SQLException connection issue
     */
    private void saveDataToDatabase(String name, String password, String selection) throws SQLException {
        Statement statement = new UsersDatabase().getStatement();
        String values = "VALUES " + "('" + name + "','" + password + "','" + selection + "')";

        String newAccountStatement = "INSERT INTO users "
                + " (username, password, position)" + values;

        statement.executeUpdate(newAccountStatement);

        changeAllControls();
    }

    /**
     * to prevent user from spamming and creating multiple accounts
     * all buttons and input fields will be closed and no input
     * will be taken.
     */
    private void changeAllControls() {
        idUserName.setDisable(true);
        idPassword.setDisable(true);
        idSubmit.setDisable(true);
        idStatus.setVisible(true);
        idStatus.setText("Account created  ");
        idStatus.setTextFill(Color.GREEN);
    }

    /**
     * close the page and previous page will be highlighted.
     */
    public void onCloseClicked() {
        Stage stage = (Stage) idSubmit.getScene().getWindow();
        stage.close();
    }
}
