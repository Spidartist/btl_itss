package services;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.db.GymDB;

public class TaiKhoanServices {
	
	public static int addTaiKhoanNhanVien(int id_role, int id_nhan_vien) throws SQLException {
		
        String INSERT_QUERY = "INSERT INTO `tai_khoan`(`id_nhan_vien`, `id_role`) VALUES (?, ?)";
        PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(INSERT_QUERY);
        preparedStatement.setInt(1, id_nhan_vien);
        preparedStatement.setInt(2, id_role);
        return preparedStatement.executeUpdate();
    }
	
	public static int addTaiKhoanHoiVien(int id_role, int id_hoi_vien) throws SQLException {
		
        String INSERT_QUERY = "INSERT INTO `tai_khoan`(`id_hoi_vien`, `id_role`) VALUES (?, ?)";
        PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(INSERT_QUERY);
        preparedStatement.setInt(1, id_hoi_vien);
        preparedStatement.setInt(2, id_role);
        return preparedStatement.executeUpdate();
    }
	
	public static int updateTaiKhoanNhanVien(String tai_khoan, String mat_khau, int id_nhan_vien) throws SQLException {
		
        String INSERT_QUERY = "UPDATE `tai_khoan` SET `tai_khoan`=?,`mat_khau`=? WHERE tai_khoan.id_nhan_vien = ?";
        PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(INSERT_QUERY);
        preparedStatement.setString(1, tai_khoan);
        preparedStatement.setString(2, mat_khau);
        preparedStatement.setInt(3, id_nhan_vien);
        return preparedStatement.executeUpdate();
    }
	
	public static int updateTaiKhoanHoiVien(String tai_khoan, String mat_khau, int id_hoi_vien) throws SQLException {
		
        String INSERT_QUERY = "UPDATE `tai_khoan` SET `tai_khoan`=?,`mat_khau`=? WHERE tai_khoan.id_hoi_vien = ?";
        PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(INSERT_QUERY);
        preparedStatement.setString(1, tai_khoan);
        preparedStatement.setString(2, mat_khau);
        preparedStatement.setInt(3, id_hoi_vien);
        return preparedStatement.executeUpdate();
    }
	

	public TaiKhoanServices() {
		// TODO Auto-generated constructor stub
	}

}
