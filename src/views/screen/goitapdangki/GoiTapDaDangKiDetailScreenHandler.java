package views.screen.goitapdangki;

import static utils.Configs.ROWS_PER_PAGE;
import static utils.Utils.createDialog;
import static utils.deAccent.removeAccent;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import entity.model.GoiTap;
import entity.model.GoiTapDaDangKi;
import entity.model.HoiVien;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;
import services.GoiTapDaDangKiServices;
import services.GoiTapServices;
import services.HoiVienServices;
import utils.ViewUtils;

public class GoiTapDaDangKiDetailScreenHandler {
	private int ID;

    @FXML
    private Button add_btn;

    @FXML
    private ComboBox<String> goiTapComboBox;

    @FXML
    private ComboBox<String> hoiVienComboBox;

    @FXML
    private DatePicker ngayDangKiDatePicker;

    @FXML
    private TextField searchTextField;

    @FXML
    private Text title;

    @FXML
    private Button update_btn;

    @FXML
    void addDangKiGoiTap(ActionEvent event) throws IOException{
    	 ViewUtils viewUtils = new ViewUtils();
         

     	 int idGoiTap = Integer.parseInt(goiTapComboBox.getValue().toString().strip().split(" - ")[0]);
         String tenGoiTap = goiTapComboBox.getValue().toString().strip().split(" - ")[1];
     	 int idHoiVien = Integer.parseInt(hoiVienComboBox.getValue().toString().strip().split(" - ")[0]);
         String tenHoiVien = hoiVienComboBox.getValue().toString().strip().split(" - ")[1];
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String date = ngayDangKiDatePicker.getValue().format(formatter);

         if (tenGoiTap.trim().equals("") || tenHoiVien.trim().equals("")) {

             createDialog(
                     Alert.AlertType.WARNING,
                     "Thông báo",
                     "", "Vui lòng nhập đủ thông tin!"
                     );
         }
         else {
         	try {
         	    
         	    int result = GoiTapDaDangKiServices.addDangKi(ID, idHoiVien, idGoiTap, date);
         	    
         	    if (result == 1) {
         	        createDialog(
         	            Alert.AlertType.CONFIRMATION,
         	            "Thành công",
         	            "", "Thêm đăng kí thành công!"
         	        );
         	    } else {
         	        createDialog(
         	            Alert.AlertType.ERROR,
         	            "Thất bại",
         	            "", "Có lỗi xảy ra, vui lòng thử lại!"
         	        );
         	    }
         	} catch (SQLException e) {
         	    e.printStackTrace();
         	}

         	viewUtils.switchToGoiTapDaDangKi(event);
             
         }
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        ViewUtils viewUtils = new ViewUtils();
        viewUtils.switchToGoiTapDaDangKi(event);
    }

    @FXML
    void update(ActionEvent event) throws IOException {
    	ViewUtils viewUtils = new ViewUtils();
        
    	int id = getID();
    	int idGoiTap = Integer.parseInt(goiTapComboBox.getValue().toString().strip().split(" - ")[0]);
        String tenGoiTap = goiTapComboBox.getValue().toString().strip().split(" - ")[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = ngayDangKiDatePicker.getValue().format(formatter);
        if (tenGoiTap.trim().equals("") || date.trim().equals("")) {

            createDialog(
                    Alert.AlertType.WARNING,
                    "Thông báo",
                    "", "Vui lòng nhập đủ thông tin!");
        } else {
                try {
                    int result = GoiTapDaDangKiServices.updateGoiTap(ID, idGoiTap, date);
                    if (result == 1) {
                        createDialog(
                                Alert.AlertType.CONFIRMATION,
                                "Thành công",
                                "", "Cập nhật thông tin đăng kí thành công!"
                        );
                    } else {
                        createDialog(
                                Alert.AlertType.ERROR,
                                "Thất bại",
                                "", "Có lỗi xảy ra, vui lòng thử lại!"
                        );
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                viewUtils.switchToGoiTapDaDangKi(event);
            
        }
        
    }
    @FXML
    public void search(MouseEvent event) {
		FilteredList<GoiTap> filteredData = new FilteredList<>(goiTapList, p -> true);
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(person -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = removeAccent(searchTextField.getText().toLowerCase());
				if (removeAccent(person.getTenGoiTap().toLowerCase()).contains(lowerCaseFilter)) {
					return true;
				} else {
					return false;
				}
			});
			int soDu = filteredData.size() % ROWS_PER_PAGE;
			if (soDu != 0)
				pagination.setPageCount(filteredData.size() / ROWS_PER_PAGE + 1);
			else
				pagination.setPageCount(filteredData.size() / ROWS_PER_PAGE);
			pagination.setMaxPageIndicatorCount(5);
			pagination.setPageFactory(pageIndex -> {
				indexColumn.setCellValueFactory(
						(Callback<TableColumn.CellDataFeatures<GoiTap, GoiTap>, ObservableValue<GoiTap>>) p -> new ReadOnlyObjectWrapper(
								p.getValue()));

				indexColumn
						.setCellFactory(new Callback<TableColumn<GoiTap, GoiTap>, TableCell<GoiTap, GoiTap>>() {
							@Override
							public TableCell<GoiTap, GoiTap> call(TableColumn<GoiTap, GoiTap> param) {
								return new TableCell<GoiTap, GoiTap>() {
									@Override
									protected void updateItem(GoiTap item, boolean empty) {
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
		        tenGoiTapColumn.setCellValueFactory(new PropertyValueFactory<GoiTap, String>("tenGoiTap"));
		        loaiGoiTapColumn.setCellValueFactory(new PropertyValueFactory<GoiTap, String>("loaiGoiTap"));
		        soTienColumn.setCellValueFactory(new PropertyValueFactory<GoiTap, String>("soTien"));
				int lastIndex = 0;
				int displace = filteredData.size() % ROWS_PER_PAGE;
				if (displace > 0) {
					lastIndex = filteredData.size() / ROWS_PER_PAGE;
				} else {
					lastIndex = filteredData.size() / ROWS_PER_PAGE - 1;
				}
				// Add goitap to table
				if (filteredData.isEmpty())
					tableView.setItems(FXCollections.observableArrayList(filteredData));
				else {
					if (lastIndex == pageIndex && displace > 0) {
						tableView.setItems(FXCollections.observableArrayList(
								filteredData.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + displace)));
					} else {
						tableView.setItems(FXCollections.observableArrayList(filteredData
								.subList(pageIndex * ROWS_PER_PAGE, pageIndex * ROWS_PER_PAGE + ROWS_PER_PAGE)));
					}
				}
				return tableView;
			});
		});

	}

    public void setGoiTapDaDangKi(GoiTapDaDangKi goiTap) throws SQLException {
		String dateString = goiTap.getNgayDangKi();
        String pattern = "yyyy-MM-dd";
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate date = LocalDate.parse(dateString, formatter);
        
        ngayDangKiDatePicker.setValue(date);
        hoiVienComboBox.setVisible(false);
        searchTextField.setText(goiTap.getHoTen());
        searchTextField.setEditable(false);
//      ObservableList<HoiVien> stringList = HoiVienServices.getAllHoiVien();
//	    hoiVienComboBox.setItems(getAllName(stringList));
//	    HoiVien selectedOption = HoiVienServices.findHoiVien(goiTap.getIdHoiVien()).get(0);
//	    hoiVienComboBox.setPromptText(selectedOption.getHoTen());
//	    hoiVienComboBox.setValue(selectedOption.getHoTen());
	    
	//    goiTapComboBox.setItems();
	    ObservableList<GoiTap> goiTapList = GoiTapServices.getAllGoiTap();
	
	    // Add the strings to the ComboBox
	    goiTapComboBox.setItems(getAllGoiTap(goiTapList));
	    GoiTap selectedGoiTap = GoiTapServices.findGoiTap(goiTap.getIdGoiTap()).get(0);
	    goiTapComboBox.setPromptText(selectedGoiTap.getId() + " - " + selectedGoiTap.getTenGoiTap());
	    goiTapComboBox.setValue(selectedGoiTap.getId() + " - " + selectedGoiTap.getTenGoiTap());
    }

    private static ObservableList<String> getAllName(ObservableList<HoiVien> stringList) {
    	ObservableList<String> nameList = FXCollections.observableArrayList();
        for (HoiVien hoiVien : stringList) {
            nameList.add(hoiVien.getId() + " - " + hoiVien.getHoTen());
        }
        return nameList;
    }
    private static ObservableList<String> getAllGoiTap(ObservableList<GoiTap> stringList) {
    	ObservableList<String> goiTapList = FXCollections.observableArrayList();
        for (GoiTap gt : stringList) {
        	goiTapList.add(gt.getId() + " - " + gt.getTenGoiTap());
        }
        return goiTapList;
    }


	public void setTitle(String title) {
	    this.title.setText(title);
	}
	public void hide_add_btn() {
	    add_btn.setVisible(false);
	}
	public void hide_update_btn() {
	    update_btn.setVisible(false);
	    add_btn.setTranslateX(100);
	}

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public int getID() {
        return this.ID;
    }

	public void set_ComboBox() throws SQLException {
		// TODO Auto-generated method stub
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // Convert date and time to string
        String dateString = now.format(pattern);
        LocalDate date = LocalDate.parse(dateString, pattern);

        ngayDangKiDatePicker.setValue(date);
		
		ObservableList<HoiVien> stringList = HoiVienServices.getAllHoiVien();

	    hoiVienComboBox.setItems(getAllName(stringList));
//        hoiVienComboBox.setPromptText(selectedOption.getHoTen());
        hoiVienComboBox.setValue(getAllName(stringList).get(0));
        
        ObservableList<GoiTap> goiTapList = GoiTapServices.getAllGoiTap();

        goiTapComboBox.setItems(getAllGoiTap(goiTapList));
//        goiTapComboBox.setPromptText(selectedGoiTap.getTenGoiTap());
        goiTapComboBox.setValue(getAllGoiTap(goiTapList).get(0));
	}



    
	


}
