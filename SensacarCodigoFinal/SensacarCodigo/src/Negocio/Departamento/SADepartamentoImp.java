package Negocio.Departamento;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Integración.Departamento.TDepartamento;
import Negocio.Empleado.Empleado;

public class SADepartamentoImp implements SADepartamento {

	public int crearDepartamento(TDepartamento dept) {

		int retorno = -1;

		if (dept != null) {
			Departamento departamento = new Departamento(dept);
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Sensacar");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			TypedQuery<Departamento> consulta = entityManager
					.createNamedQuery("Negocio.Departamento.Departamento.readByFuncion", Departamento.class);
			consulta.setParameter("funcion", dept.getFuncion());
			List<Departamento> existe = consulta.getResultList();
			if (existe.isEmpty()) {
				departamento.setActivo(dept.getActivo());
				entityManager.persist(departamento);
				entityTransaction.commit();
				retorno = departamento.getID();
			} else {
				Departamento deptAntiguo = existe.get(0);
				if (!deptAntiguo.getActivo()) {
					deptAntiguo.setActivo(true);
					deptAntiguo.setCapacidadMaxima(dept.getCapacidad_max());
					entityTransaction.commit();
					retorno = deptAntiguo.getID();
				} else
					entityTransaction.rollback();
			}
			entityManager.close();
			emfactory.close();

		}

		return retorno;
	}

	public int borrarDepartamento(Integer idDepartamento) {
		int retorno = -1;
		if (idDepartamento != null) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Sensacar");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Departamento departamento = entityManager.find(Departamento.class, idDepartamento);
			if (departamento != null) {
				if (departamento.getActivo()) {
					TypedQuery<Empleado> consulta = entityManager
							.createNamedQuery("Negocio.Empleado.Empleado.findByDepartamento", Empleado.class);
					consulta.setParameter("departamento", departamento);
					List<Empleado> empleados = consulta.getResultList();
					if (empleados.isEmpty()) {
						departamento.setActivo(false);
						entityTransaction.commit();
						retorno = idDepartamento;
					} else {
						boolean empleadosActivos = false;
						for (Empleado e : empleados) {
							if (e.getActivo())
								empleadosActivos = true;
						}
						if (empleadosActivos) {
							//Departamento con empleados activos
							retorno = -3;
							entityTransaction.rollback();
						} else {
							departamento.setActivo(false);
							entityTransaction.commit();
							retorno = idDepartamento;
						}
					}
				} else
					entityTransaction.rollback();
			} else{
				//Departamento no existe
				retorno = -2;
				entityTransaction.rollback();
			}
			entityManager.close();
			emfactory.close();
		}
		return retorno;
	}

	public int calcularNominaDeDepartamento(Integer idDepartamento) {
		int nominas = 0;
		if (idDepartamento != null) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Sensacar");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Departamento departamento = entityManager.find(Departamento.class, idDepartamento, LockModeType.OPTIMISTIC);
			if (departamento!=null && departamento.getActivo()){
				TypedQuery<Empleado> consulta = entityManager
						.createNamedQuery("Negocio.Empleado.Empleado.findByDepartamento", Empleado.class);
				consulta.setParameter("departamento", departamento);
				List<Empleado> empleados = consulta.getResultList();
				for (Empleado e : empleados) {
					entityManager.lock(e, LockModeType.OPTIMISTIC);
					nominas += e.calcularNomina();
				}
				entityTransaction.commit();
			}
			else if( !departamento.getActivo()) {
				entityTransaction.rollback();
				nominas=-1;
			}
			else {
				nominas=-2;
				entityTransaction.rollback();
			}
			entityManager.close();
			emfactory.close();
		}


		return nominas;
	}

	@Override
	public TDepartamento leerDepartamento(int dato) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Sensacar");
		EntityManager entityManager = emfactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Departamento departamento = entityManager.find(Departamento.class, dato);
		entityTransaction.commit();
		entityManager.close();
		emfactory.close();
		if (departamento != null)
			return departamento.toTransfer();
		else
			return null;
	}
}