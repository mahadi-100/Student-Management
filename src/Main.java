import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
      launch(args);
    }

    /**
     * program execution starts here and SignIn.fxml invoked
     * to complete the sign in process.
     *
     * @param primaryStage layout of the main starting page
     * @throws Exception can't load the layout properly
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/authentication/signin/SignIn.fxml"));

        primaryStage.setTitle("Sign In");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
