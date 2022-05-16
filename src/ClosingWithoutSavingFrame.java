import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClosingWithoutSavingFrame extends JFrame implements ActionListener {

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
		this.setSize(400, 150);
		this.setLayout(null);
		this.setLocationRelativeTo(null); // it will be created at the middle of the screen
		this.setResizable(false);

		yes = new JButton("yes");
		yes.setBounds(30, 60, 100, 40);
		yes.addActionListener(this);
		yes.setFocusable(false);
		yes.setFont(new Font("Arial", Font.BOLD, 25));
		yes.setBorder(BorderFactory.createEtchedBorder());

		no = new JButton("no");
		no.setBounds(145, 60, 100, 40);
		no.addActionListener(this);
		no.setFocusable(false);
		no.setFont(new Font("Arial", Font.BOLD, 25));
		no.setBorder(BorderFactory.createEtchedBorder());

		cancel = new JButton("cancel");
		cancel.setBounds(260, 60, 100, 40);
		cancel.addActionListener(this);
		cancel.setFocusable(false);
		cancel.setFont(new Font("Arial", Font.BOLD, 25));
		cancel.setBorder(BorderFactory.createEtchedBorder());

		this.add(yes);
		this.add(no);
		this.add(cancel);
		this.add(label);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
