package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSpecterBlue = new JButton("SPECTER BLUE");
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Main frame = new Main();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSpecterBlue) {
			SpecterBlue s = new SpecterBlue();
			s.setVisible(true);
		}
		
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSpecterBlue.setBounds(0, 0, 200, 292);
		contentPane.add(btnSpecterBlue);
		btnSpecterBlue.addActionListener(this);
		
		JButton btnSpecter1824 = new JButton("SPECTER 1824");
		btnSpecter1824.setBounds(200, 0, 200, 292);
		contentPane.add(btnSpecter1824);
		
		JButton btnSpecterAgency = new JButton("SPECTER AGENCY");
		btnSpecterAgency.setBounds(400, 0, 200, 292);
		contentPane.add(btnSpecterAgency);
	}
	
}
