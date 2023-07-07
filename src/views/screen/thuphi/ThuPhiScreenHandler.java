package views.screen.thuphi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ThuPhiScreenHandler {

    @FXML
    private AnchorPane basePane;

    @FXML
    private TableColumn<?, ?> indexColumn;

    @FXML
    private TableColumn<?, ?> loaiPhiColumn;

    @FXML
    private Pagination pagination;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableColumn<?, ?> soTienColumn;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> tenGoiTapColumn;

    @FXML
    private TableColumn<?, ?> tenHoiVienColumn;

    @FXML
    void addThuPhi(ActionEvent event) {

    }

    @FXML
    void deleteThuPhi(ActionEvent event) {

    }

    @FXML
    void search(MouseEvent event) {

    }

}
