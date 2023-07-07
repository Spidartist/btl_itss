package views.screen.phanhoi;

import java.io.IOException;

import entity.model.PhanHoi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import utils.ViewUtils;

public class PhanHoiDetailScreenHandler {
	
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

    @FXML
    void addPhanHoi(ActionEvent event) {

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
