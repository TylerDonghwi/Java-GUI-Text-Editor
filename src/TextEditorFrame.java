import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextEditorFrame extends JFrame implements ActionListener {

	JTextArea textBox;
	JScrollPane scrollPane;

	TextEditorFrame() {
		// initialise JFrame Properties
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setTitle("Text Editor");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null); // it will be created at the middle of the screen
		this.setResizable(true);

		textBox = new JTextArea();
		textBox.setPreferredSize(new Dimension(500, 500));
		textBox.setLineWrap(true);
		textBox.setWrapStyleWord(true);
		textBox.setFont(new Font("Consolas", Font.PLAIN, 11)); // default font is Consolas and size 11
		textBox.setForeground(new Color(0x000000)); // default color is black
		textBox.setBackground(Color.white);
		textBox.setCaretColor(Color.black);

		scrollPane = new JScrollPane(textBox);

		this.add(scrollPane);
		this.add(textBox);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
