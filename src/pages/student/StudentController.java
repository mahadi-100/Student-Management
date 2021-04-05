package pages.student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    public TableView<StudentInfo> idTable;
    public TableColumn<StudentInfo, String> idName;
    public TableColumn<StudentInfo, String> id_Id;
    public TableColumn<StudentInfo, String> idPerformance;
    public TableColumn<StudentInfo, String> idAttendance;

    /**
     * @return arrayList returned as tableViewable arrayList.
     * @throws SQLException connection failure
     */
    public ObservableList<StudentInfo> getStudentList() throws SQLException {
        StudentRecords records = new StudentRecords();

        return FXCollections.observableArrayList(records.getList());
    }

    /**
     * show all the list items in table format.
     *
     * @param location no uses particularly
     * @param resources no uses either
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idName.setCellValueFactory(new PropertyValueFactory<>("name"));
        id_Id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        idPerformance.setCellValueFactory(new PropertyValueFactory<>("performance"));
        idAttendance.setCellValueFactory(new PropertyValueFactory<>("attendance"));

        try {
            idTable.setItems(getStudentList());
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
