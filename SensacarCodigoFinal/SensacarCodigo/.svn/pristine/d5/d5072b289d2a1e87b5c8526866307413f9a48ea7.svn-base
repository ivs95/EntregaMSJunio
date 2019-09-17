/**
 * 
 */
package Integración.Transaction;

import java.util.concurrent.ConcurrentHashMap;


public class TransactionManagerImp extends TransactionManager {

	
	private ConcurrentHashMap<Thread,Transaction> transacciones = new ConcurrentHashMap<Thread,Transaction>(); 

	public void deleteTransaction() {
		this.transacciones.remove(Thread.currentThread());
	}

	public Transaction getTransaction() {
		return this.transacciones.get(Thread.currentThread());
	}

	public Transaction newTransaction() {
		this.transacciones.put(Thread.currentThread(), TransactionFactory.getInstance().createTransaction());
		return getTransaction();
	}
}