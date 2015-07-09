package Sparkonto;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import GUI.Sparziele;

import Registrierung.RegisterFenster;
import Anmelden.AnmeldeDatenbank;
import Anmelden.AnmeldenFenster;

import java.awt.Font;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SparzielEingabefenster extends JFrame {
	
	Connection connect = null;
	
	private JPanel contentPane;
	private JTextField TxtBezeichnung;
	private JTextField TxtKategorie;
	private JTextField TxtSparziel;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					SparzielEingabefenster frame = new SparzielEingabefenster();
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
	public SparzielEingabefenster() {
		
		connect = SparkontoDB.dbCon();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//Button Fenster-Schliessen		
		final JLabel BtnSchliessen = new JLabel();
		BtnSchliessen.addMouseListener(new MouseAdapter() {
			//Schliessenbutton ist grau
			@Override
			public void mouseEntered(MouseEvent arg0) {
				BtnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/schliessen_button2.png")));
			}
			
			//Schliessenbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
				BtnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/Schliessen_Button.png")));
			}
			
			//Schliesst das Fenster
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Sparziele frame = new Sparziele();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
			
				
		BtnSchliessen.setIcon(new ImageIcon(SparzielEingabefenster.class.getResource("/Design/Schliessen_Button.png")));
		BtnSchliessen.setBounds(265, 10, 25, 25);
		contentPane.add(BtnSchliessen);
		
//Textfeld Benutzername		
		JLabel LblBezeichnung = new JLabel();
		LblBezeichnung.setIcon(new ImageIcon(SparzielEingabefenster.class.getResource("/Design/txtfeld.png")));
		LblBezeichnung.setBounds(78, 120, 145, 30);
		contentPane.add(LblBezeichnung);
		
		TxtBezeichnung = new JTextField();
		TxtBezeichnung.setBorder(null);
		TxtBezeichnung.setForeground(Color.GRAY);
		TxtBezeichnung.setFont(new Font("Tahoma", Font.BOLD, 16));
		TxtBezeichnung.setBounds(81, 124, 136, 20);
		contentPane.add(TxtBezeichnung);
		TxtBezeichnung.setColumns(10);
		
		TxtKategorie = new JTextField();
		TxtKategorie.setForeground(Color.GRAY);
		TxtKategorie.setFont(new Font("Tahoma", Font.BOLD, 16));
		TxtKategorie.setBorder(null);
		TxtKategorie.setBounds(81, 164, 136, 20);
		contentPane.add(TxtKategorie);
		TxtKategorie.setColumns(10);
		
		TxtSparziel = new JTextField();
		TxtSparziel.setForeground(Color.GRAY);
		TxtSparziel.setFont(new Font("Tahoma", Font.BOLD, 16));
		TxtSparziel.setBorder(null);
		TxtSparziel.setBounds(81, 204, 136, 20);
		contentPane.add(TxtSparziel);
		TxtSparziel.setColumns(10);
		
//Textfeld Passwort		
		JLabel LblKategorie = new JLabel();
		LblKategorie.setIcon(new ImageIcon(SparzielEingabefenster.class.getResource("/Design/txtfeld.png")));
		LblKategorie.setBounds(78, 160, 145, 30);
		contentPane.add(LblKategorie);
		
//Textfeld Betrag des Sparziels	
		JLabel LblSparziel = new JLabel();
		
		LblSparziel.setIcon(new ImageIcon(SparzielEingabefenster.class.getResource("/Design/txtfeld.png")));
		LblSparziel.setBounds(78, 200, 145, 30);
		contentPane.add(LblSparziel);
		
//Button Anlegen des Sparziels	
		JLabel BtnAnlegen = new JLabel();
		BtnAnlegen.setText("Anlegen");
		BtnAnlegen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//Bei Mausklick auf Anlegen speichert das Programm Daten in die SQL-Tabelle ein
			anlegenSparziel();
			}
		});
		BtnAnlegen.setIcon(new ImageIcon(SparzielEingabefenster.class.getResource("/Design/Registrieren.png")));
		BtnAnlegen.setBounds(78, 240, 146, 38);
		contentPane.add(BtnAnlegen);
		
//Hintergrund		
		JLabel Hintergrund = new JLabel("New label");
		Hintergrund.setIcon(new ImageIcon(SparzielEingabefenster.class.getResource("/Design/login.png")));
		Hintergrund.setBounds(0, 0, 300, 300);
		contentPane.add(Hintergrund);
		
//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
				setUndecorated(true);
				setLocationRelativeTo(null);
	}


//Registrierung
	public void anlegenSparziel() {
				
		try{		
				String sqlQuery = "INSERT INTO Sparkonto (Bezeichnung,Kategorie,Sparziel) VALUES(?,?,?)";
				PreparedStatement stm = connect.prepareStatement(sqlQuery);
				stm.setString(1, TxtBezeichnung.getText());
				stm.setString(2, TxtKategorie.getText());
				stm.setString(3, TxtSparziel.getText());	
				//ResultSet result = stm.executeQuery();
				stm.execute();
			
				GUI.Sparziele frame = new Sparziele();
				frame.setVisible(true);	
				
				dispose();
				
	} catch(Exception exc){
		exc.printStackTrace();
	}
}
}