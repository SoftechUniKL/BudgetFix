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
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import BudgetPlan.Posten;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Charts extends JFrame {
	Connection connection = null;
	Connection connec = null;
	static int id;
	
	private JPanel contentPane;
	private JLabel btnZahlungsmittel;
	private JPanel DiagrammPanel;

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
	 * Create the frame.
	 */
	public Charts(int id) {
		
		this.id = id;
		connection = BPDatenbank.dbCon();
		
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
		
//Tabelle f�r Gesamt�bersicht		
		JTable tableGesamt = new JTable();			
		tableGesamt.setForeground(Color.WHITE);
		tableGesamt.setFont(new Font("Tahoma", Font.BOLD, 11));
		tableGesamt.setBounds(50, 107, 200, 200);
		tableGesamt.setBackground(new Color (27, 109, 220));	
		contentPane.add(tableGesamt);
		
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
			//Wiederholung �ffnet sich	Bild			
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
		btnWiederholung.setBounds(50, 380, 50, 50);
		contentPane.add(btnWiederholung);
		
//lblWiederholung f�r fixe Betr�ge		
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
			//Tools �ffnet sich	Bild			
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
			//Einstellungen �ffnet sich	Bild			
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
				Kategorie();
			}
		});
		btnKategorieImDetail.setIcon(new ImageIcon(Charts.class.getResource("/Design/KategorienImDetail.png")));
		btnKategorieImDetail.setBounds(550, 120, 282, 38);
		contentPane.add(btnKategorieImDetail);
				
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
						Einnahmen();
					}
				});
				btnEinnahmenentwicklung.setIcon(new ImageIcon(Charts.class.getResource("/Design/Einnahmenentwicklung.png")));
				btnEinnahmenentwicklung.setBounds(550, 420, 282, 38);
				contentPane.add(btnEinnahmenentwicklung);
				
		//Button Liquidit�tsentwicklung		
				JLabel btnLiquidit�t = new JLabel();
				btnLiquidit�t.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});
				btnLiquidit�t.setIcon(new ImageIcon(Charts.class.getResource("/Design/Liquidit\u00E4tsentwicklung.png")));
				btnLiquidit�t.setBounds(550, 480, 282, 38);
				contentPane.add(btnLiquidit�t);
				
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
//Kategorie
	private void Kategorie(){
		try{
			String queryKat = "SELECT Kategorie,Betrag FROM BenutzerErtr�ge WHERE (BenutzerID='"+this.id+"')";
			PreparedStatement stm = connection.prepareStatement(queryKat);
			ResultSet result = stm.executeQuery();
			
			JDBCCategoryDataset data = new JDBCCategoryDataset (connection);
			data.executeQuery(queryKat);
			CategoryDataset dataset = data;
			
			JFreeChart PieChart = ChartFactory.createPieChart("Kategorie im Detail",(PieDataset) dataset, false, true, true);
			
			
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
//Einnahmenentwicklung	
		private void Einnahmen(){
		try {
			String queryEin = 	"SELECT BenutzerAufwendungen.Datum,BenutzerAufwendungen.Betrag "
								+ "FROM BenutzerAufwendungen WHERE (BenutzerID='"+this.id+"') "
								+ "UNION SELECT BenutzerErtr�ge.Datum,BenutzerErtr�ge.Betrag "
								+ "FROM BenutzerErtr�ge WHERE (BenutzerID='"+this.id+"')"; 
			PreparedStatement stm = connection.prepareStatement(queryEin);
			ResultSet result = stm.executeQuery();
			
		    //Pr�fung f�r die Konsole
			ResultSetMetaData rsmd = result.getMetaData();
		    System.out.println("querying SELECT * FROM XXX");
		    int columnsNumber = rsmd.getColumnCount();
		    while (result.next()) {
		        for (int i = 1; i <= columnsNumber; i++) {
		            if (i > 1) System.out.print(",  ");
		            String columnValue = result.getString(i);
		            System.out.print(columnValue + " " + rsmd.getColumnName(i));
		        }
		        System.out.println("");
		    }
			
		    //Einnahmen Barchart
		    JDBCCategoryDataset data = new JDBCCategoryDataset (connection);
			data.executeQuery(queryEin);
		    CategoryDataset dataset = data;
		    //Ausgaben Barchart
		    //JDBCCategoryDataset data2 = new JDBCCategoryDataset (connec);
			//data2.executeQuery(query2);
		    //CategoryDataset dataset2 = data2;
		
		   
		    /*
		    //Ausgaben und Einnahmen in ein Barchart
		    final CategoryItemRenderer renderer = new LineAndShapeRenderer();
		    renderer.setItemLabelsVisible(false);
		    
		    final CategoryPlot plot = new CategoryPlot();
	        plot.setDataset(dataset);
	        plot.setRenderer(renderer);
	       
	        plot.setDomainAxis(new CategoryAxis("Datum"));
	        plot.setRangeAxis(new NumberAxis("Betrag"));
	        
	        plot.setOrientation(PlotOrientation.VERTICAL);
	        plot.setRangeGridlinesVisible(true);
	        plot.setDomainGridlinesVisible(true);
	        
	        final CategoryItemRenderer renderer2 = new LineAndShapeRenderer();
	        plot.setDataset(1, dataset2);
	        plot.setRenderer(1, renderer2);
	        
	        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
	        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
	        final JFreeChart Barchart = new JFreeChart(plot);
	        Barchart.setTitle("Zahlungsmittelauswertung");
		    */
		    
		    
			//JDBCCategoryDataset dataset = new JDBCCategoryDataset(BPDatenbank.dbCon(), query);
			JFreeChart BarChart = ChartFactory.createBarChart("Zahlungsmittelauswertung", "Datum", "Betrag", dataset, PlotOrientation.VERTICAL, false, true, true);
			BarRenderer renderer = null;
			renderer = new BarRenderer();
			ChartFrame  frame = new ChartFrame("", BarChart);
			frame.setVisible(true);
			frame.setSize(400,650);

			
			//ChartPanel barPanel = new ChartPanel (BarChart);
			//DiagrammPanel.removeAll();
			//DiagrammPanel.add(barPanel);
			//DiagrammPanel.validate();
			
			
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1);
		}
		
	}
}
