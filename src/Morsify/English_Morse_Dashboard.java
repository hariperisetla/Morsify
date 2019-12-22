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

public class English_Morse_Dashboard extends JFrame {

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
					English_Morse_Dashboard frame = new English_Morse_Dashboard();
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
	public English_Morse_Dashboard() {
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
		Morse_textArea.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		Morse_textArea.setBounds(30, 289, 654, 134);
		contentPane.add(Morse_textArea);
		
		JTextArea English_textArea = new JTextArea();
		English_textArea.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		English_textArea.setBounds(30, 95, 654, 134);
		contentPane.add(English_textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 95, 654, 134);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(682, 421, -653, -134);
		contentPane.add(scrollPane_1);
		
		JLabel lblEnglishText = new JLabel("English Text");
		lblEnglishText.setForeground(Color.WHITE);
		lblEnglishText.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		lblEnglishText.setBounds(30, 62, 279, 22);
		contentPane.add(lblEnglishText);
		
		JLabel lblMorseCode = new JLabel("Morse Code");
		lblMorseCode.setForeground(Color.WHITE);
		lblMorseCode.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		lblMorseCode.setBounds(27, 265, 279, 22);
		contentPane.add(lblMorseCode);
		
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
				String s = English_textArea.getText();
				
				// translateToMorse tm = new translateToMorse();
				String englishText = s.toLowerCase();
				String output = new String(englishText);
				//	System.out.println(englishString());
				output = "";
					for(int i=0; i<englishText.length(); i++) {	
						System.out.print(translateMorse(englishText.charAt(i)));
						System.out.print(" ");
						
						output = output + translateMorse(englishText.charAt(i)) + " ";
						
						
						
					}
					
					Morse_textArea.setText(output);
				
			}
			
			public String translateMorse(char e) {
				switch(e) {
				
				case 'a': return ".-";
				
				case 'b': return "-...";
				
				case 'c': return "-.-.";
				
				case 'd': return "-..";
				
				case 'e': return ".";
				
				case 'f': return "..-.";
				
				case 'g': return "--.";
			
				case 'h': return "....";
				
				case 'i': return "..";
				
				case 'j': return ".---";
				
				case 'k': return "-.-";
				
				case 'l': return ".-..";
				
				case 'm': return "--";
				
				case 'n': return "-.";
				
				case 'o': return "---";
				
				case 'p': return ".--.";
				
				case 'q': return "--.-";
				
				case 'r': return ".-.";
				
				case 's': return "...";
				
				case 't': return "-";
				
				case 'u': return "..-";
				
				case 'v': return "...-";
				
				case 'w': return ".--";
				
				case 'x': return "-..-";
				
				case 'y': return "-.--";
				
				case 'z': return "--..";
				
				
				
				default: return "Please Enter a Valid String!";
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
		
		setUndecorated(true);
		setLocationRelativeTo(null);

	}
}
