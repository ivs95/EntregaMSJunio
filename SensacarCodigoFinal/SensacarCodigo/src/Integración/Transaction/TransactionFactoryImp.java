/**
 * 
 */
package Integración.Transaction;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author nacho710
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionFactoryImp extends TransactionFactory {

	@Override
	public Transaction createTransaction() {
		return new TransactionMySQL();
	}
}