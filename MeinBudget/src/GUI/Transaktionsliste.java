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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class Transaktionsliste extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static int id;
	Connection connection = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaktionsliste frame = new Transaktionsliste(id);
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
	public Transaktionsliste(int id) {
		
		this.id = id;
		// Verbindung zur BPDatenbank - Erträge und Aufwendungen
		connection = BPDatenbank.dbCon();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*
		 * UtilDateModel model = new UtilDateModel(); JDatePanelImpl datePanel =
		 * new JDatePanelImpl(model); JDatePickerImpl datePicker = new
		 * JDatePickerImpl(datePanel); frame.add(datePicker);
		 */

		// Schliessen Button
		JLabel btnSchliessen = new JLabel();
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
		btnSchliessen.setIcon(new ImageIcon(Transaktionsliste.class
				.getResource("/Design/Schliessen_Button.png")));
		btnSchliessen.setBounds(440, 15, 25, 25);
		contentPane.add(btnSchliessen);

		// Überschrift "Transaktionsliste"
		JLabel lblKategorienAnlegen = new JLabel(
				"<html><u>Transaktionsliste</u></html>");
		lblKategorienAnlegen.setForeground(Color.WHITE);
		lblKategorienAnlegen.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKategorienAnlegen.setHorizontalAlignment(SwingConstants.CENTER);
		lblKategorienAnlegen.setBounds(10, 15, 460, 38);
		contentPane.add(lblKategorienAnlegen);
		btnSchliessen.setIcon(new ImageIcon(Transaktionsliste.class
				.getResource("/Design/Schliessen_Button.png")));
		btnSchliessen.setBounds(440, 15, 25, 25);
		contentPane.add(btnSchliessen);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(140, 230, 200, 50);
		contentPane.add(scrollPane);
		
		// zeigt an, welche Ausgaben man hatte, wenn man Datum auswählt
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		// Datum auswählen
				JDateChooser txt_Datum = new JDateChooser();
				txt_Datum.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						try {
							String datum = ((JTextField) txt_Datum.getDateEditor()
									.getUiComponent()).getText();	
							
							String sqlQuery = "SELECT Bezeichnung,Kategorie,Betrag FROM BenutzerAufwendungen  WHERE (BenutzerID='"
									+ Start.id + "' and Datum='"+datum+"') ";
							PreparedStatement stm = connection.prepareStatement(sqlQuery);
							ResultSet result = stm.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(result));
							result.close();
							stm.close();
						} catch (Exception exc) {
							exc.printStackTrace();
						}
					}
				});
				txt_Datum.setDateFormatString("yyyy-MM-dd");
				txt_Datum.setBounds(150, 150, 180, 30);
				contentPane.add(txt_Datum);
				
		

		JLabel label = new JLabel("<html><u>Zur\u00FCck</u></html>");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(170, 410, 144, 14);
		contentPane.add(label);

		// Hintergrund
		JLabel Hintergrund = new JLabel();
		Hintergrund.setIcon(new ImageIcon(Transaktionsliste.class
				.getResource("/Design/GUI3.png")));
		Hintergrund.setBounds(0, 0, 480, 480);
		contentPane.add(Hintergrund);

		// Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten
		// des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
