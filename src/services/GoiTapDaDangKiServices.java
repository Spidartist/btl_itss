package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.db.GymDB;
import entity.model.GoiTapDaDangKi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@SuppressWarnings("unused")
public class GoiTapDaDangKiServices {

	public static ObservableList<GoiTapDaDangKi> getAll() throws SQLException {

	    ObservableList<GoiTapDaDangKi> goiTapList = FXCollections.observableArrayList();
	    String SELECT_QUERY = "SELECT dkgt.id AS id, hv.ho_ten AS ten_hoi_vien, gt.ten_goi_tap AS ten_goi_tap, gt.loai_goi_tap AS loai_goi_tap, dkgt.ngay_dang_ki AS ngay_dang_ki " +
	                          "FROM dang_ki_goi_tap AS dkgt " +
	                          "JOIN hoi_vien AS hv ON dkgt.id_hoi_vien = hv.id " +
	                          "JOIN goi_tap AS gt ON dkgt.id_goi_tap = gt.id";
	    PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(SELECT_QUERY);
	    ResultSet result = preparedStatement.executeQuery();

	    while (result.next()) {
	        String ngayDangKi = result.getDate("ngay_dang_ki").toString();
	        goiTapList.add(new GoiTapDaDangKi(result.getInt("id"), result.getString("ten_hoi_vien"), result.getString("ten_goi_tap"), result.getString("loai_goi_tap"), ngayDangKi));
	    }

	    return goiTapList;
	}
	
	
    public static int getTotalGoiTap() {
        int total = 0;
        String GET_QUERY = "SELECT COUNT(*) FROM dang_ki_goi_tap";
        try {
            PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(GET_QUERY);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                total = result.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return total;
    }
	

	public static ObservableList<String> getLoaiGoiTapAll() throws SQLException {
		
		ObservableList<String> goiTapList = FXCollections.observableArrayList();
        
        
        return goiTapList;
    }
	
	
    public static int addDangKi(int ID, int idHoiVien, int idGoiTap, String ngayDangKi) throws SQLException {
        String UPDATE_QUERY = "INSERT INTO `dang_ki_goi_tap`(`id_hoi_vien`, `id_goi_tap`, `ngay_dang_ki`) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(UPDATE_QUERY); 
        preparedStatement.setInt(1, idHoiVien);
        preparedStatement.setInt(2, idGoiTap);
        preparedStatement.setString(3, ngayDangKi);
        return preparedStatement.executeUpdate();
        
    
    }

    
    public static int deleteGoiTap(int ID) throws SQLException {
        String DELETE_QUERY =
                "DELETE FROM dang_ki_goi_tap " +
                        "WHERE ID =?";
        PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(DELETE_QUERY);
        preparedStatement.setInt(1, ID);
        return preparedStatement.executeUpdate();
    }
    
    public static int updateGoiTap(int ID, int idHoiVien, int idGoiTap, String ngayDangKi) throws SQLException {
		String UPDATE_QUERY = "UPDATE `dang_ki_goi_tap` SET `id_hoi_vien`=?,`id_goi_tap`=?, `ngay_dang_ki`=? WHERE id = ?";
		PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(UPDATE_QUERY);
		preparedStatement.setInt(1, idHoiVien);
		preparedStatement.setInt(2, idGoiTap);
		preparedStatement.setString(3, ngayDangKi);
		preparedStatement.setInt(4, ID);
		preparedStatement.execute();
		return preparedStatement.executeUpdate();
	}
	
}