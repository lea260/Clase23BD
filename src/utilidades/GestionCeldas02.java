package utilidades;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.nio.file.FileAlreadyExistsException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import org.w3c.dom.css.RGBColor;

/**
 * 
 * Esta clase permite gestionar la tabla y los eventos realizados sobre ella
 * cada celda seria un objeto personalizable
 * 
 * @author CHENAO
 * 
 *
 */
public class GestionCeldas02 extends DefaultTableCellRenderer {

	private String tipo = "texto";

	// se definen por defecto los tipos de datos a usar
	private Font normal = new Font("Verdana", Font.PLAIN, 12);
	private Font bold = new Font("Verdana", Font.BOLD, 12);
	// etiqueta que almacenará el icono a mostrar
	private JLabel label = new JLabel();
	// iconos disponibles para ser mostrados en la etiqueta dependiendo de la
	// columna que lo contenga
	// private ImageIcon iconoGuardar = new
	// ImageIcon(getClass().getResource("/recursos/iconos/ico_guardar.png"));
	// private ImageIcon iconoBuscar = new
	// ImageIcon(getClass().getResource("/recursos/iconos/ico_buscar.png"));

	public GestionCeldas02() {

	}

	/**
	 * Constructor explicito con el tipo de dato que tendrá la celda
	 * 
	 * @param tipo
	 */
	public GestionCeldas02(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused,
			int row, int column) {

		Color colorFondoGeneral = new Color(255, 255, 255);
		Color colorFondoFilasPares = new Color(192, 192, 192);
		Color colorFondoFilaSeleciona = new Color(255, 187, 65);
		Color colorFondoActiva = new Color(255, 187, 65);
		// CTRL+SHIFT+F
		this.setBackground(colorFondoGeneral);
		// fila en la que estoy
		boolean esPar = (row % 2) == 0;
		if (esPar) {
			this.setBackground(colorFondoFilasPares);
		}

		if (selected) {
			this.setBackground(colorFondoFilaSeleciona);
		}

		if (focused) {
			this.setBackground(colorFondoActiva);
		}
		// le asigno el valor
		this.setText((String) value);			
		this.setForeground(new Color(0, 0, 0));
		if (column == 0) {
			double valor = Double.parseDouble((String) value);
			if (valor>=7) {
				this.setForeground(new Color(0, 0, 255));
			} else {
				this.setForeground(new Color(0, 0, 255));				
			}
		}
		this.setFont(normal);

		if (tipo.equals("texto")) {
			this.setHorizontalAlignment(JLabel.LEFT);
		}

		if (tipo.equals("numerico")) {
			this.setHorizontalAlignment(JLabel.CENTER);
		}
		return this;

	}

}
