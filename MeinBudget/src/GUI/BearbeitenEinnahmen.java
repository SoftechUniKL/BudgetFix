package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import com.toedter.calendar.JDateChooser;

public class BearbeitenEinnahmen extends JFrame {

	Connection connection = null;
	Connection connection2 = null;
	Connection connection3 = null;
	Connection conn = null;
	static int id;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtBetrag;
	private JTextField txtBemerkung;
	private JTextField txtBezeichnung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BearbeitenEinnahmen frame = new BearbeitenEinnahmen(id);
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
	public BearbeitenEinnahmen(int id) {

		this.id = id;

		// Verbindung zur BPDatenbank - für die Auswahl in der Combobox
		connection = BPDatenbank.dbCon();
		// Verbindung um Änderungen zu speichern
		connection2 = BPDatenbank.dbCon();
		// Verbindung zur BPDatenbank um Auswahl zu löschen
		connection3 = BPDatenbank.dbCon();
		// Verbindung zur BPDB - Kategorien
		conn = BPDatenbank.dbCon();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// btnSchliessen
		JLabel btnSchliessen = new JLabel();
		btnSchliessen.setIcon(new ImageIcon(BearbeitenEinnahmen.class
				.getResource("/Design/Schliessen_Button.png")));
		btnSchliessen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
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
		btnSchliessen.setIcon(new ImageIcon(BearbeitenEinnahmen.class
				.getResource("/Design/Schliessen_Button.png")));
		btnSchliessen.setBounds(440, 15, 25, 25);
		contentPane.add(btnSchliessen);

		// Überschrift "Bearbeiten der Einnahmen"
		JLabel lblHinzuE = new JLabel(
				"<html><u>Einnahmen bearbeiten</u></html>");
		lblHinzuE.setForeground(Color.WHITE);
		lblHinzuE.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHinzuE.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinzuE.setBounds(10, 11, 460, 38);
		contentPane.add(lblHinzuE);

		// lblBezeichnung
		JLabel lblBearbeiten = new JLabel("Bearbeiten:");
		lblBearbeiten.setForeground(Color.WHITE);
		lblBearbeiten.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBearbeiten.setBounds(100, 72, 118, 27);
		contentPane.add(lblBearbeiten);

		JLabel lblBezeichnung = new JLabel("Bezeichnung:");
		lblBezeichnung.setForeground(Color.WHITE);
		lblBezeichnung.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBezeichnung.setBounds(100, 112, 123, 27);
		contentPane.add(lblBezeichnung);

		txtBezeichnung = new JTextField();
		txtBezeichnung.setHorizontalAlignment(SwingConstants.CENTER);
		txtBezeichnung.setForeground(Color.GRAY);
		txtBezeichnung.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtBezeichnung.setColumns(10);
		txtBezeichnung.setBorder(null);
		txtBezeichnung.setBackground(Color.WHITE);
		txtBezeichnung.setBounds(222, 110, 144, 30);
		contentPane.add(txtBezeichnung);

		// Betrag
		JLabel lblBetrag = new JLabel("Betrag:");
		lblBetrag.setForeground(Color.WHITE);
		lblBetrag.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBetrag.setBounds(100, 152, 86, 27);
		contentPane.add(lblBetrag);

		// txtBetrag
		txtBetrag = new JTextField();
		txtBetrag.setHorizontalAlignment(SwingConstants.CENTER);
		txtBetrag.setBackground(Color.WHITE);
		txtBetrag.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtBetrag.setForeground(Color.GRAY);
		txtBetrag.setBorder(null);
		txtBetrag.setBounds(222, 150, 144, 30);
		txtBetrag.setColumns(10);
		contentPane.add(txtBetrag);

		// Datum
		JLabel lblDatum = new JLabel("Datum:");
		lblDatum.setForeground(Color.WHITE);
		lblDatum.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatum.setBounds(100, 192, 81, 27);
		contentPane.add(lblDatum);

		// Datum auswählen
		JDateChooser txt_Datum = new JDateChooser();
		txt_Datum.setDateFormatString("yyyy-MM-dd");
		txt_Datum.setForeground(Color.GRAY);
		txt_Datum.getCalendarButton().setForeground(Color.GRAY);
		txt_Datum.setBounds(222, 190, 145, 30);
		contentPane.add(txt_Datum);

		// Kategorie
		JLabel Kategorie = new JLabel("Kategorie:");
		Kategorie.setForeground(Color.WHITE);
		Kategorie.setFont(new Font("Tahoma", Font.BOLD, 14));
		Kategorie.setBounds(100, 232, 118, 27);
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
		cboKategorie.setBounds(222, 230, 145, 30);
		contentPane.add(cboKategorie);
		try {
			String sql = "SELECT * FROM BenutzerKategorien WHERE Typ='Einkommen' ";
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

		// Bemerkung
		JLabel lblBemerkung = new JLabel("Bemerkung:");
		lblBemerkung.setForeground(Color.WHITE);
		lblBemerkung.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBemerkung.setBounds(100, 272, 118, 27);
		contentPane.add(lblBemerkung);

		// txtBemerkung
		txtBemerkung = new JTextField();
		txtBemerkung.setHorizontalAlignment(SwingConstants.CENTER);
		txtBemerkung.setForeground(Color.GRAY);
		txtBemerkung.setColumns(10);
		txtBemerkung.setBorder(null);
		txtBemerkung.setBackground(Color.WHITE);
		txtBemerkung.setBounds(222, 270, 144, 30);
		contentPane.add(txtBemerkung);

		JComboBox cboBearbeiten = new JComboBox();
		cboBearbeiten.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				try {
					String selectedItem = (String) cboBearbeiten
							.getSelectedItem();
					String sql = "SELECT Datum,Bezeichnung,Betrag,Bemerkung FROM BenutzerErträge WHERE ( Bezeichnung='"
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
		cboBearbeiten.setForeground(Color.GRAY);
		cboBearbeiten.setBounds(222, 70, 145, 30);
		contentPane.add(cboBearbeiten);

		try {

			String sql = "SELECT * FROM BenutzerErträge WHERE (BenutzerID='"
					+ Start.id + "' and Art = 'variabel') ";
			PreparedStatement stm = connection3.prepareStatement(sql);
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

		// btnSpeichern
		JLabel btnSpeichern = new JLabel();
		btnSpeichern.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String selectedItem = (String) cboBearbeiten
							.getSelectedItem();
					String value1 = ((JTextField) txt_Datum.getDateEditor()
							.getUiComponent()).getText();
					String value2 = txtBezeichnung.getText();
					String ausgewaelteKategorie = cboKategorie
							.getSelectedItem().toString();
					String value3 = ausgewaelteKategorie;
					String value4 = txtBetrag.getText();
					String value5 = txtBemerkung.getText();

					String sqlQuery = "UPDATE BenutzerErträge SET Datum='"
							+ value1 + "', Bezeichnung='" + value2
							+ "', Kategorie='" + value3 + "', Betrag='"
							+ value4 + "', Bemerkung='" + value5
							+ "'  WHERE ( Bezeichnung='" + selectedItem
							+ "')  ";
					PreparedStatement pstm = connection2
							.prepareStatement(sqlQuery);
					pstm.execute();
					pstm.close();

					JOptionPane.showMessageDialog(null,
							"Erfolgreich gespeichert!");

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnSpeichern.setIcon(new ImageIcon(HinzufuegenEinnahmen.class
				.getResource("/Design/Speichern.png")));
		btnSpeichern.setBounds(175, 330, 144, 38);
		contentPane.add(btnSpeichern);

		// btnZurueck
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

		JLabel btnLoeschen = new JLabel();
		btnLoeschen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selectedItem = (String) cboBearbeiten.getSelectedItem();
				String sql = "DELETE FROM BenutzerErträge WHERE ( Bezeichnung='"
						+ selectedItem + "') ";
				try {
					PreparedStatement preS = connection3.prepareStatement(sql);
					preS.execute();
					preS.close();
					JOptionPane.showMessageDialog(null,
							"Eingaben erfolgreich gelöscht!");
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		btnLoeschen.setIcon(new ImageIcon(BearbeitenEinnahmen.class
				.getResource("/Design/Loeschen.png")));
		btnLoeschen.setBounds(175, 379, 144, 38);
		contentPane.add(btnLoeschen);
		btnZurueck.setHorizontalAlignment(SwingConstants.CENTER);
		btnZurueck.setForeground(Color.WHITE);
		btnZurueck.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnZurueck.setBounds(170, 420, 144, 14);
		contentPane.add(btnZurueck);

		// Hintergrund
		JLabel Hintergrund = new JLabel();
		Hintergrund.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Hintergrund.setHorizontalAlignment(SwingConstants.CENTER);
		Hintergrund.setForeground(Color.BLACK);
		Hintergrund.setIcon(new ImageIcon(HinzufuegenEinnahmen.class
				.getResource("/Design/GUI3.png")));
		Hintergrund.setBounds(0, 0, 480, 480);
		contentPane.add(Hintergrund);

		// Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten
		// des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
