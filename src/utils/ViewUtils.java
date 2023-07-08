package utils;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import views.screen.admin.AdminScreenHandler;
import views.screen.dangki.DangKiScreenHandler;
import views.screen.nhanvien.NhanVienDetailScreenHandler;
import views.screen.thaydoimatkhau.ThayDoiMatKhauScreenHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static utils.Configs.*;

public class ViewUtils {
    public void changeScene(ActionEvent event, String viewSource) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(viewSource));
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void changeAnchorPane(AnchorPane currentPane, String viewSource) throws IOException {
        Node node = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(viewSource)));
        currentPane.getChildren().setAll(node);
    }

    public void switchToHoiVien(Event event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(ADMIN_SCREEN_PATH));
        root = loader.load();
        AdminScreenHandler controller = loader.getController();
        controller.switchToHoiVien();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPhongTap(Event event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(ADMIN_SCREEN_PATH));
        root = loader.load();
        AdminScreenHandler controller = loader.getController();
        controller.switchToPhongTap();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToNhanVien (ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(ADMIN_SCREEN_PATH));
        root = loader.load();
        AdminScreenHandler controller = loader.getController();
        controller.switchToNhanVien();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToDangKi(ActionEvent event, String name, String role_name, int id_nguoi_dung, int id_role, boolean isNhanVien) throws IOException, SQLException {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(DANG_KI_USER_SCREEN_PATH));
		Parent studentViewParent = loader.load();
		Scene scene = new Scene(studentViewParent);
		DangKiScreenHandler controller = loader.getController();
		controller.setup(name, role_name, id_nguoi_dung, id_role, isNhanVien);
		stage.setScene(scene);
    }

    public void switchToThietBi(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(ADMIN_SCREEN_PATH));
        root = loader.load();
        AdminScreenHandler controller = loader.getController();
        controller.switchToThietBi();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToGoiTap(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(ADMIN_SCREEN_PATH));
        root = loader.load();
        AdminScreenHandler controller = loader.getController();
        controller.switchToGoiTap();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToThuPhi(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(ADMIN_SCREEN_PATH));
        root = loader.load();
        AdminScreenHandler controller = loader.getController();
        controller.switchToThuPhi();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToPhanHoi(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(ADMIN_SCREEN_PATH));
        root = loader.load();
        AdminScreenHandler controller = loader.getController();
        controller.switchToPhanHoi();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

	public void switchToGoiTapDaDangKi(ActionEvent event) throws IOException {
	    Stage stage;
        Scene scene;
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(ADMIN_SCREEN_PATH));
        root = loader.load();
        AdminScreenHandler controller = loader.getController();
        controller.switchToGoiTapDaDangKi();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
	}

}
