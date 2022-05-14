import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
	JButton textColourButton;
	Color textColour;
	JButton backgroundColourButton;
	Color backgroundColour;
	JColorChooser colourChooser;
	JComboBox fontBox;

	// Menu bar declaration
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem newFile;
	JMenuItem openFile;
	JMenuItem saveFile;
	JMenuItem exitFile;

	TextEditorFrame() {

		setJFrame(); // initialise JFrame Properties
		setTextBox(); // Setting up the text area
		setScrollPane(); // Scroll Pane for scroll bars
		setFontSizeSpinner(); // font size spinner
		setTextColourButton(); // text colour changer
		setBackgroundColourButton(); // background colour changer
		setFontBox(); // font box
		setMenuBar(); // menu bar

		// Adding all the components together
		this.add(fontLabel);
		this.add(fontSizeSpinner);
		this.add(textColourButton);
		this.add(backgroundColourButton);
		this.add(fontBox);
		this.add(scrollPane);
		this.setJMenuBar(menuBar);

		// set the JFrame visible
		this.setVisible(true);
	}

	public void setJFrame() {
		// initialise JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Text Editor");
		this.setSize(600, 600);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null); // it will be created at the middle of the screen
		this.setResizable(true);

	}

	public void setTextBox() {
		// initialise text area
		textBox = new JTextArea();
		textBox.setLineWrap(true);
		textBox.setWrapStyleWord(true);
		textBox.setFont(new Font("Consolas", Font.PLAIN, 14)); // default font is Consolas and size 11
	}

	public void setScrollPane() {
		scrollPane = new JScrollPane(textBox);
		scrollPane.setPreferredSize(new Dimension(500, 500));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		// label for font spinner
		fontLabel = new JLabel();
		fontLabel.setText("Font:");
	}

	public void setFontSizeSpinner() {
		// set font size spinner
		fontSizeSpinner = new JSpinner();
		fontSizeSpinner.setPreferredSize(new Dimension(50, 25));
		fontSizeSpinner.setValue(14);
		fontSizeSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				textBox.setFont(new Font(textBox.getFont().getFamily(), Font.PLAIN, (int) fontSizeSpinner.getValue()));
			}

		});
	}

	public void setTextColourButton() {
		// for changing the colour of the text
		textColourButton = new JButton("Text Color");
		textColourButton.addActionListener(this);
	}

	public void setBackgroundColourButton() {
		// for changing the colour of the text
		backgroundColourButton = new JButton("Background Color");
		backgroundColourButton.addActionListener(this);
	}

	public void setFontBox() {
		// deriving an array of all the strings of available fonts in java
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontBox = new JComboBox(fonts);
		fontBox.addActionListener(this);
		fontBox.setSelectedItem("Arial");
	}

	public void setMenuBar() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		newFile = new JMenuItem("New");
		openFile = new JMenuItem("Open");
		saveFile = new JMenuItem("Save");
		exitFile = new JMenuItem("Exit");

		newFile.addActionListener(this);
		openFile.addActionListener(this);
		saveFile.addActionListener(this);
		exitFile.addActionListener(this);

		fileMenu.add(newFile);
		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		fileMenu.add(exitFile);
		menuBar.add(fileMenu);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == textColourButton) {
			colourChooser = new JColorChooser();
			textColour = colourChooser.showDialog(null, "Text Colour", textColour);
			textBox.setForeground(textColour);
		}
		if (e.getSource() == backgroundColourButton) {
			colourChooser = new JColorChooser();
			backgroundColour = colourChooser.showDialog(null, "Background Colour", backgroundColour);
			textBox.setBackground(backgroundColour);
		}
		if (e.getSource() == fontBox) {
			textBox.setFont(new Font((String) fontBox.getSelectedItem(), Font.PLAIN, textBox.getFont().getSize()));
		}

		if (e.getSource() == newFile) {

		}

		if (e.getSource() == openFile) {

		}
		if (e.getSource() == saveFile) {

		}
		if (e.getSource() == exitFile) {
			System.exit(0);
		}
	}
}
