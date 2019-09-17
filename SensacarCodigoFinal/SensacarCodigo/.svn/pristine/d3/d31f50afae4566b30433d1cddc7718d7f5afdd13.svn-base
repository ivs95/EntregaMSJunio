
package Integración.Transaction;


public abstract class TransactionManager {

	private static TransactionManager instance;

	
	public static TransactionManager getInstance() {
		if (instance == null)
			instance = new TransactionManagerImp();
		return instance;
	}

	public abstract void deleteTransaction();

	public abstract Transaction getTransaction();

	public abstract Transaction newTransaction();
}