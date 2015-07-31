package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

/**
 * TransaktionenBearbeiten BudgetFix:
 * 
 * Hier kann man seine Ausgaben und Einnahmen als fixe Beiträge bearbeiten oder löschen,
 * die man versehentlich falsch eingegeben werden.
 * 
 * Man kann im Fenster einige Sachen auslesen, jedoch haben wir Probleme gehabt,
 * die Beträge z.B. monatlich automatisch ausgeben zu lassen.
 * 
 * Auch hier hoffen wir mit dem nächsten Update des Programms auf mehr.
 * 
 * @author Zusammenarbeit: Que Ly Dong & Patric Kleine
 * 
 */

public class TransaktionBearbeiten extends JFrame {

	private JPanel contentPane;
	private JTextField txtBezeichnung;
	private JTextField txtBetrag;
	private JTextField txtBemerkung;
	private JTextField txtIntervall;
	
	private String auswahl;
	static int id;
	Connection connection = null;
	Connection conn = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransaktionBearbeiten frame = new TransaktionBearbeiten(id);
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
	public TransaktionBearbeiten(int id) {
		
		this.id = id;
		// Verbindung zur BPDatenbank - Erträge und Aufwendungen
		connection = BPDatenbank.dbCon();
		// Verbindung zur BPDB - Kategorien
		conn = BPDatenbank.dbCon();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Schliessenbutton
		JLabel btnSchliessen = new JLabel();
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
		btnSchliessen.setIcon(new ImageIcon(TransaktionAnlegen.class
				.getResource("/Design/Schliessen_Button.png")));
		btnSchliessen.setBounds(440, 15, 25, 25);
		contentPane.add(btnSchliessen);

		// Überschrift "wiederholene Transaktionen Anlegen"
		JLabel lblTransaktionAnlegen = new JLabel(
				"<html><u>wiederholene Transaktionen bearbeiten</u></html>");
		lblTransaktionAnlegen.setForeground(Color.WHITE);
		lblTransaktionAnlegen.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTransaktionAnlegen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransaktionAnlegen.setBounds(10, 15, 460, 38);
		contentPane.add(lblTransaktionAnlegen);
		
		

		// Bezeichung
		JLabel Bezeichnung = new JLabel("Bezeichnung:");
		Bezeichnung.setForeground(Color.WHITE);
		Bezeichnung.setFont(new Font("Tahoma", Font.BOLD, 14));
		Bezeichnung.setBounds(75, 112, 118, 27);
		contentPane.add(Bezeichnung);

		// Textfeld Bezeichnung zum Eingeben, wie die Transaktion heissen soll
		txtBezeichnung = new JTextField();
		txtBezeichnung.setHorizontalAlignment(SwingConstants.CENTER);
		txtBezeichnung.setForeground(Color.GRAY);
		txtBezeichnung.setColumns(10);
		txtBezeichnung.setBorder(null);
		txtBezeichnung.setBackground(Color.WHITE);
		txtBezeichnung.setBounds(222, 110, 183, 30);
		contentPane.add(txtBezeichnung);

		// Kategorie
		JLabel Kategorie = new JLabel("Kategorie:");
		Kategorie.setForeground(Color.WHITE);
		Kategorie.setFont(new Font("Tahoma", Font.BOLD, 14));
		Kategorie.setBounds(75, 152, 118, 27);
		contentPane.add(Kategorie);

		// Kategorie Combobox, die bereits angelegten Kategorien hier als
		// Auswahl wählen
		JComboBox cboKategorie = new JComboBox();
		cboKategorie.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				String selectedItem = (String) cboKategorie.getSelectedItem();
				System.out.println(selectedItem);
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		cboKategorie.setBounds(222, 150, 183, 30);
		contentPane.add(cboKategorie);
		try {
			String sql = "SELECT * FROM BenutzerKategorien ";
			PreparedStatement stm = conn.prepareStatement(sql);
			ResultSet result = stm.executeQuery();

			while (result.next()) {
				String kategorie = result.getString("Kategorie");
				cboKategorie.addItem(kategorie);
			}
			result.close();
			stm.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// Intervall
		JLabel lblIntervall = new JLabel("Intervall:");
		lblIntervall.setForeground(Color.WHITE);
		lblIntervall.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIntervall.setBounds(75, 192, 118, 27);
		contentPane.add(lblIntervall);

		// Intervall-Feld --> Soll Zahlen eingeben können
		txtIntervall = new JTextField();
		txtIntervall.setHorizontalAlignment(SwingConstants.CENTER);
		txtIntervall.setForeground(Color.GRAY);
		txtIntervall.setColumns(10);
		txtIntervall.setBorder(null);
		txtIntervall.setBackground(Color.WHITE);
		txtIntervall.setBounds(222, 190, 54, 30);
		contentPane.add(txtIntervall);

		// Hier kann man Auswählen zwischen Tag, Woche, Monat, Jahr
		JComboBox cboIntervall = new JComboBox();
		cboIntervall.setModel(new DefaultComboBoxModel(new String[] {"Tag(e)", "Woche(n)", "Monat(e)", "Jahr(e)"}));
		cboIntervall.setBounds(285, 190, 120, 30);
		contentPane.add(cboIntervall);

		// Nächste Fälligkeit
		JLabel lblNchsteFlligkeit = new JLabel("N\u00E4chste F\u00E4lligkeit:");
		lblNchsteFlligkeit.setForeground(Color.WHITE);
		lblNchsteFlligkeit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNchsteFlligkeit.setBounds(75, 232, 135, 27);
		contentPane.add(lblNchsteFlligkeit);

		// Datum auswählen
		JDateChooser txt_Datum = new JDateChooser();
		txt_Datum.setBounds(222, 230, 183, 30);
		contentPane.add(txt_Datum);
		
		JLabel lblBearbeiten = new JLabel("Bearbeiten:");
		lblBearbeiten.setForeground(Color.WHITE);
		lblBearbeiten.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBearbeiten.setBounds(75, 72, 118, 27);
		contentPane.add(lblBearbeiten);
		
		JComboBox cboBearbeiten = new JComboBox();
		cboBearbeiten.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				try {
					String selectedItem = (String) cboBearbeiten
							.getSelectedItem();
					String sql = "SELECT Datum,Bezeichnung,Betrag,Bemerkung FROM BenutzerAufwendungen WHERE ( Bezeichnung='"
							+ selectedItem + "') ";
					PreparedStatement stm = connection.prepareStatement(sql);
					ResultSet result = stm.executeQuery();

					if (result.next()) {
						String add1 = result.getString("Datum");
						((JTextField) txt_Datum.getDateEditor()
								.getUiComponent()).setText(add1);
						String add2 = result.getString("Bezeichnung");
						txtBezeichnung.setText(add2);
						String add3 = result.getString("Betrag");
						txtBetrag.setText(add3);
						String add4 = result.getString("Bemerkung");
						txtBemerkung.setText(add4);

					}
					result.close();
					stm.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		cboBearbeiten.setBounds(222, 70, 183, 30);
		contentPane.add(cboBearbeiten);
		try {

			String sql = "SELECT * FROM BenutzerAufwendungen WHERE (BenutzerID='"
					+ Start.id + "' and Art = 'fix') ";
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet result = stm.executeQuery();

			while (result.next()) {
				String ausgaben = result.getString("Bezeichnung");
				cboBearbeiten.addItem(ausgaben);
			}

			result.close();
			stm.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// Betrag
		JLabel lblBetrag = new JLabel("Betrag:");
		lblBetrag.setForeground(Color.WHITE);
		lblBetrag.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBetrag.setBounds(75, 272, 118, 27);
		contentPane.add(lblBetrag);

		// Betrag-Textfeld --> Einnahmen/Ausgaben
		txtBetrag = new JTextField();
		txtBetrag.setHorizontalAlignment(SwingConstants.CENTER);
		txtBetrag.setForeground(Color.GRAY);
		txtBetrag.setColumns(10);
		txtBetrag.setBorder(null);
		txtBetrag.setBackground(Color.WHITE);
		txtBetrag.setBounds(222, 270, 183, 30);
		contentPane.add(txtBetrag);

		// lblBetrag
		JLabel Betrag = new JLabel();
		Betrag.setBounds(221, 270, 184, 30);
		contentPane.add(Betrag);

		// Bemerkung
		JLabel lblBemerkung = new JLabel("Bemerkung:");
		lblBemerkung.setForeground(Color.WHITE);
		lblBemerkung.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBemerkung.setBounds(75, 312, 118, 27);
		contentPane.add(lblBemerkung);

		// Bemerkung-Textfeld
		txtBemerkung = new JTextField();
		txtBemerkung.setHorizontalAlignment(SwingConstants.CENTER);
		txtBemerkung.setForeground(Color.GRAY);
		txtBemerkung.setColumns(10);
		txtBemerkung.setBorder(null);
		txtBemerkung.setBackground(Color.WHITE);
		txtBemerkung.setBounds(222, 310, 183, 30);
		contentPane.add(txtBemerkung);
		
		JLabel lblTyp = new JLabel("Typ:");
		lblTyp.setForeground(Color.WHITE);
		lblTyp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTyp.setBounds(75, 350, 118, 27);
		contentPane.add(lblTyp);
		
		JRadioButton rdbtnAusgaben = new JRadioButton("Ausgaben");
		rdbtnAusgaben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				auswahl = "Ausgaben";
			}
		});
		rdbtnAusgaben.setBounds(221, 354, 84, 23);
		contentPane.add(rdbtnAusgaben);
		
		JRadioButton rdbtnEinnahmen = new JRadioButton("Einnahmen");
		rdbtnEinnahmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				auswahl = "Einnahmen";
			}
		});
		rdbtnEinnahmen.setBounds(321, 354, 84, 23);
		contentPane.add(rdbtnEinnahmen);
		
		// Radiobutton in Group zusammenfassen
				ButtonGroup wahl = new ButtonGroup();
				wahl.add(rdbtnEinnahmen);
				wahl.add(rdbtnAusgaben);

		// btnSpeichern
		JLabel btnSpeichern = new JLabel();
		btnSpeichern.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (auswahl == "Ausgabe"){
					try{
						String sqlQuery = "INSERT INTO BenutzerAufwendungen (Datum,Bezeichnung,Kategorie,Art,Betrag,BenutzerID,Bemerkung) VALUES(?,?,?,?,?,?,?) ";
						PreparedStatement pst = connection
								.prepareStatement(sqlQuery);

						// Datum
						pst.setString(1, ((JTextField) txt_Datum.getDateEditor()
								.getUiComponent()).getText());

						// Bezeichnung
						pst.setString(2, txtBezeichnung.getText());

						// Kategorie
						String ausgewaelteKategorie = cboKategorie
								.getSelectedItem().toString();
						pst.setString(3, ausgewaelteKategorie);

						// Art
						pst.setString(4, "fix");

						// Betrag
						pst.setString(5, txtBetrag.getText());

						// BenutzerID
						pst.setLong(6, id);

						// Bemerkung
						pst.setString(7, txtBemerkung.getText());

						pst.execute();

						JOptionPane.showMessageDialog(null,
								"Erfolgreich gespeichert!");
						
					}catch (Exception ex) {
						ex.printStackTrace();
						}
				}else{
					try{
						String sqlQuery = "INSERT INTO BenutzerErträge (Datum,Bezeichnung,Kategorie,Art,Betrag,BenutzerID,Bemerkung) VALUES(?,?,?,?,?,?,?) ";
						PreparedStatement pst = connection
								.prepareStatement(sqlQuery);

						// Datum
						pst.setString(1, ((JTextField) txt_Datum.getDateEditor()
								.getUiComponent()).getText());

						// Bezeichnung
						pst.setString(2, txtBezeichnung.getText());

						// Kategorie
						String ausgewaelteKategorie = cboKategorie
								.getSelectedItem().toString();
						pst.setString(3, ausgewaelteKategorie);

						// Art
						pst.setString(4, "fix");

						// Betrag
						pst.setString(5, txtBetrag.getText());

						// BenutzerID
						pst.setLong(6, id);

						// Bemerkung
						pst.setString(7, txtBemerkung.getText());

						pst.execute();
						pst.close();
						JOptionPane.showMessageDialog(null,
								"Erfolgreich gespeichert!");
						
					}catch (Exception ex) {
						ex.printStackTrace();
						}
					
				}
			}
		});
		btnSpeichern.setIcon(new ImageIcon(TransaktionAnlegen.class
				.getResource("/Design/Speichern.png")));
		btnSpeichern.setBounds(90, 395, 144, 38);
		contentPane.add(btnSpeichern);

		// btnZurueck
		JLabel btnZurueck = new JLabel("<html><u>Zur\u00FCck</u></html>");
		btnZurueck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Wiederholung frame = new Wiederholung(Wiederholung.id);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JLabel btnLoeschen = new JLabel("New label");
		btnLoeschen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selectedItem = (String) cboBearbeiten.getSelectedItem();
				String sql = "DELETE FROM BenutzerAufwendungen WHERE ( Bezeichnung='"
						+ selectedItem + "') ";
				try {
					PreparedStatement preS = connection.prepareStatement(sql);
					preS.execute();
					preS.close();
					JOptionPane.showMessageDialog(null,
							"Eingaben erfolgreich gelöscht!");
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		btnLoeschen.setIcon(new ImageIcon(TransaktionBearbeiten.class.getResource("/Design/Loeschen.png")));
		btnLoeschen.setBounds(250, 395, 144, 38);
		contentPane.add(btnLoeschen);
		btnZurueck.setHorizontalAlignment(SwingConstants.CENTER);
		btnZurueck.setForeground(Color.WHITE);
		btnZurueck.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnZurueck.setBounds(170, 440, 144, 14);
		contentPane.add(btnZurueck);

		// Hintergrund
		JLabel Hintergrund = new JLabel();
		Hintergrund.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Hintergrund.setHorizontalAlignment(SwingConstants.CENTER);
		Hintergrund.setForeground(Color.BLACK);
		Hintergrund.setIcon(new ImageIcon(TransaktionAnlegen.class
				.getResource("/Design/GUI3.png")));
		Hintergrund.setBounds(0, 0, 480, 480);
		contentPane.add(Hintergrund);

		// Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten
		// des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);		
	}

}
