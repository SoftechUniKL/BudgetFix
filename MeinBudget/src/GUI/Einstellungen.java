package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Einstellungen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Einstellungen frame = new Einstellungen();
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
	public Einstellungen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 707);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		btnSchliessen.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/schliessengross.png")));
		btnSchliessen.setBounds(930, 15, 40, 40);
		contentPane.add(btnSchliessen);

//Button Menue		
		JLabel btnMenue = new JLabel();
		btnMenue.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/Men\u00FC.png")));
		btnMenue.setBounds(50, 30, 66, 75);
		contentPane.add(btnMenue);
		
//lblMenue		
		JLabel txtMenue = new JLabel("Men\u00FC");
		txtMenue.setFont(new Font("Tahoma", Font.BOLD, 34));
		txtMenue.setForeground(Color.WHITE);
		txtMenue.setBounds(130, 50, 150, 34);
		contentPane.add(txtMenue);
		
//Tabelle für Gesamtübersicht		
		JTable tableGesamt = new JTable();			
		tableGesamt.setBounds(50, 107, 200, 200);
		contentPane.add(tableGesamt);
		
//btnStart		
		JLabel btnStart = new JLabel();
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			//Start öffnet sich					
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
			//Start-Icon wird blau bei drübergehen der Maus
			@Override
			public void mouseEntered(MouseEvent e) {
				btnStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/StartBlau.png")));
			}
			//Start-Icon ist gelb
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Start.png")));
			}
		});
		btnStart.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/Start.png")));
		btnStart.setBounds(50, 320, 50, 50);
		contentPane.add(btnStart);
		
//lblStart
		JLabel lblStart = new JLabel("Start");
		lblStart.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblStart.setForeground(Color.WHITE);
		lblStart.setBounds(110, 332, 80, 25);
		contentPane.add(lblStart);
		
//Button Wiederholung		
		JLabel btnWiederholung = new JLabel();
		btnWiederholung.addMouseListener(new MouseAdapter() {
			@Override
			//Wiederholung öffnet sich	Bild			
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Wiederholung frame = new Wiederholung();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			//Wiederholung-Icon ist blau bei drübergehen der Maus
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnWiederholung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/WiederholungenBlau.png")));
			}	
			//Wiederholung-Icon ist gelb
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnWiederholung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/wiederholung.png")));
			}
		});
		btnWiederholung.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/wiederholung.png")));
		btnWiederholung.setBounds(50, 380, 50, 50);
		contentPane.add(btnWiederholung);
		
//lblWiederholung für fixe Beträge		
		JLabel lblWiederholung = new JLabel("Wiederholung");
		lblWiederholung.setForeground(Color.WHITE);
		lblWiederholung.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWiederholung.setBounds(110, 392, 174, 25);
		contentPane.add(lblWiederholung);
		
//Button Charts		
		JLabel btnCharts = new JLabel();
		btnCharts.addMouseListener(new MouseAdapter() {
			@Override
			//Charts öffnet sich
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Charts frame = new Charts();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}					
			//Charts-Icon wird blau bei drübergehen der Maus
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCharts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/ChartsBlau.png")));
			}
			//Charts-Icon ist gelb
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnCharts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Charts.png")));
			}
		});
		btnCharts.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/Charts.png")));
		btnCharts.setBounds(50, 440, 50, 50);
		contentPane.add(btnCharts);
		
//lblCharts		
		JLabel lblCharts = new JLabel("Charts");
		lblCharts.setForeground(Color.WHITE);
		lblCharts.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCharts.setBounds(110, 452, 174, 25);
		contentPane.add(lblCharts);
		
//Button Sparziele		
		JLabel btnSparziele = new JLabel();
		btnSparziele.addMouseListener(new MouseAdapter() {
			//Sparziele öffnet sich
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
			//Sparziele-Icon wird blau bei drübergehen der Maus
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSparziele.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/SparzieleBlau.png")));
			}
			//Sparziele-Icon ist gelb
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSparziele.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Sparziele.png")));
			}
		});
		btnSparziele.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/Sparziele.png")));
		btnSparziele.setBounds(50, 500, 50, 50);
		contentPane.add(btnSparziele);
		
//lblSparziele		
		JLabel lblSparziele = new JLabel("Sparziele");
		lblSparziele.setForeground(Color.WHITE);
		lblSparziele.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSparziele.setBounds(110, 512, 174, 25);
		contentPane.add(lblSparziele);
		
//Button Tools		
		JLabel btnTools = new JLabel("New label");
		btnTools.addMouseListener(new MouseAdapter() {
			@Override
			//Tools öffnet sich	Bild			
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Tools frame = new Tools();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			//Tools-Icon wird blau bei drübergehen der Maus
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTools.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/ToolsBlau.png")));
			}
			//Tools-Icon ist gelb
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnTools.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Tools.png")));
			}
		});
		btnTools.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/Tools.png")));
		btnTools.setBounds(50, 560, 50, 50);
		contentPane.add(btnTools);
		
//lblTools		
		JLabel lblTools = new JLabel("Tools");
		lblTools.setForeground(Color.WHITE);
		lblTools.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTools.setBounds(110, 572, 174, 25);
		contentPane.add(lblTools);
		
//Button Einstellungen		
		JLabel btnEinstellungen = new JLabel();
		btnEinstellungen.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/EinstellungenBlau.png")));
		btnEinstellungen.setBounds(50, 620, 50, 50);
		contentPane.add(btnEinstellungen);
		
//lblEinstellungen		
		JLabel lblEinstellungen = new JLabel("Einstellungen");
		lblEinstellungen.setIcon(null);
		lblEinstellungen.setForeground(Color.BLUE);
		lblEinstellungen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEinstellungen.setBounds(110, 632, 174, 25);
		contentPane.add(lblEinstellungen);
		
//Haupt"klasse"- Einstellungen		
		JLabel lblHauptEinstellungen = new JLabel("<html><u>EINSTELLUNGEN</u><HTML>");
		lblHauptEinstellungen.setForeground(Color.WHITE);
		lblHauptEinstellungen.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblHauptEinstellungen.setBounds(510, 50, 306, 34);
		contentPane.add(lblHauptEinstellungen);
		
//Haupt"klasse" Button Einstellungen		
		JLabel btnHauptEinstellungen = new JLabel();
		btnHauptEinstellungen.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/EinstellungenGross.png")));
		btnHauptEinstellungen.setBounds(430, 30, 66, 75);
		contentPane.add(btnHauptEinstellungen);
		
		JLabel lblAltesPasswortEingeben = new JLabel("altes Passwort eingeben:");
		lblAltesPasswortEingeben.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltesPasswortEingeben.setForeground(Color.WHITE);
		lblAltesPasswortEingeben.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAltesPasswortEingeben.setBounds(430, 130, 460, 38);
		contentPane.add(lblAltesPasswortEingeben);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setForeground(Color.GRAY);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(529, 180, 262, 30);
		contentPane.add(passwordField);
		
		JLabel lblNeuesPasswortEingeben = new JLabel("neues Passwort eingeben:");
		lblNeuesPasswortEingeben.setHorizontalAlignment(SwingConstants.CENTER);
		lblNeuesPasswortEingeben.setForeground(Color.WHITE);
		lblNeuesPasswortEingeben.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNeuesPasswortEingeben.setBounds(430, 260, 460, 38);
		contentPane.add(lblNeuesPasswortEingeben);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(null);
		passwordField_1.setForeground(Color.GRAY);
		passwordField_1.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField_1.setBounds(529, 310, 262, 30);
		contentPane.add(passwordField_1);
		
		JLabel lblNeuesPasswortWiederholen = new JLabel("neues Passwort wiederholen:");
		lblNeuesPasswortWiederholen.setHorizontalAlignment(SwingConstants.CENTER);
		lblNeuesPasswortWiederholen.setForeground(Color.WHITE);
		lblNeuesPasswortWiederholen.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNeuesPasswortWiederholen.setBounds(430, 390, 460, 38);
		contentPane.add(lblNeuesPasswortWiederholen);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBorder(null);
		passwordField_2.setForeground(Color.GRAY);
		passwordField_2.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField_2.setBounds(529, 440, 262, 30);
		contentPane.add(passwordField_2);
		
		JLabel btnSpeichern = new JLabel();
		btnSpeichern.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/Speichern.png")));
		btnSpeichern.setBounds(587, 540, 144, 38);
		contentPane.add(btnSpeichern);
		
		
//Hintergrund		
		JLabel Hintergrund = new JLabel();
		Hintergrund.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/GUI4.png")));
		Hintergrund.setBounds(0, -55, 1378, 815);
		contentPane.add(Hintergrund);

//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);		
		
	}
}

