package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class Charts extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public Charts() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 707);
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
		btnSchliessen.setIcon(new ImageIcon(Charts.class.getResource("/Design/schliessengross.png")));
		btnSchliessen.setBounds(930, 15, 40, 40);
		contentPane.add(btnSchliessen);

//Button Menue		
		JLabel btnMenue = new JLabel();
		btnMenue.setIcon(new ImageIcon(Charts.class.getResource("/Design/Men\u00FC.png")));
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
		btnStart.setIcon(new ImageIcon(Charts.class.getResource("/Design/Start.png")));
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
		btnWiederholung.setIcon(new ImageIcon(Charts.class.getResource("/Design/wiederholung.png")));
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
		btnCharts.setIcon(new ImageIcon(Charts.class.getResource("/Design/ChartsBlau.png")));
		btnCharts.setBounds(50, 440, 50, 50);
		contentPane.add(btnCharts);
		
//lblCharts		
		JLabel lblCharts = new JLabel("Charts");
		lblCharts.setForeground(Color.BLUE);
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
		btnSparziele.setIcon(new ImageIcon(Charts.class.getResource("/Design/Sparziele.png")));
		btnSparziele.setBounds(50, 500, 50, 50);
		contentPane.add(btnSparziele);
		
//lblSparziele		
		JLabel lblSparziele = new JLabel("Sparziele");
		lblSparziele.setForeground(Color.WHITE);
		lblSparziele.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSparziele.setBounds(110, 512, 174, 25);
		contentPane.add(lblSparziele);
		
//Button Tools		
		JLabel btnTools = new JLabel();
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
		btnTools.setIcon(new ImageIcon(Charts.class.getResource("/Design/Tools.png")));
		btnTools.setBounds(50, 560, 50, 50);
		contentPane.add(btnTools);
		
//lblTools		
		JLabel lblTools = new JLabel("Tools");
		lblTools.setForeground(Color.WHITE);
		lblTools.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTools.setBounds(110, 572, 174, 25);
		contentPane.add(lblTools);
		
//Button Einstellungen		
		JLabel btnEinstellungen = new JLabel("New label");
		btnEinstellungen.addMouseListener(new MouseAdapter() {
			@Override
			//Einstellungen öffnet sich	Bild			
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Einstellungen frame = new Einstellungen();
							frame.setVisible(true);
							dispose();
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
		btnEinstellungen.setIcon(new ImageIcon(Charts.class.getResource("/Design/Einstellungen.png")));
		btnEinstellungen.setBounds(50, 620, 50, 50);
		contentPane.add(btnEinstellungen);
		
//lblEinstellungen		
		JLabel lblEinstellungen = new JLabel("Einstellungen");
		lblEinstellungen.setIcon(null);
		lblEinstellungen.setForeground(Color.WHITE);
		lblEinstellungen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEinstellungen.setBounds(110, 632, 174, 25);
		contentPane.add(lblEinstellungen);
		
//Haupt"klasse"- Charts
		JLabel lblHauptCharts = new JLabel("<html><u>CHARTS</u><HTML>");
		lblHauptCharts.setForeground(Color.WHITE);
		lblHauptCharts.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblHauptCharts.setBounds(510, 50, 150, 34);
		contentPane.add(lblHauptCharts);
		
//Haupt"klasse" Button Charts		
		JLabel btnHauptCharts = new JLabel();
		btnHauptCharts.setIcon(new ImageIcon(Charts.class.getResource("/Design/ChartsGross.png")));
		btnHauptCharts.setBounds(430, 30, 66, 75);
		contentPane.add(btnHauptCharts);
		
//Button Kategorie im Detail		
		JLabel btnKategorieImDetail = new JLabel();
		btnKategorieImDetail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnKategorieImDetail.setIcon(new ImageIcon(Charts.class.getResource("/Design/KategorienImDetail.png")));
		btnKategorieImDetail.setBounds(550, 120, 282, 38);
		contentPane.add(btnKategorieImDetail);
		
//Button Zahlungsmittelauswertung		
		JLabel btnZahlungsmittel = new JLabel();
		btnZahlungsmittel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String query = "select Datum,Betrag from Benutzererträge";
					JDBCCategoryDataset dataset = new JDBCCategoryDataset(BPDatenbank.dbCon(), query);
					JFreeChart chart=ChartFactory.createLineChart("Zahlungsmittelauswertung", "Datum", "Einnahmen", dataset, PlotOrientation.VERTICAL, false, true, true);
					BarRenderer renderer = null;
					CategoryPlot plot = null;
					renderer=new BarRenderer();
					ChartFrame  frame=new ChartFrame("Zahlungsmittelauswertung", chart);
					frame.setVisible(true);
					frame.setSize(400,650);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnZahlungsmittel.setIcon(new ImageIcon(Charts.class.getResource("/Design/Zahlungsmittelauswertung.png")));
		btnZahlungsmittel.setBounds(550, 180, 282, 38);
		contentPane.add(btnZahlungsmittel);
		
//Button Monatsauswertung		
		JLabel btnMonatsauswertung = new JLabel();
		btnMonatsauswertung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnMonatsauswertung.setIcon(new ImageIcon(Charts.class.getResource("/Design/Monatsauswertung.png")));
		btnMonatsauswertung.setBounds(550, 240, 282, 38);
		contentPane.add(btnMonatsauswertung);
		
//Button Jahresauswertung		
		JLabel btnJahresauswertung = new JLabel();
		btnJahresauswertung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnJahresauswertung.setIcon(new ImageIcon(Charts.class.getResource("/Design/Jahresauswertung.png")));
		btnJahresauswertung.setBounds(550, 300, 282, 38);
		contentPane.add(btnJahresauswertung);
		
//Button Ausgabeentwicklung		
		JLabel btnAusgabenentwicklung = new JLabel();
		btnAusgabenentwicklung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnAusgabenentwicklung.setIcon(new ImageIcon(Charts.class.getResource("/Design/Ausgabenentwicklung.png")));
		btnAusgabenentwicklung.setBounds(550, 360, 282, 38);
		contentPane.add(btnAusgabenentwicklung);
		
//Button Einnahmenentwicklung		
		JLabel btnEinnahmenentwicklung = new JLabel();
		btnEinnahmenentwicklung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnEinnahmenentwicklung.setIcon(new ImageIcon(Charts.class.getResource("/Design/Einnahmenentwicklung.png")));
		btnEinnahmenentwicklung.setBounds(550, 420, 282, 38);
		contentPane.add(btnEinnahmenentwicklung);
		
//Button Liquiditätsentwicklung		
		JLabel btnLiquidität = new JLabel();
		btnLiquidität.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnLiquidität.setIcon(new ImageIcon(Charts.class.getResource("/Design/Liquidit\u00E4tsentwicklung.png")));
		btnLiquidität.setBounds(550, 480, 282, 38);
		contentPane.add(btnLiquidität);
		
//Button Ausgabeverteilung		
		JLabel btnAusgabeverteilung = new JLabel();
		btnAusgabeverteilung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnAusgabeverteilung.setIcon(new ImageIcon(Charts.class.getResource("/Design/Ausgabenverteilung.png")));
		btnAusgabeverteilung.setBounds(550, 540, 282, 38);
		contentPane.add(btnAusgabeverteilung);
		
//Button Einnahmenverteilung		
		JLabel btnEinnahmenverteilung = new JLabel();
		btnEinnahmenverteilung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnEinnahmenverteilung.setIcon(new ImageIcon(Charts.class.getResource("/Design/Einnahmenverteilung.png")));
		btnEinnahmenverteilung.setBounds(550, 600, 282, 38);
		contentPane.add(btnEinnahmenverteilung);
		
//Hintergrund		
		JLabel Hintergrund = new JLabel();
		Hintergrund.setIcon(new ImageIcon(Charts.class.getResource("/Design/GUI4.png")));
		Hintergrund.setBounds(0, -31, 1381, 767);
		contentPane.add(Hintergrund);

//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);		
		
	}

}
