package views.screen.thuphi;

import entity.model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import services.*;
import utils.ViewUtils;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static utils.Utils.LOCAL_DATE;
import static utils.Utils.createDialog;

public class ThuPhiDetailScreenHandler implements Initializable {

    private int ID;
    @FXML
    private Button add_btn;

    @FXML
    private ChoiceBox<String> loaiThuPhiChoiceBox;

    @FXML
    private TextField soTienTextField;

    @FXML
    private ComboBox<String> tenGoiTapComboBox;

    @FXML
    private ComboBox<String> tenHoiVienComboBox;

    @FXML
    private Text title;

    @FXML
    private DatePicker ngayThuPhiDatePicker;

    @FXML
    private Button update_btn;

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void hide_add_btn() {
        add_btn.setVisible(false);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void hide_update_btn() {
        update_btn.setVisible(false);
        add_btn.setTranslateX(100);
    }

    public void setThuPhi(ThuPhi thuPhi) {
        String soTien = String.valueOf(thuPhi.getSoTien());
        soTienTextField.setText(soTien);
        loaiThuPhiChoiceBox.setValue(thuPhi.getLoaiGoiTap());
        tenGoiTapComboBox.setValue(thuPhi.getTenGoiTap());
        tenHoiVienComboBox.setValue(thuPhi.getTenHoiVien());
        ngayThuPhiDatePicker.setValue(LOCAL_DATE(thuPhi.getNgayThuPhi()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<HoiVien> hoiVienList;
        ObservableList<String> tenGoiTapList;
        ObservableList<String> loaiGoiTapList;
        try {
            hoiVienList = HoiVienServices.getAllHoiVien();
            for (HoiVien hoiVien : hoiVienList) {
                tenHoiVienComboBox.getItems().add(hoiVien.getHoTen());
            }
            tenGoiTapList = GoiTapServices.getTenGoiTapAll();
            loaiGoiTapList = GoiTapServices.getLoaiGoiTapList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tenGoiTapComboBox.setItems(tenGoiTapList);
        loaiThuPhiChoiceBox.setItems(loaiGoiTapList);
    }

    @FXML
    void addThuPhi(ActionEvent event) throws SQLException, IOException {
        ViewUtils viewUtils = new ViewUtils();
        if (ngayThuPhiDatePicker.getValue() == null) createDialog(
                Alert.AlertType.WARNING,
                "Thông báo",
                "", "Vui lòng nhập đủ thông tin!");
        else {
            String tenHoiVien = tenHoiVienComboBox.getValue().toString();
            String soTien = soTienTextField.getText();
            String ngayThuPhi = ngayThuPhiDatePicker.getValue().toString();
            String tenGoiTap = tenGoiTapComboBox.getValue().toString();
            String loaiGoiTap = loaiThuPhiChoiceBox.getValue().toString();
            int id_hoi_vien = GeneralServices.getIdViaName("hoi_vien","ho_ten",tenHoiVien);
            int id_goi_tap = GeneralServices.getIdVia2Condition("goi_tap","ten_goi_tap","loai_goi_tap",
                    tenGoiTap,loaiGoiTap);
            if (tenHoiVien.trim().equals("") || ngayThuPhi.trim().equals("") || tenGoiTap.trim().equals("") ||
                    loaiGoiTap.trim().equals("")) {
                createDialog(
                        Alert.AlertType.WARNING,
                        "Thông báo",
                        "", "Vui lòng nhập đủ thông tin!");
            } else {
                try {
                    int result = ThuPhiServices.addThuPhi(id_hoi_vien,id_goi_tap,ngayThuPhi);
                    if (result == 1) {
                        createDialog(
                                Alert.AlertType.CONFIRMATION,
                                "Thành công",
                                "", "Thêm thu phí thành công!"
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
                viewUtils.switchToThuPhi(event);
            }
        }
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        ViewUtils viewUtils = new ViewUtils();
        viewUtils.switchToThuPhi(event);
    }

    @FXML
    void update(ActionEvent event) throws SQLException, IOException {
        ViewUtils viewUtils = new ViewUtils();
        if (ngayThuPhiDatePicker.getValue() == null) createDialog(
                Alert.AlertType.WARNING,
                "Thông báo",
                "", "Vui lòng nhập đủ thông tin!");
        else {
            String tenHoiVien = tenHoiVienComboBox.getValue().toString();
            String soTien = soTienTextField.getText();
            String ngayThuPhi = ngayThuPhiDatePicker.getValue().toString();
            String tenGoiTap = tenGoiTapComboBox.getValue().toString();
            String loaiGoiTap = loaiThuPhiChoiceBox.getValue().toString();
            int id_hoi_vien = GeneralServices.getIdViaName("hoi_vien","ho_ten",tenHoiVien);
            int id_goi_tap = GeneralServices.getIdVia2Condition("goi_tap","ten_goi_tap","loai_goi_tap",
                    tenGoiTap,loaiGoiTap);
            if (tenHoiVien.trim().equals("") || ngayThuPhi.trim().equals("") || tenGoiTap.trim().equals("") ||
                    loaiGoiTap.trim().equals("")) {
                createDialog(
                        Alert.AlertType.WARNING,
                        "Thông báo",
                        "", "Vui lòng nhập đủ thông tin!");
            } else {
                try {
                    int result = ThuPhiServices.updateThuPhi(ID,id_hoi_vien,id_goi_tap,ngayThuPhi);
                    if (result == 1) {
                        createDialog(
                                Alert.AlertType.CONFIRMATION,
                                "Thành công",
                                "", "Cập nhật thu phí thành công!"
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
                viewUtils.switchToThuPhi(event);
            }
        }
    }

}