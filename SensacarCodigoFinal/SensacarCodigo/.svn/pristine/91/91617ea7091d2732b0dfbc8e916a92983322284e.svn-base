package Negocio.Cliente;

import Integración.Cliente.TCliente;
import Integración.Factorias.FactoriaIntegracion;
import Integración.Query.FactoriaQuery;
import Integración.Query.TQuery;
import Integración.Transaction.TransactionManager;
import Negocio.ParseadorVariables.ParseadorVariables;

import java.util.ArrayList;

public class SAClienteImp implements SACliente {

	public Integer crearCliente(TCliente cliente) {
		FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
		TransactionManager.getInstance().newTransaction().start();
		// EL crear un Cliente con el mismo DNI fallara porque el DNI es unico
		Integer retorno = -2;
		TCliente c = factoriaIntegracion.generaDAOCliente().readByDNI(cliente.getDNI());
		ParseadorVariables p = new ParseadorVariables();
		if (c == null && p.comprobarDNI(cliente.getDNI()) && p.comprobarTelefono(cliente.getTelefono())) {
			retorno = factoriaIntegracion.generaDAOCliente().create(cliente);
			if (retorno != -1)
				TransactionManager.getInstance().getTransaction().commit();
			else
				TransactionManager.getInstance().getTransaction().rollback();
		} else {
			if (!p.comprobarDNI(cliente.getDNI()))
				retorno = -3;
			else if (!p.comprobarTelefono(cliente.getTelefono()))
				retorno = -4;
			TransactionManager.getInstance().getTransaction().rollback();
		}
		TransactionManager.getInstance().deleteTransaction();
		return retorno;
	}

	public Integer borrarCliente(Integer idCliente) {

		FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
		TransactionManager.getInstance().newTransaction().start();
		Integer retorno = -1;
		TCliente clienteExiste = factoriaIntegracion.generaDAOCliente().read(idCliente);
		if (clienteExiste == null) {
			TransactionManager.getInstance().getTransaction().rollback();
			retorno = -2;
		} else {
			if (clienteExiste.getActivo()) {
				retorno = factoriaIntegracion.generaDAOCliente().delete(idCliente);
				if (retorno != -1)
					TransactionManager.getInstance().getTransaction().commit();
				else
					TransactionManager.getInstance().getTransaction().rollback();
			} else
				TransactionManager.getInstance().getTransaction().rollback();
		}
		TransactionManager.getInstance().deleteTransaction();
		return retorno;
	}

	public Integer actualizarCliente(TCliente cliente) {
		FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
		TransactionManager.getInstance().newTransaction().start();
		ParseadorVariables p = new ParseadorVariables();
		Integer retorno = -1;
		TCliente clienteExiste = factoriaIntegracion.generaDAOCliente().read(cliente.getId());
		if (clienteExiste == null) {
			TransactionManager.getInstance().getTransaction().rollback();
		} else if (p.comprobarDNI(cliente.getDNI()) && p.comprobarTelefono(cliente.getTelefono())) {
			retorno = factoriaIntegracion.generaDAOCliente().update(cliente);
			if (retorno != -1)
				TransactionManager.getInstance().getTransaction().commit();
			else
				TransactionManager.getInstance().getTransaction().rollback();
		}
		else{
			if (!p.comprobarDNI(cliente.getDNI())){
				//DNI no valido
				retorno = -2;
			}
			else{
				//Telefono no valido
				retorno = -3;
			}
			TransactionManager.getInstance().getTransaction().rollback();
		}
		TransactionManager.getInstance().deleteTransaction();
		return retorno;

	}

	public TCliente leerCliente(Integer idCliente) {
		FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
		TransactionManager.getInstance().newTransaction().start();
		TCliente retorno = factoriaIntegracion.generaDAOCliente().read(idCliente);
		if (retorno != null)
			TransactionManager.getInstance().getTransaction().commit();
		else
			TransactionManager.getInstance().getTransaction().rollback();
		TransactionManager.getInstance().deleteTransaction();

		return retorno;
	}

	public ArrayList<TCliente> leerListaClientes() {
		FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
		TransactionManager.getInstance().newTransaction().start();
		ArrayList<TCliente> retorno = factoriaIntegracion.generaDAOCliente().readAll();
		if (retorno != null && retorno.size() > 0)
			TransactionManager.getInstance().getTransaction().commit();
		else {
			retorno = null;
			TransactionManager.getInstance().getTransaction().rollback();
		}
		TransactionManager.getInstance().deleteTransaction();
		return retorno;
	}

	public ArrayList<TCliente> queryCliente(TQuery query) {

		TransactionManager.getInstance().newTransaction().start();
		ArrayList<TCliente> retorno = (ArrayList<TCliente>) FactoriaQuery.getInstance().createQueryCliente()
				.execute(query);
		if (retorno != null)
			TransactionManager.getInstance().getTransaction().commit();
		else
			TransactionManager.getInstance().getTransaction().rollback();
		TransactionManager.getInstance().deleteTransaction();
		return retorno;
	}
}