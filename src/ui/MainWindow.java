package ui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Adventure");
		btnNewButton.setBounds(50, 187, 800, 167);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("2-Player");
		btnNewButton_2.setBounds(50, 364, 800, 167);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Credits");
		btnNewButton_3.setBounds(50, 541, 800, 167);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel label = new JLabel("Eternal Conflict");
		label.setBounds(50, 10, 800, 167);
		frame.getContentPane().add(label);
		
		Image plane = Toolkit.getDefaultToolkit().getImage("PossiblyTheBestTitlePhraseEver.png");
		BackgroundPanel panel = new BackgroundPanel(plane,BackgroundPanel.ACTUAL);
		panel.setLayout(null);
		panel.setBounds(0, 0, 884, 729);
		frame.getContentPane().add(panel);
	}
}
