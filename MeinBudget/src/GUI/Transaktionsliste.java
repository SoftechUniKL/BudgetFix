package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JTextField;

public class Transaktionsliste extends JFrame {

	private JPanel contentPane;
	private JTextField txtDatum;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaktionsliste frame = new Transaktionsliste();
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
	public Transaktionsliste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		frame.add(datePicker);
		*/
	
		
		
		
//Schliessen Button		
		JLabel btnSchliessen = new JLabel();
		btnSchliessen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/schliessen_button2.png")));
			}
					
			//Schliessenbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Schliessen_Button.png")));
			}
					
			//Schliesst das Fenster
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnSchliessen.setIcon(new ImageIcon(Transaktionsliste.class.getResource("/Design/Schliessen_Button.png")));
		btnSchliessen.setBounds(440, 15, 25, 25);
		contentPane.add(btnSchliessen);

//Überschrift "Transaktionsliste"			
		JLabel lblKategorienAnlegen = new JLabel("<html><u>Transaktionsliste</u></html>");
		lblKategorienAnlegen.setForeground(Color.WHITE);
		lblKategorienAnlegen.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKategorienAnlegen.setHorizontalAlignment(SwingConstants.CENTER);
		lblKategorienAnlegen.setBounds(10, 15, 460, 38);
		contentPane.add(lblKategorienAnlegen);
		btnSchliessen.setIcon(new ImageIcon(KategorieAnlegen.class.getResource("/Design/Schliessen_Button.png")));
		btnSchliessen.setBounds(440, 15, 25, 25);
		contentPane.add(btnSchliessen);
		
		txtDatum = new JTextField();
		txtDatum.setHorizontalAlignment(SwingConstants.CENTER);
		txtDatum.setForeground(Color.GRAY);
		txtDatum.setColumns(10);
		txtDatum.setBorder(null);
		txtDatum.setBackground(Color.WHITE);
		txtDatum.setBounds(151, 78, 144, 30);
		contentPane.add(txtDatum);
		
		JLabel lblDatum = new JLabel();
		lblDatum.setIcon(new ImageIcon(Transaktionsliste.class.getResource("/Design/Textfeldgross.png")));
		lblDatum.setBounds(150, 78, 145, 30);
		contentPane.add(lblDatum);
		
		JLabel btnDatum = new JLabel("New label");
		btnDatum.setIcon(new ImageIcon(Transaktionsliste.class.getResource("/Design/Kalender.png")));
		btnDatum.setBounds(305, 78, 30, 30);
		contentPane.add(btnDatum);
		
//Hintergrund		
		JLabel Hintergrund = new JLabel();
		Hintergrund.setIcon(new ImageIcon(KategorieAnlegen.class.getResource("/Design/GUI3.png")));
		Hintergrund.setBounds(0, 0, 480, 480);
		contentPane.add(Hintergrund);
						
//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
