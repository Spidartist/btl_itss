package views.screen.goitap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class GoiTapScreenHandler {

    @FXML
    private AnchorPane basePane;

    @FXML
    private TableColumn<?, ?> indexColumn;

    @FXML
    private TableColumn<?, ?> loaiGoiTapColumn;

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
    void addGoiTap(ActionEvent event) {

    }

    @FXML
    void deleteGoiTap(ActionEvent event) {

    }

    @FXML
    void search(MouseEvent event) {

    }

}
