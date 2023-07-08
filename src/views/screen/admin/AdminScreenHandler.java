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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import services.GoiTapServices;
import services.HoiVienServices;
import services.NhanVienServices;
import services.PhongTapServices;
import services.ThietBiServices;
import services.ThuPhiServices;
import utils.ViewUtils;
import views.screen.login.LoginScreenHandler;

import static utils.Utils.toUpperFirstLetter;
import static utils.Configs.*;

public class AdminScreenHandler implements Initializable{

	@FXML
    private AnchorPane basePane;
	
    @FXML
    private VBox VBoxButton;

    @FXML
    private Button dangXuatButton;

    @FXML
    private BarChart<?, ?> facilityChart;

    @FXML
    private Button goiTapButton;

    @FXML
    private Button goiTapDaDangKiButton;

    @FXML
    private Label goiTapLabel;

    @FXML
    private Button hoiVienButton;

    @FXML
    private Label hoiVienLabel;

    @FXML
    private Button lichSuDiTapButton;

    @FXML
    private Button nhanVienButton;

    @FXML
    private Label nhanVienLabel;

    @FXML
    private Button phanHoiButton;

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
    void switchToGoiTapDaDangKi() throws IOException {
    	viewUtils.changeAnchorPane(basePane, GOI_TAP_DA_DANG_KI_SCREEN_PATH);
    }
    
    @FXML
    void switchToLichSuDiTap() throws IOException {
    	viewUtils.changeAnchorPane(basePane, LICH_SU_DI_TAP_SCREEN_PATH);
    }
    
    @FXML
    public void switchToPhanHoi() throws IOException {
    	viewUtils.changeAnchorPane(basePane, PHAN_HOI_SCREEN_PATH);
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
    

    @FXML
    void switchToLogin(ActionEvent event) throws IOException {
    	viewUtils.changeScene(event, LOGIN_PATH);
    }

	// Save user role
//	private static Preferences userPreferences = Preferences.userRoot();
//	public static String userRole = userPreferences.get("role", "");
//	public static String userName = userPreferences.get("username", "");
	private final ViewUtils viewUtils = new ViewUtils();
	private Connection conn = GymDB.getConnection();

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		String userName = GymDB.getUserPreferences().get("username", "");
		int id_role = Integer.parseInt(GymDB.getUserPreferences().get("role", ""));
		
		hoiVienButton.setVisible(true);
		phongTapButton.setVisible(true);
		thietBiButton.setVisible(true);
		nhanVienButton.setVisible(true);
		goiTapButton.setVisible(true);
		thuPhiButton.setVisible(true);
		phanHoiButton.setVisible(true);
		thongKeButton.setVisible(true);
		goiTapDaDangKiButton.setVisible(true);
		lichSuDiTapButton.setVisible(true);
		
		// Phân quyền:
		switch (id_role) {
		case 1: // Chủ phòng gym
			
			break;
		case 2: // Quản lý 
			phongTapButton.setVisible(false);
			phongTapButton.setManaged(false);

			nhanVienButton.setVisible(false);
			nhanVienButton.setManaged(false);
			
			goiTapButton.setVisible(false);
			goiTapButton.setManaged(false);
			break;
		case 3: // Huấn luyện viên
			phongTapButton.setVisible(false);
			phongTapButton.setManaged(false);
			
			thietBiButton.setVisible(false);
			thietBiButton.setManaged(false);
			
			nhanVienButton.setVisible(false);
			nhanVienButton.setManaged(false);
			
			goiTapButton.setVisible(false);
			goiTapButton.setManaged(false);
			
			thuPhiButton.setVisible(false);
			thuPhiButton.setManaged(false);
			
			phanHoiButton.setVisible(false);
			phanHoiButton.setManaged(false);
			
			thongKeButton.setVisible(false);
			thongKeButton.setManaged(false);
			break;
		case 4: // Nhân viên
			phongTapButton.setVisible(false);
			phongTapButton.setManaged(false);
			
			thietBiButton.setVisible(false);
			thietBiButton.setManaged(false);
			
			nhanVienButton.setVisible(false);
			nhanVienButton.setManaged(false);
			
			goiTapButton.setVisible(false);
			goiTapButton.setManaged(false);
			
			phanHoiButton.setVisible(false);
			phanHoiButton.setManaged(false);
			
			thongKeButton.setVisible(false);
			thongKeButton.setManaged(false);
			
			break;
		case 5: // Hội viên
			hoiVienButton.setVisible(false);
			hoiVienButton.setManaged(false);
			
			phongTapButton.setVisible(false);
			phongTapButton.setManaged(false);
			
			thietBiButton.setVisible(false);
			thietBiButton.setManaged(false);
			
			nhanVienButton.setVisible(false);
			nhanVienButton.setManaged(false);
			
			goiTapButton.setVisible(false);
			goiTapButton.setManaged(false);

			thongKeButton.setVisible(false);
			thongKeButton.setManaged(false);
			break;
			

		}
		VBoxButton.setSpacing(0);
		
		
		
		usernameLabel.setText(toUpperFirstLetter(userName));
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
