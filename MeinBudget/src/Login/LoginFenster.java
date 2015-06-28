package Login;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.awt.Color;
import java.awt.Font;
import java.util.Map;

public class LoginFenster extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private JLabel lblRegistrieren;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFenster frame = new LoginFenster();
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
	public LoginFenster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBenutzername = new JLabel("BenutzernameLabel");
		lblBenutzername.setIcon(new ImageIcon(LoginFenster.class.getResource("/Login/txtfeld.png")));
		lblBenutzername.setBounds(78, 124, 145, 30);
		contentPane.add(lblBenutzername);
		
		JLabel lblRegistrieren = new JLabel("<html><u>Registrieren</u></<html>");
		lblRegistrieren.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			//Bei Mausklick öffnet sich RegisterFenster
			}
		});
		lblRegistrieren.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegistrieren.setBounds(119, 253, 104, 25);
		contentPane.add(lblRegistrieren);
		
		
		JLabel lblPasswort = new JLabel("PasswortLabel");
		lblPasswort.setIcon(new ImageIcon(LoginFenster.class.getResource("/Login/txtfeld.png")));
		lblPasswort.setBounds(78, 164, 145, 30);
		contentPane.add(lblPasswort);
		
		JLabel btnAnmelden = new JLabel("btnAnmelden");
		btnAnmelden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//Tu was
				
			}
		});
		btnAnmelden.setIcon(new ImageIcon(LoginFenster.class.getResource("/Login/Anmelden_Knopf.png")));
		btnAnmelden.setBounds(78, 204, 146, 38);
		contentPane.add(btnAnmelden);
		
		final JLabel btnSchliessen = new JLabel("btnSchliessen");
		btnSchliessen.addMouseListener(new MouseAdapter() {
			
			//Schliessenbutton ist grau
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/schliessen_button2.png")));
			}
			
			//Schliessenbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/Schliessen_Button.png")));
			}
			
			//Schließt das Fenster
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			
		});
		btnSchliessen.setIcon(new ImageIcon(LoginFenster.class.getResource("/Login/Schliessen_Button.png")));
		btnSchliessen.setBounds(265, 10, 25, 25);
		contentPane.add(btnSchliessen);
		
		JLabel Hintergrund = new JLabel("Hintergrund");
		Hintergrund.setIcon(new ImageIcon(LoginFenster.class.getResource("/Login/login.png")));
		Hintergrund.setBounds(0, 0, 300, 300);
		contentPane.add(Hintergrund);
		
		//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
