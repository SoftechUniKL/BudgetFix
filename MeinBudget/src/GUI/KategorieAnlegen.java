package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class KategorieAnlegen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KategorieAnlegen frame = new KategorieAnlegen();
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
	public KategorieAnlegen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//Schliessenbutton		
			final JLabel btnSchliessen = new JLabel();
			btnSchliessen.addMouseListener(new MouseAdapter() {
			//Schliessenbutton ist grau
			@Override
			public void mouseEntered(MouseEvent arg0) {
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
			
//Überschrift "Kategorie Anlegen"			
			JLabel lblKategorienAnlegen = new JLabel("Kategorien Anlegen");
			lblKategorienAnlegen.setForeground(Color.WHITE);
			lblKategorienAnlegen.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblKategorienAnlegen.setHorizontalAlignment(SwingConstants.CENTER);
			lblKategorienAnlegen.setBounds(10, 15, 460, 38);
			contentPane.add(lblKategorienAnlegen);
			btnSchliessen.setIcon(new ImageIcon(KategorieAnlegen.class.getResource("/Design/Schliessen_Button.png")));
			btnSchliessen.setBounds(440, 15, 25, 25);
			contentPane.add(btnSchliessen);
		
//Kategorie		
		JLabel lblKategorie = new JLabel();
		lblKategorie.setIcon(new ImageIcon(KategorieAnlegen.class.getResource("/Design/Textfeldgross.png")));
		lblKategorie.setBounds(222, 105, 145, 30);
		contentPane.add(lblKategorie);
		
//Typ für Kategorie		
		JLabel Kategorie = new JLabel("Kategorie:");
		Kategorie.setForeground(Color.WHITE);
		Kategorie.setFont(new Font("Tahoma", Font.BOLD, 14));
		Kategorie.setBounds(100, 105, 91, 27);
		contentPane.add(Kategorie);
		
//Typ für Ausgaben oder Einnahmen		
		JLabel Typ = new JLabel("Typ:");
		Typ.setForeground(Color.WHITE);
		Typ.setFont(new Font("Tahoma", Font.BOLD, 14));
		Typ.setBounds(100, 170, 91, 27);
		contentPane.add(Typ);
		
//Auswahl Ausgaben		
		JRadioButton rdbtnAusgaben = new JRadioButton("Ausgaben");
		rdbtnAusgaben.setBounds(222, 174, 145, 30);
		contentPane.add(rdbtnAusgaben);
		
//Auswahl Einnahmen		
		JRadioButton rdbtnEinnahmen = new JRadioButton("Einnahmen");
		rdbtnEinnahmen.setBounds(222, 207, 145, 30);
		contentPane.add(rdbtnEinnahmen);
		
//Button Auswahl für Icons		
		JLabel lblIcon = new JLabel("Icon:");
		lblIcon.setForeground(Color.WHITE);
		lblIcon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIcon.setBounds(100, 274, 91, 27);
		contentPane.add(lblIcon);
		
		JLabel lblAuswahl = new JLabel("Auswahl");
		lblAuswahl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblAuswahl.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuswahl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAuswahl.setBounds(222, 272, 124, 30);
		contentPane.add(lblAuswahl);
		
		JComboBox<Object> cboAuswahl = new JComboBox<Object>();
		cboAuswahl.setBounds(222, 272, 145, 30);
		contentPane.add(cboAuswahl);
		
//Button Speichern		
		JLabel btnSpeichern = new JLabel();
		btnSpeichern.setIcon(new ImageIcon(KategorieAnlegen.class.getResource("/Design/Speichern.png")));
		btnSpeichern.setBounds(148, 372, 188, 38);
		contentPane.add(btnSpeichern);
				
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
