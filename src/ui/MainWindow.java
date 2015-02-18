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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(50, 187, 800, 167);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(50, 364, 800, 167);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(50, 541, 800, 167);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel label = new JLabel("New label");
		label.setBounds(50, 10, 800, 167);
		frame.getContentPane().add(label);
		
		Image plane = Toolkit.getDefaultToolkit().getImage("PossiblyTheBestTitlePhraseEver.png");
		BackgroundPanel panel = new BackgroundPanel(plane,BackgroundPanel.ACTUAL);
		panel.setLayout(null);
		panel.setBounds(23, 76, 30, 100);
		frame.getContentPane().add(panel);
		
		JCheckBox chckbxHi = new JCheckBox("hi");
		chckbxHi.setBounds(6, 44, 97, 23);
		panel.add(chckbxHi);
	}
}
