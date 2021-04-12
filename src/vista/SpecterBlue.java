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
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;

public class SpecterBlue extends JDialog {
	private JTextField textField;
	private JList listServicios = new JList();
	private DefaultListModel modeloServicios = new DefaultListModel();
	private DefaultListModel modeloSeleccion = new DefaultListModel();
	private DefaultTableModel modeloTabla;
	
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
	
	public void mueveServicio () {
		int servicio_seleccionado = listServicios.getSelectedIndex();
		
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
		
		JButton btnAdd = new JButton("<");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnAdd.setBounds(803, 351, 90, 80);
		getContentPane().add(btnAdd);
		
		JButton btnLess = new JButton(">");
		btnLess.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnLess.setBounds(803, 456, 90, 80);
		getContentPane().add(btnLess);
		
		modeloTabla = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"n","Nombre"
			}
		);
		Object [] fila = new Object[2];
		fila[0] = "dato columna 1";
		fila[1] = "dato columna 3";
		modeloTabla.addRow ( fila ); // Añade una fila al final
		
		table = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"wdd", "n", "Nombre"
			}
		));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(25, 292, 739, 419);
		getContentPane().add(table);
		
		//LOGICA
		aServicios = new ArrayList<Servicios>();
		cargarLista();
		
	}
}
