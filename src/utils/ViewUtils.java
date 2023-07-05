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

import java.io.IOException;
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
        controller.switchToCoSoVatChat();
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
        controller.switchToSoHoKhau();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToThietBi(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(ADMIN_SCREEN_PATH));
        root = loader.load();
        AdminScreenHandler controller = loader.getController();
        controller.switchToLichHoatDong();
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
        controller.switchToLichHoatDong();
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
        controller.switchToLichHoatDong();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
