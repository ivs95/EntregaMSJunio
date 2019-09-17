package Integración.Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Integración.Transaction.TransactionManager;

public class DAOModeloImp implements DAOModelo {

	public Integer create(TModelo tModelo) {
		int id = -1;
		int activo = 0;
		if (tModelo.getActivo())
			activo = 1;
		String insercion = "INSERT INTO modelos (nombre,precio,activo,tipo,extra,stock) VALUES (?,?,?,?,?,?)";
		try {
			Connection conn = (Connection) TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				PreparedStatement stmt = conn.prepareStatement(insercion, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, tModelo.getNombre());
				stmt.setFloat(2, tModelo.getPrecio());
				stmt.setInt(3, activo);
				stmt.setString(4, tModelo.getTipoVehiculo());
				if (tModelo.getTipoVehiculo().toLowerCase().equals("coche")) {
					stmt.setInt(5, ((TCoche) tModelo).getNumPuertas());
				} else if (tModelo.getTipoVehiculo().toLowerCase().equals("moto")) {
					stmt.setInt(5, ((TMoto) tModelo).getCilindrada());
				}
				stmt.setInt(6, tModelo.getStock());
				stmt.execute();
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next())
					id = rs.getInt(1);
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return id;
	}

	public Integer update(TModelo tModelo) {
		int retorno = -1;

		int activo = 0;
		if (tModelo.getActivo())
			activo = 1;

		int extra = 0;
		if (tModelo.getTipoVehiculo().toLowerCase().equals("coche")) {
			extra = ((TCoche) tModelo).getNumPuertas();
		} else
			extra = ((TMoto) tModelo).getCilindrada();

		String actualizacion = "UPDATE modelos SET  id='" + tModelo.getID() + "', nombre='" + tModelo.getNombre()
				+ "', precio='" + tModelo.getPrecio() + "', activo='" + activo + "', tipo='" + tModelo.getTipoVehiculo()
				+ "', extra='" + extra + "', stock='" + tModelo.getStock() + "' WHERE id='" + tModelo.getID() + "'";
		try {
			Connection conn = (Connection) TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(actualizacion);
				retorno = tModelo.getID();
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			retorno = -1;
		}
		return retorno;
	}

	public Integer delete(Integer idModelo) {
		int retorno = -1;

		String borrado = "UPDATE modelos SET activo=0 WHERE id=" + idModelo;
		try {
			Connection conn = (Connection) TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(borrado);
				retorno = idModelo;
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			retorno = -1;
		}
		return retorno;
	}

	public TModelo read(Integer idModelo) {
		String lectura = "SELECT * FROM modelos WHERE id=" + idModelo + " FOR UPDATE;";
		TModelo retorno = null;
		try {
			Connection conn = (Connection) TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(lectura);
				if (rs.next()) {
					String tipo = rs.getString("tipo").toLowerCase();
					if (tipo.equals("coche")) {
						retorno = new TCoche(idModelo, rs.getFloat("precio"), rs.getBoolean("activo"),
								rs.getInt("extra"), rs.getInt("stock"), rs.getString("nombre"));
					} else
						retorno = new TMoto(idModelo, rs.getFloat("precio"), rs.getBoolean("activo"),
								rs.getInt("extra"), rs.getInt("stock"), rs.getString("nombre"));
				}
				rs.close();
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			retorno = null;
		}
		return retorno;
	}

	public ArrayList<TModelo> readAll() {
		String lectura = "SELECT * FROM modelos WHERE activo=" + true + " FOR UPDATE;";
		ArrayList<TModelo> retorno = new ArrayList<TModelo>();
		try {
			Connection conn = (Connection) TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(lectura);
				while (rs.next()) {
					String tipo = rs.getString("tipo").toLowerCase();
					if (tipo.equals("coche")) {
						retorno.add(new TCoche(rs.getInt("id"), rs.getFloat("precio"), rs.getBoolean("activo"),
								rs.getInt("extra"), rs.getInt("stock"), rs.getString("nombre")));
					} else
						retorno.add(new TMoto(rs.getInt("id"), rs.getFloat("precio"), rs.getBoolean("activo"),
								rs.getInt("extra"), rs.getInt("stock"), rs.getString("nombre")));
				}
				stmt.close();

			}
		} catch (SQLException e) {
			retorno = null;
		}
		return retorno;
	}

	public TModelo readByNombre(String nombre) {
		String lectura = "SELECT * FROM modelos WHERE Nombre='" + nombre + "' FOR UPDATE;";
		TModelo retorno = null;
		try {
			Connection conn = (Connection) TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(lectura);
				if (rs.next()) {
					String tipo = rs.getString("tipo").toLowerCase();
					if (tipo.equals("coche")) {
						retorno = new TCoche(rs.getInt("id"), rs.getFloat("precio"), rs.getBoolean("activo"),
								rs.getInt("extra"), rs.getInt("stock"), rs.getString("nombre"));
					} else
						retorno = new TMoto(rs.getInt("id"), rs.getFloat("precio"), rs.getBoolean("activo"),
								rs.getInt("extra"), rs.getInt("stock"), rs.getString("nombre"));

				}
				stmt.close();

			}
		} catch (SQLException e) {
			retorno = null;
		}
		return retorno;
	}
}