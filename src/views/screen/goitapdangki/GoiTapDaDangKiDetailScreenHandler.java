package views.screen.goitapdangki;

import java.io.IOException;
import java.sql.SQLException;

import entity.model.GoiTap;
import entity.model.GoiTapDaDangKi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import utils.ViewUtils;

public class GoiTapDaDangKiDetailScreenHandler {

    @FXML
    private Button add_btn;

    @FXML
    private ComboBox<?> goiTapComboBox;

    @FXML
    private ComboBox<?> hoiVienComboBox;

    @FXML
    private DatePicker ngayDangKiDatePicker;

    @FXML
    private TextField searchTextField;

    @FXML
    private Text title;

    @FXML
    private Button update_btn;

    @FXML
    void addDangKiGoiTap(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        ViewUtils viewUtils = new ViewUtils();
        viewUtils.switchToGoiTapDaDangKi(event);
    }

    @FXML
    void update(ActionEvent event) {

    }

    public void setGoiTapDaDangKi(GoiTapDaDangKi goiTap) throws SQLException {
//    	tenGoiTapTextField.setText(goiTap.getTenGoiTap());
//    	soTienTextField.setText(soTien_format);
//    	loaiGoiTapChoiceBox.setValue(goiTap.getLoaiGoiTap());
//    	setComboBox();
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
	


}
