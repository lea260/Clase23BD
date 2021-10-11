package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;

import entidades.ClienteEntidad;
import modelo.Cliente;
import modelo.Empresa;
import utilidades.GestionCeldas02;
import utilidades.GestionEncabezadoTabla;
import utilidades.ModeloTabla;
import utilidades.Utilidades;

public class ListaClientesInternalFrame extends JInternalFrame implements MouseListener {
	private JTable tablaCLientes;
	private ArrayList<ClienteEntidad> listaClientes;
	private JScrollPane scrollPane;
	private ModeloTabla modelo;
	private Empresa empresa;
	private VentanaPrincipal vp;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ListaClientesInternalFrame(VentanaPrincipal vp) {
		Utilidades.filaSeleccionada=-1;
		this.vp = vp;
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Lista Clientes");
		setBounds(100, 100, 885, 592);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 63, 759, 303);
		getContentPane().add(scrollPane);

		tablaCLientes = new JTable();
		scrollPane.setViewportView(tablaCLientes);

		JPanel panel = new JPanel();
		panel.setBounds(37, 427, 759, 100);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCliente();
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAgregar.setBounds(29, 31, 200, 40);
		panel.add(btnAgregar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarCliente();
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEditar.setBounds(288, 31, 200, 40);
		panel.add(btnEditar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarCliente();
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEliminar.setBounds(520, 31, 200, 40);
		panel.add(btnEliminar);
		construirTabla();
	}

	private void construirTabla() {
		// llamamos
		empresa = new Empresa();
		listaClientes = empresa.mostrarDatosClientes();
		// utiliza el metodo compareTo implementado en personaEntidad
		listaClientes.sort(null);
		// listaPersonas.sort(new OrdenarPersonaEdad());
		// listaPersonas.sort(new OrdenarPersonaEdadId());
		/*
		 * listaPersonas.sort((p1, p2) -> { int valor = 0; if (p1.getEdad() <
		 * p2.getEdad()) { valor = -1; } else if (p1.getEdad() > p1.getEdad()) { valor =
		 * 1; } else if (p1.getId() < p1.getId()) { valor = -1; } else if (p1.getId() >
		 * p1.getId()) { valor = 1; } else { valor = 0; } return valor; });
		 */

		// listaPersonas.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));

		ArrayList<String> titulosList = new ArrayList<>();

		titulosList.add("ID");
		titulosList.add("Nombre");
		titulosList.add("Edad");

		// se asignan las columnas al arreglo para enviarse al momento de construir la
		// tabla
		String titulos[] = new String[titulosList.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = titulosList.get(i);
		}
		/*
		 * obtenemos los datos de la lista y los guardamos en la matriz que luego se
		 * manda a construir la tabla
		 */
		Object[][] data = obtenerMatrizDatos(titulosList);
		construirTabla(titulos, data);
	}

	private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

		/*
		 * se crea la matriz donde las filas son dinamicas pues corresponde a todos los
		 * usuarios, mientras que las columnas son estaticas correspondiendo a las
		 * columnas definidas por defecto
		 */
		String informacion[][] = new String[listaClientes.size()][titulosList.size()];

		for (int x = 0; x < informacion.length; x++) {
			informacion[x][Utilidades.ID] = listaClientes.get(x).getId() + "";
			informacion[x][Utilidades.NOMBRE] = listaClientes.get(x).getNombre() + "";
			informacion[x][Utilidades.EDAD] = listaClientes.get(x).getEdad() + "";
		}
		return informacion;
	}

	private void construirTabla(String[] titulos, Object[][] data) {
		modelo = new ModeloTabla(data, titulos);
		// se asigna el modelo a la tabla
		tablaCLientes.setModel(modelo);

		// filasTabla=tablaPersonas.getRowCount();
		// columnasTabla=tablaPersonas.getColumnCount();

		// se asigna el tipo de dato que tendrán las celdas de cada columna definida
		// respectivamente para validar su personalización

		// tablaPersonas.getColumnModel().getColumn(Utilidades.ID).setCellRenderer(new
		// GestionCeldas02("texto"));
		// tablaPersonas.getColumnModel().getColumn(Utilidades.NOMBRE).setCellRenderer(new
		// GestionCeldas02("texto"));
		for (int i = 0; i < titulos.length; i++) {// se resta 7 porque las ultimas 7 columnas se definen arriba
			// System.out.println(i);
			tablaCLientes.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas02("texto"));
		}

		// se recorre y asigna el resto de celdas que serian las que almacenen datos de
		// tipo texto

		tablaCLientes.getTableHeader().setReorderingAllowed(false);
		tablaCLientes.setRowHeight(25);// tamaño de las celdas
		tablaCLientes.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tamaño de largo para cada columna y su contenido
		tablaCLientes.getColumnModel().getColumn(Utilidades.ID).setPreferredWidth(100);// documento
		tablaCLientes.getColumnModel().getColumn(Utilidades.NOMBRE).setPreferredWidth(200);// nombre
		tablaCLientes.getColumnModel().getColumn(Utilidades.EDAD).setPreferredWidth(200);// direccion

		// personaliza el encabezado
		JTableHeader jtableHeader = tablaCLientes.getTableHeader();
		jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
		tablaCLientes.setRowSelectionAllowed(true);
		// falto agregar que la tabla escuche los eventos
		tablaCLientes.addMouseListener(this);
		// tablaCLientes.getSelectedColumn();

		tablaCLientes.setTableHeader(jtableHeader);

		// limitar seleccion a una fila
		tablaCLientes.setRowSelectionAllowed(true);
		tablaCLientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// se asigna la tabla al scrollPane

		JScrollBar vertical = scrollPane.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());
	}

	protected void crearCliente() {
		// TODO Auto-generated method stub
		this.vp.verFormularioCrearCliente();
		this.dispose();
		Utilidades.filaSeleccionada=-1;
	}

	protected void editarCliente() {
		// ClienteEntidad cli = new ClienteEntidad(25, "juan", 14);
		int fila = Utilidades.filaSeleccionada;
		if (fila >= 0) {
			ClienteEntidad cli = listaClientes.get(fila);
			String info = "ClienteId " + cli.getId();
			info += "Edad: " + cli.getEdad();
			info += "Nombre: " + cli.getNombre();
			JOptionPane.showMessageDialog(null, info);
			this.vp.verFormularioEditarCliente(cli);
			this.dispose();
			Utilidades.filaSeleccionada=-1;
		}
	}

	public void eliminarCliente() {
		// TODO Auto-generated method stub
		int fila = Utilidades.filaSeleccionada;
		if (fila >= 0) {
			ClienteEntidad cli = listaClientes.get(fila);
			int input = JOptionPane.showConfirmDialog(null, "quieres eliminar el cliente con id: " + cli.getId());
			// 0=yes, 1=no, 2=cancel
			if (input == 0) {
				Cliente cliente = new Cliente(cli.getId(), cli.getEdad(), cli.getNombre());
				cliente.eliminar();
				this.dispose();
				this.vp.verFormularioListaClientes();	
				Utilidades.filaSeleccionada=-1;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int fila = tablaCLientes.rowAtPoint(e.getPoint());
		int columna = tablaCLientes.columnAtPoint(e.getPoint());
		int filaAux = tablaCLientes.getSelectedRow();
		int columnaAux = tablaCLientes.getSelectedColumn();
		Utilidades.filaSeleccionada = fila;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
