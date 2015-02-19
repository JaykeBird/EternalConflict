package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.SwingConstants;

public class CharacterSelect {

	private JFrame frame;
	private final Action action = new SwingAction_1();
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CharacterSelect window = new CharacterSelect();
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
	public CharacterSelect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnChar1 = new JButton("Character 1");
		btnChar1.setBounds(91, 109, 118, 104);
		frame.getContentPane().add(btnChar1);
		
		JButton brnChar2 = new JButton("Character 2");
		brnChar2.setBounds(300, 109, 118, 104);
		frame.getContentPane().add(brnChar2);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(509, 109, 118, 104);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(718, 109, 118, 104);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(927, 109, 118, 104);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(1136, 109, 118, 104);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(91, 255, 118, 104);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("New button");
		button_6.setBounds(300, 255, 118, 104);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("New button");
		button_7.setBounds(509, 255, 118, 104);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("New button");
		button_8.setBounds(718, 255, 118, 104);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("New button");
		button_9.setBounds(927, 255, 118, 104);
		frame.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("New button");
		button_10.setBounds(1136, 255, 118, 104);
		frame.getContentPane().add(button_10);
		
		JLabel lblNewLabel = new JLabel("Placeholder for images of selected character");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(91, 456, 327, 263);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPlaceholderForImages = new JLabel("Placeholder for images of selected character\r\n");
		lblPlaceholderForImages.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaceholderForImages.setBounds(927, 456, 327, 263);
		frame.getContentPane().add(lblPlaceholderForImages);
		
		JLabel lblNewLabel_1 = new JLabel("Stats");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(428, 472, 200, 247);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblStats = new JLabel("Stats");
		lblStats.setHorizontalAlignment(SwingConstants.CENTER);
		lblStats.setBounds(717, 472, 200, 247);
		frame.getContentPane().add(lblStats);
		
		JLabel lblNewLabel_2 = new JLabel("CHARACTER SELECTION (Will be image here that says character selection)");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(509, 11, 327, 62);
		frame.getContentPane().add(lblNewLabel_2);
	}
	
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
