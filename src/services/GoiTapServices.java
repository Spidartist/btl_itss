package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
}
