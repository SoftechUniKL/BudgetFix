package GUI;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * BPDatenbank BudgetFix:
 * Verbindung mit der SQLite, wo die Budget�bersicht der Ausgaben und Einnahmen hinterlegt sind
 * 
 * 
 * @author Patric Kleine
 * 
 */

public class BPDatenbank {

	static Connection conn = null;

	public static Connection dbCon() {
		try {
			Class.forName("org.sqlite.JDBC");
			String db = "jdbc:sqlite:src/BudgetPlan/Budget�bersicht";
			conn = DriverManager.getConnection(db);
			System.out.println("---> Verbindung zur Budget-Datenbank OK!");
			return conn;
		} catch (Exception e) {

			System.out
					.println("---> Verbindung zur Budget-Datenbank gescheitert!");
			System.out.println("Exception " + e);

			return null;
		}
	}
}
