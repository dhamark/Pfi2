import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;


import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JScrollPane;


public class GUI extends JFrame {

	private JPanel contentPane;
	JTextArea textArea = new JTextArea();

	JTextField textField = new JTextField();
	private Parser p = new Parser();
	JTextField textField_1 = new JTextField();
	JTextField textField_2 = new JTextField();
	JTextArea textArea_1 = new JTextArea();

	Thread T = new ThreadJourney( p, this);
	Thread T2 = new ThreadStation(p,this);
    GUI gui = this;
	//ArrayList<Station> searchStations = new ArrayList<Station>();
	//Journeys journeys = Parser.getJourneys(searchURL);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 331);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 316, 297);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 22, 134, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 121, 304, 170);
		panel.add(scrollPane_1);
		
		scrollPane_1.setViewportView(textArea);
		
		//Knappen för att söka station
		JButton btnSk = new JButton("Search Station");
		btnSk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				textArea.setText("söker\n");
				Thread T2 = new ThreadStation(p,GUI.this );
				T2.start();
				
				/*searchStations.addAll(Parser.getStationsFromURL(textField.getText())); // Lägger till stationer innehållandes malmö. 
				for (Station s: searchStations){
			       textArea.append(s.getStationName() + " number" + s.getStationNbr() + "\n");
				}*/
				
			}
		});
		btnSk.setBounds(6, 80, 117, 29);
		panel.add(btnSk);
		
		JLabel lblStation = new JLabel("Station");
		lblStation.setBounds(6, 6, 61, 16);
		panel.add(lblStation);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(323, 6, 269, 297);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(6, 31, 110, 28);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(153, 31, 110, 28);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(29, 6, 61, 16);
		panel_1.add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(185, 6, 61, 16);
		panel_1.add(lblTo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 123, 257, 168);
		panel_1.add(scrollPane);
		
		scrollPane.setViewportView(textArea_1);
		
	
		//Knapp för att söka resor
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Thread T = new ThreadJourney(p, GUI.this);
				T.start();
				
				/*String searchURL = Constants.getURL(textField_1.getText(),textField_2.getText(),20);
				
				Journeys journeys = Parser.getJourneys(searchURL);
				for (Journey journey : journeys.getJourneys()){
					
				textArea_1.append(journey.getStartStation()+" - ");
				textArea_1.append(""+journey.getEndStation());
				String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)
						+ ":" + journey.getDepDateTime().get(Calendar.MINUTE);
					textArea_1.append(" departs "  + time + " that is in "+journey.getTimeToDeparture()+ " minutes. And it is "
						+journey.getDepTimeDeviation()+" min late" +"\n");
				} */
				}
		}); 
		btnNewButton.setBounds(78, 71, 117, 29);
		panel_1.add(btnNewButton);
		
		
	
	}
}
