package BudgetPlan;
import java.awt.EventQueue;
import Anmelden.AnmeldenFenster;

/**
 * Anwendung BudgetFix:
 * 
 * Willkommen zur Applikation eines Budgetverwaltungsprogramm.
 * Die App hat noch einige Bugs, jedoch f�r die erste Testphase schon gut geeignet.
 * Einfach Programm starten und in BudgetFix reingeschnuppern.
 * Viel Spa�!
 *
 * F�r Verbesserungsvorschl�ge w�ren die Authoren sehr erfreut.
 * 
 * 
 * @author Que Ly Dong & Patric Kleine
 * @version Beta 1.2.0 
 * Dieses Programm wurde in Java geschrieben in Verbindung mit SQLite.
 * 
 */

public class BudgetPlan {
	public static void main(String[] args) {
		//�ffnet Anmeldung-Fenster, um sich als Benutzer anmelden zu koennen
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AnmeldenFenster frame = new AnmeldenFenster();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
	}

}
