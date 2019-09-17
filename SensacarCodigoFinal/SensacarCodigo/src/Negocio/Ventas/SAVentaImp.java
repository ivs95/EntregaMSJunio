package Negocio.Ventas;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import Integración.Cliente.TCliente;
import Integración.Factorias.FactoriaIntegracion;
import Integración.Modelos.TModelo;
import Integración.Transaction.TransactionManager;
import Integración.Ventas.LineaVenta;
import Integración.Ventas.TVenta;
import Negocio.ParseadorVariables.ParseadorVariables;

public class SAVentaImp implements SAVenta {

	public TVenta abrirVenta(int idCliente) {
		TVenta retorno = null;
		ParseadorVariables parseador = new ParseadorVariables();
		if (parseador.comprobarNumeroPositivo(idCliente)) {

			retorno = new TVenta(idCliente);
		}
		return retorno;

	}

	public TVenta anadirModeloAVenta(TVenta venta, int idModelo, int cantidad) {
		ParseadorVariables parseador = new ParseadorVariables();
		if (parseador.comprobarNumeroPositivo(idModelo) && parseador.comprobarNumeroPositivo(cantidad)) {
			FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
			TransactionManager.getInstance().newTransaction().start();
			TModelo modelo = factoriaIntegracion.generaDAOModelo().read(idModelo);
			if (venta != null && modelo != null) {
				float precio = modelo.getPrecio() * cantidad;
				if (venta.getLineasVenta().containsKey(idModelo)) {
					LineaVenta l = venta.getLineasVenta().get(idModelo);
					l.setCantidad(l.getCantidad() + cantidad);
					l.setPrecioTotal(l.getPrecioTotal() + precio);
				} else {
					LineaVenta l = new LineaVenta(idModelo, cantidad, precio);
					venta.getLineasVenta().put(idModelo, l);
				}
				venta.setPrecioTotal(venta.getPrecioTotal() + precio);
				TransactionManager.getInstance().getTransaction().commit();
			} else
				TransactionManager.getInstance().getTransaction().rollback();

			TransactionManager.getInstance().deleteTransaction();
		}

		return venta;
	}

	public TVenta eliminarModeloDeVenta(TVenta venta, int idModelo) {
		ParseadorVariables parseador = new ParseadorVariables();
		TVenta retorno = null;
		if (parseador.comprobarNumeroPositivo(idModelo) && venta != null) {
			FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
			TransactionManager.getInstance().newTransaction().start();
			TModelo modelo = factoriaIntegracion.generaDAOModelo().read(idModelo);
			if (modelo != null) {
				if (venta.getLineasVenta().containsKey(idModelo)) {
					venta.setPrecioTotal(
							venta.getPrecioTotal() - venta.getLineasVenta().get(idModelo).getPrecioTotal());
					venta.getLineasVenta().remove(idModelo);
					retorno = venta;
					TransactionManager.getInstance().getTransaction().commit();
				} else
					TransactionManager.getInstance().getTransaction().rollback();
			} else
				TransactionManager.getInstance().getTransaction().rollback();

			TransactionManager.getInstance().deleteTransaction();
		}
		return retorno;
	}

	public int cerrarVenta(TVenta venta) {
		int retorno = -1;
		ParseadorVariables parseador = new ParseadorVariables();
		if (venta != null) {
			FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
			TransactionManager.getInstance().newTransaction().start();
			TCliente cliente = factoriaIntegracion.generaDAOCliente().read(venta.getIdCliente());
			if (!venta.getLineasVenta().isEmpty()) {
				if (cliente != null && cliente.getActivo()) {
					boolean modelosCorrectos = true;
					for (LineaVenta l : venta.getLineasVenta().values()) {
						TModelo modelo = factoriaIntegracion.generaDAOModelo().read(l.getIdArticulo());
						if (modelo != null && modelo.getActivo()) {
							if (modelo.getStock() < venta.getLineasVenta().get(l.getIdArticulo()).getCantidad()
									|| !parseador.comprobarNumeroPositivo(
											venta.getLineasVenta().get(l.getIdArticulo()).getCantidad())) {
								// La cantidad de la linea de venta no es
								// correcta
								retorno = -2;
								modelosCorrectos = false;
							} else {
								modelo.setStock(modelo.getStock()
										- venta.getLineasVenta().get(l.getIdArticulo()).getCantidad());
								factoriaIntegracion.generaDAOModelo().update(modelo);
							}
						} else if (modelo == null) {
							// El modelo no existe o está inactivo
							retorno = -4;
							modelosCorrectos = false;
						} else {
							retorno = -3;
							modelosCorrectos = false;
						}
					}
					if (modelosCorrectos) {
						Calendar calendar = Calendar.getInstance();
						long timeInMillis = calendar.getTimeInMillis();
						Date fecha = new Date(timeInMillis);
						venta.setFecha(fecha);
						retorno = factoriaIntegracion.generaDAOVentas().create(venta);
						if (retorno != -1) {
							TransactionManager.getInstance().getTransaction().commit();

						} else {
							// Ha fallado la insercion en la BDD
							TransactionManager.getInstance().getTransaction().rollback();
						}
					} else {
						// Ha fallado alguna comprobacion de las lineas de venta
						TransactionManager.getInstance().getTransaction().rollback();
					}
				} else {
					// El cliente no existe o está inactivo
					retorno = -5;
					TransactionManager.getInstance().getTransaction().rollback();

				}
			} else {
				retorno = -6;
				TransactionManager.getInstance().getTransaction().rollback();
			}
			TransactionManager.getInstance().deleteTransaction();
		}
		return retorno;

	}

	public int devolverVenta(int idVenta, int idModelo, int cantidad) {
		int retorno = -1;
		ParseadorVariables parseador = new ParseadorVariables();
		if (parseador.comprobarNumeroPositivo(idVenta) && parseador.comprobarNumeroPositivo(idModelo)
				&& parseador.comprobarNumeroPositivo(cantidad)) {
			FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
			TransactionManager.getInstance().newTransaction().start();
			TVenta venta = factoriaIntegracion.generaDAOVentas().read(idVenta);
			TModelo modelo = factoriaIntegracion.generaDAOModelo().read(idModelo);
			if (venta != null && modelo != null && venta.isActivo()) {
				if (venta.getLineasVenta().containsKey(idModelo)) {
					LineaVenta l = venta.getLineasVenta().get(idModelo);
					if (l.getCantidad() >= cantidad) {
						float precioEliminado = modelo.getPrecio() * cantidad;
						l.setCantidad(l.getCantidad() - cantidad);
						l.setPrecioTotal(l.getPrecioTotal() - precioEliminado);
						venta.setPrecioTotal(venta.getPrecioTotal() - precioEliminado);
						modelo.setStock(modelo.getStock() + cantidad);
						retorno = factoriaIntegracion.generaDAOModelo().update(modelo);
						if (retorno != -1) {
							retorno = factoriaIntegracion.generaDAOVentas().update(venta);
							if (retorno != -1) {
								TransactionManager.getInstance().getTransaction().commit();
							} else
								TransactionManager.getInstance().getTransaction().rollback();
						} else
							TransactionManager.getInstance().getTransaction().rollback();
					} else {
						retorno = -3; // Cantidad mayor a la vendida
						TransactionManager.getInstance().getTransaction().rollback();
					}
				} else {
					retorno = -4; // Modelo no existia en la venta
					TransactionManager.getInstance().getTransaction().rollback();
				}
			} else {
				if (modelo == null)
					retorno = -5;//Modelo no existe
				else if (venta == null)
					retorno = -6;//Venta no existe
				else
					retorno = -7;//Venta inactiva
				TransactionManager.getInstance().getTransaction().rollback();
			}
			TransactionManager.getInstance().deleteTransaction();
		}
		return retorno;

	}

	public int eliminarVenta(int id) {
		int retorno = -1;
		ParseadorVariables parseador = new ParseadorVariables();
		if (parseador.comprobarNumeroPositivo(id)) {
			FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
			TransactionManager.getInstance().newTransaction().start();
			TVenta venta = factoriaIntegracion.generaDAOVentas().read(id);
			if (venta != null && venta.isActivo()) {
				retorno = factoriaIntegracion.generaDAOVentas().delete(id);
				if (retorno != -1) {
					for (LineaVenta l : venta.getLineasVenta().values()) {
						TModelo modelo = factoriaIntegracion.generaDAOModelo().read(l.getIdArticulo());
						modelo.setStock(modelo.getStock() + l.getCantidad());
						if (!modelo.getActivo())
							modelo.setActivo(true);
						factoriaIntegracion.generaDAOModelo().update(modelo);
					}
					TransactionManager.getInstance().getTransaction().commit();
				} else {
					// Ha fallado al borrar
					retorno = -1;
					TransactionManager.getInstance().getTransaction().rollback();
				}
			} else {
				if (venta != null)
					// La venta no existe
					retorno = -2;
				else
					// La venta ya estaba inactiva
					retorno = -3;
				TransactionManager.getInstance().getTransaction().rollback();
			}

			TransactionManager.getInstance().deleteTransaction();

		} else {
			// El id no es válido
			retorno = -4;
		}
		return retorno;
	}

	public TVenta leerVenta(int id) {
		TVenta retorno = null;
		ParseadorVariables parseador = new ParseadorVariables();
		if (parseador.comprobarNumeroPositivo(id)) {
			FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
			TransactionManager.getInstance().newTransaction().start();
			retorno = factoriaIntegracion.generaDAOVentas().read(id);
			if (retorno != null) {
				TransactionManager.getInstance().getTransaction().commit();

			} else {
				retorno = null;
				TransactionManager.getInstance().getTransaction().rollback();
			}
		}
		TransactionManager.getInstance().deleteTransaction();
		return retorno;
	}

	public ArrayList<TVenta> leerListaVentas() {
		FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
		TransactionManager.getInstance().newTransaction().start();
		ArrayList<TVenta> retorno = factoriaIntegracion.generaDAOVentas().readAll();
		if (retorno != null && retorno.size() > 0)
			TransactionManager.getInstance().getTransaction().commit();
		else {
			retorno = null;
			TransactionManager.getInstance().getTransaction().rollback();
		}
		TransactionManager.getInstance().deleteTransaction();
		return retorno;
	}

	public TDetallesVenta obtenerDetallesVenta(int idVenta) {
		TransactionManager.getInstance().newTransaction().start();
		TDetallesVenta retorno = null;
		// Obtener TVenta
		TVenta tV = FactoriaIntegracion.getInstance().generaDAOVentas().read(idVenta);
		if (tV != null && tV.isActivo()) {
			// Obtener TCliente
			TCliente tC = FactoriaIntegracion.getInstance().generaDAOCliente().read(tV.getIdCliente());
			// Obtener lista TModelo
			ArrayList<TModelo> lista = new ArrayList<TModelo>();

			for (int i : tV.getLineasVenta().keySet()) {
				lista.add(FactoriaIntegracion.getInstance().generaDAOModelo().read(i));
			}
			retorno = new TDetallesVenta(tV, tC, lista);
			TransactionManager.getInstance().getTransaction().commit();
		} else {
			TransactionManager.getInstance().getTransaction().rollback();
		}
		TransactionManager.getInstance().deleteTransaction();

		return retorno;
	}
}