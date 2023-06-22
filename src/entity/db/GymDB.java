package entity.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class GymDB {

	private static Connection connect;

    public static Connection getConnection() {
        if (connect != null) return connect;
        try {
			Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:assets/db/itss.db";
            connect = DriverManager.getConnection(url);
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
