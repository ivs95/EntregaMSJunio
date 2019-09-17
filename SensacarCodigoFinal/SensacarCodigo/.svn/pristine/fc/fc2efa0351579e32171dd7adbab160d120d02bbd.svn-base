package Negocio.Ventas;

import java.util.ArrayList;

import Integración.Ventas.TVenta;

public interface SAVenta {

	public TVenta abrirVenta(int idCliente);

	public int devolverVenta(int idVenta, int idModelo, int cantidad);

	public TVenta anadirModeloAVenta(TVenta venta, int idModelo, int cantidad);

	public TVenta eliminarModeloDeVenta(TVenta venta, int idModelo);

	public int cerrarVenta(TVenta venta);

	public int eliminarVenta(int id);

	public TVenta leerVenta(int id);

	public ArrayList<TVenta> leerListaVentas();

	public TDetallesVenta obtenerDetallesVenta(int idVenta);
}