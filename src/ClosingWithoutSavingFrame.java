import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ClosingWithoutSavingFrame extends JFrame implements ActionListener {

	JButton yes;
	JButton no;
	JButton cancel;

	public ClosingWithoutSavingFrame() {

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Close without saving?");
		this.setSize(400, 100);
		this.setLayout(null);
		this.setLocationRelativeTo(null); // it will be created at the middle of the screen
		this.setResizable(false);

		// Yes button (save and close)
		yes = new JButton("yes");
		yes.setBounds(30, 15, 100, 40);
		yes.addActionListener(this);
		yes.setFocusable(false);
		yes.setFont(new Font("Arial", Font.BOLD, 25));
		yes.setBorder(BorderFactory.createEtchedBorder());

		// No button (don't save and close)
		no = new JButton("no");
		no.setBounds(145, 15, 100, 40);
		no.addActionListener(this);
		no.setFocusable(false);
		no.setFont(new Font("Arial", Font.BOLD, 25));
		no.setBorder(BorderFactory.createEtchedBorder());

		// Cancel button (don't save and don't close)
		cancel = new JButton("cancel");
		cancel.setBounds(260, 15, 100, 40);
		cancel.addActionListener(this);
		cancel.setFocusable(false);
		cancel.setFont(new Font("Arial", Font.BOLD, 25));
		cancel.setBorder(BorderFactory.createEtchedBorder());

		this.add(yes);
		this.add(no);
		this.add(cancel);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == yes) {
			System.out.println("yes");
		}
		if (e.getSource() == no) {
			System.out.println("no");
		}
		if (e.getSource() == cancel) {
			System.out.println("cancel");
		}

	}
}
