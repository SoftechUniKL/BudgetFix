package Anmelden;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnmeldenFenster extends JFrame {
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnmeldenFenster frame = new AnmeldenFenster();
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
	public AnmeldenFenster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//Button Schliessen		
		final JLabel btnSchliessen = new JLabel();
		btnSchliessen.addMouseListener(new MouseAdapter() {
			//Schliessenbutton ist grau
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anmelden/schliessen_button2.png")));
			}
			
			//Schliessenbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anmelden/Schliessen_Button.png")));
			}
			
			//Schließt das Fenster
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			
		});
		btnSchliessen.setIcon(new ImageIcon(AnmeldenFenster.class.getResource("/Anmelden/Schliessen_Button.png")));
		btnSchliessen.setBounds(265, 10, 25, 25);
		contentPane.add(btnSchliessen);
		
//Textfeld Benutzername		
		JLabel lblBenutzer = new JLabel();
		lblBenutzer.setIcon(new ImageIcon(AnmeldenFenster.class.getResource("/Anmelden/txtfeld.png")));
		lblBenutzer.setBounds(78, 120, 145, 30);
		contentPane.add(lblBenutzer);
		
//Textfeld Passwort		
		JLabel lblPasswort = new JLabel();
		lblPasswort.setIcon(new ImageIcon(AnmeldenFenster.class.getResource("/Anmelden/txtfeld.png")));
		lblPasswort.setBounds(78, 160, 145, 30);
		contentPane.add(lblPasswort);
		
//Button Anmelden		
		JLabel btnAnmelden = new JLabel();
		btnAnmelden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			//Benutzer hat sich erfolgreich angemeldet und BudgetFix-Fenster öffnet sich
			}
		});
		btnAnmelden.setIcon(new ImageIcon(AnmeldenFenster.class.getResource("/Anmelden/Anmelden_Knopf.png")));
		btnAnmelden.setBounds(78, 200, 146, 38);
		contentPane.add(btnAnmelden);
		
//Button Registrieren		
		JLabel btnRegistrieren = new JLabel();
		btnRegistrieren.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Bei Mausklick RegisterFenster zum Registrieren anmelden
			}
		});
		btnRegistrieren.setIcon(new ImageIcon(AnmeldenFenster.class.getResource("/Anmelden/Registrieren_Login.png")));
		btnRegistrieren.setBounds(78, 249, 145, 30);
		contentPane.add(btnRegistrieren);
		
//Hintergrund		
		JLabel Hintergrund = new JLabel();
		Hintergrund.setIcon(new ImageIcon(AnmeldenFenster.class.getResource("/Registrierung/register.png")));
		Hintergrund.setBounds(0, 0, 300, 300);
		contentPane.add(Hintergrund);
		
//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
				setUndecorated(true);
				setLocationRelativeTo(null);
	}
}


