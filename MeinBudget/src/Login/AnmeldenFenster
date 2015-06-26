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


public class Anmelden extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anmelden frame = new Anmelden();
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
	public Anmelden() {
		setTitle("BudgetFix - Anmelden");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGebenSieZur = new JLabel("Geben Sie zur Anmeldung Ihre Daten ein!");
		lblGebenSieZur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGebenSieZur.setBounds(10, 10, 414, 50);
		contentPane.add(lblGebenSieZur);
		
		JLabel lblBenutzername = new JLabel("Benutzername:");
		lblBenutzername.setBounds(10, 76, 200, 50);
		contentPane.add(lblBenutzername);
		
		JLabel lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(10, 109, 200, 50);
		contentPane.add(lblPasswort);
		
		textField = new JTextField();
		textField.setBounds(100, 91, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 124, 200, 20);
		contentPane.add(passwordField);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(79, 187, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(254, 187, 89, 23);
		contentPane.add(btnAbbrechen);
	}

}
