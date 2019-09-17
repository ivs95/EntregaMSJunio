package Integración.Query;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Integración.Modelos.TModelo;
import Integración.Transaction.TransactionManager;


public class QueryModelo implements Query {
	
	public Object execute(Object param) {
		
		Date fecha = ((TQuery)param).getFecha();
		int numVentas = ((TQuery)param).getNumVenta();
		String sql ="select modelos.* from modelos join lineaventa on modelos.id=lineaventa.idArticulo join ventas on lineaventa.idVenta=ventas.id";
		sql+=" where modelos.activo=1 and ventas.fecha>='"+fecha+"' group by modelos.id";
		sql+=" having sum(cantidad)>="+numVentas+";";
		ArrayList<TModelo> retorno = new ArrayList<TModelo>();

		try {
			Connection conn = (Connection) TransactionManager.getInstance().getTransaction().getResource();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					TModelo modelo = new TModelo(rs.getInt("id"), rs.getFloat("precio"),rs.getBoolean("activo"), rs.getString("tipo"), rs.getInt("stock"), rs.getString("nombre"));			
					retorno.add(modelo);
				}
			}
		} catch (SQLException e) {
			retorno = null;
		}
		return retorno;
	}
}