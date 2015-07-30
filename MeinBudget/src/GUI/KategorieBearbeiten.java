package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class KategorieBearbeiten extends JFrame {

	private JPanel contentPane;
	private JTextField txtKategorie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KategorieBearbeiten frame = new KategorieBearbeiten();
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
	public KategorieBearbeiten() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Schliessenbutton
		final JLabel btnSchliessen = new JLabel();
		btnSchliessen.addMouseListener(new MouseAdapter() {
			// Schliessenbutton ist grau
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/schliessen_button2.png")));
			}

			// Schliessenbutton ist blau
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("/Design/Schliessen_Button.png")));
			}

			// Schliesst das Fenster
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}

		});
		
		JLabel lblBearbeiten = new JLabel("Bearbeiten:");
		lblBearbeiten.setForeground(Color.WHITE);
		lblBearbeiten.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBearbeiten.setBounds(100, 85, 91, 27);
		contentPane.add(lblBearbeiten);
		
		JComboBox cboBearbeiten = new JComboBox();
		cboBearbeiten.setFont(new Font("Tahoma", Font.BOLD, 12));
		cboBearbeiten.setForeground(Color.GRAY);
		cboBearbeiten.setBounds(222, 85, 145, 30);
		contentPane.add(cboBearbeiten);

		// Überschrift "Kategorie Anlegen"
		JLabel lblKategorienAnlegen = new JLabel(
				"<html><u>Kategorien anlegen</u></html>");
		lblKategorienAnlegen.setForeground(Color.WHITE);
		lblKategorienAnlegen.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKategorienAnlegen.setHorizontalAlignment(SwingConstants.CENTER);
		lblKategorienAnlegen.setBounds(10, 15, 460, 38);
		contentPane.add(lblKategorienAnlegen);
		btnSchliessen.setIcon(new ImageIcon(KategorieAnlegen.class
				.getResource("/Design/Schliessen_Button.png")));
		btnSchliessen.setBounds(440, 15, 25, 25);
		contentPane.add(btnSchliessen);

		// Textfeld für Kategorie
		txtKategorie = new JTextField();
		txtKategorie.setHorizontalAlignment(SwingConstants.CENTER);
		txtKategorie.setBorder(null);
		txtKategorie.setForeground(Color.GRAY);
		txtKategorie.setBackground(Color.WHITE);
		txtKategorie.setBounds(222, 150, 144, 30);
		contentPane.add(txtKategorie);
		txtKategorie.setColumns(10);

		// Kategorie
		JLabel lblKategorie = new JLabel();
		lblKategorie.setIcon(new ImageIcon(KategorieAnlegen.class
				.getResource("/Design/Textfeldgross.png")));
		lblKategorie.setBounds(222, 150, 145, 30);
		contentPane.add(lblKategorie);

		// Typ für Kategorie
		JLabel Kategorie = new JLabel("Kategorie:");
		Kategorie.setForeground(Color.WHITE);
		Kategorie.setFont(new Font("Tahoma", Font.BOLD, 14));
		Kategorie.setBounds(100, 150, 91, 27);
		contentPane.add(Kategorie);

		// Typ für Ausgaben oder Einnahmen
		JLabel Typ = new JLabel("Typ:");
		Typ.setForeground(Color.WHITE);
		Typ.setFont(new Font("Tahoma", Font.BOLD, 14));
		Typ.setBounds(100, 230, 91, 27);
		contentPane.add(Typ);

		// Auswahl Ausgaben
		JRadioButton rdbtnAusgaben = new JRadioButton("Ausgaben");
		rdbtnAusgaben.setBounds(222, 230, 145, 30);
		contentPane.add(rdbtnAusgaben);

		// Auswahl Einnahmen
		JRadioButton rdbtnEinnahmen = new JRadioButton("Einnahmen");
		rdbtnEinnahmen.setBounds(222, 264, 145, 30);
		contentPane.add(rdbtnEinnahmen);

					//rdbtnAusgaben.setSelected(true);
		//Radiobutton in Group zusammenfassen
		ButtonGroup wahl = new ButtonGroup();
		wahl.add(rdbtnEinnahmen);
		wahl.add(rdbtnAusgaben);
		
					//JRadioButton selectedButton = (JRadioButton)wahl.getSelection();
		//Auswahl
		if(rdbtnEinnahmen.isSelected()){
			String selected = "Einkommen";
		}else{
			String selected = "Ausgaben";
		}

		
		// Button Zurück zu z.B. Start
		JLabel btnZurueck = new JLabel("<html><u>Zur\u00FCck</u></html>");
		btnZurueck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					
					public void run() {
						try {
							KategorieAnlegen frame = new KategorieAnlegen();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnZurueck.setHorizontalAlignment(SwingConstants.CENTER);
		btnZurueck.setForeground(Color.WHITE);
		btnZurueck.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnZurueck.setBounds(170, 410, 144, 14);
		contentPane.add(btnZurueck);
		
		
		// Button Speichern
				JLabel btnSpeichern = new JLabel();
				btnSpeichern.setIcon(new ImageIcon(KategorieAnlegen.class
						.getResource("/Design/Speichern.png")));
				btnSpeichern.setBounds(170, 330, 144, 38);
				contentPane.add(btnSpeichern);
		
		JLabel btnLöschen = new JLabel();
		btnLöschen.setIcon(new ImageIcon(KategorieBearbeiten.class.getResource("/Design/Loeschen.png")));
		btnLöschen.setBounds(170, 370, 144, 38);
		contentPane.add(btnLöschen);


		// Hintergrund
		JLabel Hintergrund = new JLabel();
		Hintergrund.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Hintergrund.setHorizontalAlignment(SwingConstants.CENTER);
		Hintergrund.setForeground(Color.GRAY);
		Hintergrund.setIcon(new ImageIcon(KategorieAnlegen.class
				.getResource("/Design/GUI3.png")));
		Hintergrund.setBounds(0, 0, 480, 480);
		contentPane.add(Hintergrund);


		// Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten
		// des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);		
	}

}
