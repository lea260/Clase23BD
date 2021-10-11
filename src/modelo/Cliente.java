package modelo;

import dao.ClienteDao;
import entidades.ClienteEntidad;
import persistencia.FakeClientePersistencia;
import persistencia.IPersonaCliente;

public class Cliente {
	private int id;
	private int edad;
	private String nombre;
	private IPersonaCliente repositorioCli;

	public Cliente(int edad, String nombre) {
		super();
		if (edad < 0) {
			throw new IllegalArgumentException("La edad no puede ser cero");
		}
		this.edad = edad;
		this.nombre = nombre;
	}
	
	public Cliente(int id, int edad, String nombre) {
		super();
		if (edad < 0) {
			throw new IllegalArgumentException("La edad no puede ser cero");
		}
		this.id = id;
		this.edad = edad;
		this.nombre = nombre;
	}

	public int agregarCliente() {
		int id = 0;
		//repositorioCli = new FakeClientePersistencia();
		repositorioCli = new ClienteDao();
		ClienteEntidad cli = this.getEntidad();
		id = repositorioCli.agregarCliente(cli);
		return id;
	}

	public boolean editarCliente() {
		boolean res = false;
		//repositorioCli = new FakeClientePersistencia();
		repositorioCli = new ClienteDao();
		ClienteEntidad cli = this.getEntidad();
		res = repositorioCli.editarCliente(cli);
		return res;
	}

	public ClienteEntidad getEntidad() {
		ClienteEntidad ent = new ClienteEntidad(this.id, this.nombre, this.edad);
		return ent;
	}

	public boolean eliminar() {
		// TODO Auto-generated method stub
		boolean res = false;
		//repositorioCli = new FakeClientePersistencia();
		repositorioCli = new ClienteDao();
		ClienteEntidad cli = this.getEntidad();
		res = repositorioCli.eliminarCliente(cli.getId());
		return res;
	}

}
