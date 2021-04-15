package pages.admin;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;

public class AdminController {

    public VBox vBox;

    public void onAddClicked(){
        HBox hBox = new HBox();
        Button student = new Button("add student Record");
        Button teacher = new Button("add teacher record");

        hBox.getChildren().addAll(student, teacher);
        hBox.setAlignment(Pos.CENTER);

        vBox.getChildren().setAll(hBox);

        student.setOnAction(event->{
            VBox studentAdd = null;
            try {
                studentAdd = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminActions/add/AddStudent.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            vBox.getChildren().setAll(studentAdd);
        });

        teacher.setOnAction(event -> {
            VBox teacherAdd = null;
            try {
                teacherAdd = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminActions/add/AddTeacher.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            vBox.getChildren().setAll(teacherAdd);
        });

    }

    public void onSearchClicked() throws IOException {
        VBox search = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("adminActions/Search.fxml")));
        vBox.getChildren().setAll(search);
    }
}
