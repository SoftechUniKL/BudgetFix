package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class HinzufuegenAusgaben extends JFrame {

	private JPanel contentPane;
	private JTextField txtBetrag;
	private JTextField txtBemerkung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HinzufuegenAusgaben frame = new HinzufuegenAusgaben();
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
	public HinzufuegenAusgaben() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//btnSchliessen		
		JLabel btnSchliessen = new JLabel();
		btnSchliessen.setIcon(new ImageIcon(HinzufuegenAusgaben.class.getResource("/Design/Schliessen_Button.png")));
		btnSchliessen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
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
		btnSchliessen.setIcon(new ImageIcon(TransaktionAnlegen.class.getResource("/Design/Schliessen_Button.png")));
		btnSchliessen.setBounds(440, 15, 25, 25);
		contentPane.add(btnSchliessen);
		
//Überschrift "Ausgaben hinzufügen"			
		JLabel lblHinzuA = new JLabel("<html><u>Ausgaben hinzufügen</u></html>");
		lblHinzuA.setForeground(Color.WHITE);
		lblHinzuA.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHinzuA.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinzuA.setBounds(10, 11, 460, 38);
		contentPane.add(lblHinzuA);
		
//Betrag		
		JLabel lblBetrag = new JLabel("Betrag:");
		lblBetrag.setForeground(Color.WHITE);
		lblBetrag.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBetrag.setBounds(100, 100, 86, 27);
		contentPane.add(lblBetrag);
				
//txtBetrag		
		txtBetrag = new JTextField();
		txtBetrag.setHorizontalAlignment(SwingConstants.CENTER);
		txtBetrag.setForeground(Color.GRAY);
		txtBetrag.setColumns(10);
		txtBetrag.setBorder(null);
		txtBetrag.setBackground(Color.WHITE);
		txtBetrag.setBounds(223, 100, 144, 30);
		contentPane.add(txtBetrag);
				
//lblBetrag		
		JLabel Betrag = new JLabel();
		Betrag.setIcon(new ImageIcon(HinzufuegenEinnahmen.class.getResource("/Design/Textfeldgross.png")));
		Betrag.setBounds(222, 100, 145, 30);
		contentPane.add(Betrag);
								
//Datum	
		JLabel lblDatum = new JLabel("Datum:");
		lblDatum.setForeground(Color.WHITE);
		lblDatum.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatum.setBounds(100, 160, 81, 27);
		contentPane.add(lblDatum);
				
//Datum auswählen		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setForeground(Color.GRAY);
		dateChooser.getCalendarButton().setForeground(Color.GRAY);
		dateChooser.setBounds(222, 160, 145, 30);
		contentPane.add(dateChooser);
						
						
//Kategorie		
		JLabel Kategorie = new JLabel("Kategorie:");
		Kategorie.setForeground(Color.WHITE);
		Kategorie.setFont(new Font("Tahoma", Font.BOLD, 14));
		Kategorie.setBounds(100, 220, 118, 27);
		contentPane.add(Kategorie);
						
//Kategorie Combobox, die bereits angelegten Kategorien hier als Auswahl wählen		
		JComboBox cboKategorie = new JComboBox();
		cboKategorie.setBounds(222, 220, 145, 30);
		contentPane.add(cboKategorie);
						
//Bemerkung		
		JLabel lblBemerkung = new JLabel("Bemerkung:");
		lblBemerkung.setForeground(Color.WHITE);
		lblBemerkung.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBemerkung.setBounds(100, 280, 118, 27);
		contentPane.add(lblBemerkung);

//txtBemerkung		
		txtBemerkung = new JTextField();
		txtBemerkung.setHorizontalAlignment(SwingConstants.CENTER);
		txtBemerkung.setForeground(Color.GRAY);
		txtBemerkung.setColumns(10);
		txtBemerkung.setBorder(null);
		txtBemerkung.setBackground(Color.WHITE);
		txtBemerkung.setBounds(222, 280, 144, 30);
		contentPane.add(txtBemerkung);
				
//lblBemerkung		
		JLabel Bemerkung = new JLabel();
		Bemerkung.setIcon(new ImageIcon(HinzufuegenEinnahmen.class.getResource("/Design/Textfeldgross.png")));
		Bemerkung.setBounds(222, 280, 145, 30);
		contentPane.add(Bemerkung);

//btnSpeichern		
		JLabel btnSpeichern = new JLabel();
		btnSpeichern.setIcon(new ImageIcon(TransaktionAnlegen.class.getResource("/Design/Speichern.png")));
		btnSpeichern.setBounds(175, 350, 144, 38);
		contentPane.add(btnSpeichern);
						
//btnZurueck		
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
			
//Hintergrund		
		JLabel Hintergrund = new JLabel();
		Hintergrund.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Hintergrund.setHorizontalAlignment(SwingConstants.CENTER);
		Hintergrund.setForeground(Color.BLACK);
		Hintergrund.setIcon(new ImageIcon(KategorieAnlegen.class.getResource("/Design/GUI3.png")));
		Hintergrund.setBounds(0, 0, 480, 480);
		contentPane.add(Hintergrund);
								
//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
		setUndecorated(true);
		setLocationRelativeTo(null);		
	}

}
