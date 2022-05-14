import javax.swing.JFrame;

public class TextEditorFrame extends JFrame {

	TextEditorFrame() {
		// initialise JFrame Properties
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Text Editor");
		this.setSize(500, 500);
		this.setResizable(true);

		this.setVisible(true);
	}
}
