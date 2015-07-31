package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import CSV.CSV;
/**
 * Tools BudgetFix:
 * 
 * Hier kann man seine Übersicht speichern:
 * 		> in Cloud synchronisieren lassen
 * 		> in die Dropbox hinzufügen
 * 		> als CSV.Datei speichern
 * Leider hatten wir hier einige Schwierigkeiten gehabt. Es funktioniert nur die CSV.Datei.
 * Wir hoffen auf den nächsten Update auf Erfolg.
 * Leider hatten wir hier einige Schwierigkeiten und hoffen auf den nächsten Update auf Erfolg.
 * 
 * @author Zusammenarbeit: Que Ly Dong & Patric Kleine
 * 
 */


public class Tools extends JFrame {

	Connection connection = null;
	static int id;
	
	private JPanel contentPane;
	private JTextField txtMonat;
	private JTextField txtVormonat;
	private JTextField txtJahr;
	private JTextField txtGesamt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tools frame = new Tools(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Visualisierungsfenster
	 */
	public Tools(int id) {
		
		this.id = id;
		// Verbindung zur BPDatenbank - Erträge und Aufwendungen
		connection = BPDatenbank.dbCon();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 706);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Button Schliessen
		final JLabel btnSchliessen = new JLabel();
		btnSchliessen.addMouseListener(new MouseAdapter() {
			@Override
			// Schliessenbutton in grau
			public void mouseEntered(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/schliessengross2.png")));
			}

			// Schliessenbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/schliessengross.png")));
			}

			// Schliesst das Fenster
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnSchliessen.setIcon(new ImageIcon(Tools.class
				.getResource("/Design/schliessengross.png")));
		btnSchliessen.setBounds(930, 15, 40, 40);
		contentPane.add(btnSchliessen);

		// Button Menue
		JLabel btnMenue = new JLabel();
		btnMenue.setIcon(new ImageIcon(Tools.class
				.getResource("/Design/Men\u00FC.png")));
		btnMenue.setBounds(50, 150, 66, 75);
		contentPane.add(btnMenue);

		// lblMenue
		JLabel txtMenue = new JLabel("Men\u00FC");
		txtMenue.setFont(new Font("Tahoma", Font.BOLD, 34));
		txtMenue.setForeground(Color.WHITE);
		txtMenue.setBounds(130, 170, 150, 34);
		contentPane.add(txtMenue);
		
		// btnStart
		JLabel btnStart = new JLabel();
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			// Start öffnet sich
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Start frame = new Start(Start.id);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}

			// Start-Icon wird blau bei drübergehen der Maus
			@Override
			public void mouseEntered(MouseEvent e) {
				btnStart.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/StartBlau.png")));
			}

			// Start-Icon ist gelb
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnStart.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Start.png")));
			}
		});
		btnStart.setIcon(new ImageIcon(Tools.class
				.getResource("/Design/Start.png")));
		btnStart.setBounds(60, 255, 50, 50);
		contentPane.add(btnStart);

		// lblStart
		JLabel lblStart = new JLabel("Start");
		lblStart.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblStart.setForeground(Color.WHITE);
		lblStart.setBounds(120, 267, 80, 25);
		contentPane.add(lblStart);

		// Button Wiederholung
		JLabel btnWiederholung = new JLabel();
		btnWiederholung.addMouseListener(new MouseAdapter() {
			@Override
			// Wiederholung öffnet sich Bild
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Wiederholung frame = new Wiederholung(Start.id);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}

			// Wiederholung-Icon ist blau bei drübergehen der Maus
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnWiederholung.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/WiederholungenBlau.png")));
			}

			// Wiederholung-Icon ist gelb
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnWiederholung.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/wiederholung.png")));
			}
		});
		btnWiederholung.setIcon(new ImageIcon(Tools.class
				.getResource("/Design/wiederholung.png")));
		btnWiederholung.setBounds(60, 315, 50, 50);
		contentPane.add(btnWiederholung);

		// lblWiederholung für fixe Beträge
		JLabel lblWiederholung = new JLabel("Wiederholung");
		lblWiederholung.setForeground(Color.WHITE);
		lblWiederholung.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWiederholung.setBounds(120, 327, 174, 25);
		contentPane.add(lblWiederholung);

		// Button Charts
		JLabel btnCharts = new JLabel();
		btnCharts.addMouseListener(new MouseAdapter() {
			@Override
			// Charts öffnet sich
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Charts frame = new Charts(Start.id);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}

			// Charts-Icon wird blau bei drübergehen der Maus
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCharts.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/ChartsBlau.png")));
			}

			// Charts-Icon ist gelb
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnCharts.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Charts.png")));
			}
		});
		btnCharts.setIcon(new ImageIcon(Tools.class
				.getResource("/Design/Charts.png")));
		btnCharts.setBounds(60, 375, 50, 50);
		contentPane.add(btnCharts);

		// lblCharts
		JLabel lblCharts = new JLabel("Charts");
		lblCharts.setForeground(Color.WHITE);
		lblCharts.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCharts.setBounds(120, 387, 174, 25);
		contentPane.add(lblCharts);

		// Button Sparziele
		JLabel btnSparziele = new JLabel();
		btnSparziele.addMouseListener(new MouseAdapter() {
			// Sparziele öffnet sich
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Sparziele frame = new Sparziele();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}

			// Sparziele-Icon wird blau bei drübergehen der Maus
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSparziele.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/SparzieleBlau.png")));
			}

			// Sparziele-Icon ist gelb
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSparziele.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Sparziele.png")));
			}
		});
		btnSparziele.setIcon(new ImageIcon(Tools.class
				.getResource("/Design/Sparziele.png")));
		btnSparziele.setBounds(60, 435, 50, 50);
		contentPane.add(btnSparziele);

		// lblSparziele
		JLabel lblSparziele = new JLabel("Sparziele");
		lblSparziele.setForeground(Color.WHITE);
		lblSparziele.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSparziele.setBounds(120, 447, 174, 25);
		contentPane.add(lblSparziele);

		// Button Tools
		JLabel btnTools = new JLabel();
		btnTools.setIcon(new ImageIcon(Tools.class
				.getResource("/Design/ToolsBlau.png")));
		btnTools.setBounds(60, 495, 50, 50);
		contentPane.add(btnTools);

		// lblTools
		JLabel lblTools = new JLabel("Tools");
		lblTools.setForeground(Color.BLUE);
		lblTools.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTools.setBounds(120, 507, 174, 25);
		contentPane.add(lblTools);

		// Button Einstellungen
		JLabel btnEinstellungen = new JLabel();
		btnEinstellungen.addMouseListener(new MouseAdapter() {
			@Override
			// Einstellungen öffnet sich Bild
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Einstellungen frame = new Einstellungen(Einstellungen.id);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}

			// Einstellungen-Icon wird blau bei drübergehen der Maus
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEinstellungen.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/EinstellungenBlau.png")));
			}

			// Einstellungen-Icon ist gelb
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnEinstellungen.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Einstellungen.png")));
			}
		});
		btnEinstellungen.setIcon(new ImageIcon(Tools.class
				.getResource("/Design/Einstellungen.png")));
		btnEinstellungen.setBounds(60, 555, 50, 50);
		contentPane.add(btnEinstellungen);

		// lblEinstellungen
		JLabel lblEinstellungen = new JLabel("Einstellungen");
		lblEinstellungen.setIcon(null);
		lblEinstellungen.setForeground(Color.WHITE);
		lblEinstellungen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEinstellungen.setBounds(120, 567, 174, 25);
		contentPane.add(lblEinstellungen);

		// Haupt"klasse"- Tools
		JLabel lblHauptTools = new JLabel("<html><u>TOOLS</u><HTML>");
		lblHauptTools.setForeground(Color.WHITE);
		lblHauptTools.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblHauptTools.setBounds(510, 50, 150, 34);
		contentPane.add(lblHauptTools);

		// Haupt"klasse" Button Tools
		JLabel btnHauptTools = new JLabel();
		btnHauptTools.setIcon(new ImageIcon(Tools.class
				.getResource("/Design/ToolsGross.png")));
		btnHauptTools.setBounds(430, 30, 66, 75);
		contentPane.add(btnHauptTools);

		JLabel lblDatenexport = new JLabel("Datenexport:");
		lblDatenexport.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatenexport.setForeground(Color.WHITE);
		lblDatenexport.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDatenexport.setBounds(430, 150, 460, 38);
		contentPane.add(lblDatenexport);

		// Button zum Exportieren in die Cloud
		JLabel btnCloud = new JLabel();
		btnCloud.setIcon(new ImageIcon(Tools.class
				.getResource("/Design/Cloud.png")));
		btnCloud.setBounds(548, 250, 232, 38);
		contentPane.add(btnCloud);

		// Button zum exportieren in Dropbox
		JLabel btnDropbox = new JLabel();
		btnDropbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Dropbox = Dropbox.DropboxCon(); ------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>DROPBOX
			}
		});
		btnDropbox.setIcon(new ImageIcon(Tools.class
				.getResource("/Design/Dropbox.png")));
		btnDropbox.setBounds(548, 350, 232, 38);
		contentPane.add(btnDropbox);

		//Button zum exportieren als CSV-Datei
		//Erstellung der CSV im Pfad: \BudgetFix\MeinBudget
		JLabel btnCSV = new JLabel();
		btnCSV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CSV.main(null);
			}
		});
		btnCSV.setIcon(new ImageIcon(Tools.class.getResource("/Design/csv.png")));
		btnCSV.setBounds(548, 450, 232, 38);
		contentPane.add(btnCSV);

		// Hintergrund
		JLabel Hintergrund = new JLabel();
		Hintergrund.setIcon(new ImageIcon(Tools.class.getResource("/Design/GUI6.png")));
		Hintergrund.setBounds(0, -56, 1000, 820);
		contentPane.add(Hintergrund);

		// Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten
		// des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);

	}

}
