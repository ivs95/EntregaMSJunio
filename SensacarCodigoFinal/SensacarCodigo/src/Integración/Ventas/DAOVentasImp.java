
package Integración.Ventas;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Integración.Transaction.TransactionManager;

public class DAOVentasImp implements DAOVentas {

	@Override
	public int create(TVenta tVenta) {
		int id = -1;
		int activo = 1;
		if (!tVenta.isActivo())
			activo = 0;

		String insercion = "INSERT INTO ventas (precioTotal,fecha,idCliente,activo) VALUES (?,?,?,?)";
		try {
			Connection conn = (Connection) TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				
				PreparedStatement stmt = conn.prepareStatement(insercion, Statement.RETURN_GENERATED_KEYS);
				stmt.setFloat(1, tVenta.getPrecioTotal());
				stmt.setDate(2, tVenta.getFecha());
				stmt.setInt(3, tVenta.getIdCliente());
				stmt.setInt(4, activo);
				stmt.execute();
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next())
					id = rs.getInt(1);
				for (LineaVenta l : tVenta.getLineasVenta().values())
					insertaLineaVenta(l, conn, id);
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			id = -1;
		}
		return id;
	}

	@Override
	public TVenta read(int id) {
		String lectura = "SELECT * FROM ventas WHERE id=" + id + " FOR UPDATE;";
		TVenta retorno = null;
		try {
			Connection conn = (Connection) TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(lectura);
				if (rs.next()) {
					HashMap<Integer, LineaVenta> lineasVenta = getLineasVentas(id, conn);
					retorno = new TVenta(rs.getBoolean("activo"), rs.getDate("fecha"), rs.getInt("idCliente"), id,
							lineasVenta, rs.getFloat("precioTotal"));
				}
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			retorno = null;
		}
		return retorno;
	}

	@Override
	public ArrayList<TVenta> readAll() {
		String lectura = "SELECT * FROM ventas WHERE activo= " + true + " FOR UPDATE;";
		ArrayList<TVenta> retorno = new ArrayList<TVenta>();
		try {
			Connection conn = (Connection) TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(lectura);
				while (rs.next()) {
					int id = rs.getInt("id");
					HashMap<Integer, LineaVenta> lineasVenta = getLineasVentas(id, conn);
					TVenta venta = new TVenta(rs.getBoolean("activo"), rs.getDate("fecha"), rs.getInt("idCliente"), id,
							lineasVenta, rs.getFloat("precioTotal"));
					retorno.add(venta);
				}
				stmt.close();
			}
		} catch (SQLException e) {
			retorno = null;
		}
		return retorno;
	}

	@Override
	public int update(TVenta tVenta) {
		int retorno = -1;
		int activo = 1;
		if (!tVenta.isActivo())
			activo = 0;
		String actualizacion = "UPDATE ventas SET  id='" + tVenta.getId() + "', precioTotal='" + tVenta.getPrecioTotal()
				+ "', fecha='" + tVenta.getFecha() + "', activo='" + activo + "' WHERE id='" + tVenta.getId() + "'";
		try {
			Connection conn = (Connection) TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(actualizacion);
				for (LineaVenta l : tVenta.getLineasVenta().values())
					updateTablaLineaVenta(l, conn, tVenta.getId());
				retorno = tVenta.getId();
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			retorno = -1;
		}
		return retorno;
	}

	@Override
	public int delete(int id) {
		int retorno = -1;
		String borrado = "UPDATE ventas SET activo=0 WHERE id=" + id;
		try {
			Connection conn = (Connection) TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(borrado);
				retorno = id;
				stmt.close();
			}
		} catch (SQLException e) {
			retorno = -1;
		}
		return retorno;
	}



	private void insertaLineaVenta(LineaVenta linea, Connection conexion, int idVenta) {
		String insercion = "INSERT INTO lineaVenta (idArticulo, idVenta, cantidad, precioTotal) VALUES (?,?,?,?)";
		try {
			PreparedStatement stmt = conexion.prepareStatement(insercion);
			stmt.setInt(1, linea.getIdArticulo());
			stmt.setInt(2, idVenta);
			stmt.setInt(3, linea.getCantidad());
			stmt.setFloat(4, linea.getPrecioTotal());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private HashMap<Integer, LineaVenta> getLineasVentas(int idVenta, Connection conexion) {
		String lectura = "SELECT * FROM lineaVenta WHERE idVenta=" + idVenta + " FOR UPDATE;";
		HashMap<Integer, LineaVenta> retorno = new HashMap<Integer, LineaVenta>();
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(lectura);
			while (rs.next()) {
				int idArticulo = rs.getInt("idArticulo");
				LineaVenta lineaventa = new LineaVenta(idArticulo, rs.getInt("cantidad"),
						rs.getFloat("precioTotal"));
				retorno.put(idArticulo, lineaventa);
			}
			stmt.close();
		} catch (SQLException e) {
			retorno = null;
		}
		return retorno;
	}

	private void updateTablaLineaVenta(LineaVenta linea, Connection conexion, int idVenta) {
		String update = "UPDATE lineaVenta SET idArticulo='" + linea.getIdArticulo() + "', idVenta='"
				+ idVenta + "', cantidad='" + linea.getCantidad() + "', precioTotal='"
				+ linea.getPrecioTotal() + "' WHERE idVenta='" + idVenta + "' AND idArticulo='"
				+ linea.getIdArticulo() + "'";
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeUpdate(update);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}