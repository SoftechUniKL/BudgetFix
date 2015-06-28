import java.awt.EventQueue;
import Login.LoginFenster;

/**
 * Anwendung BudgetPlan
 * 
 */

public class BudgetPlan {
	public static void main(String[] args) {
		//Anmeldung
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LoginFenster frame = new LoginFenster();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
		
		BudgetPlanModel budget = new BudgetPlanModel(); // Modell
		new BudgetPlanGUI(budget); // View und Controller
		
		
	}

}
