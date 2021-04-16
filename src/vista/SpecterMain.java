package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
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
import vista.SpecterBlue.MyRenderer;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class SpecterMain extends JFrame implements ActionListener {

//	private static final String [] logos = {"specterBLUENEGRO.png","specter1824.png","specterAgency.png"};
	private static final String nombre_pdf = "InformePresupuesto.pdf";
	String ruta_jasperreport = "src/vista/presupuestos.jasper";
	
	private int tableColumn = 4;
	private String archivo_activo = Servicios.getFichServiciosBlue();
	private int modo = 1; // 1: borrar   5: edita
	
	private JPanel contentPane;
	private JTextField tfCliente;
	private JList listServicios = new JList();
	private DefaultListModel modeloServicios = new DefaultListModel();
	private DefaultTableModel modeloTabla;
	private JLabel lblLogoBlue;
	private JButton btnAdd;
	private JButton btnLess;
	private JButton btnBlue;
	private JButton btn1824;
	private JButton btnAgency;
	private JButton btnGenera;
	private JButton btnVer;
	private JRadioButton rbEditar;
	private JRadioButton rbBorrar;
	
	private ArrayList<Servicios> aServicios;
	private ArrayList<Servicios> aTableService;
	private JTable table;
	private JScrollPane scrollPane_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpecterMain frame = new SpecterMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog( null, e.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
				}
			}
		});
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
//			generaInforme();
			claseRuina();
		}
		else if (e.getSource() == rbBorrar) {
			System.out.println("rbBorrar presionado");
			modo = 1;
		}
		else if (e.getSource() == rbEditar) {
			System.out.println("rbEditar presionado");
			modo = 5;
		}
	}
	
	public void claseRuina () {
		String nombre, descripcion;
		Double precio;
		List<Prueba> lista = new ArrayList<Prueba>();
		
		for (int i = 0; i < 3; i++) {
			
			lista.add(new Prueba("hola","asas",232323.2));
			lista.add(new Prueba("dfdfdf","sdlalalalalla",666.2));
			lista.add(new Prueba("aaaaa","asas",723.2));
		}
		
		//esto funciona, la replica de arriba aun no lose
		//en genera informe2() está el codigo que eestaba comentado aquí
		
		JasperPrint jasperPrint = null; 
		try { 
			jasperPrint = JasperFillManager.fillReport(ruta_jasperreport, null,new JRBeanCollectionDataSource(lista)); 
		} catch (JRException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace(); 
			JOptionPane.showMessageDialog( null, e1.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
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
			JOptionPane.showMessageDialog( null, e1.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		}
	}
	
	/** Imprime el informe directamente en el directorio raiz del proyecto, por lo que hay que
	 * hacer algo con el nombre del doc que se generará si es el mismo siempre se cargará el anterior siempre
	 */
	public void generaInforme2 () {
		String nombre, descripcion;
		Double precio;
		List<Prueba> lista = new ArrayList<Prueba>();
		
		for (int i = 0; i < aTableService.size(); i++) {
			nombre = aTableService.get(i).getNombre();
			descripcion = aTableService.get(i).getDescripcion();
			precio = aTableService.get(i).getPrecio();
			lista.add(new Prueba(nombre,descripcion,precio));
		}
		
		//esto funciona, la replica de arriba aun no lose
//		for (int i = 0; i < aServicios.size(); i++) {
//			nombre = aServicios.get(i).getNombre();
//			descripcion = aServicios.get(i).getDescripcion();
//			precio = aServicios.get(i).getPrecio();
//			lista.add(new Prueba(nombre,descripcion,precio));
//		}
		
		JasperPrint jasperPrint = null; 
		try { 
			jasperPrint = JasperFillManager.fillReport(ruta_jasperreport, null,new JRBeanCollectionDataSource(lista)); 
		} catch (JRException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace(); 
			JOptionPane.showMessageDialog( null, e1.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
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
			JOptionPane.showMessageDialog( null, e1.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		}
		 
	}
	
	/**
	 * Muestra la vista previa del informe y da la opcion a imprirlo y donde
	 * tiene que coger el arraylist correcto. falta cambiar eso en caso de implementarlo
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
		String path = ruta_jasperreport;
		try { 
			reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
			JasperPrint jprint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
			JasperViewer viewer = new JasperViewer(jprint, false);
			viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			viewer.setVisible(true);
		} catch (JRException e1) { 
			e1.printStackTrace(); 
			JOptionPane.showMessageDialog( null, e1.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
		} 
	}
	
	public void cambiaSector () {
		//cambiaLogo();
		cargarLista();
	}
	
	public void quitaServicio () {
		try {
			DefaultTableModel dtm = (DefaultTableModel) table.getModel(); //TableProducto es el nombre de mi tabla ;)
			dtm.removeRow(table.getSelectedRow());
		}
		catch (Exception e) {
			e.printStackTrace();
//			System.out.println("no se ha seleccionado ninguna fila");
			JOptionPane.showMessageDialog( null, e.getStackTrace(), "PDF Guardado", JOptionPane.PLAIN_MESSAGE ); 
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
		
		aTableService.add(aServicios.get(servicio_seleccionado));
		
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
		scrollPane_1.setViewportView(listServicios);
		listServicios.setFont(new Font("Tahoma", Font.PLAIN, 24));
		listServicios.setModel(modeloServicios);
	}
	 

	/**
	 * Create the frame.
	 */
	public SpecterMain() {
		ruta_jasperreport.replace('/', File.separatorChar);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SpecterBlue.class.getResource("/img/icon.png")));
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 1426, 795);
		getContentPane().setLayout(null);
		
		lblLogoBlue = new JLabel("LOGO");
		lblLogoBlue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLogoBlue.setBackground(Color.RED);
		lblLogoBlue.setBounds(-17, -60, 256, 208);
		getContentPane().add(lblLogoBlue);
		
		ImageIcon imgIcon = new ImageIcon("spectergroup.png");
        Image imgEscalada = imgIcon.getImage().getScaledInstance(lblLogoBlue.getWidth(),
                lblLogoBlue.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        lblLogoBlue.setIcon(iconoEscalado);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(925, 290, 446, 419);
		getContentPane().add(scrollPane_1);
		
		listServicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listServicios.setBackground(Color.GRAY);
		listServicios.addMouseListener(new MouseAdapter() { 
			public void mouseClicked(MouseEvent evt) { 
				JList list = (JList)evt.getSource(); 
				if (evt.getClickCount() == 1) { 
					int index = list.locationToIndex(evt.getPoint());
//					System.out.println("doble click "+index);
					mueveServicio();
				}
			}
		});
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblCliente.setBounds(55, 179, 97, 44);
		getContentPane().add(lblCliente);
		
		tfCliente = new RoundJTextField(15);
		tfCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCliente.setBounds(164, 179, 242, 45);
		getContentPane().add(tfCliente);
		tfCliente.setColumns(10);
        
        creaRadioButtons();
		creaBotones();
		creaTabla();
//		cambiaLogo();
		
		//LOGICA
		aTableService = new ArrayList<Servicios>();
		aServicios = new ArrayList<Servicios>();
		rbBorrar.setSelected(true);
		cargarLista();
	}
	
	public void creaRadioButtons () {
		rbEditar = new JRadioButton("Editar");
		rbEditar.setBackground(Color.WHITE);
		buttonGroup.add(rbEditar);
		rbEditar.setBounds(187, 249, 127, 25);
		getContentPane().add(rbEditar);
		rbEditar.addActionListener(this);
		
		rbBorrar = new JRadioButton("Borrar");
		rbBorrar.setBackground(Color.WHITE);
		buttonGroup.add(rbBorrar);
		rbBorrar.setBounds(37, 249, 127, 25);
		getContentPane().add(rbBorrar);
		rbBorrar.addActionListener(this);
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
		
		modeloTabla.isCellEditable(1, 1);
		
		table = new JTable(modeloTabla);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setHeaderRenderer(new MyRenderer(new Color(49, 198, 191),Color.black));
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBackground(Color.WHITE);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(370);
		table.setRowHeight(30);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if(e.getClickCount()== modo){
					System.out.println("Se ha hecho click: " + table.getSelectedRow());
					quitaServicio();
		        }
				if(e.getClickCount()==2){
					System.out.println("Se ha hecho doble click: " + table.getSelectedRow());
//					quitaServicio();
				}
			}});
		
		scrollPane.setViewportView(table);
		
	}
	
	public void creaBotones () {
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
		
		btnGenera = new JButton("OKEY");
		btnGenera.setFont(new Font("Tahoma", Font.BOLD, 18));
//		btnGenera.setIcon(new ImageIcon(SpecterBlue.class.getResource("/img/check-icon.png")));
		getContentPane().add(btnGenera);
		btnGenera.addActionListener(this);
		btnGenera.setBounds(1256, 183, 115, 80);
		
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
	
	public class RoundJTextField extends JTextField {
	    private Shape shape;
	    public RoundJTextField(int size) {
	        super(size);
	        setOpaque(false); // As suggested by @AVD in comment.
	    }
	    protected void paintComponent(Graphics g) {
	         g.setColor(getBackground());
	         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	         super.paintComponent(g);
	    }
	    protected void paintBorder(Graphics g) {
	         g.setColor(getForeground());
	         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	    }
	    public boolean contains(int x, int y) {
	         if (shape == null || !shape.getBounds().equals(getBounds())) {
	             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	         }
	         return shape.contains(x, y);
	    }
	}
	
//	public void cambiaLogo () {
//	lblLogoBlue.setVisible(false);
//	lblLogo1824.setVisible(false);
//	lblLogoAgency.setVisible(false);
//	
//	switch (modo) {
//	case 0: lblLogoBlue.setVisible(true);
//			getContentPane().setBackground(Color.WHITE);
//			break;
//	case 1: lblLogo1824.setVisible(true); 
//			getContentPane().setBackground(Color.WHITE);
//			break;
//	case 2: lblLogoAgency.setVisible(true); 
//			getContentPane().setBackground(Color.WHITE);
//			break;
//	default: System.out.println("fallo en cambiaLogo()"); break;
//	}
//}
}
