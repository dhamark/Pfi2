import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;


public class DigitalClockGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldHour;
	private JTextField textFieldMin;
	private JTextField textAlarmSet;
	private JTextField textClock;
	private ClockLogic clockLogic; 

	JLabel lblAlarmClock = new JLabel("00:00:00");
	JLabel lblAlarmset = new JLabel("No Alarm");
	JButton btnClearAlarm = new JButton("Clear Alarm");
	JLabel lblErrorMsg = new JLabel("");
	JLabel lblAlarmMsg = new JLabel("");
	
	JLabel bakgrund = new JLabel("");
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
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
	public DigitalClockGUI() {
		setBackground(new Color(245, 222, 179));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSetAlarm = new JButton("Set Alarm");
		btnSetAlarm.setFont(new Font("Lithos Pro", Font.PLAIN, 13));
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int hourCheck = Integer.parseInt(textFieldHour.getText());
			    int minuteCheck = Integer.parseInt(textFieldMin.getText());

			    if (hourCheck < 0 || hourCheck > 23 || minuteCheck < 0
			      || minuteCheck > 59) {
			     textAlarmSet.setText("Not valid");
			    } else {
			     String s4 = "";
			     String s5 = "";
			     
			     if (hourCheck < 10){
				      s4 = "0";
				     }
				     if (minuteCheck < 10){
				      s5 = "0";
				     }
				     
				     textAlarmSet.setText(s4 + hourCheck + ":" + s5 + minuteCheck);
				     
				     clockLogic.setAlarm(hourCheck, minuteCheck);
			    }
			    }
		});
		btnSetAlarm.setBounds(17, 230, 117, 29);
		contentPane.add(btnSetAlarm);
		
		JButton btnClearAlarm = new JButton("Clear Alarm");
		btnClearAlarm.setFont(new Font("Lithos Pro", Font.BOLD, 13));
		btnClearAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldHour.setText("");
				textFieldMin.setText("");
				textAlarmSet.setText("No Alarm");
				clockLogic.clearAlarm();
			}
		});
		btnClearAlarm.setBounds(140, 230, 117, 29);
		contentPane.add(btnClearAlarm);
		
		textFieldHour = new JTextField();
		textFieldHour.setBounds(99, 190, 104, 28);
		contentPane.add(textFieldHour);
		textFieldHour.setColumns(10);
		
		textFieldMin = new JTextField();
		textFieldMin.setBounds(305, 190, 104, 28);
		contentPane.add(textFieldMin);
		textFieldMin.setColumns(10);
		
		textAlarmSet = new JTextField();
		textAlarmSet.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		textAlarmSet.setBounds(269, 229, 134, 28);
		contentPane.add(textAlarmSet);
		textAlarmSet.setColumns(10);
		
		textClock = new JTextField();
		textClock.setFont(new Font("Marker Felt", Font.BOLD, 22));
		textClock.setBounds(245, 41, 186, 55);
		contentPane.add(textClock);
		textClock.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(17, 196, 61, 16);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(0, 0, 61, 16);
		panel.add(lblHours);
		lblHours.setFont(new Font("Lao MN", Font.BOLD, 15));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(215, 196, 104, 16);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setBounds(0, 0, 80, 16);
		panel_1.add(lblMinutes);
		lblMinutes.setFont(new Font("Lao MN", Font.BOLD, 15));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/images/pizzacomplete1.png")));
		lblNewLabel.setBounds(6, 6, 438, 266);
		contentPane.add(lblNewLabel);
		
		JLabel bakgrund = new JLabel("");
		bakgrund.setBounds(6, 0, 438, 272);
		contentPane.add(bakgrund);
		
				clockLogic = new ClockLogic(this);

			}
			public void setTimeOnLabel (String time){
				textClock.setText(time);
			}
			
			public void alarm (boolean activate){
				if (true) {
					textAlarmSet.setText("ALARM!");
				
					bakgrund.setBackground(new Color(28, 132, 170));
					
				}
				
	}
}
