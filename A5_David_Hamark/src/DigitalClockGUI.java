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
	
	
	//Random rand = new Random(); //Implementerar randomfunktionen för alarmet
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSetAlarm = new JButton("Set Alarm");
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int hourCheck = Integer.parseInt(textFieldHour.getText());
			    int minuteCheck = Integer.parseInt(textFieldMin.getText());

			    if (hourCheck < 0 || hourCheck > 23 || minuteCheck < 0
			      || minuteCheck > 59) {
			     textAlarmSet.setText("NEJ");
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
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(26, 196, 61, 16);
		contentPane.add(lblHours);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setBounds(232, 196, 61, 16);
		contentPane.add(lblMinutes);
		
		textAlarmSet = new JTextField();
		textAlarmSet.setBounds(269, 229, 134, 28);
		contentPane.add(textAlarmSet);
		textAlarmSet.setColumns(10);
		
		textClock = new JTextField();
		textClock.setBounds(245, 41, 186, 55);
		contentPane.add(textClock);
		textClock.setColumns(10);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/images/pizzacomplete1.png")));
		label.setBounds(0, 4, 444, 174);
		contentPane.add(label);
		
				clockLogic = new ClockLogic(this);

			}
			public void setTimeOnLabel (String time){
				textClock.setText(time);
			}
			
			public void alarm (boolean activate){
				if (true) {
					textAlarmSet.setText("ALARM!");
				}
				
	}
}
