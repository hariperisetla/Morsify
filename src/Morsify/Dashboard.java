package Morsify;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;

public class Dashboard extends JFrame {

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
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 451);
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
			public void mouseDragged(MouseEvent e) {
				int cordinateX = e.getXOnScreen();
				int cordinateY = e.getYOnScreen();
				
				
				setLocation(cordinateX-mouseX, cordinateY-mouseY);
			}
		});
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMorsify = new JLabel("MORSIFY");
		lblMorsify.setBounds(2, 30, 650, 55);
		lblMorsify.setHorizontalAlignment(SwingConstants.CENTER);
		lblMorsify.setForeground(Color.WHITE);
		lblMorsify.setFont(new Font("Bahnschrift", Font.BOLD, 45));
		contentPane.add(lblMorsify);
		
		JLabel lblAMorseCode = new JLabel("A Morse Code Translator");
		lblAMorseCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblAMorseCode.setForeground(Color.CYAN);
		lblAMorseCode.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblAMorseCode.setBounds(213, 88, 227, 22);
		contentPane.add(lblAMorseCode);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(619, 11, 31, 22);
		contentPane.add(lblX);
		
		JButton btnNewButton = new JButton("English to Morse Code");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("English to Morse Clicked!");
				English_Morse_Dashboard em = new English_Morse_Dashboard();
				em.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(197, 182, 265, 47);
		contentPane.add(btnNewButton);
		
		JButton btnMorseCodeTo = new JButton("Morse Code to English");
		btnMorseCodeTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Morse to English Clicked!");
			}
		});
		btnMorseCodeTo.setForeground(Color.BLACK);
		btnMorseCodeTo.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnMorseCodeTo.setBackground(Color.WHITE);
		btnMorseCodeTo.setBounds(197, 266, 265, 47);
		contentPane.add(btnMorseCodeTo);
		
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
