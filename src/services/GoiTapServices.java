package services;

import entity.db.GymDB;
import entity.model.GoiTap;
import entity.model.HoiVien;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static utils.Utils.convertDate;

public class GoiTapServices {
	public static ObservableList<GoiTap> getAllHoiVien() throws SQLException {

		ObservableList<GoiTap> goiTapList = FXCollections.observableArrayList();
		String SELECT_QUERY = "SELECT * FROM `goi_tap`";
		PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(SELECT_QUERY);
		ResultSet result = preparedStatement.executeQuery();

		while (result.next()) {
			goiTapList.add(new GoiTap(result.getInt("id"), result.getInt("so_tien"),
					result.getString("ten_goi_tap"), result.getString("loai_goi_tap")));
		}

		return goiTapList;
	}

	public static int addGoiTap(int soTien, String tenGoiTap, String loaiGoiTap) throws SQLException {

		String INSERT_QUERY = "INSERT INTO `goi_tap`(`ten_goi_tap`, `so_tien`, `loai_goi_tap`) VALUES (?, ?, ?)";
		PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(INSERT_QUERY);
		preparedStatement.setString(1, tenGoiTap);
		preparedStatement.setInt(2, soTien);
		preparedStatement.setString(3, loaiGoiTap);

		return preparedStatement.executeUpdate();
	}

	public static int deleteGoiTap(int ID) throws SQLException {
		String DELETE_QUERY =
				"DELETE FROM `goi_tap` " +
						"WHERE `id` =?";
		PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(DELETE_QUERY);
		preparedStatement.setInt(1, ID);
		return preparedStatement.executeUpdate();
	}

	public static int updateGoiTap(int ID, int soTien, String tenGoiTap, String loaiGoiTap) throws SQLException {
		String UPDATE_QUERY = "UPDATE `goi_tap` SET `ten_goi_tap`=?, `so_tien`=?, `loai_goi_tap`=? WHERE `id` = ?";
		PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(UPDATE_QUERY);
		preparedStatement.setString(1, tenGoiTap);
		preparedStatement.setInt(2, soTien);
		preparedStatement.setString(3, loaiGoiTap);
		preparedStatement.setInt(4, ID);
		preparedStatement.execute();
		return preparedStatement.executeUpdate();
	}
	public GoiTapServices() {
		// TODO Auto-generated constructor stub
	}

}
