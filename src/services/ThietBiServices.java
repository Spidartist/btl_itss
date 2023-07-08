package services;

import entity.db.GymDB;
import entity.model.PhongTap;
import entity.model.ThietBi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static utils.Utils.convertDate;

public class ThietBiServices {
	
	public static int getPhongTapId(String tenPhongTap) throws SQLException {
	    String SELECT_QUERY = "SELECT id FROM `phong_tap` WHERE ten_phong = ?";
	    PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(SELECT_QUERY);
	    preparedStatement.setString(1, tenPhongTap);
	    ResultSet result = preparedStatement.executeQuery();

	    if (result.next()) {
	        return result.getInt("id");
	    } else {
	        // Handle the case where the PhongTap with the given tenPhongTap doesn't exist
	        return -1; // or throw an exception, return a default value, etc.
	    }
	}
	
    public static int getTotalThietBi() {
        int total = 0;
        String GET_QUERY = "SELECT COUNT(*) FROM thiet_bi";
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
	
	public static ObservableList<ThietBi> getAllThietBi() throws SQLException {

		ObservableList<ThietBi> thietBiList = FXCollections.observableArrayList();
		String SELECT_QUERY = "SELECT tb.id, tb.ten, tb.ngay_nhap_ve, tb.xuat_xu, tb.tinh_trang, pt.ten_phong AS ten_phong FROM `thiet_bi` tb " +
				"JOIN `phong_tap` pt ON tb.id_phong_tap = pt.id";
		PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(SELECT_QUERY);
		ResultSet result = preparedStatement.executeQuery();

		while (result.next()) {
			int id = result.getInt("id");
			String ten = result.getString("ten");
			String ngayNhapVe = convertDate(result.getString("ngay_nhap_ve"));
			String xuatXu = result.getString("xuat_xu");
			String tinhTrang = result.getString("tinh_trang");
			String tenPhong = result.getString("ten_phong");

			ThietBi thietBi = new ThietBi(id, ten, ngayNhapVe, xuatXu, tinhTrang, tenPhong);
			thietBiList.add(thietBi);
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

//	public static ThietBi findThietBiById(int ID) throws SQLException{
//		String SELECT_QUERY = "SELECT * FROM `thiet_bi` WHERE `id` = ?";
//		PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(SELECT_QUERY);
//		ResultSet result = preparedStatement.executeQuery();
//		ThietBi thietBi = new ThietBi(result.getInt("id"), result.getInt("id_phong_tap"),
//				result.getString("ten"), convertDate(result.getString("ngay_nhap_ve")),
//				result.getString("xuat_xu"),result.getString("tinh_trang"));
//
//		return thietBi;
//	}
//
//	public static ObservableList<ThietBi> findThietBiByIdRoom(int idRoom) throws SQLException {
//		ObservableList<ThietBi> thietBiList = FXCollections.observableArrayList();
//		String SELECT_QUERY = "SELECT * FROM `thiet_bi` WHERE `id_phong_tap` = ?";
//		PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(SELECT_QUERY);
//		ResultSet result = preparedStatement.executeQuery();
//		while (result.next()) {
//			thietBiList.add(new ThietBi(result.getInt("id"), result.getInt("id_phong_tap"),
//					result.getString("ten"), convertDate(result.getString("ngay_nhap_ve")),
//					result.getString("xuat_xu"), result.getString("tinh_trang")));
//		}
//		return thietBiList;
//	}

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
