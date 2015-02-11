import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class DogHumanGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Human human;
	private Dog dog; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DogHumanGUI frame = new DogHumanGUI();
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
	public DogHumanGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

																	//Textboxarna
		JTextArea textArea = new JTextArea();
		textArea.setBounds(49, 178, 469, 77);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(49, 267, 469, 51);
		contentPane.add(textArea_1);
																	//Texter på boxarna
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(49, 161, 61, 16);
		contentPane.add(lblInfo);
		
		JLabel lblErrorMessage = new JLabel("Error Message");
		lblErrorMessage.setBounds(49, 253, 134, 16);
		contentPane.add(lblErrorMessage);
		
															//Knapp för att skapa människa
		JButton btnNewHuman = new JButton("New Human");
		btnNewHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
						 if (textField.getText().length() < 3){
							 textArea_1.setText("Must be more than three letters");
						 } else{
							 human = new Human(textField.getText());
							 textArea_1.setText("");
				}			 
			}
		}
			);
		btnNewHuman.setBounds(262, 24, 117, 29);
		contentPane.add(btnNewHuman);
															//Knapp för att skapa hund
		JButton btnBuyDog = new JButton("Buy Dog");
		btnBuyDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(human == null){
					textArea_1.setText("You must enter a human first");
				}else{
					dog = new Dog(textField_1.getText());
					human.buyDog(dog); 
				}
				
				
			}
		});
		btnBuyDog.setBounds(262, 65, 117, 29);
		contentPane.add(btnBuyDog);
															//Printar texten i textfältet.
		JButton btnNewButton = new JButton("Print Info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(human.getInfo());
				
			}
		});
		btnNewButton.setBounds(262, 126, 149, 29);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(68, 23, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(68, 64, 134, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
	
	}
}
