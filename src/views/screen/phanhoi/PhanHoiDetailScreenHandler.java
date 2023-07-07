package views.screen.phanhoi;

import static utils.Utils.createDialog;

import java.io.IOException;
import java.sql.SQLException;
import java.util.prefs.Preferences;

import entity.model.PhanHoi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import services.GeneralServices;
import services.HoiVienServices;
import services.PhanHoiServices;
import services.TaiKhoanServices;
import utils.ViewUtils;

public class PhanHoiDetailScreenHandler {
	
	private static final Preferences userPreferences = Preferences.userRoot();
	public static final String userName = userPreferences.get("username", "");
	
	private int ID;
	
    public void setID(int ID) {
        this.ID = ID;
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
    
    public void setPhanHoi(PhanHoi phanHoi) {
    	hoVaTenText.setText(phanHoi.getTenHoiVien());
    	phanHoiText.setText(phanHoi.getNoiDung());
    	hoiDapText.setText(phanHoi.getHoiDap());
    	hoVaTenText.setEditable(false);
    }

    @FXML
    private Button add_btn;

    @FXML
    private TextField hoVaTenText;

    @FXML
    private TextArea hoiDapText;

    @FXML
    private TextArea phanHoiText;

    @FXML
    private Text title;

    @FXML
    private Button update_btn;
    
    public void setName() {
    	try {
			hoVaTenText.setText(TaiKhoanServices.getNameViaUsername(userName));
			hoVaTenText.setEditable(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void addPhanHoi(ActionEvent event) throws IOException {
    	ViewUtils viewUtils = new ViewUtils();
        String hoVaTen = hoVaTenText.getText();
        String phanHoi = phanHoiText.getText();
        if (hoVaTen.trim().equals("") || phanHoi.trim().equals("")) {
            createDialog(
                    Alert.AlertType.WARNING,
                    "Thông báo",
                    "", "Vui lòng nhập đủ thông tin!");
        } else {
            try {
            	int id_hoi_vien = GeneralServices.getIdViaName("hoi_vien", "ho_ten", hoVaTen);
                int result = PhanHoiServices.addPhanHoi(id_hoi_vien, phanHoi);
                if (result == 1) {
                    createDialog(
                            Alert.AlertType.CONFIRMATION,
                            "Thành công",
                            "Thêm phản hồi thành công!", "Hãy đợi hồi đáp từ quản lý"
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
            viewUtils.switchToPhanHoi(event);
        
        }

    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        ViewUtils viewUtils = new ViewUtils();
        viewUtils.switchToPhanHoi(event);
    }

    @FXML
    void update(ActionEvent event) {

    }

}
