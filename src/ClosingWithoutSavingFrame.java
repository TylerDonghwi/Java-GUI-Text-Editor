import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClosingWithoutSavingFrame extends JFrame {

	JLabel label;
	JButton yes;
	JButton no;
	JButton cancel;

	public ClosingWithoutSavingFrame() {

		label = new JLabel();
		label.setText("Close without saving?");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);

		label.setBackground(Color.black);
		label.setOpaque(true); // background color

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setLayout(null);
		this.setLocationRelativeTo(null); // it will be created at the middle of the screen
		this.setResizable(false);

//		yes = new JButton("yes");
//		no = new JButton("no");
//		cancel = new JButton("cancel");

//		this.add(yes);
//		this.add(no);
//		this.add(cancel);
		this.setVisible(true);
		this.add(label);
	}
}
