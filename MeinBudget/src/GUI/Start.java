package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JMenuBar;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

public class Start extends JFrame {
	
	Connection connection = null;
	Connection connec = null;
	
	private JPanel contentPane;
	private JTable tableEinnahmen;
	private JTextField txtAusgaben;
	private JTextField txtEinnahmen;
	private JTextField txtGesamtbilanz;
	private JTable tableAusgaben;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
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
	public Start() {
		
		connection = BPDatenbank.dbCon();
		connec = BPDatenbank.dbCon();
		
		//Erträgetabelle();
	//	Aufwendungstabelle();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1378, 745);
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
				btnSchliessen.setIcon(new ImageIcon(Start.class.getResource("/Design/schliessengross.png")));
				btnSchliessen.setBounds(1305, 21, 40, 40);
				contentPane.add(btnSchliessen);
		
//Button Menue		
				JLabel btnMenue = new JLabel();
				btnMenue.setIcon(new ImageIcon(Start.class.getResource("/Design/Men\u00FC.png")));
				btnMenue.setBounds(50, 30, 66, 75);
				contentPane.add(btnMenue);
				
//lblMenue		
				JLabel Menue = new JLabel("Men\u00FC");
				Menue.setFont(new Font("Tahoma", Font.BOLD, 34));
				Menue.setForeground(Color.WHITE);
				Menue.setBounds(130, 50, 150, 34);
				contentPane.add(Menue);
				
//Tabelle für Gesamtübersicht		
				JTable tableGesamt = new JTable();			
				tableGesamt.setBounds(50, 116, 200, 200);
				contentPane.add(tableGesamt);
				
//btnStart		
				JLabel btnStart = new JLabel();
				btnStart.setIcon(new ImageIcon(Start.class.getResource("/Design/StartBlau.png")));
				btnStart.setBounds(50, 340, 50, 50);
				contentPane.add(btnStart);
				
//lblStart
				JLabel lblStart = new JLabel("Start");
				lblStart.setFont(new Font("Tahoma", Font.BOLD, 22));
				lblStart.setForeground(Color.BLUE);
				lblStart.setBounds(110, 352, 80, 25);
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
				btnWiederholung.setIcon(new ImageIcon(Start.class.getResource("/Design/wiederholung.png")));
				btnWiederholung.setBounds(50, 410, 50, 50);
				contentPane.add(btnWiederholung);
				
//lblWiederholung für fixe Beträge		
				JLabel lblWiederholung = new JLabel("Wiederholung");
				lblWiederholung.setForeground(Color.WHITE);
				lblWiederholung.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblWiederholung.setBounds(110, 422, 174, 25);
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
				btnCharts.setIcon(new ImageIcon(Start.class.getResource("/Design/Charts.png")));
				btnCharts.setBounds(50, 480, 50, 50);
				contentPane.add(btnCharts);
				
//lblCharts		
				JLabel lblCharts = new JLabel("Charts");
				lblCharts.setForeground(Color.WHITE);
				lblCharts.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblCharts.setBounds(110, 492, 174, 25);
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
				btnSparziele.setIcon(new ImageIcon(Start.class.getResource("/Design/Sparziele.png")));
				btnSparziele.setBounds(50, 550, 50, 50);
				contentPane.add(btnSparziele);
				
//lblSparziele		
				JLabel lblSparziele = new JLabel("Sparziele");
				lblSparziele.setForeground(Color.WHITE);
				lblSparziele.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblSparziele.setBounds(110, 562, 174, 25);
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
				btnTools.setIcon(new ImageIcon(Start.class.getResource("/Design/Tools.png")));
				btnTools.setBounds(50, 620, 50, 50);
				contentPane.add(btnTools);
				
//lblTools		
				JLabel lblTools = new JLabel("Tools");
				lblTools.setForeground(Color.WHITE);
				lblTools.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTools.setBounds(110, 631, 174, 25);
				contentPane.add(lblTools);
				
//Button Einstellungen		
				JLabel btnEinstellungen = new JLabel();
				btnEinstellungen.addMouseListener(new MouseAdapter() {
					@Override
					//Einstellungen öffnet sich	Bild			
					public void mouseClicked(MouseEvent e) {
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
					//Einstellungen-Icon wird blau bei drübergehen der Maus			
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
				btnEinstellungen.setIcon(new ImageIcon(Start.class.getResource("/Design/Einstellungen.png")));
				btnEinstellungen.setBounds(50, 690, 50, 50);
				contentPane.add(btnEinstellungen);
				
//lblEinstellungen		
				JLabel lblEinstellungen = new JLabel("Einstellungen");
				lblEinstellungen.addMouseListener(new MouseAdapter() {
					@Override
					//Einstellungen öffnen					
					public void mouseClicked(MouseEvent e) {
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
				});
				lblEinstellungen.setIcon(null);
				lblEinstellungen.setForeground(Color.WHITE);
				lblEinstellungen.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblEinstellungen.setBounds(110, 700, 174, 25);
				contentPane.add(lblEinstellungen);
				
//Haupt"klasse"-Start		
				JLabel lblHauptStart = new JLabel("<html><u>START</u><HTML>");
				lblHauptStart.setForeground(Color.WHITE);
				lblHauptStart.setFont(new Font("Tahoma", Font.BOLD, 34));
				lblHauptStart.setBounds(510, 50, 150, 34);
				contentPane.add(lblHauptStart);
				
//Haupt"klasse" Button Start		
				JLabel btnHauptStart = new JLabel();
				btnHauptStart.setIcon(new ImageIcon(Start.class.getResource("/Design/Startgross.png")));
				btnHauptStart.setBounds(430, 30, 66, 75);
				contentPane.add(btnHauptStart);
				
//Neue Kategorie Text				
				JLabel txtNeueKategorie = new JLabel("Neue Kategorie");
				txtNeueKategorie.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtNeueKategorie.setBounds(490, 150, 117, 34);
				contentPane.add(txtNeueKategorie);
				
//Button um "Neue Kategorie"-Fenster zu öffnen				
				JLabel btnNeueKategorie = new JLabel();
				btnNeueKategorie.addMouseListener(new MouseAdapter() {
					@Override
					//Plusbutton wird grau bei drübergehen der Maus
					public void mouseEntered(MouseEvent arg0) {
						btnNeueKategorie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Plus2.png")));
					}
					
					//Plusbutton ist blau
					@Override
					public void mouseExited(MouseEvent arg0) {
						btnNeueKategorie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Plus.png")));
					}
					//Öffnet Fenster Anlegen
					@Override
					public void mouseClicked(MouseEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									KategorieAnlegen frame = new KategorieAnlegen();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				});
				btnNeueKategorie.setIcon(new ImageIcon(Start.class.getResource("/Design/Plus.png")));
				btnNeueKategorie.setBounds(460, 155, 25, 25);
				contentPane.add(btnNeueKategorie);
				
//Neue Kategorie Label				
				JLabel lblNeueKategorie = new JLabel();
				lblNeueKategorie.setIcon(new ImageIcon(Start.class.getResource("/Design/Textfeldgross2.png")));
				lblNeueKategorie.setBounds(440, 150, 160, 34);
				contentPane.add(lblNeueKategorie);
				
//Transaktionsliste				
				JLabel txtTransaktionsliste = new JLabel("Transaktionsliste");
				txtTransaktionsliste.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtTransaktionsliste.setBounds(675, 150, 117, 34);
				contentPane.add(txtTransaktionsliste);
				
//btnTransaktionsliste				
				JLabel btnTransaktionsliste = new JLabel();
				btnTransaktionsliste.addMouseListener(new MouseAdapter() {
					@Override
					//Plusbutton wird grau bei drübergehen der Maus
					public void mouseEntered(MouseEvent arg0) {
						btnTransaktionsliste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Plus2.png")));
					}
					
					//Plusbutton ist blau
					@Override
					public void mouseExited(MouseEvent arg0) {
						btnTransaktionsliste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Plus.png")));
					}
				});
				btnTransaktionsliste.setIcon(new ImageIcon(Start.class.getResource("/Design/Plus.png")));
				btnTransaktionsliste.setBounds(645, 155, 25, 25);
				contentPane.add(btnTransaktionsliste);
				
//lblTransaktionsliste				
				JLabel lblTransaktionsliste = new JLabel();
				lblTransaktionsliste.setIcon(new ImageIcon(Start.class.getResource("/Design/Textfeldgross2.png")));
				lblTransaktionsliste.setBounds(630, 150, 160, 34);
				contentPane.add(lblTransaktionsliste);
				
//Gesamtbilanz				
				JLabel Gesamtbilanz = new JLabel("Gesamtbilanz:");
				Gesamtbilanz.setForeground(Color.WHITE);
				Gesamtbilanz.setFont(new Font("Tahoma", Font.BOLD, 14));
				Gesamtbilanz.setBounds(900, 150, 117, 34);
				contentPane.add(Gesamtbilanz);
				
//Gesamtbilanz Textfeld --> Einnahmen - Ausgaben = Gesamtbilanz des Monats				
				txtGesamtbilanz = new JTextField();
				txtGesamtbilanz.setBorder(null);
				txtGesamtbilanz.setColumns(10);
				txtGesamtbilanz.setBounds(1000, 152, 247, 30);
				contentPane.add(txtGesamtbilanz);
				
//lblGesamtbilanz				
				JLabel lblGesamtbilanz = new JLabel();
				lblGesamtbilanz.setIcon(new ImageIcon(Start.class.getResource("/Design/Textfeldgross3.png")));
				lblGesamtbilanz.setBounds(997, 150, 253, 34);
				contentPane.add(lblGesamtbilanz);
				
//Ausgaben				
				JLabel Ausgaben = new JLabel("Ausgaben:");
				Ausgaben.setForeground(Color.WHITE);
				Ausgaben.setFont(new Font("Tahoma", Font.BOLD, 14));
				Ausgaben.setBounds(440, 230, 117, 34);
				contentPane.add(Ausgaben);
				
//Ausgaben Textefeld zur Eingabe der Ausgaben				
				txtAusgaben = new JTextField();
				txtAusgaben.setBorder(null);
				txtAusgaben.setHorizontalAlignment(SwingConstants.CENTER);
				txtAusgaben.setForeground(Color.GRAY);
				txtAusgaben.setBounds(528, 232, 262, 30);
				contentPane.add(txtAusgaben);
				txtAusgaben.setColumns(10);
				
//lblAusgaben				
				JLabel lblAusgaben = new JLabel();
				lblAusgaben.setIcon(new ImageIcon(Start.class.getResource("/Design/Textfeldgross3.png")));
				lblAusgaben.setBounds(528, 230, 262, 34);
				contentPane.add(lblAusgaben);
								
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(440, 310, 352, 346);
				contentPane.add(scrollPane);
				
//Tabelle Ausgaben Übersicht				
				tableAusgaben = new JTable();
				scrollPane.setViewportView(tableAusgaben);
				
//Einnahmen				
				JLabel Einnahmen = new JLabel("Einnahmen:");
				Einnahmen.setForeground(Color.WHITE);
				Einnahmen.setFont(new Font("Tahoma", Font.BOLD, 14));
				Einnahmen.setBounds(900, 230, 87, 34);
				contentPane.add(Einnahmen);

//Einnahmen als Eingabe				
				txtEinnahmen = new JTextField();
				txtEinnahmen.setBorder(null);
				txtEinnahmen.setColumns(10);
				txtEinnahmen.setBounds(1000, 232, 247, 30);
				contentPane.add(txtEinnahmen);
				
//lblEinnahmen			
				JLabel lblEinnahmen = new JLabel();
				lblEinnahmen.setIcon(new ImageIcon(Start.class.getResource("/Design/Textfeldgross3.png")));
				lblEinnahmen.setBounds(997, 230, 253, 34);
				contentPane.add(lblEinnahmen);
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(900, 310, 352, 346);
				contentPane.add(scrollPane_1);
				
//Einnahmen Tabellenübersicht				
				tableEinnahmen = new JTable();
				scrollPane_1.setViewportView(tableEinnahmen);
				
				
//Hintergrund		
				JLabel Hintergrund = new JLabel();
				Hintergrund.setIcon(new ImageIcon(Start.class.getResource("/Design/GUI2.png")));
				Hintergrund.setBounds(-10, -23, 1378, 815);
				contentPane.add(Hintergrund);

				
				
//Fullscreen Bildschirm
				setExtendedState(Frame.MAXIMIZED_BOTH);
//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
				setUndecorated(true);
				setLocationRelativeTo(null);		

//	}

//Verbindung zur BPDatenbank - Erträge
	
//*	//private void Erträgetabelle(){
		try{
			String sqlQuery = "SELECT Datum,Bezeichnung,Kategorie,Art,Betrag FROM BenutzerErträge  WHERE (BenutzerID='2') ";
			String sqlQuery2 = "SELECT Datum,Bezeichnung,Kategorie,Art,Betrag FROM BenutzerAufwendungen WHERE (BenutzerID='2')  ";
			PreparedStatement stm = connection.prepareStatement(sqlQuery);
			PreparedStatement pstmt = connec.prepareStatement(sqlQuery2);
			ResultSet result = stm.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			tableEinnahmen.setModel(DbUtils.resultSetToTableModel(result));	
			tableAusgaben.setModel(DbUtils.resultSetToTableModel(rs));
	
	}catch(Exception exc){
		exc.printStackTrace();
}	
}}