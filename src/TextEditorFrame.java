import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import javax.swing.filechooser.FileNameExtensionFilter;

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

	// Menu bar declarations
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem newFile;
	JMenuItem openFile;
	JMenuItem saveFile;
	JMenuItem saveAsFile;
	JMenuItem exitFile;

	Boolean fileExist;
	File existingFile;

	TextEditorFrame() {
		fileExist = false;

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
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Text Editor");
		this.setSize(600, 600);
		this.setLayout(new FlowLayout());
		this.setMinimumSize(new Dimension(100, 100));
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
		// initialise the scroll bar
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
		saveAsFile = new JMenuItem("Save as");
		exitFile = new JMenuItem("Exit");

		// actions
		newFile.addActionListener(this);
		openFile.addActionListener(this);
		saveFile.addActionListener(this);
		saveAsFile.addActionListener(this);
		exitFile.addActionListener(this);

		// menu bar mnemonics
		fileMenu.setMnemonic(KeyEvent.VK_F); // Alt + f for file
		newFile.setMnemonic(KeyEvent.VK_N);
		openFile.setMnemonic(KeyEvent.VK_O);
		saveFile.setMnemonic(KeyEvent.VK_S);
		saveAsFile.setMnemonic(KeyEvent.VK_A);
		exitFile.setMnemonic(KeyEvent.VK_E);

		// adding elements
		fileMenu.add(newFile);
		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		fileMenu.add(saveAsFile);
		fileMenu.add(exitFile);
		menuBar.add(fileMenu);

	}

	public void saveFile() {
		PrintWriter fileOut = null;

		if (fileExist == false) {
			// if the file doesn't exist, create a new file
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));

			int response = fileChooser.showSaveDialog(null);

			if (response == JFileChooser.APPROVE_OPTION) {
				File file;

				file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				try {
					fileOut = new PrintWriter(file);
					fileOut.println(textBox.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} finally {
					existingFile = fileChooser.getSelectedFile();
					fileOut.close();
				}

			}

			fileExist = true;
		} else {
			try {
				fileOut = new PrintWriter(existingFile);

				fileOut.println(textBox.getText());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				fileOut.close();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// change text colour
		if (e.getSource() == textColourButton) {
			colourChooser = new JColorChooser();
			textColour = colourChooser.showDialog(null, "Text Colour", textColour);
			textBox.setForeground(textColour);
		}

		// change the background colour
		if (e.getSource() == backgroundColourButton) {
			colourChooser = new JColorChooser();
			backgroundColour = colourChooser.showDialog(null, "Background Colour", backgroundColour);
			textBox.setBackground(backgroundColour);
		}

		// change the font
		if (e.getSource() == fontBox) {
			textBox.setFont(new Font((String) fontBox.getSelectedItem(), Font.PLAIN, textBox.getFont().getSize()));
		}

		// create a new gui window
		if (e.getSource() == newFile) {
			new TextEditorFrame();
		}

		// open existing text file
		if (e.getSource() == openFile) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));

			// only accepts txt files
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
			fileChooser.setFileFilter(filter);

			int response = fileChooser.showSaveDialog(null);

			if (response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				Scanner fileIn = null;

				try {
					fileIn = new Scanner(file);
					if (file.isFile()) {
						while (fileIn.hasNextLine()) {
							String line = fileIn.nextLine() + "\n";
							textBox.append(line);
						}
					}

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} finally {
					existingFile = fileChooser.getSelectedFile();
					fileIn.close();
				}

				// TODO opening file should allow saving it overwrites over it
			}

		}

		// save file
		if (e.getSource() == saveFile) {
			saveFile();

		}

		if (e.getSource() == saveAsFile) {
			// create a new file and save it
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));

			int response = fileChooser.showSaveDialog(null);

			if (response == JFileChooser.APPROVE_OPTION) {
				File file;
				PrintWriter fileOut = null;
				file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				try {
					fileOut = new PrintWriter(file);
					fileOut.println(textBox.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} finally {
					fileOut.close();
				}

			}
		}

		// exit the program
		if (e.getSource() == exitFile) {
			if (true) {
				new ClosingWithoutSavingFrame(this);
			}
			// TODO add a feature for the program to see if the file is changed from last
			// saved
		}
	}
}
