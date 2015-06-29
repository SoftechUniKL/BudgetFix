package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Charts extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Charts frame = new Charts();
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
	public Charts() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		//Button Schliessen		
				final JLabel btnSchliessen = new JLabel();
				btnSchliessen.addMouseListener(new MouseAdapter() {
					@Override
					//Schliessenbutton in grau
					public void mouseEntered(MouseEvent arg0) {
						btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/schliessengross2.png")));
					}
					
					//Schliessenbutton ist blau
					@Override
					public void mouseExited(MouseEvent arg0) {
						btnSchliessen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Design/schliessengross.png")));
					}
					
					//Schliesst das Fenster
					@Override
					public void mouseClicked(MouseEvent arg0) {
						System.exit(0);
					}
				});
				
				btnSchliessen.setIcon(new ImageIcon(Start.class.getResource("/Design/schliessengross.png")));
				btnSchliessen.setBounds(1310, 20, 40, 40);
				contentPane.add(btnSchliessen);
				
		//Hintergrund		
				JLabel Hintergrund = new JLabel("");
				Hintergrund.setIcon(new ImageIcon(Start.class.getResource("/Design/GUI.png")));
				Hintergrund.setBounds(0, 0, 1365, 767);
				contentPane.add(Hintergrund);
				
				
		//Fullscreen Bildschirm
				setExtendedState(Frame.MAXIMIZED_BOTH);
		//Deaktivieren des Standard-JFrame Design und lege die Lage in Mitten des Bildschirms
				setUndecorated(true);
				setLocationRelativeTo(null);		
		
	}

}
