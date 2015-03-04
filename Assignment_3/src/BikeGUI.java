import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;


public class BikeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtColor;
	private JTextField txtPrice;
	private JTextField txtPrice_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BikeGUI frame = new BikeGUI();
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
	public BikeGUI() {
		
		final BikeStore BikeStore = new BikeStore();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 438, 266);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 207, 254);
		panel.add(scrollPane);
		
		JTextArea txtrBikes = new JTextArea();
		scrollPane.setViewportView(txtrBikes);
		txtrBikes.append(BikeStore.getAllBikes());
		
		txtColor = new JTextField();
		txtColor.setBounds(260, 25, 134, 28);
		panel.add(txtColor);
		txtColor.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(260, 85, 134, 28);
		panel.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtPrice_1 = new JTextField();
		txtPrice_1.setBounds(260, 138, 134, 28);
		panel.add(txtPrice_1);
		txtPrice_1.setColumns(10);
		
		JButton btnSpara = new JButton("Search");
		btnSpara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String colorInput = txtColor.getText();
					int sizeInput = Integer.parseInt(txtPrice.getText());
					int priceInput = Integer.parseInt(txtPrice_1.getText());
					
					BikeStore.addBike(colorInput, sizeInput, priceInput);
					txtrBikes.append(BikeStore.getAllBikes());
					}
					catch (NumberFormatException ex){
						txtrBikes.append("Specify color, size and price \n" + "\n");
					}
				
			}
		});
		btnSpara.setBounds(260, 197, 117, 29);
		panel.add(btnSpara);
		
		JLabel lblFrg = new JLabel("Color");
		lblFrg.setBounds(263, 6, 61, 16);
		panel.add(lblFrg);
		
		JLabel lblStorlek = new JLabel("Size");
		lblStorlek.setBounds(260, 65, 61, 16);
		panel.add(lblStorlek);
		
		JLabel lblPris = new JLabel("Price");
		lblPris.setBounds(260, 125, 61, 16);
		panel.add(lblPris);
	}
}
