package Registrierung;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterFenster extends JFrame {
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFenster frame = new RegisterFenster();
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
	public RegisterFenster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//Button Fenster-Schliessen		
		final JLabel btnSchliessen = new JLabel();
		btnSchliessen.addMouseListener(new MouseAdapter() {
			//Schliessenbutton ist grau
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Registrierung/schliessen_button2.png")));
			}
			
			//Schliessenbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Registrierung/Schliessen_Button.png")));
			}
			
			//Schliesst das Fenster
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			
		});
		btnSchliessen.setIcon(new ImageIcon(RegisterFenster.class.getResource("/Registrierung/Schliessen_Button.png")));
		btnSchliessen.setBounds(265, 10, 25, 25);
		contentPane.add(btnSchliessen);
		
//Textfeld Benutzername		
		JLabel BenutzerLabel = new JLabel();
		BenutzerLabel.setIcon(new ImageIcon(RegisterFenster.class.getResource("/Registrierung/txtfeld.png")));
		BenutzerLabel.setBounds(78, 120, 145, 30);
		contentPane.add(BenutzerLabel);
		
//Textfeld Passwort		
		JLabel PasswortLabel = new JLabel();
		PasswortLabel.setIcon(new ImageIcon(RegisterFenster.class.getResource("/Registrierung/txtfeld.png")));
		PasswortLabel.setBounds(78, 160, 145, 30);
		contentPane.add(PasswortLabel);
		
//Textfeld Passwort wiederholen		
		JLabel PasswortWdhLabel = new JLabel();
		PasswortWdhLabel.setIcon(new ImageIcon(RegisterFenster.class.getResource("/Registrierung/txtfeld.png")));
		PasswortWdhLabel.setBounds(78, 200, 145, 30);
		contentPane.add(PasswortWdhLabel);
		
//Button Registrieren		
		JLabel Registrieren = new JLabel();
		Registrieren.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Bei Mausklick auf Registrieren speichert er Daten in SQL ein
			}
		});
		Registrieren.setIcon(new ImageIcon(RegisterFenster.class.getResource("/Registrierung/Registrieren.png")));
		Registrieren.setBounds(78, 240, 146, 38);
		contentPane.add(Registrieren);
		
//Hintergrund		
		JLabel Hintergrund = new JLabel("New label");
		Hintergrund.setIcon(new ImageIcon(RegisterFenster.class.getResource("/Registrierung/register.png")));
		Hintergrund.setBounds(0, 0, 300, 300);
		contentPane.add(Hintergrund);
		
//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
				setUndecorated(true);
				setLocationRelativeTo(null);
	}
}
