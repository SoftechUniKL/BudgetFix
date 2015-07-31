package CSV;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;
import GUI.BPDatenbank;
 
public class CSV {
 
	static int id;
	
	public static void main(String[] args) {
		//this.id = id;
		
		Connection conn;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:src/BudgetPlan/Budget‹bersicht");	
			
			
				String sqlQuery = "CREATE VIEW MeineAusgaben AS SELECT Datum,Bezeichnung,Kategorie,Art,Betrag,Bemerkung FROM BenutzerAufwendungen WHERE (BenutzerID='2') ";
				String sqlQuery2 ="CREATE VIEW MeineEinnahmen AS SELECT Datum,Bezeichnung,Kategorie,Art,Betrag,Bemerkung FROM BenutzerErtr‰ge WHERE (BenutzerID='2') ";
				//PreparedStatement stm = conn.prepareStatement(sqlQuery);
				//PreparedStatement pstmt = conn.prepareStatement(sqlQuery2);
				//ResultSet result = stm.executeQuery();
				//ResultSet rs = pstmt.executeQuery();
				
				
			
			
			
			DatabaseMetaData meta = conn.getMetaData();
 
			// Tabellen laden
			ResultSet resGetTables = meta.getTables(null, null, null, new String[] { "VIEW" });
			Collection<String> collectionTables = new ArrayList<String>();
			while (resGetTables.next()) {
				collectionTables.add(resGetTables.getString("TABLE_NAME"));
			}
			resGetTables.close();
 
			// Load the Columns
			for(String tableName : collectionTables) {
				FileWriter foutputstream = new FileWriter(tableName + ".csv");
		        BufferedWriter out = new BufferedWriter(foutputstream);
				ResultSet resGetColumns = meta.getColumns(null, null, tableName, null);
				Collection<String> collectionColumns = new ArrayList<String>();
				while (resGetColumns.next()) {
			        out.write(resGetColumns.getString("COLUMN_NAME") + ";");
			        collectionColumns.add(resGetColumns.getString("COLUMN_NAME"));
				}
				out.write("\n");
				// End of columns
				// Load the actual data:
				Statement stmt = conn.createStatement();
				ResultSet rst = stmt.executeQuery("SELECT * FROM " + tableName);
				while (rst.next()) {
					for(String columnName : collectionColumns) {
						out.write(rst.getString(columnName) + ";");
					}
					out.write("\n");
				}
				out.close();
				resGetColumns.close();
				JOptionPane.showMessageDialog(null, "CSV erfolgreich erstellt!" );
			}
			
			//result.close();
			//stm.close();
			//rs.close();
			//pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("---> Verbindung zur Budget-Datenbank gescheitert!");
			System.out.println("Exception " + e);
			System.exit(1);
		}

	}
}