package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class Utils {

    public static void createDialog(Alert.AlertType type, String title, String headerText, String contentText) {
        Alert warning = new Alert(type);
        warning.setTitle(title);
        warning.setHeaderText(headerText);
        warning.setContentText(contentText);

        // Set the custom button type
        ButtonType okButtonType = new ButtonType("OK");
        warning.getButtonTypes().setAll(okButtonType);

        // Get the button from the dialog pane
        Button okButton = (Button) warning.getDialogPane().lookupButton(okButtonType);
        okButton.setStyle("-fx-background-color:#FCF7DE;-fx-text-fill: black;-fx-border-color:black;");
        // Apply custom CSS to the button
        okButton.setOnMouseEntered(event -> okButton.setStyle("-fx-background-color: #EBE1B9;"
                + "-fx-font-weight: bold;-fx-text-fill: black;-fx-border-color:black;"));
        okButton.setOnMouseExited(event -> okButton.setStyle("-fx-background-color:#FCF7DE;-fx-text-fill: black;-fx-border-color:black;"));

        // Show the alert
        warning.showAndWait();
    }

    public static LocalDate LOCAL_DATE(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateString, formatter);
    }

    public static String toUpperFirstLetter(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    public static String convertDate(String date){
        String result;
        String[] date_split = date.split("-");
        result = date_split[2]+"/"+date_split[1]+"/"+date_split[0];
        return result;
    }


    public Utils() {
        // TODO Auto-generated constructor stub
    }

}
