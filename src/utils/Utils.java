package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.Alert;

public class Utils {
	
    public static void createDialog(Alert.AlertType type, String title, String headerText, String contentText) {
        Alert warning = new Alert(type);
        warning.setTitle(title);
        warning.setHeaderText(headerText);
        warning.setContentText(contentText);
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
