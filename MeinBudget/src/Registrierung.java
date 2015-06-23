import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Registrierung extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrierung frame = new Registrierung();
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
	public Registrierung() {
		setTitle("BudgetFix - Registrierung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBitteGebenSie = new JLabel("Bitte geben Sie Ihre Daten ein!");
		lblBitteGebenSie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBitteGebenSie.setBounds(10, 11, 414, 23);
		contentPane.add(lblBitteGebenSie);
		
		JLabel lblBenutzername = new JLabel("Benutzername:");
		lblBenutzername.setBounds(50, 60, 84, 14);
		contentPane.add(lblBenutzername);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setBounds(50, 101, 84, 14);
		contentPane.add(lblPasswort);
		
		JLabel lblPasswortWiederholen = new JLabel("Passwort wiederholen:");
		lblPasswortWiederholen.setBounds(50, 140, 124, 14);
		contentPane.add(lblPasswortWiederholen);
		
		textField = new JTextField();
		textField.setBounds(200, 57, 180, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 98, 180, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(200, 137, 180, 20);
		contentPane.add(passwordField_1);
		
		//Registerobjekt deklarieren
		private Benutzername einBenutzername;
						
		//Registerobjekt instanziieren
		private einBenutzername = new Benutzername();
		
		JButton btnRegistrieren = new JButton("Registrieren");
		btnRegistrieren.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				registrieren ();
			}
		});
		btnRegistrieren.setBounds(70, 196, 104, 23);
		contentPane.add(btnRegistrieren);
		
		//Benutzernamendaten zur Laufzeit speichern
		public void registrieren (){
			einBenutzername.setName(txtBenutzer.getText());
		}
		
		JButton Abbrechen = new JButton("Abbrechen");
		Abbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Abbrechen.setBounds(262, 196, 104, 23);
		contentPane.add(Abbrechen);
	}
}
