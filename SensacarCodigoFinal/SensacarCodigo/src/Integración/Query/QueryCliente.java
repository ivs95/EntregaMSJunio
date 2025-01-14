package Integración.Query;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Integración.Cliente.TCliente;
import Integración.Transaction.TransactionManager;


public class QueryCliente implements Query {

	public Object execute(Object param) {
		

		ArrayList<TCliente> retorno = new ArrayList<TCliente>();
		Date fecha = ((TQuery)param).getFecha();
		int numVentas = ((TQuery)param).getNumVenta();
		String sql = "select cliente.* from cliente join ventas on cliente.id=ventas.idCliente where cliente.activo=1 and ventas.activo=1 ";
		sql+=" and ventas.fecha>='"+fecha+"'group by cliente.id ";
		sql+="having count(idCliente)>="+numVentas+";";
		try {
			Connection conn = (Connection) TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					TCliente cliente = new TCliente(rs.getInt("id"),rs.getString("dni"), rs.getString("nombre"),rs.getInt("telefono"), 
							rs.getBoolean("activo"));
					retorno.add(cliente);
				}
			}
		} catch (SQLException e) {
			retorno = null;
			System.out.println(e.getMessage());
		}
		return retorno;
	}	
	
}