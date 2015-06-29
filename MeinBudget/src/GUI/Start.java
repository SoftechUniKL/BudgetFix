package GUI;
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
import java.awt.Color;


//Graphische Benutzeroberflaeche des BudgetFix
public class Start extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableGesamt;
	
		
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
		btnSchliessen.setBounds(1310, 20, 40, 40);
		contentPane.add(btnSchliessen);
		
		JLabel lblMenue = new JLabel();
		lblMenue.setIcon(new ImageIcon(Start.class.getResource("/Design/Menuebutton.png")));
		lblMenue.setBounds(30, 30, 75, 75);
		contentPane.add(lblMenue);
		
		JLabel lblMen = new JLabel("Men\u00FC");
		lblMen.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblMen.setForeground(Color.WHITE);
		lblMen.setBounds(100, 50, 147, 34);
		contentPane.add(lblMen);
		
		tableGesamt = new JTable();
		tableGesamt.setBounds(40, 120, 200, 200);
		contentPane.add(tableGesamt);
		
		JLabel lblStart = new JLabel("New label");
		lblStart.setIcon(new ImageIcon(Start.class.getResource("/Design/Start.png")));
		lblStart.setBounds(30, 340, 50, 50);
		contentPane.add(lblStart);
		
		JLabel lblStart_1 = new JLabel("Start");
		lblStart_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStart_1.setForeground(Color.WHITE);
		lblStart_1.setBounds(85, 355, 80, 25);
		contentPane.add(lblStart_1);
		
		
//Hintergrund		
		JLabel Hintergrund = new JLabel();
		Hintergrund.setIcon(new ImageIcon(Start.class.getResource("/Design/GUI.png")));
		Hintergrund.setBounds(0, 0, 1365, 767);
		contentPane.add (Hintergrund);
		
//Hintergrundrame Design und lege die Lage in Mitten des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
