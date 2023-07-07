package services;

import java.sql.Connection;
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
	
	
    public static int addGoiTap(int ID, String tenGoiTap, String soTien, String loaiGoiTap) throws SQLException {
        int soTien_int = Integer.parseInt(soTien);
        String UPDATE_QUERY = "INSERT INTO `goi_tap`(`ten_goi_tap`, `so_tien`, `loai_goi_tap`) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(UPDATE_QUERY); 
        preparedStatement.setString(1, tenGoiTap);
        preparedStatement.setInt(2, soTien_int);
        preparedStatement.setString(3, loaiGoiTap);
        return preparedStatement.executeUpdate();
        
    
    }

    
    public static int deleteGoiTap(int ID) throws SQLException {
        String DELETE_QUERY =
                "DELETE FROM goi_tap " +
                        "WHERE ID =?";
        PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, ID);
        return preparedStatement.executeUpdate();
    }
    
    public static int updateGoiTap(int ID, String tenGoiTap, String soTien) throws SQLException {
    	int soTien_int = Integer.parseInt(soTien);
		String UPDATE_QUERY = "UPDATE `goi_tap` SET `ten_goi_tap`=?,`so_tien`=? WHERE id = ?";
		PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(UPDATE_QUERY);
		preparedStatement.setString(1, tenGoiTap);
		preparedStatement.setInt(2, soTien_int);
		preparedStatement.setInt(3, ID);
		preparedStatement.execute();
		return preparedStatement.executeUpdate();
	}
	
}
