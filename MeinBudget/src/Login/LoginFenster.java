package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class LoginFenster extends JFrame {

	private JPanel contentPane;

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
		
		JLabel BenutzernameLabel = new JLabel("BenutzernameLabel");
		BenutzernameLabel.setIcon(new ImageIcon(LoginFenster.class.getResource("/Login/txtfeld.png")));
		BenutzernameLabel.setBounds(78, 133, 145, 30);
		contentPane.add(BenutzernameLabel);
		
		JLabel PasswortLabel = new JLabel("PasswortLabel");
		PasswortLabel.setIcon(new ImageIcon(LoginFenster.class.getResource("/Login/txtfeld.png")));
		PasswortLabel.setBounds(78, 178, 145, 30);
		contentPane.add(PasswortLabel);
		
		JLabel btnAnmelden = new JLabel("btnAnmelden");
		btnAnmelden.setIcon(new ImageIcon(LoginFenster.class.getResource("/Login/Anmelden_Knopf.png")));
		btnAnmelden.setBounds(78, 219, 146, 38);
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
			
			//Schlieﬂt das Fenster
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
