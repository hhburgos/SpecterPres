package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelo.ModeloBlue;
import modelo.Prueba;
import modelo.Servicios;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class SpecterBlue extends JDialog implements ActionListener {
	private static final String [] logos = {"specterBLUENEGRO.png","specter1824.png"};
	private static final String nombre_pdf = "InformePresupuesto.pdf";
	private static final String ruta_jasperreport = "src\\\\vista\\\\presupuestos.jasper";
	
	private int tableColumn = 4;
	private String archivo_activo = Servicios.getFichServiciosBlue();
	private int modo = 0; //0.Blue 1.1824 2.Agency
	
	private JTextField textField;
	private JList listServicios = new JList();
	private DefaultListModel modeloServicios = new DefaultListModel();
	private DefaultTableModel modeloTabla;
	private JLabel lblLogoBlue;
	private JLabel lblLogo1824;
	private JButton btnAdd;
	private JButton btnLess;
	private JButton btnBlue;
	private JButton btn1824;
	private JButton btnAgency;
	private JButton btnGenera;
	private JButton btnVer;
	
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
//			JOptionPane.showMessageDialog( null, e.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
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
		else if (e.getSource() == btnBlue) {
			modo = 0;
			archivo_activo = Servicios.getFichServiciosBlue();
			cambiaSector();
		}
		else if (e.getSource() == btn1824) {
			modo = 1;
			archivo_activo = Servicios.getFichServicios1824();
			cambiaSector();
		}
		else if (e.getSource() == btnAgency) {
			modo = 2;
			archivo_activo = Servicios.getFichServiciosAgency();
			cambiaSector();
		}
		else if (e.getSource() == btnGenera) {
			generaInforme2();
		}
		else if (e.getSource() == btnVer) {
			generaInforme();
		}
	}
	
	/**
	 * Imprime el informe directamente en el directorio raiz del proyecto, por lo que hay que
	 * hacer algo con el nombre del doc que se generará si es el mismo siempre se cargará el anterior siempre
	 */
	public void generaInforme2 () {
		String nombre, descripcion;
		Double precio;
		List<Prueba> lista = new ArrayList<Prueba>();
		for (int i = 0; i < aServicios.size(); i++) {
			nombre = aServicios.get(i).getNombre();
			descripcion = aServicios.get(i).getDescripcion();
			precio = aServicios.get(i).getPrecio();
			lista.add(new Prueba(nombre,descripcion,precio));
		}
		
		JasperPrint jasperPrint = null; 
		try { 
			jasperPrint = JasperFillManager.fillReport(ruta_jasperreport, null,new JRBeanCollectionDataSource(lista)); 
		} catch (JRException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace(); 
//			JOptionPane.showMessageDialog( null, e1.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		} 
		JRPdfExporter exp = new JRPdfExporter(); 
		exp.setExporterInput(new SimpleExporterInput(jasperPrint)); 
		exp.setExporterOutput(new
		SimpleOutputStreamExporterOutput(nombre_pdf)); 
		JOptionPane.showMessageDialog( null, "Informe generado y almacenado", "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		try { 
			exp.exportReport(); 
		} catch (JRException e1) { // TODO Auto-generated catch block
			e1.printStackTrace(); 
//			JOptionPane.showMessageDialog( null, e1.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		}
		 
	}
	
	/**
	 * Muestra la vista previa del informe y da la opcion a imprirlo y donde
	 */
	public void generaInforme () { 
		String nombre, apellido;
		Double precio;
		List<Prueba> lista = new ArrayList<Prueba>();
		for (int i = 0; i < aServicios.size(); i++) {
			nombre = aServicios.get(i).getNombre();
			apellido = aServicios.get(i).getDescripcion();
			precio = aServicios.get(i).getPrecio();
			lista.add(new Prueba(nombre,apellido,precio));
		}
		
		System.out.println("Count aServicios: " + aServicios.size());
		JasperReport reporte;
		String path = "src\\\\vista\\\\presupuestos.jasper";
		try { 
			reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
			JasperPrint jprint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			viewer.setVisible(true);
		} catch (JRException e1) { 
			e1.printStackTrace(); 
//			JOptionPane.showMessageDialog( null, e1.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		} 
	}
	
	public void cambiaSector () {
		cambiaLogo();
		cargarLista();
	}
	
	public void cambiaLogo () {
		lblLogoBlue.setVisible(false);
		lblLogo1824.setVisible(false);
		
		switch (modo) {
		case 0: lblLogoBlue.setVisible(true); break;
		case 1: lblLogo1824.setVisible(true); break;
		case 2: lblLogo1824.setVisible(true); break; //cambiar por SpecterAgency
		default: System.out.println("fallo en cambiaLogo()"); break;
		}
	}
	
	public void quitaServicio () {
		try {
			DefaultTableModel dtm = (DefaultTableModel) table.getModel(); //TableProducto es el nombre de mi tabla ;)
			dtm.removeRow(table.getSelectedRow());
		}
		catch (Exception e) {
			e.printStackTrace();
//			System.out.println("no se ha seleccionado ninguna fila");
//			JOptionPane.showMessageDialog( null, e.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
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
		aServicios.clear();
		modeloServicios.clear();
		
		ModeloBlue.leeFicheroServicios(aServicios,archivo_activo);
		for (int i = 0; i < aServicios.size(); i++) {
			modeloServicios.add(i, aServicios.get(i).getNombre());
//			System.out.println("buc:"  + i);
		}
		listServicios.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
		
		lblLogoBlue = new JLabel("LOGO");
		lblLogoBlue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLogoBlue.setBackground(Color.RED);
		lblLogoBlue.setBounds(37, 30, 235, 65);
		getContentPane().add(lblLogoBlue);
		
		lblLogo1824 = new JLabel("LOGO");
		lblLogo1824.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLogo1824.setBackground(Color.RED);
		lblLogo1824.setBounds(37, 9, 235, 107);
		getContentPane().add(lblLogo1824);
		
		ImageIcon imgIcon = new ImageIcon("specterBLUENEGRO.png");
        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblLogoBlue.getWidth(),
                lblLogoBlue.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        lblLogoBlue.setIcon(iconoEscalado);
        
        ImageIcon imgIcon8 = new ImageIcon("specter1824.png");
        Image imgEscalada8 = imgIcon8.getImage().getScaledInstance(lblLogo1824.getWidth(),
                lblLogo1824.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado8 = new ImageIcon(imgEscalada8);
        lblLogo1824.setIcon(iconoEscalado8);
		
		listServicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listServicios.setBackground(Color.GRAY);
		listServicios.setBounds(925, 290, 446, 419);
		getContentPane().add(listServicios);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblCliente.setBounds(55, 179, 97, 44);
		getContentPane().add(lblCliente);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(164, 179, 242, 45);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnGenera = new JButton("OKEY");
		btnGenera.setFont(new Font("Tahoma", Font.BOLD, 18));
//		btnGenera.setIcon(new ImageIcon(SpecterBlue.class.getResource("/img/check-icon.png")));
		getContentPane().add(btnGenera);
		btnGenera.addActionListener(this);
		
		btnGenera.setBounds(1256, 183, 115, 80);
		ImageIcon imgIcon2 = new ImageIcon("/img/check-icon.png");
        Image imgEscalada2 = imgIcon2.getImage().getScaledInstance(btnGenera.getWidth(),
                btnGenera.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado2 = new ImageIcon(imgEscalada2);
		
		
		btnAdd = new JButton("<");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnAdd.setBounds(803, 391, 90, 80);
		getContentPane().add(btnAdd);
		btnAdd.addActionListener(this);
		
		btnLess = new JButton(">");
		btnLess.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnLess.setBounds(803, 496, 90, 80);
		getContentPane().add(btnLess);
		btnLess.addActionListener(this);
		
		btnVer = new JButton("Ver");
		btnVer.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnVer.setBounds(1106, 181, 127, 80);
		getContentPane().add(btnVer);
		btnVer.addActionListener(this);
	
		
		creaTabla();
		cambiaLogo();
		
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
		table.getColumnModel().getColumn(0).setHeaderRenderer(new MyRenderer(new Color(49, 198, 191),Color.black));
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBackground(Color.WHITE);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(370);
		table.setRowHeight(30);
		
		scrollPane.setViewportView(table);
		
		btnBlue = new JButton("SPECTER BLUE");
		btnBlue.setBackground(new Color(135, 206, 250));
		btnBlue.setBounds(882, 30, 155, 52);
		getContentPane().add(btnBlue);
		btnBlue.addActionListener(this);
		
		btn1824 = new JButton("SPECTER 1824");
		btn1824.setBackground(new Color(218, 165, 32));
		btn1824.setBounds(1049, 30, 155, 52);
		getContentPane().add(btn1824);
		btn1824.addActionListener(this);
		
		btnAgency = new JButton("SPECTER AGENCY");
		btnAgency.setBackground(new Color(240, 255, 255));
		btnAgency.setBounds(1216, 30, 155, 52);
		getContentPane().add(btnAgency);
		btnAgency.addActionListener(this);
		
	}
	
	/**
	 * Su método colorea las cabeceras de una jtable
	 * @author sburg
	 *
	 */
	public class MyRenderer extends DefaultTableCellRenderer {
		Color background;
		Color foreground;
		public MyRenderer (Color background,Color foreground) {
			super();
			this.background = background;
			this.foreground = foreground;
		}
		public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
			Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			comp.setBackground(background);
			comp.setForeground(foreground);
			return comp;
		}
	}
}
