package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Cliente;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearClienteSV extends JInternalFrame {
	private VentanaPrincipal vp;
	private JTextField textEdad;
	private JTextField textNombre;
	private Cliente cliente;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CrearClienteSV(VentanaPrincipal vp) {
		this.vp = vp;
		setTitle("Crear Cliente");
		setBounds(100, 100, 885, 592);
		// setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(46, 49, 795, 353);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(28, 180, 123, 46);
		panel.add(lblNombre);

		textEdad = new JTextField();
		textEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textEdad.setColumns(10);
		textEdad.setBounds(228, 31, 259, 57);
		panel.add(textEdad);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEdad.setBounds(28, 36, 123, 46);
		panel.add(lblEdad);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textNombre.setColumns(10);
		textNombre.setBounds(228, 175, 259, 57);
		panel.add(textNombre);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarCliente();
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnAgregar.setBounds(28, 285, 123, 46);
		panel.add(btnAgregar);
	}

	private void agregarCliente() {
		// TODO Auto-generated method stub
		try {
			String edadStr = textEdad.getText();
			int edadInt = Integer.parseInt(edadStr);
			cliente = new Cliente(edadInt, textNombre.getText());
			int id = cliente.agregarCliente();
			JOptionPane.showMessageDialog(null, "Se creo el cliente con id =" + id);
			this.dispose();
			vp.verFormularioListaClientes();
		} catch (NumberFormatException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "la edad debe ser un entero");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
