package demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	//DB Credentials
	public static String url ="jdbc:postgresql://"+System.getenv("TRAINING_DB_ENDPOINT")+
								"/ERS";

    public static String username = System.getenv("TRAINING_DB_USERNAME");
    public static String password = System.getenv("TRAINING_DB_PASSWORD");
   


////IF YOU WANT TO USE JDBC WITH A WAR PROJECT YOU NEED TO DO THE FOLLOWING:
static { //(this would normally go into your dao layer)
    try {
        Class.forName("org.postgresql.Driver");
    }catch(ClassNotFoundException e) {
        e.printStackTrace();
        System.out.println("Static block has failed me");
    }
  }
	public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url, username, password);
	}

}