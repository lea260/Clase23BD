package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import entidades.ClienteEntidad;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private ListaClientesInternalFrame listaClientesInternalFrame;
	private CrearClienteSV crearClienteSV;
	private EditarClienteSV editarClienteSV;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		// hace que la ventana se vea en tamanio completo
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);

		JMenuItem mntmListarClientes = new JMenuItem("Listar");
		mntmListarClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mntmListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verFormularioListaClientes();
			}
		});
		mnClientes.add(mntmListarClientes);

		JMenuItem mntmCrearCliente = new JMenuItem("Crear");
		mnClientes.add(mntmCrearCliente);

		JMenu mnEmpleado = new JMenu("Empleados");
		menuBar.add(mnEmpleado);

		JMenuItem mntmListarEmpleado = new JMenuItem("Listar");
		mnEmpleado.add(mntmListarEmpleado);

		JMenuItem mntmCrearEmpleado = new JMenuItem("Crear");
		mnEmpleado.add(mntmCrearEmpleado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);

		JButton btnListarClientes = new JButton("Listar Clientes");
		btnListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verFormularioListaClientes();
			}
		});
		toolBar.add(btnListarClientes);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.activeCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

	public void verFormularioListaClientes() {
		// evalucaion en cirito corto de los condicional
		/*
		 * personaFormularioFrame.isClosed() va a ejecutarse si falla la primera
		 * condicion falla entonces personaFormularioFrame != null (cierto)
		 * 
		 */
		if (listaClientesInternalFrame == null || listaClientesInternalFrame.isClosed()) {
			listaClientesInternalFrame = new ListaClientesInternalFrame(this);
			listaClientesInternalFrame.setVisible(true);
			Dimension tfDimension = listaClientesInternalFrame.getSize();
			int anchoDP = desktopPane.getWidth();
			int anchoPersona = tfDimension.width;
			float margen = (anchoDP - anchoPersona) / 2;
			listaClientesInternalFrame.setLocation((int) margen, 0);
			desktopPane.add(listaClientesInternalFrame);
		}
	}
	
	public void verFormularioCrearCliente() {
		// evalucaion en cirito corto de los condicional
		/*
		 * personaFormularioFrame.isClosed() va a ejecutarse si falla la primera
		 * condicion falla entonces personaFormularioFrame != null (cierto)
		 * 
		 */
		if (crearClienteSV == null || crearClienteSV.isClosed()) {
			crearClienteSV = new CrearClienteSV(this);
			crearClienteSV.setVisible(true);
			Dimension tfDimension = crearClienteSV.getSize();
			int anchoDP = desktopPane.getWidth();
			int anchoPersona = tfDimension.width;
			float margen = (anchoDP - anchoPersona) / 2;
			crearClienteSV.setLocation((int) margen, 0);
			desktopPane.add(crearClienteSV);
		}
	}
	
	public void verFormularioEditarCliente(ClienteEntidad cli) {
		// evalucaion en cirito corto de los condicional
		/*
		 * personaFormularioFrame.isClosed() va a ejecutarse si falla la primera
		 * condicion falla entonces personaFormularioFrame != null (cierto)
		 * 
		 */
		if (editarClienteSV == null || editarClienteSV.isClosed()) {
			editarClienteSV = new EditarClienteSV(this, cli);
			editarClienteSV.setVisible(true);
			Dimension tfDimension = editarClienteSV.getSize();
			int anchoDP = desktopPane.getWidth();
			int anchoPersona = tfDimension.width;
			float margen = (anchoDP - anchoPersona) / 2;
			editarClienteSV.setLocation((int) margen, 0);
			desktopPane.add(editarClienteSV);
		}
	}
}
