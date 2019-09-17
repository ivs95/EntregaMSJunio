package Negocio.Cliente;

import Integración.Cliente.TCliente;
import Integración.Query.TQuery;

import java.util.ArrayList;

public interface SACliente {

	public Integer crearCliente(TCliente cliente);

	public Integer borrarCliente(Integer idCliente);

	public Integer actualizarCliente(TCliente cliente);

	public TCliente leerCliente(Integer idCliente);

	public ArrayList<TCliente> leerListaClientes();

	public ArrayList<TCliente> queryCliente(TQuery query);
}