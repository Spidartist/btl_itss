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

	public TaiKhoanServices() {
		// TODO Auto-generated constructor stub
	}

}
