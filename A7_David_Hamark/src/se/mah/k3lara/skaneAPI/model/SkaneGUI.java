package se.mah.k3lara.skaneAPI.model;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

public class SkaneGUI extends JFrame {
	JTextArea textArea = new JTextArea();
	JTextArea textArea_1 = new JTextArea();
	JTextArea textArea_2 = new JTextArea();
	JTextArea textArea_3 = new JTextArea();
	static private Parser p = new Parser();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SkaneGUI frame = new SkaneGUI();
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
	public SkaneGUI() {
		
		Thread t = new ThreadJourney(p);
		t.start();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(6, 6, 557, 319);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUbtshallen = new JLabel("UBÅTSHALLEN");
		lblUbtshallen.setFont(new Font("Helvetica", Font.PLAIN, 20));
		lblUbtshallen.setForeground(Color.ORANGE);
		lblUbtshallen.setBounds(210, 20, 150, 33);
		panel.add(lblUbtshallen);
		
		JLabel lblLinje = new JLabel("Linje");
		lblLinje.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblLinje.setForeground(Color.ORANGE);
		lblLinje.setBounds(19, 56, 61, 16);
		panel.add(lblLinje);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblDestination.setForeground(Color.ORANGE);
		lblDestination.setBounds(66, 56, 88, 16);
		panel.add(lblDestination);
		
		JLabel lblAvgr = new JLabel("Avgår");
		lblAvgr.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblAvgr.setForeground(Color.ORANGE);
		lblAvgr.setBounds(328, 56, 61, 16);
		panel.add(lblAvgr);
		
		JLabel lblFrsening = new JLabel("Försening");
		lblFrsening.setFont(new Font("Helvetica", Font.PLAIN, 13));
		lblFrsening.setForeground(Color.ORANGE);
		lblFrsening.setBounds(435, 56, 73, 16);
		panel.add(lblFrsening);
		
		
		textArea_1.setBackground(Color.GRAY);
		textArea_1.setBounds(19, 89, 279, 196);
		panel.add(textArea_1);
		
		
		textArea_2.setBackground(Color.GRAY);
		textArea_2.setBounds(328, 89, 208, 196);
		panel.add(textArea_2);
	}
	public class ThreadJourney extends Thread{
		private Parser par; 
		
		public ThreadJourney (Parser p){
			this.par = p; 
			textArea.setText("searching..."); 
		}
public void run(){
			
			System.out.println("// Busses departing from Ubåtshallen stationsnummer 80046 ");
			Lines lines = Parser.getStationResults(new Station("80046"));
			textArea.setText("");
			for (Line l : lines.getLines()) {
				
				textArea_1.append(l.getLine() + "  -  " + l.getDestination()+ "\n");
				//textArea_2.append(l.getDepTime().get(Calendar.HOUR_OF_DAY)+":"+l.getDepTime().get(Calendar.MINUTE) +"\n");
				textArea_2.append(l.getDepTime().get(Calendar.HOUR_OF_DAY)+":"+l.getDepTime().get(Calendar.MINUTE) + "         " + "and is " +  l.getDepTimeDeviation()+" minutes late"+ "\n");
				
			}
}
}
	}
