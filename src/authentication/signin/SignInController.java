package authentication.signin;

import database.DatabaseConnection;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInController{

    public TextField idUserName;
    public PasswordField idPassword;

    public void onEnterClicked() throws SQLException {
        String userName = idUserName.getText();
        String passWord = idPassword.getText();

        ResultSet resultSet = new DatabaseConnection().getResult();

        int match = 0;
        while (resultSet.next()){
            if(userName.equals(resultSet.getString("username"))
                && passWord.equals(resultSet.getString("password"))){
                match = 1;
                break;
            }
        }

        //TODO
        //just to test purpose
        if(match == 1){
            System.out.println("done");
        }else {
            System.out.println("Not done!");
        }

    }

    public void onNewUserClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/authentication/signup/SignUp.fxml"));

        Stage stage = new Stage();
        stage.setTitle("Sign Up");
        stage.setScene(new Scene(root));
        stage.show();
    }
}