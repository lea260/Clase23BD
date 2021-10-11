package persistencia;

import java.util.ArrayList;

import entidades.ClienteEntidad;


public class Singleton {
	private ArrayList<ClienteEntidad> listaClientes;
	private static Singleton instancia = null;

	private Singleton() {
	}

	public static Singleton getInstancia() {
		if (instancia == null) {
			instancia = new Singleton();
			instancia.listaClientes = new ArrayList<ClienteEntidad>();			
			instancia.listaClientes.add(new ClienteEntidad(21, "Juan", 25));
			instancia.listaClientes.add(new ClienteEntidad(105, "El reja", 105));
			instancia.listaClientes.add(new ClienteEntidad(15, "el flecha", 44));
			instancia.listaClientes.add(new ClienteEntidad(5, "juncho hebio", 17));
			instancia.listaClientes.add(new ClienteEntidad(7, "el crack", 25));
			
			
		}
		return instancia;
	}

	public ArrayList<ClienteEntidad> listarPersonas() {
		return listaClientes;
	}
	
	public int agregarCliente(ClienteEntidad cli) {
		listaClientes.add(cli);
		return cli.getId();
	}
}
