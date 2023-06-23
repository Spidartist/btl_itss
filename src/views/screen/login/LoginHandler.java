package views.screen.login;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import views.screen.BaseScreenHandler;

public class LoginHandler extends BaseScreenHandler{

	public LoginHandler(Stage stage, String screenPath) throws IOException {
		super(stage, screenPath);
		this.setImage(loginImg, "/../../assets/img/batsu-harem-1-jp.thumb_500x.jpg");
		this.setImage(loginLock, "/../../assets/img/678129.png");
	}

    @FXML
    private Label alertText;

    @FXML
    private Button btnLogin;

    @FXML
    private ImageView loginImg;

    @FXML
    private ImageView loginLock;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    

//    public void userLogIn(ActionEvent event) throws IOException {
//        checkLogin();
//
//    }

//    private void checkLogin() throws IOException {
//        Main m = new Main();
//        if(username.getText().toString().equals("javacoding") && password.getText().toString().equals("123")) {
//            wrongLogIn.setText("Success!");
//
//            m.changeScene("afterLogin.fxml");
//        }
//
//        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
//            wrongLogIn.setText("Please enter your data.");
//        }
//
//
//        else {
//            wrongLogIn.setText("Wrong username or password!");
//        }
//    }
    public static void main(String[] args) {
		
	}

}