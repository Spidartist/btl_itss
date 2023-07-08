package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import entity.db.GymDB;
import entity.model.GoiTap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GoiTapServices {

	public static ObservableList<GoiTap> getAllGoiTap() throws SQLException {

        ObservableList<GoiTap> goiTapList = FXCollections.observableArrayList();
        String SELECT_QUERY = "SELECT * FROM goi_tap";
        PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(SELECT_QUERY);
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            goiTapList.add(new GoiTap(result.getInt("id"), result.getInt("so_tien"),
                    result.getString("ten_goi_tap"), result.getString("loai_goi_tap")));
        }

        return goiTapList;
    }

public static ObservableList<String> getLoaiGoiTapAll() throws SQLException {
		
		ObservableList<String> goiTapList = FXCollections.observableArrayList();
        
        
        return goiTapList;
    }

    public static ObservableList<String> getTenGoiTapAll() throws SQLException {
        ObservableList<String> tenGoiTapList = FXCollections.observableArrayList();
        Set<String> uniqueValues = new HashSet<>(); // To store unique values

        String SELECT_QUERY = "SELECT `ten_goi_tap` FROM `goi_tap`";
        PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(SELECT_QUERY);
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            String tenGoiTap = result.getString("ten_goi_tap");
            if (!uniqueValues.contains(tenGoiTap)) { // Check if the value already exists
                tenGoiTapList.add(tenGoiTap);
                uniqueValues.add(tenGoiTap); // Add the value to the set
            }
        }

        return tenGoiTapList;
    }

    public static ObservableList<String> getLoaiGoiTapList() throws SQLException {

        ObservableList<String> loaiGoiTapList = FXCollections.observableArrayList();
        Set<String> uniqueValues = new HashSet<>(); // To store unique values

        String SELECT_QUERY = "SELECT `loai_goi_tap` FROM `goi_tap`";
        PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(SELECT_QUERY);
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            String loadiGoiTap = result.getString("loai_goi_tap");
            if (!uniqueValues.contains(loadiGoiTap)) { // Check if the value already exists
                loaiGoiTapList.add(loadiGoiTap);
                uniqueValues.add(loadiGoiTap); // Add the value to the set
            }
        }
        return loaiGoiTapList;
    }
	
}
