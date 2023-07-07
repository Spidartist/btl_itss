package views.screen.dangki;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static utils.Utils.*;
import static utils.ViewUtils.*;
import static utils.Configs.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import services.GeneralServices;
import services.RoleServices;
import services.TaiKhoanServices;
import utils.ViewUtils;

public class DangKiScreenHandler implements Initializable{
	
	int id_role;
	int id_nguoi_dung;
	boolean isNhanVien;
	
	public void setup() throws SQLException {
		userComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			  @Override 
			  public void changed(ObservableValue<? extends String> selected, String oldSelect, String newSelect) {
				  roleDisplayTextField.setText(newSelect);
			  }
		});
		
		ObservableList<String> chuaCoTaiKhoanList = GeneralServices.getDanhSachChuaCoTaiKhoan();
		userComboBox.setItems(chuaCoTaiKhoanList);
		
	}
	
	
	
	
    @FXML
    private TextField roleDisplayTextField;

    @FXML
    private Button signUpButton;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private TextField signUpUsername;

    @FXML
    private ComboBox<String> userComboBox;

    @FXML
    void signUp(ActionEvent event) throws SQLException, IOException {
    	String tai_khoan = signUpUsername.getText();
    	String mat_khau = signUpPassword.getText();
    	if (tai_khoan.trim().equals("") || mat_khau.trim().equals("")) {

            createDialog(
                    Alert.AlertType.WARNING,
                    "Thông báo",
                    "", "Vui lòng nhập đủ thông tin!")
            ;
        }else {
        	if (isNhanVien) {
        		TaiKhoanServices.updateTaiKhoanNhanVien(tai_khoan, mat_khau, id_nguoi_dung);
        	}else {
        		TaiKhoanServices.updateTaiKhoanHoiVien(tai_khoan, mat_khau, id_nguoi_dung);
        	}
        	createDialog(
        			Alert.AlertType.INFORMATION,
        			"Thông báo",
        			"", "Thêm tài khoản thành công");
        	ViewUtils viewUtils = new ViewUtils();
        	viewUtils.changeScene(event, ADMIN_SCREEN_PATH);
        }
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		roleDisplayTextField.setEditable(false);
		userComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			  @Override 
			  public void changed(ObservableValue<? extends String> selected, String oldSelect, String newSelect) {
				  try {
					id_role = GeneralServices.getRoleViaName(newSelect);
					String role_name = RoleServices.getNameViaId(id_role);
					roleDisplayTextField.setText(role_name);
					if (id_role == 5) {
						isNhanVien = false;
						id_nguoi_dung = GeneralServices.getIdViaName("hoi_vien", "ho_ten", newSelect);
					}else {
						isNhanVien = true;
						id_nguoi_dung = GeneralServices.getIdViaName("nhan_vien", "ho_va_ten", newSelect);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				  
			  }
		});
		
		ObservableList<String> chuaCoTaiKhoanList;
		try {
			chuaCoTaiKhoanList = GeneralServices.getDanhSachChuaCoTaiKhoan();
			userComboBox.setItems(chuaCoTaiKhoanList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}