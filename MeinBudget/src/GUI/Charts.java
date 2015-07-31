package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xml.DatasetReader;

import BudgetPlan.Posten;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Charts BudgetFix:
 * 
 * Hier kann man seine Ausgaben und Einnahmen als Grafik ausgeben lassen als:
 * 
 * 		> "Kategorien im Detail": alle Kategorien werden als Kuchendiagramm ausgegeben
 * 		> "Monatsauswertung" : monatliche Ausgaben als Balkendiagramm
 * 		> "Jahresauswertung": j�hrliche Ausgaben als Balkendiagramm
 * 		> "Ausgabenentwicklung": Ausgabenentwicklung �ber die Zeit als Balkendiagramm
 * 		> "Einnahmenentwicklung": Einnahmenentwicklung �ber die Zeit als Balkendiagramm
 * 		> "Liquidit�tsentwicklung": Liquidit�tsentwicklung �ber die Zeit als Balkendiagramm
 * 		> "Ausgabenverteilung" (Kuchendiagramm)
 * 		> "Einnahmeverteilung" (Kuchendiagramm)
 * 
 * 
 * @author Que Ly Dong
 * 
 */


public class Charts extends JFrame {
	Connection connection = null;
	Connection connec = null;
	Connection conn	= null;
	static int id;
	
	private JPanel contentPane;
	private JLabel btnZahlungsmittel;
	private JPanel DiagrammPanel;
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
					Charts frame = new Charts(id);
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
	public Charts(int id) {
		
		this.id = id;
		connection = BPDatenbank.dbCon();
		connec = BPDatenbank.dbCon();
		conn = BPDatenbank.dbCon();
		
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
		btnStart.setIcon(new ImageIcon(Charts.class.getResource("/Design/Start.png")));
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
		btnWiederholung.addMouseListener(new MouseAdapter() {
			@Override
			//Wiederholung �ffnet sich	Bild			
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Wiederholung frame = new Wiederholung(Wiederholung.id);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			//Wiederholung-Icon ist blau bei dr�bergehen der Maus
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
		btnWiederholung.setBounds(60, 315, 50, 50);
		contentPane.add(btnWiederholung);
		
//lblWiederholung f�r fixe Betr�ge		
		JLabel lblWiederholung = new JLabel("Wiederholung");
		lblWiederholung.setForeground(Color.WHITE);
		lblWiederholung.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWiederholung.setBounds(120, 327, 174, 25);
		contentPane.add(lblWiederholung);
		
//Button Charts		
		JLabel btnCharts = new JLabel();
		btnCharts.setIcon(new ImageIcon(Charts.class.getResource("/Design/ChartsBlau.png")));
		btnCharts.setBounds(60, 375, 50, 50);
		contentPane.add(btnCharts);
		
//lblCharts		
		JLabel lblCharts = new JLabel("Charts");
		lblCharts.setForeground(Color.BLUE);
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
		btnSparziele.setIcon(new ImageIcon(Charts.class.getResource("/Design/Sparziele.png")));
		btnSparziele.setBounds(60, 435, 50, 50);
		contentPane.add(btnSparziele);
		
//lblSparziele		
		JLabel lblSparziele = new JLabel("Sparziele");
		lblSparziele.setForeground(Color.WHITE);
		lblSparziele.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSparziele.setBounds(120, 447, 174, 25);
		contentPane.add(lblSparziele);
		
//Button Tools		
		JLabel btnTools = new JLabel();
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
		btnTools.setIcon(new ImageIcon(Charts.class.getResource("/Design/Tools.png")));
		btnTools.setBounds(60, 495, 50, 50);
		contentPane.add(btnTools);
		
//lblTools		
		JLabel lblTools = new JLabel("Tools");
		lblTools.setForeground(Color.WHITE);
		lblTools.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTools.setBounds(120, 507, 174, 25);
		contentPane.add(lblTools);
		
//Button Einstellungen		
		JLabel btnEinstellungen = new JLabel("New label");
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
		btnEinstellungen.setIcon(new ImageIcon(Charts.class.getResource("/Design/Einstellungen.png")));
		btnEinstellungen.setBounds(60, 555, 50, 50);
		contentPane.add(btnEinstellungen);
		
//lblEinstellungen		
		JLabel lblEinstellungen = new JLabel("Einstellungen");
		lblEinstellungen.setIcon(null);
		lblEinstellungen.setForeground(Color.WHITE);
		lblEinstellungen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEinstellungen.setBounds(120, 567, 174, 25);
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
				try {
					Kategorie();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnKategorieImDetail.setIcon(new ImageIcon(Charts.class.getResource("/Design/KategorienImDetail.png")));
		btnKategorieImDetail.setBounds(550, 140, 282, 38);
		contentPane.add(btnKategorieImDetail);
				
		//Button Monatsauswertung		
				JLabel btnMonatsauswertung = new JLabel();
				btnMonatsauswertung.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Monat();
					}
				});
				btnMonatsauswertung.setIcon(new ImageIcon(Charts.class.getResource("/Design/Monatsauswertung.png")));
				btnMonatsauswertung.setBounds(550, 200, 282, 38);
				contentPane.add(btnMonatsauswertung);
				
		//Button Jahresauswertung		
				JLabel btnJahresauswertung = new JLabel();
				btnJahresauswertung.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Jahr();
					}
				});
				btnJahresauswertung.setIcon(new ImageIcon(Charts.class.getResource("/Design/Jahresauswertung.png")));
				btnJahresauswertung.setBounds(550, 260, 282, 38);
				contentPane.add(btnJahresauswertung);
				
		//Button Ausgabeentwicklung		
				JLabel btnAusgabenentwicklung = new JLabel();
				btnAusgabenentwicklung.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Ausgaben();
					}
				});
				btnAusgabenentwicklung.setIcon(new ImageIcon(Charts.class.getResource("/Design/Ausgabenentwicklung.png")));
				btnAusgabenentwicklung.setBounds(550, 320, 282, 38);
				contentPane.add(btnAusgabenentwicklung);
				
		//Button Einnahmenentwicklung		
				JLabel btnEinnahmenentwicklung = new JLabel();
				btnEinnahmenentwicklung.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Einnahmen();
					}
				});
				btnEinnahmenentwicklung.setIcon(new ImageIcon(Charts.class.getResource("/Design/Einnahmenentwicklung.png")));
				btnEinnahmenentwicklung.setBounds(550, 380, 282, 38);
				contentPane.add(btnEinnahmenentwicklung);
				
		//Button Liquidit�tsentwicklung		
				JLabel btnLiquidit�t = new JLabel();
				btnLiquidit�t.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Liquiditaet();
					}
				});
				btnLiquidit�t.setIcon(new ImageIcon(Charts.class.getResource("/Design/Liquidit\u00E4tsentwicklung.png")));
				btnLiquidit�t.setBounds(550, 440, 282, 38);
				contentPane.add(btnLiquidit�t);
				
		//Button Ausgabeverteilung		
				JLabel btnAusgabeverteilung = new JLabel();
				btnAusgabeverteilung.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						AusV();
					}
				});
				btnAusgabeverteilung.setIcon(new ImageIcon(Charts.class.getResource("/Design/Ausgabenverteilung.png")));
				btnAusgabeverteilung.setBounds(550, 500, 282, 38);
				contentPane.add(btnAusgabeverteilung);
				
		//Button Einnahmenverteilung		
				JLabel btnEinnahmenverteilung = new JLabel();
				btnEinnahmenverteilung.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						EinV();
					}
				});
				btnEinnahmenverteilung.setIcon(new ImageIcon(Charts.class.getResource("/Design/Einnahmenverteilung.png")));
				btnEinnahmenverteilung.setBounds(550, 560, 282, 38);
				contentPane.add(btnEinnahmenverteilung);
				
		
		//Hintergrund		
		JLabel Hintergrund = new JLabel();
		Hintergrund.setIcon(new ImageIcon(Charts.class.getResource("/Design/GUI6.png")));
		Hintergrund.setBounds(0, -31, 1381, 767);
		contentPane.add(Hintergrund);

		//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);		
	}

	
///////////////////////
//
// Charts
//

	
//Kategorie
	private void Kategorie() {
		
			DefaultPieDataset PieDataset = new DefaultPieDataset();
			Statement stmt;
			Statement stm;
			//f�lle Daten aus der Tabelle zu JFreeChart
			try {
				stmt = connec.createStatement();
				ResultSet queryKat = stmt.executeQuery("SELECT Kategorie,Sum(Betrag) as AufwendungBetrag FROM BenutzerAufwendungen WHERE (BenutzerID='"+this.id+"') GROUP BY Kategorie");
				stm = connection.createStatement();
				ResultSet queryKat2 = stm.executeQuery("SELECT Kategorie,Sum(Betrag) as Ertr�geBetrag FROM BenutzerErtr�ge WHERE (BenutzerID='"+this.id+"') GROUP BY Kategorie");
				
				
				//Pr�fung
				ResultSetMetaData rsmd = queryKat.getMetaData();
			    System.out.println("querying SELECT * FROM XXX");
			    int columnsNumber = rsmd.getColumnCount();
			 	
				while (queryKat.next()) {
					String Kategorie = queryKat.getString("Kategorie");
					double Betrag = queryKat.getDouble("AufwendungBetrag");
					PieDataset.setValue(Kategorie, Betrag); // Konvertiere Datenquelle von Tabelle zu PieChart Datasource
				}
				
				while (queryKat2.next()) {
					String Kategorie2 = queryKat2.getString("Kategorie");
					double Betrag2 = queryKat2.getDouble("Ertr�geBetrag");
					PieDataset.setValue(Kategorie2, Betrag2);
				}
				
				//Chart
				JFreeChart PieChartKat = ChartFactory.createPieChart("Kategorie im Detail", PieDataset, true, true, true);
				PiePlot p = (PiePlot) PieChartKat.getPlot();
				p.setForegroundAlpha(1.0f);
				p.setCircular(true);
				ChartFrame frame = new ChartFrame("", PieChartKat);
				frame.setVisible(true);
				frame.setSize(450,600);
				queryKat.close();
				queryKat2.close();
				stmt.close();
				stm.close();

				}
				catch (Exception i)
                 {
                         JOptionPane.showMessageDialog(null, i);
                 
                }
			}
        

//Monat Kreisdiagramm
	private void Monat(){
		try{			
			String queryMonat = "SELECT  strftime('%m', Datum) AS PerDate, SUM(Betrag) AS MonthBetrag FROM BenutzerAufwendungen WHERE (BenutzerID='"+this.id+"') GROUP BY strftime('%m', Datum) ";
			PreparedStatement pst = conn.prepareStatement(queryMonat);
			ResultSet res = pst.executeQuery();
			
			//Pr�fung
			ResultSetMetaData rsmd = res.getMetaData();
		    System.out.println("querying SELECT * FROM XXX"); 
		    int columnsNumber = rsmd.getColumnCount();
		    while (res.next()) {
		        for (int i = 1; i <= columnsNumber; i++) {
		            if (i > 1) System.out.print(",  ");
		            String columnValue = res.getString(i);
		            System.out.print(columnValue + " " + rsmd.getColumnName(i));
		        }
		        System.out.println("");
		    }
			
		    
		    //Chart
			JDBCCategoryDataset dataMonat = new JDBCCategoryDataset (connection);
			dataMonat.executeQuery(queryMonat);
			CategoryDataset datasetMonat = dataMonat;
			
			 JFreeChart BarChart = ChartFactory.createBarChart("Monatsauswertung", "monatliche Ausgaben", "Betrag", datasetMonat, PlotOrientation.VERTICAL, false, true, true);
				CategoryPlot plot = BarChart.getCategoryPlot();
				BarRenderer renderer = null;
				renderer = new BarRenderer();
				ChartFrame  frame = new ChartFrame("", BarChart);
				frame.setVisible(true);
				frame.setSize(400,650);
				pst.close();
				res.close();
			
			
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		
		}
	}
	
//Jahr	 Kreisdiagramm
	private void Jahr(){
		try{	
			String queryJahr = "SELECT  strftime('%Y', Datum) AS PerDate, SUM(Betrag) AS YearBetrag FROM BenutzerAufwendungen WHERE (BenutzerID='"+this.id+"') GROUP BY strftime('%Y', Datum) ";
			PreparedStatement pst = conn.prepareStatement(queryJahr);
			ResultSet res = pst.executeQuery();
			
			//Pr�fung
			ResultSetMetaData rsmd = res.getMetaData();
		    System.out.println("queryJahr SELECT Datum,Betrag FROM BenutzerAufwendungen");
		   
		    int columnsNumber = rsmd.getColumnCount();
		    while (res.next()) {
		        for (int i = 1; i <= columnsNumber; i++) {
		            if (i > 1) System.out.print(",  ");
		            String columnValue = res.getString(i);
		            System.out.print(columnValue + " " + rsmd.getColumnName(i));
		        }
		        System.out.println("");
		    }
			
			JDBCCategoryDataset dataJahr = new JDBCCategoryDataset (connection);
			dataJahr.executeQuery(queryJahr);
			CategoryDataset datasetJahr = dataJahr;
			
			 JFreeChart BarChart = ChartFactory.createBarChart("Jahresauswertung", "j�hrliche Ausgaben", "Betrag", datasetJahr, PlotOrientation.VERTICAL, false, true, true);
				CategoryPlot plot = BarChart.getCategoryPlot();
				BarRenderer renderer = null;
				renderer = new BarRenderer();
				ChartFrame  frame = new ChartFrame("", BarChart);
				frame.setVisible(true);
				frame.setSize(400,650);
				pst.close();
				res.close();
			
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		
		}
	}
		
	
	
//Einnahmenentwicklung Balkendiagramm
	private void Einnahmen(){
		try{		
			String queryEin = "SELECT Datum,Sum(Betrag) FROM BenutzerErtr�ge WHERE (BenutzerID='"+this.id+"') GROUP BY Datum";
			PreparedStatement pst = conn.prepareStatement(queryEin);
			ResultSet res = pst.executeQuery();
			
			//Pr�fung
			ResultSetMetaData rsmd = res.getMetaData();
		    System.out.println("querying SELECT * FROM XXX");
		    int columnsNumber = rsmd.getColumnCount();
		    while (res.next()) {
		        for (int i = 1; i <= columnsNumber; i++) {
		            if (i > 1) System.out.print(",  ");
		            String columnValue = res.getString(i);
		            System.out.print(columnValue + " " + rsmd.getColumnName(i));
		        }
		        System.out.println("");
		    }
			
			JDBCCategoryDataset dataEin = new JDBCCategoryDataset (connection);
			dataEin.executeQuery(queryEin);
			CategoryDataset datasetEin = dataEin;
			
			 JFreeChart BarChart = ChartFactory.createBarChart("Einnahmeentwicklung", "Datum", "Betrag", datasetEin, PlotOrientation.VERTICAL, false, true, true);
				CategoryPlot plot = BarChart.getCategoryPlot();
				BarRenderer renderer = null;
				renderer = new BarRenderer();
				ChartFrame  frame = new ChartFrame("", BarChart);
				frame.setVisible(true);
				frame.setSize(400,650);
				pst.close();
				res.close();
			
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		
		}
	}
	
//Ausgabenentwicklung Balkendiagramm
	private void Ausgaben(){
		try{		
			String queryAus = "SELECT Datum,Betrag FROM BenutzerAufwendungen WHERE (BenutzerID='"+this.id+"') GROUP BY Datum";
			PreparedStatement pst = conn.prepareStatement(queryAus);
			ResultSet res = pst.executeQuery();
			
			//Pr�fung
			ResultSetMetaData rsmd = res.getMetaData();
		    System.out.println("querying SELECT * FROM XXX");
		    int columnsNumber = rsmd.getColumnCount();
		    while (res.next()) {
		        for (int i = 1; i <= columnsNumber; i++) {
		            if (i > 1) System.out.print(",  ");
		            String columnValue = res.getString(i);
		            System.out.print(columnValue + " " + rsmd.getColumnName(i));
		        }
		        System.out.println("");
		    }
			
			JDBCCategoryDataset dataAus = new JDBCCategoryDataset (connection);
			dataAus.executeQuery(queryAus);
			CategoryDataset datasetAus = dataAus;
			
			 JFreeChart BarChart = ChartFactory.createBarChart("Zahlungsmittelauswertung", "Datum", "Betrag", datasetAus, PlotOrientation.VERTICAL, false, true, true);
				CategoryPlot plot = BarChart.getCategoryPlot();
				BarRenderer renderer = null;
				renderer = new BarRenderer();
				ChartFrame  frame = new ChartFrame("", BarChart);
				frame.setVisible(true);
				frame.setSize(400,650);
				pst.close();
				res.close();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		
		}
	}	
	
//Liquidit�tsentwicklung = Ausgaben und Einnahmen im Vergleich
		private void Liquiditaet(){
			try {
				String queryAus	=	"SELECT Datum,Sum(Betrag) as AufwendungBetrag FROM BenutzerAufwendungen WHERE (BenutzerID='"+this.id+"')  GROUP BY Datum"; 
				PreparedStatement stm = connection.prepareStatement(queryAus);
				ResultSet resultAus = stm.executeQuery();
				
				
				String queryEin	=	"SELECT Datum,Sum(Betrag) as ErtragBetrag FROM BenutzerErtr�ge WHERE (BenutzerID='"+this.id+"') GROUP BY Datum"; 
				PreparedStatement pstmt = connec.prepareStatement(queryEin);
				ResultSet resultEin = pstmt.executeQuery();
				

			    System.out.println("querying SELECT * FROM XXX");
			    
			    //Barchart
			    DefaultCategoryDataset  dataset = new DefaultCategoryDataset();
			    
			    //Ausgaben
			    while (resultAus.next()) {
					String Datum = resultAus.getString("Datum");
					double Betrag = resultAus.getDouble("AufwendungBetrag");
					 dataset.addValue(Betrag, "Aufwendung", Datum);
				}
			    
			    //Einnahmen
			    while (resultEin.next()) {
					String Datum = resultEin.getString("Datum");
					double  Betrag = resultEin.getDouble("ErtragBetrag");
					 dataset.addValue(Betrag, "Ertr�ge", Datum);
				}				
			    JFreeChart Chart = ChartFactory.createBarChart("Zahlungsmittelauswertung", "Datum", "Betrag", dataset, PlotOrientation.VERTICAL, false, true, true);
				CategoryPlot plot = Chart.getCategoryPlot();
				BarRenderer renderer = (BarRenderer) plot.getRenderer();
				renderer.setDrawBarOutline(false);		 
				ChartFrame  frame = new ChartFrame("", Chart);
				frame.setVisible(true);
				frame.setSize(400,650);
				stm.close();
				pstmt.close();
				resultAus.close();
				resultEin.close();
		
				
				} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1);
				}
	
	}	

//Ausgabenverteilung in den einzelnen Kategorien, Prozentual
		private void AusV(){
			DefaultPieDataset PieDataset = new DefaultPieDataset();
			Statement stmt;
			//f�lle Daten aus der Tabelle zu JFreeChart
			try {
				stmt = connec.createStatement();
				ResultSet queryAus = stmt.executeQuery("SELECT Kategorie,Sum(Betrag) as AufwendungBetrag FROM BenutzerAufwendungen WHERE (BenutzerID='"+this.id+"') GROUP BY Kategorie");
				
				//Pr�fung
				ResultSetMetaData rsmd = queryAus.getMetaData();
			    System.out.println("querying SELECT * FROM XXX");
			    int columnsNumber = rsmd.getColumnCount();
			 	
				while (queryAus.next()) {
					String Kategorie = queryAus.getString("Kategorie");
					double Betrag = queryAus.getDouble("AufwendungBetrag");
					PieDataset.setValue(Kategorie, Betrag); // Konvertiere Datenquelle von Tabelle zu PieChart Datasource
				}
				
				//Chart
				JFreeChart PieChartKat = ChartFactory.createPieChart("Ausgabenverteilung", PieDataset, true, true, true);
				PiePlot p = (PiePlot) PieChartKat.getPlot();
				p.setForegroundAlpha(1.0f);
				p.setCircular(true);
				ChartFrame frame = new ChartFrame("", PieChartKat);
				frame.setVisible(true);
				frame.setSize(450,600);
				queryAus.close();
				stmt.close();

				}
				catch (Exception i)
                 {
                         JOptionPane.showMessageDialog(null, i);
                 
                }
			
		}

//Einnahmenverteilung in den einzelnen Kategorien, prozentual
		private void EinV(){
			DefaultPieDataset PieDataset = new DefaultPieDataset();
			Statement stmt;
			//f�lle Daten aus der Tabelle zu JFreeChart
			try {
				stmt = connec.createStatement();
				ResultSet queryEin = stmt.executeQuery("SELECT Kategorie,Sum(Betrag) as Ertr�geBetrag FROM BenutzerErtr�ge WHERE (BenutzerID='"+this.id+"') GROUP BY Kategorie");
				
				//Pr�fung
				ResultSetMetaData rsmd = queryEin.getMetaData();
			    System.out.println("querying SELECT * FROM XXX");
			    int columnsNumber = rsmd.getColumnCount();
			 	
				while (queryEin.next()) {
					String Kategorie = queryEin.getString("Kategorie");
					double Betrag = queryEin.getDouble("Ertr�geBetrag");
					//int Betrag = queryKat.getInt("Betrag");
					PieDataset.setValue(Kategorie, Betrag); // Konvertiere Datenquelle von Tabelle zu PieChart Datasource
				}
				
				//Chart
				JFreeChart PieChartKat = ChartFactory.createPieChart("Einnahmenverteilung", PieDataset, true, true, true);
				PiePlot p = (PiePlot) PieChartKat.getPlot();
				p.setForegroundAlpha(1.0f);
				p.setCircular(true);
				ChartFrame frame = new ChartFrame("", PieChartKat);
				frame.setVisible(true);
				frame.setSize(450,600);
				queryEin.close();
				stmt.close();

				}
				catch (Exception i)
                 {
                         JOptionPane.showMessageDialog(null, i);
                 
                }
			}
}
