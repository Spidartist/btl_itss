package views.screen.admin;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import entity.db.GymDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import services.GoiTapServices;
import services.HoiVienServices;
import services.NhanVienServices;
import services.PhongTapServices;
import services.ThietBiServices;
import services.ThuPhiServices;
import utils.ViewUtils;
import static utils.Utils.toUpperFirstLetter;
import static utils.Configs.*;

public class AdminScreenHandler implements Initializable{

	@FXML
    private Button DangKiTaiKhoanButton;

    @FXML
    private AnchorPane basePane;

    @FXML
    private BarChart<?, ?> facilityChart;

    @FXML
    private Button goiTapButton;

    @FXML
    private Label goiTapLabel;

    @FXML
    private Button hoiVienButton;

    @FXML
    private Label hoiVienLabel;

    @FXML
    private Button nhanVienButton;

    @FXML
    private Label nhanVienLabel;

    @FXML
    private Button phongTapButton;

    @FXML
    private Label phongTapLabel;

    @FXML
    private Button thietBiButton;

    @FXML
    private Label thietBiLabel;

    @FXML
    private Button thongKeButton;

    @FXML
    private Button thuPhiButton;

    @FXML
    private Button trangChuButton;

    @FXML
    private Label usernameLabel;

    @FXML
    public void switchToDangKiTaiKhoan() throws IOException {
    	viewUtils.changeAnchorPane(basePane, DANG_KI_USER_SCREEN_PATH);
    }

    @FXML
    public void switchToGoiTap() throws IOException {
    	viewUtils.changeAnchorPane(basePane, GOI_TAP_SCREEN_PATH);
    }

    @FXML
    public void switchToHoiVien() throws IOException {
    	viewUtils.changeAnchorPane(basePane, HOI_VIEN_SCREEN_PATH);
    }

    @FXML
    public void switchToNhanVien() throws IOException {
    	viewUtils.changeAnchorPane(basePane, NHAN_VIEN_SCREEN_PATH);
    }

    @FXML
    public void switchToPhongTap() throws IOException {
    	viewUtils.changeAnchorPane(basePane, PHONG_TAP_SCREEN_PATH);
    }

    @FXML 
    public void switchToThietBi() throws IOException {
    	viewUtils.changeAnchorPane(basePane, THIET_BI_SCREEN_PATH);
    }

    @FXML
    public void switchToThongKe() throws IOException {
    	viewUtils.changeAnchorPane(basePane, THONG_KE_SCREEN_PATH);
    }

    @FXML
    public void switchToThuPhi() throws IOException {
    	viewUtils.changeAnchorPane(basePane, THU_PHI_SCREEN_PATH);
    }

    @FXML
    public void switchToTrangChu(ActionEvent event) throws IOException {
    	viewUtils.changeScene(event, ADMIN_SCREEN_PATH);
    }

	// Save user role
	private static final Preferences userPreferences = Preferences.userRoot();
	public static final String userRole = userPreferences.get("role", "");
	public static final String userName = userPreferences.get("username", "");
	private final ViewUtils viewUtils = new ViewUtils();
	private Connection conn = GymDB.getConnection();

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		usernameLabel.setText(toUpperFirstLetter(userName));
		DangKiTaiKhoanButton.setVisible(userRole.equals("1"));
//		hoiVienLabel.setText("" + HoiVienServices.getTotalNhanKhau());
//		phongTapLabel.setText("" + PhongTapServices.getTotalSoHoKhau());
//		nhanVienLabel.setText("" + NhanVienServices.getTotalNhanKhau());
//		goiTapLabel.setText(""+GoiTapServices.SoLuongNhanKhauTamVang());
//		thietBiLabel.setText(""+ThietBiServices.SoLuongNhanKhauTamTru());
		ResultSet result = null;

//		List<LoaiCoSoVatChat> listCoSoVatChat = CoSoVatChatServices.getStatisticCSVC();
//
//		XYChart.Series<String, Number> seriesConDungDuoc = new XYChart.Series<>();
//
//		XYChart.Series<String, Number> seriesHong = new XYChart.Series<>();
//		seriesHong.setName("Hỏng");
//		for (LoaiCoSoVatChat loaiCSVC : listCoSoVatChat) {
//			if (loaiCSVC.getTinhTrang().equals(CON_DUNG_DUOC)) {
//
//				seriesConDungDuoc.getData().add(new XYChart.Data<>(loaiCSVC.getLoaiDoDung(), loaiCSVC.getSoLuong()));
//			} else {
//				seriesHong.getData().add(new XYChart.Data<>(loaiCSVC.getLoaiDoDung(), loaiCSVC.getSoLuong()));
//			}
//		}
//		seriesConDungDuoc.setName("Còn dùng được");
//
//		// Đặt dữ liệu cho StackedBarChart
//		facilityChart.getData().addAll(seriesConDungDuoc, seriesHong);

		
	}

}
