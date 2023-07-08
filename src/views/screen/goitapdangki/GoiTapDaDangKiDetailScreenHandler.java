package views.screen.goitapdangki;

import static utils.Utils.createDialog;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import entity.model.GoiTap;
import entity.model.GoiTapDaDangKi;
import entity.model.HoiVien;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
