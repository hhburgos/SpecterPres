package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.ModeloBlue;
import modelo.Servicios;

import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class SpecterBlue extends JDialog implements ActionListener {
	private int tableColumn = 4;
	
	private JTextField textField;
	private JList listServicios = new JList();
	private DefaultListModel modeloServicios = new DefaultListModel();
	private DefaultTableModel modeloTabla;
	private JButton btnAdd;
	private JButton btnLess;
	
	private ArrayList<Servicios> aServicios;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SpecterBlue dialog = new SpecterBlue();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			mueveServicio();
		} 
		else if (e.getSource() == btnLess) {
			quitaServicio();
		}
	}
	
	public void quitaServicio () {
		try {
			DefaultTableModel dtm = (DefaultTableModel) table.getModel(); //TableProducto es el nombre de mi tabla ;)
			dtm.removeRow(table.getSelectedRow());
		}
		catch (Exception e) {
//			System.out.println("no se ha seleccionado ninguna fila");
		}
	}
	
	public void mueveServicio () {
		int servicio_seleccionado = listServicios.getSelectedIndex();
		
		Object [] fila = new Object[tableColumn];
		fila[0] = aServicios.get(servicio_seleccionado).get_id();
		fila[1] = aServicios.get(servicio_seleccionado).getNombre();
		fila[2] = aServicios.get(servicio_seleccionado).getDescripcion();
		fila[3] = aServicios.get(servicio_seleccionado).getPrecio();
		modeloTabla.addRow ( fila ); // Añade una fila al final
	}
	
	/**
	 * Recoge del fichero obj correspondiente los distintos servicios del sector Blue y coloca los nombres de cada objeto servicio a la lista listServicios
	 */
	public void cargarLista () {
		ModeloBlue.leeFichero(aServicios);
		for (int i = 0; i < aServicios.size(); i++) {
			modeloServicios.add(i, aServicios.get(i).getNombre());
//			System.out.println("buc:"  + i);
		}
		listServicios.setModel(modeloServicios);
	}

	/**
	 * Create the dialog.
	 */
	public SpecterBlue() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(SpecterBlue.class.getResource("/img/icon.png")));
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 1426, 795);
		getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("LOGO");
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLogo.setBackground(Color.RED);
		lblLogo.setBounds(37, 30, 235, 65);
		getContentPane().add(lblLogo);
		
		ImageIcon imgIcon = new ImageIcon("specterBLUENEGRO.png");
        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblLogo.getWidth(),
                lblLogo.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        lblLogo.setIcon(iconoEscalado);
		
		listServicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listServicios.setBackground(Color.GRAY);
		listServicios.setBounds(925, 290, 446, 419);
		getContentPane().add(listServicios);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblCliente.setBounds(55, 179, 97, 44);
		getContentPane().add(lblCliente);
		
		textField = new JTextField();
		textField.setBounds(164, 179, 242, 45);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnGenera = new JButton("Genera PDF");
		btnGenera.setBounds(1274, 126, 97, 114);
		getContentPane().add(btnGenera);
		
		btnAdd = new JButton("<");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnAdd.setBounds(803, 351, 90, 80);
		getContentPane().add(btnAdd);
		btnAdd.addActionListener(this);
		
		btnLess = new JButton(">");
		btnLess.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnLess.setBounds(803, 456, 90, 80);
		getContentPane().add(btnLess);
		btnLess.addActionListener(this);
		
		creaTabla();
		
		//LOGICA
		aServicios = new ArrayList<Servicios>();
		cargarLista();
		
	}
	
	public void creaTabla() {
		modeloTabla = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Nombre","Descripción","Precio"
			}
		);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 292, 739, 419);
		getContentPane().add(scrollPane);
		
		table = new JTable(modeloTabla);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 120, 215), new Color(50, 205, 50), new Color(250, 128, 114), new Color(255, 20, 147)));
		table.setBackground(Color.WHITE);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		
		scrollPane.setViewportView(table);
	}

	
}
