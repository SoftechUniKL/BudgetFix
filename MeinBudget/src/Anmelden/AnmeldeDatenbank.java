package Anmelden;


import java.sql.*; 

public class AnmeldeDatenbank {

	static Connection con = null;
	
	public static Connection dbCon(){
		try{
			Class.forName("org.sqlite.JDBC");
			String db = "jdbc:sqlite:src/Anmelden/NutzerDB";
			con = DriverManager.getConnection(db);
			System.out.println("---> Verbidung zur Datenbank OK!");
			return con;
		}catch(Exception e){
			
			System.out.println("---> Verbidung zur Datenbank gescheitert!");
			System.out.println("Exception " + e);
			
			return null;
		}
	}
}
