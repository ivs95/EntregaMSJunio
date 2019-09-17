
package Integración.Transaction;


public interface Transaction {
	
	public void commit();

	
	public Object getResource();

	
	public void rollback();

	
	public void start();
}