
package Integración.Ventas;

import java.sql.Date;
import java.util.HashMap;

public class TVenta {

	private boolean activo;

	private Date fecha;

	private int id;

	private int idCliente;

	private float precioTotal;

	private HashMap<Integer, LineaVenta> lineasVenta = new HashMap<Integer, LineaVenta>();

	public TVenta(int idCliente) {
		this.idCliente = idCliente;
		this.activo = true;
	}

	public TVenta(boolean activo, Date fecha, int idCliente, int id, HashMap<Integer, LineaVenta> lineasVenta,
			float precioTotal) {
		this.activo = activo;
		this.fecha = fecha;
		this.id = id;
		this.idCliente = idCliente;
		this.lineasVenta = lineasVenta;
		this.precioTotal = precioTotal;
	}

	public boolean isActivo() {
		return activo;
	}

	public Date getFecha() {
		return fecha;
	}

	public int getId() {
		return id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public HashMap<Integer, LineaVenta> getLineasVenta() {
		return lineasVenta;
	}

	public void setLineasVenta(HashMap<Integer, LineaVenta> lineasVenta) {
		this.lineasVenta = lineasVenta;
	}

}