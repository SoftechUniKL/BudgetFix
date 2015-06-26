package Registrierung;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class RFenster extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBenutzername;
	private JPasswordField PW1;
	private JPasswordField PW2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RFenster frame = new RFenster();
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
	public RFenster() {
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
		
		JLabel lblPW1 = new JLabel("Passwort:");
		lblPW1.setBounds(50, 101, 84, 14);
		contentPane.add(lblPW1);
		
		JLabel lblPW2 = new JLabel("Passwort wiederholen:");
		lblPW2.setBounds(50, 140, 124, 14);
		contentPane.add(lblPW2);
		
		txtBenutzername = new JTextField();
		txtBenutzername.setBounds(200, 57, 180, 20);
		contentPane.add(txtBenutzername);
		txtBenutzername.setColumns(10);
		
		PW1 = new JPasswordField();
		PW1.setBounds(200, 98, 180, 20);
		contentPane.add(PW1);
		
		PW2 = new JPasswordField();
		PW2.setBounds(200, 137, 180, 20);
		contentPane.add(PW2);
		
		
		
		//Registrieren mit Mausklick oder Leertaste
		JButton btnRegistrieren = new JButton("Registrieren");
		btnRegistrieren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		btnRegistrieren.setBounds(70, 200, 104, 23);
		contentPane.add(btnRegistrieren);
		
		//Abbrechen mit Mausklick
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(260, 200, 104, 23);
		contentPane.add(btnAbbrechen);
		
		btnAbbrechen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
	}
}
