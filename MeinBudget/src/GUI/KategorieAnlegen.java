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
		lblKategorie.setBounds(273, 104, 145, 30);
		contentPane.add(lblKategorie);
				
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
