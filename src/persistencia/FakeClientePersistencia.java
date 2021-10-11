package persistencia;

import java.util.ArrayList;
import java.util.Iterator;

import entidades.ClienteEntidad;

import vista.*;

public class FakeClientePersistencia implements IPersonaCliente {
	public static int idCliente = 105;

	@Override
	public ArrayList<ClienteEntidad> obternerListaClientes() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Singleton singleton = Singleton.getInstancia();
		ArrayList<ClienteEntidad> lista = singleton.listarPersonas();
		return lista;
	}

	@Override
	public int agregarCliente(ClienteEntidad cli) {
		// TODO Auto-generated method stub
		idCliente++;
		Singleton singleton = Singleton.getInstancia();
		cli.setId(idCliente);
		singleton.agregarCliente(cli);
		return idCliente;
	}

	@Override
	public boolean eliminarCliente(int id) {
		// TODO Auto-generated method stub
		boolean res=false;
		Singleton singleton = Singleton.getInstancia();
		ArrayList<ClienteEntidad> lista = singleton.listarPersonas();
		Iterator<ClienteEntidad> iterator=lista.iterator();
		while (iterator.hasNext()) {
			ClienteEntidad elem= iterator.next();
			if (elem.getId()==id) {
				iterator.remove();
				res=true;
			}			
		}
		return res;
	}

	@Override
	public boolean editarCliente(ClienteEntidad cli) {
		// TODO Auto-generated method stub
		//boolean res = false;
		Singleton singleton = Singleton.getInstancia();
		ArrayList<ClienteEntidad> lista = singleton.listarPersonas();
		boolean encontrado = false;
		int i=0; 
		int pos= i;
		while (!encontrado && i < lista.size()) {
			ClienteEntidad elemento = lista.get(i);
			if (elemento.getId() == cli.getId()) {				
				encontrado=true;
				pos = i;
			}
			i++;
		}
		if (encontrado) {
			lista.get(pos).setEdad(cli.getEdad());
			lista.get(pos).setNombre(cli.getNombre());
		}			
		return encontrado;
	}

	/*
	 * @Override public ArrayList<ClienteEntidad> obternerListaPersonas() { // TODO
	 * Auto-generated method stub Singleton singleton = Singleton.getInstancia();
	 * ArrayList<PersonaEntidad> lista = singleton.listarPersonas(); return lista; }
	 * 
	 * @Override public int agregarPersona() { // TODO Auto-generated method stub
	 * return 0; }
	 * 
	 * @Override public boolean eliminarPersona() { // TODO Auto-generated method
	 * stub return false; }
	 * 
	 * public void editarPersona(PersonaEntidad persona) { // TODO Auto-generated
	 * method stub Singleton singleton = Singleton.getInstancia();
	 * ArrayList<ClienteEntidad> lista = singleton.listarPersonas();
	 * Iterator<ClienteEntidad> nombreIterator = lista.iterator();
	 * while(nombreIterator.hasNext()){ ClienteEntidad elemento =
	 * nombreIterator.next(); if (elemento.getId()==persona.getId()) {
	 * nombreIterator.remove(); } } lista.add(persona); }
	 */

}
