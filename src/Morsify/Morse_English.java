package Morsify;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseMotionAdapter;

public class Morse_English extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int mouseX;
	int mouseY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Morse_English frame = new Morse_English();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Morse_English() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 465);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(java.awt.event.MouseEvent arg0) {
				int cordinateX = arg0.getXOnScreen();
				int cordinateY = arg0.getYOnScreen();
				
				
				setLocation(cordinateX-mouseX, cordinateY-mouseY);
			}
			
		});
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		lblX.setForeground(Color.WHITE);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblX.setBackground(Color.WHITE);
		lblX.setBounds(681, 11, 24, 14);
		contentPane.add(lblX);
		
		JTextArea Morse_textArea = new JTextArea();
		Morse_textArea.setLineWrap(true);
		Morse_textArea.setWrapStyleWord(true);
		Morse_textArea.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		Morse_textArea.setBounds(30, 96, 654, 134);
		contentPane.add(Morse_textArea);
		
		JScrollPane scrollPane = new JScrollPane(Morse_textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(30, 95, 654, 134);
		contentPane.add(scrollPane);
		
		JTextArea English_textArea = new JTextArea();
		English_textArea.setLineWrap(true);
		English_textArea.setWrapStyleWord(true);
		English_textArea.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		English_textArea.setBounds(30, 289, 654, 134);
		contentPane.add(English_textArea);
		
		JScrollPane scrollPane1 = new JScrollPane(English_textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane1.setBounds(29, 300, 654, 134);
		contentPane.add(scrollPane1);
		
		JLabel lblMorseText = new JLabel("Morse Code");
		lblMorseText.setForeground(Color.WHITE);
		lblMorseText.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		lblMorseText.setBounds(30, 62, 279, 22);
		contentPane.add(lblMorseText);
		
		JLabel lblEnglishCode = new JLabel("English Text");
		lblEnglishCode.setForeground(Color.WHITE);
		lblEnglishCode.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		lblEnglishCode.setBounds(27, 265, 279, 22);
		contentPane.add(lblEnglishCode);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dashboard h = new Dashboard();
				h.setVisible(true);
				
				dispose();
			}
		});
		btnMenu.setBackground(Color.WHITE);
		btnMenu.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		btnMenu.setBounds(30, 11, 118, 31);
		contentPane.add(btnMenu);
		
		JButton btnTranslate = new JButton("Translate");
		btnTranslate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = Morse_textArea.getText();
				
				// translateToMorse tm = new translateToMorse();
				String morseText = s.toLowerCase();
				String output = new String(morseText);
				//	System.out.println(englishString());
				String[] letters = morseText.split("\\s");
				output = "";
					for(String m:letters) {	
						
						output = output + translateMorse(m);
						
					}
					
					English_textArea.setText(output);
				
			}
			
			public String translateMorse(String l) {
				switch(l) {
				
				case ".-": return "A";
				
				case "-...": return "B";
				
				case "-.-.": return "C";
				
				case "-..": return "D";
				
				case ".": return "E";
				
				case "..-.": return "F";
				
				case "--.": return "G";
			
				case "....": return "H";
				
				case "..": return "I";
				
				case ".---": return "J";
				
				case "-.-": return "K";
				
				case ".-..": return "L";
				
				case "--": return "M";
				
				case "-.": return "N";
				
				case "---": return "0";
				
				case ".--.": return "P";
				
				case "--.-": return "Q";
				
				case ".-.": return "R";
				
				case "...": return "S";
				
				case "-": return "T";
				
				case "..-": return "U";
				
				case "...-": return "V";
				
				case ".--": return "W";
				
				case "-..-": return "X";
				
				case "-.--": return "Y";
				
				case "--..": return "Z";
				
				case " ": return " ";
				
				case "   ": return "    ";
				
				case "/": return " ";

				default : return "";
				
				}
		}
		});
		btnTranslate.setBackground(Color.WHITE);
		btnTranslate.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnTranslate.setBounds(572, 240, 112, 23);
		contentPane.add(btnTranslate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				English_textArea.setText(null);
				Morse_textArea.setText(null);
			}
		});
		btnClear.setBackground(Color.WHITE);
		btnClear.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		btnClear.setBounds(421, 240, 112, 23);
		contentPane.add(btnClear);
		
		JLabel test_label = new JLabel("");
		test_label.setBackground(Color.WHITE);
		test_label.setForeground(Color.BLACK);
		test_label.setBounds(129, 240, 245, 31);
		contentPane.add(test_label);
		
		JLabel lblPleaseAddA = new JLabel("Please add a  space after each letter and \" / \" after each word.");
		lblPleaseAddA.setForeground(Color.WHITE);
		lblPleaseAddA.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblPleaseAddA.setBounds(235, 69, 449, 14);
		contentPane.add(lblPleaseAddA);
		
		setUndecorated(true);
		setLocationRelativeTo(null);

	}
}

