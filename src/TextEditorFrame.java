import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextEditorFrame extends JFrame implements ActionListener {

	JTextField textField;

	TextEditorFrame() {
		// initialise JFrame Properties
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setTitle("Text Editor");
		this.setSize(500, 500);
		this.setResizable(true);

		textField = new JTextField();
		textField.setPreferredSize(new Dimension(500, 500));
		textField.setFont(new Font("Consolas", Font.PLAIN, 11)); // default font is Consolas and size 11
		textField.setForeground(new Color(0xFFFFFF)); // default color is black
		textField.setBackground(Color.white);
		textField.setCaretColor(Color.black);

		this.add(textField);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
