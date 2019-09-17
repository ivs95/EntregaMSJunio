
package Integración.Ventas;

import java.util.ArrayList;


public interface DAOVentas {
	
	public int create(TVenta venta);


	public int delete(int idABorrar);

	
	public TVenta read(int id);

	
	public ArrayList<TVenta> readAll();


	public int update(TVenta venta);


}