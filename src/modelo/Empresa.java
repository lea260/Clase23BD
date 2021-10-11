package modelo;

import java.util.ArrayList;

import dao.ClienteDao;
import entidades.ClienteEntidad;
import persistencia.FakeClientePersistencia;
import persistencia.IPersonaCliente;

public class Empresa {
	public Empresa() {

	}

	public ArrayList<ClienteEntidad> mostrarDatosClientes() {
		IPersonaCliente rep = new ClienteDao();		
		ArrayList<ClienteEntidad> lista = rep.obternerListaClientes();
		return lista;
	}

}
