
package Integración.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionMySQL implements Transaction {
	
	private Connection connection;

	@Override
	public void commit() {
		try{
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Object getResource() {
		return connection;
	}

	@Override
	public void rollback() {
		try{
			connection.rollback();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void start() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/SensaCar","root", "1234");
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}