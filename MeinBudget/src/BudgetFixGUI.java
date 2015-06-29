import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.Font;
import javax.swing.JTextField;


//Graphische Benutzeroberflaeche des BudgetFix
public class BudgetFixGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
/*	
	//Tabelle mit Uebersicht der Ausgaben
	private JTable table;

	//Scrollelemente, das die Tabelle umfasst
	private JScrollPane scrollpane;
		
	//Schaltflaeche, die beim Klicken einen Dialog anzeigt
	private JButton button;
		
	//Modell der Daten
	private static BudgetPlanModel budget;

		/**
		 * Konstruktor fuer die GUI.
		 * 
		 * Hier wird das Hauptfenster initialisiert und aktiviert.
		 * 
		 * @param budget
		 *            Modell der Daten
		 */
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BudgetFixGUI frame = new BudgetFixGUI(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		}); 
	} 

	/**
	 * Create the frame.
	 */
		
	public BudgetFixGUI(BudgetPlanModel budget) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1378, 745);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
/*		
			//super("BudgetFix");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(new FlowLayout());

			this.budget = budget;
			initWindow(); // Initialisierung des Frameinhalts
			addBehavior(); // Verhalten der GUI Elemente dieses Frames
			setBounds(10, 10, 1000, 1000); // Groesse des Frames
			setVisible(true); // Frame wird sichtbar
		}
		
		// Initialisieren des Fensters
		protected void initWindow() {

			// Tabelle mit Uebersicht der Ausgaben
			Object[][] data = new Object[budget.ausgaben.size()][5];
			int i = 0;
			for (Posten p : budget.ausgaben) {
				data[i][0] = new SimpleDateFormat("dd/MM/yyyy")
						.format(p.getDatum());
				data[i][1] = p.getBezeichnung();
				data[i][2] = String.format("%.2f", p.getBetrag());
				data[i][3] =  p.getKategorie();
				data[i][4] =  p.getArt();
				i++;
			}

			table = new JTable(data, new Object[] { "Datum", "Bezeichnung",
					"Betrag", "Kategorie", "Art" });
			scrollpane = new JScrollPane(table);

			// Kreisdiagramm
			DefaultPieDataset pd = new DefaultPieDataset();
			for (Posten p : budget.ausgaben) {
				pd.setValue(p.getKategorie(), p.getBetrag());
			}
			JFreeChart pie = ChartFactory.createPieChart("Ausgaben", pd);
			ChartPanel panel = new ChartPanel(pie);

			// Button
			JButton btnTest = new JButton("TestButton!");

			// Elemente dem Fenster hinzufuegen:
			getContentPane().add(scrollpane);
			getContentPane().add(panel);
			getContentPane().add(button);
			// Berechnet Layout mit geringstem Platzbedarf
			pack();
		}
		
		
		// Verhalten hinzufuegen
		public void addBehavior() {
			// registriere den ActionListener fuer den Button als anonyme Klasse
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(BudgetFixGUI.this,
							"Sie sollten Ihre Finanzplanung ueberdenken!",
							"Hinweis", JOptionPane.PLAIN_MESSAGE);
				}

			});
*/		
		
		
//Button Schliessen		
		final JLabel btnSchliessen = new JLabel();
		btnSchliessen.addMouseListener(new MouseAdapter() {
			@Override
			//Schliessenbutton in grau
			public void mouseEntered(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/schliessengross2.png")));
			}
			
			//Schliessenbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/schliessengross.png")));
			}
			
			//Schliesst das Fenster
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		
		btnSchliessen.setIcon(new ImageIcon(BudgetFixGUI.class.getResource("/Design/schliessengross.png")));
		btnSchliessen.setBounds(1310, 20, 40, 40);
		contentPane.add(btnSchliessen);
		
		JLabel lblAusgaben = new JLabel("Ausgaben:");
		lblAusgaben.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAusgaben.setBounds(25, 20, 112, 50);
		contentPane.add(lblAusgaben);
		
		textField = new JTextField();
		textField.setBounds(120, 30, 200, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
//Hintergrund		
		JLabel Hintergrund = new JLabel("");
		Hintergrund.setIcon(new ImageIcon(BudgetFixGUI.class.getResource("/Design/GUI.png")));
		Hintergrund.setBounds(0, 0, 1365, 767);
		contentPane.add(Hintergrund);
		
		
//Fullscreen Bildschirm
		setExtendedState(Frame.MAXIMIZED_BOTH);
//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
