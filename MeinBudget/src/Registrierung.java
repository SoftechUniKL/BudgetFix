import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Label;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;


public class Registrierung {

	private JFrame Registrierung;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrierung window = new Registrierung();
					window.Registrierung.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registrierung() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Registrierung = new JFrame();
		Registrierung.setBounds(100, 100, 450, 300);
		Registrierung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Registrierung.getContentPane().setLayout(null);
		Registrierung.setTitle("Registrierung");
	
		JLabel label = new JLabel("Melden Sie sich bitte an!");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 19, 200, 26);
		Registrierung.getContentPane().add(label);
		
		JLabel lblBenutzername = new JLabel("Benutzername:");
		lblBenutzername.setBounds(10, 56, 84, 26);
		Registrierung.getContentPane().add(lblBenutzername);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setBounds(10, 105, 200, 26);
		Registrierung.getContentPane().add(lblPasswort);
		
		JLabel lblPasswortWiederholen = new JLabel("Passwort wiederholen:");
		lblPasswortWiederholen.setBounds(10, 155, 114, 26);
		Registrierung.getContentPane().add(lblPasswortWiederholen);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 105, 200, 26);
		Registrierung.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(146, 155, 200, 26);
		Registrierung.getContentPane().add(passwordField_1);
		
		textField = new JTextField();
		textField.setBounds(146, 56, 200, 26);
		Registrierung.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnRegistrien = new JButton("Registrieren");
		btnRegistrien.setBounds(62, 204, 108, 23);
		Registrierung.getContentPane().add(btnRegistrien);
		
		JButton button = new JButton("Abbrechen");
		button.setBounds(253, 204, 108, 23);
		Registrierung.getContentPane().add(button);
		

	
	}
}
