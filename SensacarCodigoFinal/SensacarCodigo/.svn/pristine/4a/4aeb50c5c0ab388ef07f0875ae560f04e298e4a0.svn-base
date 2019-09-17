package Integración.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Integración.Transaction.TransactionManager;

public class DAOClienteImp implements DAOCliente {
	
	public Integer create(TCliente tCliente) {
		int activo = 0;
		if(tCliente.getActivo())
			activo = 1;
		int id =-1;
		String insercion = "INSERT INTO cliente (DNI,Nombre,Telefono,Activo) VALUES (?,?,?,?)";
			
		Connection conn =(Connection)TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				try {				
					PreparedStatement stmt = conn.prepareStatement(insercion ,Statement.RETURN_GENERATED_KEYS);
					stmt.setString(1, tCliente.getDNI());
					stmt.setString(2, tCliente.getNombre());
					stmt.setInt(3, tCliente.getTelefono() );
					stmt.setInt(4, activo);
					stmt.execute();
					ResultSet rs = stmt.getGeneratedKeys();
					if(rs.next())
						id = rs.getInt(1);
					stmt.close();
					if (!stmt.isClosed())
						stmt.close();
				} catch (  SQLException e) {
					e.printStackTrace();
				}
			}
		
		return id ;
		
		
	}


	public Integer delete(Integer idCliente) {
		int retorno = -1;

		String borrado = "UPDATE cliente SET activo=0 WHERE id=" + idCliente;
		try {
			Connection conn = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(borrado);
				retorno = idCliente;
				stmt.close();

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			retorno = -1;
		}
		return retorno;
	}

	
	public TCliente read(Integer idCliente) {
		
		String lectura = "SELECT * FROM cliente WHERE id=" + idCliente + " FOR UPDATE;";
		TCliente retorno = null;
		try {
			Connection conn = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(lectura);
				if (rs.next()) {
					retorno = new TCliente(idCliente,rs.getString("dni"), rs.getString("nombre"),rs.getInt("telefono"), 
							rs.getBoolean("activo"));
				}
				stmt.close();
			}
		} catch (SQLException e) {
			retorno = null;
		}
		return retorno;
		
	}


	public ArrayList<TCliente> readAll() {
		String lectura = "SELECT * FROM cliente WHERE activo=1 FOR UPDATE;";
		ArrayList<TCliente> retorno = new ArrayList<TCliente>();
		try {
			Connection conn = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(lectura);
				while (rs.next()) {
					TCliente cliente = new TCliente(rs.getInt("id"), rs.getString("dni"),rs.getString("nombre"),rs.getInt("telefono"),
							rs.getBoolean("activo"));
					retorno.add(cliente);
				}
				stmt.close();

			}
		} catch (SQLException e) {
			retorno = null;
		}
		return retorno;
	}

	
	public Integer update(TCliente tCliente) {
		int retorno = -1;
		int activo = 0;
		if(tCliente.getActivo())
			activo = 1;
		String actualizacion = "UPDATE cliente SET  dni='" + tCliente.getDNI() + "', id='" + tCliente.getId()
				+ "', nombre='" + tCliente.getNombre() + "', telefono='" + tCliente.getTelefono() + "', Activo='"
				+ activo +"' WHERE id=" + tCliente.getId();
		try {
			Connection conn =(Connection)TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(actualizacion);
				retorno = tCliente.getId();
				stmt.close();

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			retorno = -1;
		}

		return retorno;
	}

	
	public TCliente readByDNI(String DNI) {
		String lectura = "SELECT * FROM cliente WHERE dni='" + DNI + "' FOR UPDATE;";
		TCliente retorno = null;
		try {
			Connection conn = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(lectura);
				if (rs.next()) {
					retorno = new TCliente( rs.getInt("id"),rs.getString("dni"),rs.getString("nombre"),rs.getInt("telefono"), 
							rs.getBoolean("activo"));
				}
				stmt.close();

			}
		} catch (SQLException e) {
			retorno = null;
		}
		return retorno;
	}
}