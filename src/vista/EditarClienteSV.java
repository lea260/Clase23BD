package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidades.ClienteEntidad;
import modelo.Cliente;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarClienteSV extends JInternalFrame {
	private VentanaPrincipal vp;
	private JTextField textEdad;
	private JTextField textNombre;
	private Cliente cliente;
	private ClienteEntidad cli;
	private JTextField textId;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public EditarClienteSV(VentanaPrincipal vp, ClienteEntidad cli) {
		this.vp = vp;
		this.cli = cli;
		setTitle("Editar Cliente");
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
		textEdad.setBounds(228, 105, 259, 57);
		panel.add(textEdad);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEdad.setBounds(28, 110, 123, 46);
		panel.add(lblEdad);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textNombre.setColumns(10);
		textNombre.setBounds(228, 175, 259, 57);
		panel.add(textNombre);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarCliente();
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnEditar.setBounds(28, 285, 123, 46);
		panel.add(btnEditar);

		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(28, 33, 123, 46);
		panel.add(lblId);

		textId = new JTextField();
		textId.setEditable(false);
		textId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textId.setColumns(10);
		textId.setBounds(228, 22, 259, 57);
		panel.add(textId);
		textId.setText(cli.getId() + "");
		textEdad.setText(cli.getEdad() + "");
		textNombre.setText(cli.getNombre() + "");
	}

	private void editarCliente() {
		// TODO Auto-generated method stub
		try {
			String edadStr = textEdad.getText();
			int edadInt = Integer.parseInt(edadStr);
			int idInt = Integer.parseInt(textId.getText());
			cliente = new Cliente(idInt, edadInt, textNombre.getText());
			boolean res = cliente.editarCliente();
			if (res) {
				JOptionPane.showMessageDialog(null, "Se edito el cliente con id: " + cli.getId());
				this.dispose();
				vp.verFormularioListaClientes();
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "la edad debe ser un entero");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
