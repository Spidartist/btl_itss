package views.screen.goitap;

import java.io.IOException;
import java.sql.SQLException;

import entity.model.GoiTap;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import services.GoiTapServices;
import utils.ViewUtils;

public class GoiTapDetailScreenHandler {

    @FXML
    private Button add_btn;

    @FXML
    private ChoiceBox<String> loaiGoiTapChoiceBox;

    @FXML
    private TextField soTienTextField;

    @FXML
    private TextField tenGoiTapTextField;

    @FXML
    private Text title;

    @FXML
    private Button update_btn;

    @SuppressWarnings("unused")
	public void setComboBox() throws SQLException {
    	ObservableList<String> goiTapList = GoiTapServices.getLoaiGoiTapAll();
    	
    }
    
    public void setGoiTap(GoiTap goiTap) throws SQLException {
	    String soTien_format = String.valueOf(goiTap.getSoTien_int());
    	tenGoiTapTextField.setText(goiTap.getTenGoiTap());
    	soTienTextField.setText(soTien_format);
    	loaiGoiTapChoiceBox.setValue(goiTap.getLoaiGoiTap());
    	setComboBox();
    }
    
    @FXML
    void addGoiTap(ActionEvent event) {
    	
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        ViewUtils viewUtils = new ViewUtils();
        viewUtils.switchToGoiTap(event);
    }

    @FXML
    void update(ActionEvent event) {

    }

	    
    public void setTitle(String title) {
        this.title.setText(title);
    }
    


}
