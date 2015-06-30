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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
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
				
				btnSchliessen.setIcon(new ImageIcon(Charts.class.getResource("/Design/schliessengross.png")));
				btnSchliessen.setBounds(1310, 20, 40, 40);
				contentPane.add(btnSchliessen);
				
				//Button Menue		
				JLabel btnMenue = new JLabel();
				btnMenue.setIcon(new ImageIcon(Charts.class.getResource("/Design/Menuebutton.png")));
				btnMenue.setBounds(30, 30, 63, 75);
				contentPane.add(btnMenue);
				
		//lblMenue		
				JLabel txtMenue = new JLabel("Men\u00FC");
				txtMenue.setFont(new Font("Tahoma", Font.BOLD, 34));
				txtMenue.setForeground(Color.WHITE);
				txtMenue.setBounds(100, 50, 150, 34);
				contentPane.add(txtMenue);
				
		//Tabelle für Gesamtübersicht		
				JTable tableGesamt = new JTable();			
				tableGesamt.setBounds(40, 120, 200, 200);
				contentPane.add(tableGesamt);
				
		//btnStart		
				JLabel btnStart = new JLabel();
				btnStart.setIcon(new ImageIcon(Charts.class.getResource("/Design/Start.png")));
				btnStart.setBounds(30, 340, 50, 50);
				contentPane.add(btnStart);
				
		//lblStart
				JLabel lblStart = new JLabel("Start");
				lblStart.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblStart.setForeground(Color.WHITE);
				lblStart.setBounds(85, 355, 80, 25);
				contentPane.add(lblStart);
				
		//Button Wiederholung		
				JLabel btnWiederholung = new JLabel();
				btnWiederholung.setIcon(new ImageIcon(Charts.class.getResource("/Design/wiederholung.png")));
				btnWiederholung.setBounds(30, 400, 50, 50);
				contentPane.add(btnWiederholung);
				
		//lblWiederholung für fixe Beträge		
				JLabel lblWiederholung = new JLabel("Wiederholung");
				lblWiederholung.setForeground(Color.WHITE);
				lblWiederholung.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblWiederholung.setBounds(85, 409, 174, 25);
				contentPane.add(lblWiederholung);
				
		//Button Charts		
				JLabel btnCharts = new JLabel();
				btnCharts.setIcon(new ImageIcon(Charts.class.getResource("/Design/Charts.png")));
				btnCharts.setBounds(30, 460, 50, 50);
				contentPane.add(btnCharts);
				
		//lblCharts		
				JLabel lblCharts = new JLabel("Charts");
				lblCharts.setForeground(Color.WHITE);
				lblCharts.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblCharts.setBounds(85, 469, 174, 25);
				contentPane.add(lblCharts);
				
		//Button Sparziele		
				JLabel btnSparziele = new JLabel();
				btnSparziele.setIcon(new ImageIcon(Charts.class.getResource("/Design/Sparziele.png")));
				btnSparziele.setBounds(30, 520, 50, 50);
				contentPane.add(btnSparziele);
				
		//lblSparziele		
				JLabel lblSparziele = new JLabel("Sparziele");
				lblSparziele.setForeground(Color.WHITE);
				lblSparziele.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblSparziele.setBounds(85, 530, 174, 25);
				contentPane.add(lblSparziele);
				
		//Button Tools		
				JLabel btnTools = new JLabel("New label");
				btnTools.setIcon(new ImageIcon(Charts.class.getResource("/Design/Tools.png")));
				btnTools.setBounds(30, 580, 50, 50);
				contentPane.add(btnTools);
				
		//lblTools		
				JLabel lblTools = new JLabel("Tools");
				lblTools.setForeground(Color.WHITE);
				lblTools.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblTools.setBounds(85, 589, 174, 25);
				contentPane.add(lblTools);
				
		//Button Einstellungen		
				JLabel btnEinstellungen = new JLabel("New label");
				btnEinstellungen.setIcon(new ImageIcon(Charts.class.getResource("/Design/Einstellungen.png")));
				btnEinstellungen.setBounds(30, 640, 50, 50);
				contentPane.add(btnEinstellungen);
				
		//lblEinstellungen		
				JLabel lblEinstellungen = new JLabel("Einstellungen");
				lblEinstellungen.setForeground(Color.WHITE);
				lblEinstellungen.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblEinstellungen.setBounds(85, 649, 174, 25);
				contentPane.add(lblEinstellungen);
				
		//Haupt"klasse"-Charts		
				JLabel lblHauptStart = new JLabel("CHARTS");
				lblHauptStart.setForeground(Color.WHITE);
				lblHauptStart.setFont(new Font("Tahoma", Font.BOLD, 34));
				lblHauptStart.setBounds(380, 50, 150, 34);
				contentPane.add(lblHauptStart);
				
		//Hintergrund		
				JLabel Hintergrund = new JLabel();
				Hintergrund.setIcon(new ImageIcon(Charts.class.getResource("/Design/GUI.png")));
				Hintergrund.setBounds(0, 0, 1365, 767);
				contentPane.add(Hintergrund);
				
				
		//Fullscreen Bildschirm
				setExtendedState(Frame.MAXIMIZED_BOTH);
		//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
				setUndecorated(true);
				setLocationRelativeTo(null);		
		
	}

}
