package entity.db;

import static utils.Configs.DATABASE;
import static utils.Configs.USERNAME;
import static utils.Configs.PASSWORD;

import java.sql.Connection;
import java.sql.DriverManager;

public class GymDB {

	private static Connection connect;

    public static Connection getConnection() {
        if (connect != null) return connect;
        try {
        	Connection connect = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
            System.out.println("Connect database successfully");
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        } 
        return connect;
    }
    

    public static void main(String[] args) {
    	GymDB.getConnection();
    }
}
