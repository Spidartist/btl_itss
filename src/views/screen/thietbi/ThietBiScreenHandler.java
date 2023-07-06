package views.screen.thietbi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ThietBiScreenHandler {

    @FXML
    private AnchorPane basePane;

    @FXML
    private TableColumn<?, ?> indexColumn;

    @FXML
    private TableColumn<?, ?> ngayNhapVeColumn;

    @FXML
    private TableColumn<?, ?> oPhongColumn;

    @FXML
    private Pagination pagination;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> tenThietBiColumn;

    @FXML
    private TableColumn<?, ?> tinhTrangColumn;

    @FXML
    private TableColumn<?, ?> xuatXuColumn;

    @FXML
    void addThietBi(ActionEvent event) {

    }

    @FXML
    void deleteThietBi(ActionEvent event) {

    }

    @FXML
    void search(MouseEvent event) {

    }

}
