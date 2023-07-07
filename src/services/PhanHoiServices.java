package services;

import static utils.Utils.convertDate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.db.GymDB;
import entity.model.HoiVien;
import entity.model.PhanHoi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PhanHoiServices {
	
	public static ObservableList<PhanHoi> getAllPhanHoi() throws SQLException {
		
		ObservableList<PhanHoi> phanHoiList = FXCollections.observableArrayList();
        String SELECT_QUERY = "SELECT hoi_vien.id, hoi_vien.ho_ten, `noi_dung`, `hoi_dap` FROM `phan_hoi` JOIN hoi_vien ON phan_hoi.id_hoi_vien = hoi_vien.id";
        PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(SELECT_QUERY);
        ResultSet result = preparedStatement.executeQuery();
        
        while (result.next()) {
        	phanHoiList.add(new PhanHoi(result.getInt("id"), result.getString("ho_ten"), result.getString("noi_dung"),
        			result.getString("hoi_dap")));
		}
        
        return phanHoiList;
    }

	public PhanHoiServices() {
		// TODO Auto-generated constructor stub
	}

}
