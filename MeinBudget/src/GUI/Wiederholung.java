package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

/**
 * Wiederholung BudgetFix:
 * 
 * Hier kann man fixe  Beitr�ge intervallm��ig bestimmt werden,
 * damit man, je nach dem wie man es haben m�chte, die Beitr�ge t�glich, monatlich, j�hrlich automatisch festlegen kann.
 * 
 * Bugfix: hier kann man diese Anwendung jedoch noch nicht anwenden. Folgt beim n�chsten Update. Wir bitten um Geduld!
 * 
 * 
 * @author Zusammenarbeit: Que Ly Dong & Patric Kleine
 * 
 */


public class Wiederholung extends JFrame {
	
	Connection connection = null;
	
	private JPanel contentPane;
	private JTable tableFix;

	static int id;
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
					Wiederholung frame = new Wiederholung(id);
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
	public Wiederholung(int id) {
		
		this.id = id;
		
		// Verbindung zur BPDatenbank - Ertr�ge und Aufwendungen
		connection = BPDatenbank.dbCon();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 704);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

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
		contentPane.setLayout(null);
		btnSchliessen.setIcon(new ImageIcon(Wiederholung.class.getResource("/Design/schliessengross.png")));
		btnSchliessen.setBounds(925, 15, 40, 40);
		contentPane.add(btnSchliessen);

//Button Menue		
		JLabel btnMenue = new JLabel();
		btnMenue.setIcon(new ImageIcon(Wiederholung.class.getResource("/Design/Men\u00FC.png")));
		btnMenue.setBounds(50, 150, 66, 75);
		contentPane.add(btnMenue);
		
//lblMenue		
		JLabel txtMenue = new JLabel("Men\u00FC");
		txtMenue.setFont(new Font("Tahoma", Font.BOLD, 34));
		txtMenue.setForeground(Color.WHITE);
		txtMenue.setBounds(130, 170, 150, 34);
		contentPane.add(txtMenue);

//btnStart		
		JLabel btnStart = new JLabel();
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			//Start �ffnet sich					
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
			//Start-Icon wird blau bei dr�bergehen der Maus
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
		btnStart.setIcon(new ImageIcon(Wiederholung.class.getResource("/Design/Start.png")));
		btnStart.setBounds(60, 255, 50, 50);
		contentPane.add(btnStart);
		
//lblStart
		JLabel lblStart = new JLabel("Start");
		lblStart.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblStart.setForeground(Color.WHITE);
		lblStart.setBounds(120, 267, 80, 25);
		contentPane.add(lblStart);
		
//Button Wiederholung		
		JLabel btnWiederholung = new JLabel();
		btnWiederholung.setIcon(new ImageIcon(Wiederholung.class.getResource("/Design/WiederholungenBlau.png")));
		btnWiederholung.setBounds(60, 315, 50, 50);
		contentPane.add(btnWiederholung);
		
//lblWiederholung f�r fixe Betr�ge		
		JLabel lblWiederholung = new JLabel("Wiederholung");
		lblWiederholung.setForeground(Color.BLUE);
		lblWiederholung.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWiederholung.setBounds(120, 327, 174, 25);
		contentPane.add(lblWiederholung);
		
//Button Charts		
		JLabel btnCharts = new JLabel();
		btnCharts.addMouseListener(new MouseAdapter() {
			@Override
			//Charts �ffnet sich
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Charts frame = new Charts(id);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}					
			//Charts-Icon wird blau bei dr�bergehen der Maus
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
		btnCharts.setIcon(new ImageIcon(Wiederholung.class.getResource("/Design/Charts.png")));
		btnCharts.setBounds(60, 375, 50, 50);
		contentPane.add(btnCharts);
		
//lblCharts		
		JLabel lblCharts = new JLabel("Charts");
		lblCharts.setForeground(Color.WHITE);
		lblCharts.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCharts.setBounds(120, 387, 174, 25);
		contentPane.add(lblCharts);
		
//Button Sparziele		
		JLabel btnSparziele = new JLabel();
		btnSparziele.addMouseListener(new MouseAdapter() {
			//Sparziele �ffnet sich
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
			//Sparziele-Icon wird blau bei dr�bergehen der Maus
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
		btnSparziele.setIcon(new ImageIcon(Wiederholung.class.getResource("/Design/Sparziele.png")));
		btnSparziele.setBounds(60, 435, 50, 50);
		contentPane.add(btnSparziele);
		
//lblSparziele		
		JLabel lblSparziele = new JLabel("Sparziele");
		lblSparziele.setForeground(Color.WHITE);
		lblSparziele.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSparziele.setBounds(120, 447, 174, 25);
		contentPane.add(lblSparziele);
		
//Button Tools		
		JLabel btnTools = new JLabel("New label");
		btnTools.addMouseListener(new MouseAdapter() {
			@Override
			//Tools �ffnet sich	Bild			
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Tools frame = new Tools(Tools.id);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			//Tools-Icon wird blau bei dr�bergehen der Maus
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
		btnTools.setIcon(new ImageIcon(Wiederholung.class.getResource("/Design/Tools.png")));
		btnTools.setBounds(60, 495, 50, 50);
		contentPane.add(btnTools);
		
//lblTools		
		JLabel lblTools = new JLabel("Tools");
		lblTools.setForeground(Color.WHITE);
		lblTools.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTools.setBounds(120, 507, 174, 25);
		contentPane.add(lblTools);
		
//Button Einstellungen		
		JLabel btnEinstellungen = new JLabel();
		btnEinstellungen.addMouseListener(new MouseAdapter() {
			@Override
			//Einstellungen �ffnet sich	Bild			
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
			//Einstellungen-Icon wird blau bei dr�bergehen der Maus			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEinstellungen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/EinstellungenBlau.png")));
			}
			//Einstellungen-Icon ist gelb
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnEinstellungen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Einstellungen.png")));
			}
		});
		btnEinstellungen.setIcon(new ImageIcon(Wiederholung.class.getResource("/Design/Einstellungen.png")));
		btnEinstellungen.setBounds(60, 555, 50, 50);
		contentPane.add(btnEinstellungen);
		
//lblEinstellungen		
		JLabel lblEinstellungen = new JLabel("Einstellungen");
		lblEinstellungen.setIcon(null);
		lblEinstellungen.setForeground(Color.WHITE);
		lblEinstellungen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEinstellungen.setBounds(120, 567, 174, 25);
		contentPane.add(lblEinstellungen);
		
		
//Haupt"klasse"- Wiederholung	
		JLabel lblHauptWiederholung = new JLabel("<html><u>WIEDERHOLUNG</u><HTML>");
		lblHauptWiederholung.setForeground(Color.WHITE);
		lblHauptWiederholung.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblHauptWiederholung.setBounds(510, 50, 322, 34);
		contentPane.add(lblHauptWiederholung);
		
//Haupt"klasse" Button Wiederholung		
		JLabel btnHauptWiederholung = new JLabel();
		btnHauptWiederholung.setIcon(new ImageIcon(Wiederholung.class.getResource("/Design/WiederholungGross.png")));
		btnHauptWiederholung.setBounds(430, 30, 66, 75);
		contentPane.add(btnHauptWiederholung);
		
//lblFixeTransaktion		
		JLabel lblFixeTransaktion = new JLabel("neue wiederholende Transaktion");
		lblFixeTransaktion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFixeTransaktion.setBounds(580, 149, 199, 35);
		contentPane.add(lblFixeTransaktion);
		
//Button FixeTransaktion		
		JLabel btnFixeTransaktion = new JLabel();
		btnFixeTransaktion.addMouseListener(new MouseAdapter() {
			//Plusbutton wird grau bei dr�bergehen der Maus
			@Override
			public void mouseEntered(MouseEvent e) {
					btnFixeTransaktion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Plus2.png")));
				}
			//Plusbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
					btnFixeTransaktion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Plus.png")));
				}
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TransaktionAnlegen frame = new TransaktionAnlegen(Wiederholung.id);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnFixeTransaktion.setIcon(new ImageIcon(Wiederholung.class.getResource("/Design/Plus.png")));
		btnFixeTransaktion.setBounds(538, 156, 25, 25);
		contentPane.add(btnFixeTransaktion);
		
//FixeTransaktion		
		JLabel FixeTransaktion = new JLabel();
		FixeTransaktion.setIcon(new ImageIcon(Wiederholung.class.getResource("/Design/Textfeldgross3.png")));
		FixeTransaktion.setBounds(510, 150, 291, 35);
		contentPane.add(FixeTransaktion);

//Scroll Pane f�r Tabelle		
		JScrollPane scrollPane_TabelleFix = new JScrollPane();
		scrollPane_TabelleFix.setBorder(null);
		scrollPane_TabelleFix.setForeground(Color.GRAY);
		scrollPane_TabelleFix.setBounds(510, 220, 291, 307);
		scrollPane_TabelleFix.getViewport().setBackground(new Color(27, 109, 220));
		contentPane.add(scrollPane_TabelleFix);
		
//�bersicht einer Tabelle der fixen Beitr�ge		
		tableFix = new JTable();
		tableFix.setBackground(new Color(27, 109, 220));
		scrollPane_TabelleFix.setViewportView(tableFix);
		tableFix.setForeground(Color.WHITE);
		tableFix.setFont(new Font("Tahoma", Font.BOLD, 11));		
		
//Bearbeiten		
		JLabel btnBearbeiten = new JLabel("New label");
		btnBearbeiten.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TransaktionBearbeiten frame = new TransaktionBearbeiten(Wiederholung.id);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnBearbeiten.setIcon(new ImageIcon(Wiederholung.class.getResource("/Design/Bearbeiten.png")));
		btnBearbeiten.setBounds(585, 570, 144, 38);
		contentPane.add(btnBearbeiten);
		
//Hintergrund		
		JLabel Hintergrund = new JLabel();
		Hintergrund.setIcon(new ImageIcon(Wiederholung.class.getResource("/Design/GUI6.png")));
		Hintergrund.setBounds(-5, -50, 985, 807);
		contentPane.add(Hintergrund);
		


//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);
	
	try {
		String sqlQuery = "SELECT Datum,Bezeichnung,Kategorie,Betrag FROM BenutzerAufwendungen  WHERE (BenutzerID='"
				+ this.id + "' and Art='fix') ";
		PreparedStatement stm = connection.prepareStatement(sqlQuery);
		ResultSet result = stm.executeQuery();
		tableFix.setModel(DbUtils.resultSetToTableModel(result));
		result.close();
		stm.close();
	} catch (Exception exc) {
		exc.printStackTrace();
	}
}
}
