package views.screen.goitapdangki;

import static utils.Configs.DETAIL_GOI_TAP_DA_DANG_KI_VIEW_FXML;
import static utils.Configs.ROWS_PER_PAGE;
import static utils.Utils.createDialog;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import entity.model.GoiTapDaDangKi;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import services.GoiTapDaDangKiServices;
import views.screen.goitapdangki.GoiTapDaDangKiDetailScreenHandler;

@SuppressWarnings("unused")
public class GoiTapDaDangKiScreenHandler implements Initializable{

    @FXML
    private AnchorPane basePane;

    @FXML
    private TableColumn<GoiTapDaDangKi, String> hoVaTenColumn;

    @SuppressWarnings("rawtypes")
	@FXML
    private TableColumn indexColumn;

    @FXML
    private TableColumn<GoiTapDaDangKi, String> loaiGoiTapColumn;

    @FXML
    private TableColumn<GoiTapDaDangKi, String> ngayDangKiColumn;

    @FXML
    private Pagination pagination;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<GoiTapDaDangKi> tableView;

    @FXML
    private TableColumn<GoiTapDaDangKi, String> tenGoiTapColumn;

    private ObservableList<GoiTapDaDangKi> goiTapList = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resources) {
		try {
    		goiTapList = GoiTapDaDangKiServices.getAll();
    		System.out.println(goiTapList);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int soDu = goiTapList.size() % ROWS_PER_PAGE;
		if (soDu != 0)
			pagination.setPageCount(goiTapList.size() / ROWS_PER_PAGE + 1);
		else
			pagination.setPageCount(goiTapList.size() / ROWS_PER_PAGE);
		pagination.setMaxPageIndicatorCount(5);
		pagination.setPageFactory(this::createTableView);

		tableView.setRowFactory(tv -> {
			TableRow<GoiTapDaDangKi> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					try {
						try {
							detail(event);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			});
			return row;
		});

	}
    
    @SuppressWarnings("unused")
	public void detail(MouseEvent event) throws IOException, SQLException {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(DETAIL_GOI_TAP_DA_DANG_KI_VIEW_FXML));
		Parent studentViewParent = loader.load();
		Scene scene = new Scene(studentViewParent);
		GoiTapDaDangKiDetailScreenHandler controller = loader.getController();
		GoiTapDaDangKi selected = tableView.getSelectionModel().getSelectedItem();
		if (selected == null)
			createDialog(Alert.AlertType.WARNING, "Từ từ đã Bạn", "", "Vui lòng chọn một gói tập");
		else {
//			controller.setGoiTap(selected);
//			controller.setID(selected.getId());
//			controller.hide_add_btn();
			controller.setTitle("Cập nhật thông tin gói tập");
			stage.setScene(scene);
		}
	}
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Node createTableView(int pageIndex) {

        indexColumn.setCellValueFactory(
                (Callback<CellDataFeatures<GoiTapDaDangKi, String>, ObservableValue<String>>) p -> new ReadOnlyObjectWrapper(
                        p.getValue()));

        indexColumn.setCellFactory(new Callback<TableColumn<GoiTapDaDangKi, GoiTapDaDangKi>, TableCell<GoiTapDaDangKi, GoiTapDaDangKi>>() {
            public TableCell<GoiTapDaDangKi, GoiTapDaDangKi> call(TableColumn<GoiTapDaDangKi, GoiTapDaDangKi> param) {
                return new TableCell<GoiTapDaDangKi, GoiTapDaDangKi>() {
                    @Override
                    protected void updateItem(GoiTapDaDangKi item, boolean empty) {
                        super.updateItem(item, empty);

                        if (this.getTableRow() != null && item != null) {
                            setText(this.getTableRow().getIndex() + 1 + pageIndex * ROWS_PER_PAGE + "");
                        } else {
                            setText("");
                        }
                    }
                };
            }
        });
        indexColumn.setSortable(false);
        hoVaTenColumn.setCellValueFactory(new PropertyValueFactory<GoiTapDaDangKi, String>("hoTen"));
        tenGoiTapColumn.setCellValueFactory(new PropertyValueFactory<GoiTapDaDangKi, String>("tenGoiTap"));
        loaiGoiTapColumn.setCellValueFactory(new PropertyValueFactory<GoiTapDaDangKi, String>("loaiGoiTap"));
        ngayDangKiColumn.setCellValueFactory(new PropertyValueFactory<GoiTapDaDangKi, String>("ngayDangKi"));

        int lastIndex = 0;
        int displace = goiTapList.size() % ROWS_PER_PAGE;
        if (displace > 0) {
            lastIndex = goiTapList.size() / ROWS_PER_PAGE;
        } else {
            lastIndex = goiTapList.size() / ROWS_PER_PAGE - 1;
        }

        if (goiTapList.isEmpty())
            tableView.setItems(FXCollections.observableArrayList(goiTapList));
        else {
            if (lastIndex == pageIndex && displace > 0) {
                tableView.setItems(FXCollections.observableArrayList(
                        goiTapList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + displace)));
            } else {
                tableView.setItems(FXCollections.observableArrayList(
                        goiTapList.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + ROWS_PER_PAGE)));
            }
        }
        return tableView;
    }
    
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