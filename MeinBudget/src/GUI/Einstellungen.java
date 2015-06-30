package GUI;

import java.awt.BorderLayout;
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

public class Einstellungen extends JFrame {

	private JPanel contentPane;

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
		btnSchliessen.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/schliessengross.png")));
		btnSchliessen.setBounds(1305, 21, 40, 40);
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
		tableGesamt.setBounds(50, 116, 200, 200);
		contentPane.add(tableGesamt);
		
//btnStart		
		JLabel btnStart = new JLabel();
		btnStart.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/Start.png")));
		btnStart.setBounds(50, 340, 50, 50);
		contentPane.add(btnStart);
		
//lblStart
		JLabel lblStart = new JLabel("Start");
		lblStart.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblStart.setForeground(Color.WHITE);
		lblStart.setBounds(110, 352, 80, 25);
		contentPane.add(lblStart);
		
//Button Wiederholung		
		JLabel btnWiederholung = new JLabel();
		btnWiederholung.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/wiederholung.png")));
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
		btnCharts.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/Charts.png")));
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
		btnSparziele.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/Sparziele.png")));
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
		btnTools.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/Tools.png")));
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
		btnEinstellungen.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/Einstellungen.png")));
		btnEinstellungen.setBounds(50, 690, 50, 50);
		contentPane.add(btnEinstellungen);
		
//lblEinstellungen		
		JLabel lblEinstellungen = new JLabel("Einstellungen");
		lblEinstellungen.setIcon(null);
		lblEinstellungen.setForeground(Color.WHITE);
		lblEinstellungen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEinstellungen.setBounds(110, 700, 174, 25);
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
		
		
//Hintergrund		
		JLabel Hintergrund = new JLabel();
		Hintergrund.setIcon(new ImageIcon(Einstellungen.class.getResource("/Design/GUI2.png")));
		Hintergrund.setBounds(-10, -24, 1378, 815);
		contentPane.add(Hintergrund);


//Fullscreen Bildschirm
		setExtendedState(Frame.MAXIMIZED_BOTH);
//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);		
		
	}

}
