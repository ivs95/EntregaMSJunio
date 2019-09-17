package Negocio.Modelos;

import Integración.Factorias.FactoriaIntegracion;
import Integración.Modelos.TModelo;
import Integración.Query.FactoriaQuery;
import Integración.Query.TQuery;
import Integración.Transaction.TransactionManager;
import Negocio.ParseadorVariables.ParseadorVariables;

import java.util.ArrayList;

public class SAModeloImp implements SAModelo {

	public Integer crearModelo(TModelo modelo) {
		Integer retorno = -1;

		if (modelo.getPrecio() > 0 && modelo.getStock() >= 0) {
			FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
			TransactionManager.getInstance().newTransaction().start();
			TModelo modeloExiste = factoriaIntegracion.generaDAOModelo().readByNombre(modelo.getNombre());
			if (modeloExiste != null) {
				retorno = -2;
				TransactionManager.getInstance().getTransaction().rollback();
			} else {

				retorno = factoriaIntegracion.generaDAOModelo().create(modelo);
				if (retorno != -1)
					TransactionManager.getInstance().getTransaction().commit();
				else
					TransactionManager.getInstance().getTransaction().rollback();
			}
			TransactionManager.getInstance().deleteTransaction();

		} else {
			if (modelo.getPrecio() > 0) {
				// Stock negativo
				retorno = -3;
			} else {
				// Precio negativo
				retorno = -4;
			}

		}
		return retorno;

	}

	public Integer actualizarModelo(TModelo modelo) {
		FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
		TransactionManager.getInstance().newTransaction().start();
		ParseadorVariables p = new ParseadorVariables();
		Integer retorno = -1;
		TModelo modeloExiste = factoriaIntegracion.generaDAOModelo().read(modelo.getID());
		if (modeloExiste == null) {
			TransactionManager.getInstance().getTransaction().rollback();
		} else {
			if (p.comprobarNumeroPositivo(modelo.getStock()) && p.comprobarNumeroPositivo(modelo.getPrecio())) {
				retorno = factoriaIntegracion.generaDAOModelo().update(modelo);
				if (retorno != -1)
					TransactionManager.getInstance().getTransaction().commit();
				else
					TransactionManager.getInstance().getTransaction().rollback();
			} else{
				if (!p.comprobarNumeroPositivo(modelo.getPrecio()))
						retorno = -2;
				else
					retorno = -3;
				TransactionManager.getInstance().getTransaction().rollback();
			}

		}
		TransactionManager.getInstance().deleteTransaction();
		return retorno;
	}

	public Integer borrarModelo(Integer idModelo) {
		FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
		TransactionManager.getInstance().newTransaction().start();
		TModelo modeloExiste = factoriaIntegracion.generaDAOModelo().read(idModelo);
		Integer retorno = -1;
		if (modeloExiste == null) {
			retorno = -2;
			TransactionManager.getInstance().getTransaction().rollback();
		} else {
			if (modeloExiste.getActivo()) {
				retorno = factoriaIntegracion.generaDAOModelo().delete(idModelo);
				if (retorno != -1)
					TransactionManager.getInstance().getTransaction().commit();

				else
					TransactionManager.getInstance().getTransaction().commit();
			} else
				TransactionManager.getInstance().getTransaction().rollback();

		}
		TransactionManager.getInstance().deleteTransaction();
		return retorno;
	}

	public TModelo leerModelo(Integer idModelo) {
		TModelo retorno = null;
		FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
		TransactionManager.getInstance().newTransaction().start();
		retorno = factoriaIntegracion.generaDAOModelo().read(idModelo);
		if (retorno != null) {
			TransactionManager.getInstance().getTransaction().commit();
		} else {
			TransactionManager.getInstance().getTransaction().rollback();
		}
		TransactionManager.getInstance().deleteTransaction();
		return retorno;
	}

	public ArrayList<TModelo> leerListaModelos() {
		FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
		TransactionManager.getInstance().newTransaction().start();
		ArrayList<TModelo> retorno = factoriaIntegracion.generaDAOModelo().readAll();
		if (retorno != null && retorno.size() > 0)
			TransactionManager.getInstance().getTransaction().commit();
		else {
			TransactionManager.getInstance().getTransaction().rollback();
			retorno = null;
		}
		TransactionManager.getInstance().deleteTransaction();
		return retorno;
	}

	public ArrayList<TModelo> queryModelo(TQuery query) {
		TransactionManager.getInstance().newTransaction().start();
		ArrayList<TModelo> modelo = (ArrayList<TModelo>) FactoriaQuery.getInstance().createQueryModelo().execute(query);
		if (modelo != null)
			TransactionManager.getInstance().getTransaction().commit();
		else
			TransactionManager.getInstance().getTransaction().rollback();
		TransactionManager.getInstance().deleteTransaction();
		return modelo;
	}
}