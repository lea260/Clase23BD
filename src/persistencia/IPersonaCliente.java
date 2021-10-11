package persistencia;

import java.util.ArrayList;

import entidades.ClienteEntidad;


public interface IPersonaCliente {
	ArrayList<ClienteEntidad> obternerListaClientes();

	int agregarCliente(ClienteEntidad cli);

	boolean eliminarCliente(int id);

	boolean editarCliente(ClienteEntidad cli);
}
