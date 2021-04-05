package pages.teacher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {
    public TableColumn<TeacherInfos, String> idName;
    public TableColumn<TeacherInfos, String> id_ID;
    public TableColumn<TeacherInfos, String> idFirstClass;
    public TableColumn<TeacherInfos, String> idSecondClass;
    public TableColumn<TeacherInfos, String> idThirdClass;
    public TableView<TeacherInfos> idTable;

    public ObservableList<TeacherInfos> getTeacherList() throws SQLException {
        TeacherRecords records = new TeacherRecords();

        return FXCollections.observableArrayList(records.getList());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idName.setCellValueFactory(new PropertyValueFactory<>("name"));
        id_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        idFirstClass.setCellValueFactory(new PropertyValueFactory<>("firstClass"));
        idSecondClass.setCellValueFactory(new PropertyValueFactory<>("secondClass"));
        idThirdClass.setCellValueFactory(new PropertyValueFactory<>("thirdClass"));

        try {
            idTable.setItems(getTeacherList());
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
