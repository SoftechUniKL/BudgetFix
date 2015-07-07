package GUI;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*; 

public class BPDatenbank {

		static Connection conn = null;
		
		public static Connection dbCon(){
			try{
				Class.forName("org.sqlite.JDBC");
				String db = "jdbc:sqlite:src/BugetPlan/BudgetÜbersicht";
				conn = DriverManager.getConnection(db);
				System.out.println("---> Verbidung zur Datenbank OK!");
				return conn;
			}catch(Exception e){
				
				System.out.println("---> Verbidung zur Datenbank gescheitert!");
				System.out.println("Exception " + e);
				
				return null;
			}
		}
	}
