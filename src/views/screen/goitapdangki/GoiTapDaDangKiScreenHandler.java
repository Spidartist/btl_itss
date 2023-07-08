package views.screen.goitapdangki;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class GoiTapDaDangKiScreenHandler {

    @FXML
    private AnchorPane basePane;

    @FXML
    private TableColumn<?, ?> hoVaTenColumn;

    @FXML
    private TableColumn<?, ?> indexColumn;

    @FXML
    private TableColumn<?, ?> loaiGoiTapColumn;

    @FXML
    private TableColumn<?, ?> ngayDangKiColumn;

    @FXML
    private Pagination pagination;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> tenGoiTapColumn;

    @FXML
    void addDangKiGoiTap(ActionEvent event) {

    }

    @FXML
    void deleteDangKiGoiTap(ActionEvent event) {

    }

    @FXML
    void search(MouseEvent event) {

    }

}