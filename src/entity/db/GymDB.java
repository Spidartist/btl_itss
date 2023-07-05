package entity.db;

import static utils.Configs.DATABASE;
import static utils.Configs.USERNAME;
import static utils.Configs.PASSWORD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GymDB {

	private static Connection connect;

    public static Connection getConnection() {
        if (connect != null) return connect;
        try {
        	connect  = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
            System.out.println("Connect database successfully");
        } catch (SQLException  e) {
        	System.out.println(e.getMessage());
        }
        return connect;
    }
    

    public static void main(String[] args) {
    	GymDB.getConnection();
    	if (GymDB.connect == null) {
    		System.out.println("dkmm");
    	}
    }
}
