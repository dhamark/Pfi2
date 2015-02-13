import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;


public class Animals extends JFrame {
	
    ArrayList<Animal> animals; 
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Animals frame = new Animals();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Animals() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 23, 570, 255);
		contentPane.add(textArea);
		
		JLabel lblAnimals = new JLabel("Animals");
		lblAnimals.setBounds(23, 6, 61, 16);
		contentPane.add(lblAnimals);
		
		
		animals = new ArrayList <Animal>();
		
		animals.add(new Dog("Canis Latrans", 4, false, "Kallelito"));
		Cat cat = new Cat("lynx lynx", 3, 7);
		cat.setFriendlyName("misan");
		animals.add(cat);
		animals.add(new Cat("Lynx Lynx", 3, 7, "Kissemissen"));
		animals.add(new Dog("Canis Latrans", 4, true, "Fido"));
		animals.add(new Snake("Skallrus Huggus", false));
		animals.add(new Cat("MjauMjau", 5, 1));
		Cat cat2 = (new Cat("MjauMjau", 5, 1));
		cat2.setFriendlyName("Mjamson");
		animals.add(cat2);
		animals.add(new Snake("Huggus Ormus", true));
		animals.add(new Dog("Canis Latrans", 3, false, "Dumhuvud"));
		animals.add(new Snake("Majsus Ormus", false));
		animals.add(new Cat("Jamson Kattskrellus", 3, 5));
		animals.add(new Dog("Canis Latrans", 5, true, "Wolfgang"));
		animals.add(new Snake("Pyton Regius", true));
		
		for(int i = 0; i< animals.size(); i++){
			textArea.append(animals.get(i).getInfo() + "\n");
		}
	
	}
}
