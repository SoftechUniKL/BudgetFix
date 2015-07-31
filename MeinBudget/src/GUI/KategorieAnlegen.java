package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * KategorieAnlegen BudgetFix:
 * 
 * Hier kann man seine Kategorien anlegen.
 * Mit dem n�chsten Update klappt bestimmt die Auswahl zu den Icons - work in process.
 * 
 * @author Zusammenarbeit: Que Ly Dong & Patric Kleine
 * 
 */


public class KategorieAnlegen extends JFrame {

	Connection connection = null;

	private JPanel contentPane;
	private JTextField txtKategorie;
	private String auswahl;

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
	 * Visualisierungsfenster
	 */
	public KategorieAnlegen() {

		// Verbindung zur BPDB - Kategorien
		connection = BPDatenbank.dbCon();

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

		// �berschrift "Kategorie Anlegen"
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

		// Textfeld f�r Kategorie
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

		// Typ f�r Kategorie
		JLabel Kategorie = new JLabel("Kategorie:");
		Kategorie.setForeground(Color.WHITE);
		Kategorie.setFont(new Font("Tahoma", Font.BOLD, 14));
		Kategorie.setBounds(100, 150, 91, 27);
		contentPane.add(Kategorie);

		// Typ f�r Ausgaben oder Einnahmen
		JLabel Typ = new JLabel("Typ:");
		Typ.setForeground(Color.WHITE);
		Typ.setFont(new Font("Tahoma", Font.BOLD, 14));
		Typ.setBounds(100, 230, 91, 27);
		contentPane.add(Typ);
		
		// Auswahl Ausgaben
		JRadioButton rdbtnAusgaben = new JRadioButton("Ausgaben");
		rdbtnAusgaben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				auswahl = "Ausgaben";
			}
		});
		rdbtnAusgaben.setBounds(222, 230, 145, 30);
		contentPane.add(rdbtnAusgaben);

		// Auswahl Einnahmen
		JRadioButton rdbtnEinnahmen = new JRadioButton("Einnahmen");
		rdbtnEinnahmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				auswahl = "Einnahmen";
			}
		});
		rdbtnEinnahmen.setBounds(222, 264, 145, 30);
		contentPane.add(rdbtnEinnahmen);

		// Radiobutton in Group zusammenfassen
		ButtonGroup wahl = new ButtonGroup();
		wahl.add(rdbtnEinnahmen);
		wahl.add(rdbtnAusgaben);

		// Auswahl
		if (rdbtnEinnahmen.isSelected()) {
			System.out.println("Einkommen");
		} else {
		}
		rdbtnAusgaben.getText().toString();

		// Button Zur�ck zu Start
		JLabel btnZurueck = new JLabel("<html><u>Zur\u00FCck</u></html>");
		btnZurueck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Start frame = new Start(Start.id);
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
		btnZurueck.setBounds(170, 390, 144, 14);
		contentPane.add(btnZurueck);

		// Button Speichern
		JLabel btnSpeichern = new JLabel();
		btnSpeichern.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String sqlQuery = "INSERT INTO BenutzerKategorien (Kategorie,Typ) VALUES(?,?) ";
					PreparedStatement pst = connection
							.prepareStatement(sqlQuery);

					// Kategorie
					pst.setString(1, txtKategorie.getText());

					// Typ
					pst.setString(2, auswahl);

					pst.execute();
					JOptionPane.showMessageDialog(null,
							"Erfolgreich gespeichert!");

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSpeichern.setIcon(new ImageIcon(KategorieAnlegen.class
				.getResource("/Design/Speichern.png")));
		btnSpeichern.setBounds(170, 350, 144, 38);
		contentPane.add(btnSpeichern);

		// Hintergrund
		JLabel Hintergrund = new JLabel();
		Hintergrund.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Hintergrund.setHorizontalAlignment(SwingConstants.CENTER);
		Hintergrund.setForeground(Color.BLACK);
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
