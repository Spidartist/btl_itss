package services;

import entity.db.GymDB;
import entity.model.ThietBi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static utils.Utils.convertDate;

public class ThietBiServices {
	public static ObservableList<ThietBi> getAllThietBi() throws SQLException {

		ObservableList<ThietBi> thietBiList = FXCollections.observableArrayList();
		String SELECT_QUERY = "SELECT * FROM `thiet_bi`";
		PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(SELECT_QUERY);
		ResultSet result = preparedStatement.executeQuery();

		while (result.next()) {
			thietBiList.add(new ThietBi(result.getInt("id"), result.getInt("id_phong_tap"),
					result.getString("ten"), convertDate(result.getString("ngay_nhap_ve")),
					result.getString("xuat_xu"),result.getString("tinh_trang")));
		}

		return thietBiList;
	}

	public static int addThietBi(int idRoom, String ten, String ngayNhapVe, String xuatXu, String tinhTrang) throws SQLException {

		String INSERT_QUERY = "INSERT INTO `thiet_bi`(`id_phong_tap`, `ten`, `ngay_nhap_ve`, " +
				"`xuat_xu`, `tinh_trang`) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(INSERT_QUERY);
		preparedStatement.setInt(1, idRoom);
		preparedStatement.setString(2, ten);
		preparedStatement.setString(3, ngayNhapVe);
		preparedStatement.setString(4, xuatXu);
		preparedStatement.setString(5, tinhTrang);

		return preparedStatement.executeUpdate();
	}

	public static ThietBi findThietBiById(int ID) throws SQLException{
		String SELECT_QUERY = "SELECT * FROM `thiet_bi` WHERE `id` = ?";
		PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(SELECT_QUERY);
		ResultSet result = preparedStatement.executeQuery();
		ThietBi thietBi = new ThietBi(result.getInt("id"), result.getInt("id_phong_tap"),
				result.getString("ten"), convertDate(result.getString("ngay_nhap_ve")),
				result.getString("xuat_xu"),result.getString("tinh_trang"));

		return thietBi;
	}

	public static ObservableList<ThietBi> findThietBiByIdRoom(int idRoom) throws SQLException {
		ObservableList<ThietBi> thietBiList = FXCollections.observableArrayList();
		String SELECT_QUERY = "SELECT * FROM `thiet_bi` WHERE `id_phong_tap` = ?";
		PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(SELECT_QUERY);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			thietBiList.add(new ThietBi(result.getInt("id"), result.getInt("id_phong_tap"),
					result.getString("ten"), convertDate(result.getString("ngay_nhap_ve")),
					result.getString("xuat_xu"), result.getString("tinh_trang")));
		}
		return thietBiList;
	}

	public static int deleteThietBi(int ID) throws SQLException {
		String DELETE_QUERY =
				"DELETE FROM `thiet_bi` " +
						"WHERE `id` =?";
		PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(DELETE_QUERY);
		preparedStatement.setInt(1, ID);
		return preparedStatement.executeUpdate();
	}

	public static int updateThietBi(int ID, int idRoom, String ten, String ngayNhapVe, String xuatXu, String tinhTrang) throws SQLException {
		String UPDATE_QUERY = "UPDATE `thiet_bi` SET `id_phong_tap`=?, `ten`=?, `ngay_nhap_ve`=?," +
				"`xuat_xu`=?, `tinh_trang`=? WHERE `id` = ?";
		PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(UPDATE_QUERY);
		preparedStatement.setInt(1, idRoom);
		preparedStatement.setString(2, ten);
		preparedStatement.setString(3, ngayNhapVe);
		preparedStatement.setString(4, xuatXu);
		preparedStatement.setString(5, tinhTrang);
		preparedStatement.setInt(6, ID);
		preparedStatement.execute();
		return preparedStatement.executeUpdate();
	}
	public ThietBiServices() {
		// TODO Auto-generated constructor stub
	}

}
