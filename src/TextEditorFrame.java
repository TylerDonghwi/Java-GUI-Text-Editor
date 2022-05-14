import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TextEditorFrame extends JFrame implements ActionListener {

	JTextArea textBox;
	JScrollPane scrollPane;
	JSpinner fontSizeSpinner;
	JLabel fontLabel;

	TextEditorFrame() {
		// initialise JFrame Properties
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Text Editor");
		this.setSize(600, 600);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null); // it will be created at the middle of the screen
		this.setResizable(true);

		// Setting up the text area
		textBox = new JTextArea();
		textBox.setLineWrap(true);
		textBox.setWrapStyleWord(true);
		textBox.setFont(new Font("Consolas", Font.PLAIN, 11)); // default font is Consolas and size 11

		// Scroll Pane for scroll bars
		scrollPane = new JScrollPane(textBox);
		scrollPane.setPreferredSize(new Dimension(500, 500));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		// label for font spinner
		fontLabel = new JLabel();
		fontLabel.setText("Font:");

		// font size spinner
		fontSizeSpinner = new JSpinner();
		fontSizeSpinner.setPreferredSize(new Dimension(50, 25));
		fontSizeSpinner.setValue(11);
		fontSizeSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				textBox.setFont(new Font(textBox.getFont().getFamily(), Font.PLAIN, (int) fontSizeSpinner.getValue()));
			}

		});

		// Adding all the components together
		this.add(fontLabel);
		this.add(fontSizeSpinner);
		this.add(scrollPane);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
