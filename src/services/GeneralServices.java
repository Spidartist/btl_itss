package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.db.GymDB;

public class GeneralServices {
	
	public static int getIdViaName(String tableName, String colName, String name) throws SQLException {
        String SELECT_QUERY = String.format("SELECT `id` FROM %s WHERE %s = ?", tableName, colName);

        PreparedStatement preparedStatement = GymDB.getConnection().prepareStatement(SELECT_QUERY);
        preparedStatement.setString(1, name);
        ResultSet result = preparedStatement.executeQuery();
        result.next();
        return result.getInt("id");
    }

	public GeneralServices() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println(GeneralServices.getIdViaName("role", "ten_role", "Chủ phòng gym"));
	}

}
