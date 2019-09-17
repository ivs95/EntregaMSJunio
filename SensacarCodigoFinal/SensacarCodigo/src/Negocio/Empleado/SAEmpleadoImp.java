package Negocio.Empleado;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Integración.Empleado.TEmpleado;
import Integración.Empleado.TEmpleadoCompleto;
import Integración.Empleado.TEmpleadoParcial;
import Negocio.Competencia.Tiene;
import Negocio.Departamento.Departamento;
import Negocio.ParseadorVariables.ParseadorVariables;

public class SAEmpleadoImp implements SAEmpleado {

	public int crearEmpleado(TEmpleado emp) {
		int retorno = -1;
		ParseadorVariables p = new ParseadorVariables();
		if (emp != null && p.comprobarDNI(emp.getDNI())) {
			Empleado empleado = null;
			boolean sueldoValido = true;
			if (emp instanceof TEmpleadoCompleto) {
				if (!p.comprobarNumeroPositivo(((TEmpleadoCompleto) emp).getSueldoBase())
						|| !p.comprobarNumeroPositivo(((TEmpleadoCompleto) emp).getDietas()))
					sueldoValido = false;
				empleado = new EmpleadoTC((TEmpleadoCompleto) emp);
			} else if (emp instanceof TEmpleadoParcial) {
				if (!p.comprobarNumeroPositivo(((TEmpleadoParcial) emp).getHorasSemana())
						|| !p.comprobarNumeroPositivo(((TEmpleadoParcial) emp).getSueldoHora()))
					sueldoValido = false;
				empleado = new EmpleadoTP((TEmpleadoParcial) emp);
			}
			if (sueldoValido) {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Sensacar");
				EntityManager entityManager = emfactory.createEntityManager();
				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				TypedQuery<Empleado> consultaDNI = entityManager.createNamedQuery("Negocio.Empleado.Empleado.findByDNI",
						Empleado.class);
				consultaDNI.setParameter("DNI", empleado.getDNI());
				List<Empleado> existe = consultaDNI.getResultList();
				// Comprobar que ningun empleado con ese DNI existia
				if (existe.isEmpty()) {
					empleado.setActivo(true);
					Departamento departamento = entityManager.find(Departamento.class, emp.getDepartamento());
					// Comprobar que el departamento existe y está activo
					if (departamento != null && departamento.getActivo()) {
						entityManager.lock(departamento, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
						TypedQuery<Empleado> consultaDepartamento = entityManager
								.createNamedQuery("Negocio.Empleado.Empleado.findByDepartamento", Empleado.class);
						consultaDepartamento.setParameter("departamento", departamento);
						if (consultaDepartamento.getResultList().size() < departamento.getCapacidadMaxima()) {
							empleado.setDepartamento(departamento);
							entityManager.persist(empleado);
							entityTransaction.commit();
							retorno = empleado.getId();
						}
					} else
						entityTransaction.rollback();

				} else {
					Empleado empleadoAntiguo = existe.get(0);
					Departamento departamento = entityManager.find(Departamento.class,
							empleadoAntiguo.getDepartamento().getID());

					if (!empleadoAntiguo.getActivo() && departamento.getActivo()) {
						entityManager.lock(departamento, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
						TypedQuery<Empleado> consultaDepartamento = entityManager
								.createNamedQuery("Negocio.Empleado.Empleado.findByDepartamento", Empleado.class);
						consultaDepartamento.setParameter("departamento", departamento);
						if (consultaDepartamento.getResultList().size() < departamento.getCapacidadMaxima()) {
							empleadoAntiguo.setActivo(true);
							entityTransaction.commit();
							retorno = empleadoAntiguo.getId();
						} else {
							// Departamento lleno
							retorno = -3;
							entityTransaction.rollback();
						}
					} else {
						if (empleadoAntiguo.getActivo()) {
							// Ya existe el empleado
							retorno = -4;
						} else {
							// Departamento inactivo
							retorno = -5;
						}
						entityTransaction.rollback();

					}
				}

				entityManager.close();
				emfactory.close();

			} else
				// Parámetros de sueldo negativos
				retorno = -6;
		} else if (emp != null)
			// DNI inválido
			retorno = -2;

		return retorno;
	}

	public int actualizarEmpleado(TEmpleado empleado) {
		int retorno = -1;
		ParseadorVariables p = new ParseadorVariables();
		if (empleado != null) {
			int idEmpleado = empleado.getID();
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Sensacar");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Empleado empAntiguo = entityManager.find(Empleado.class, idEmpleado);
			if (empAntiguo != null) {
				int idNuevoDepartamento = empleado.getDepartamento();
				Departamento nuevoDepartamento = entityManager.find(Departamento.class, idNuevoDepartamento,
						LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				TypedQuery<Empleado> consultaDepartamento = entityManager
						.createNamedQuery("Negocio.Empleado.Empleado.findByDepartamento", Empleado.class);
				consultaDepartamento.setParameter("departamento", nuevoDepartamento);
				if (nuevoDepartamento != null && nuevoDepartamento.getActivo()
						&& consultaDepartamento.getResultList().size() < nuevoDepartamento.getCapacidadMaxima()) {
					if (empleado instanceof TEmpleadoParcial && empAntiguo instanceof EmpleadoTP
							&& p.comprobarNumeroPositivo(((TEmpleadoParcial) empleado).getNomina())) {
						empAntiguo.setActivo(empleado.getActivo());
						empAntiguo.setDepartamento(nuevoDepartamento);
						empAntiguo.setDNI(empleado.getDNI());
						empAntiguo.setNombre(empleado.getNombre());
						((EmpleadoTP) empAntiguo).setHorasSemana(((TEmpleadoParcial) empleado).getHorasSemana());
						((EmpleadoTP) empAntiguo).setSueldoHora(((TEmpleadoParcial) empleado).getSueldoHora());
						retorno = idEmpleado;
						entityTransaction.commit();

					} else if (empleado instanceof TEmpleadoCompleto && empAntiguo instanceof EmpleadoTC
							&& p.comprobarNumeroPositivo(((TEmpleadoCompleto) empleado).getNomina())) {
						empAntiguo.setActivo(empleado.getActivo());
						empAntiguo.setDepartamento(nuevoDepartamento);
						empAntiguo.setDNI(empleado.getDNI());
						empAntiguo.setNombre(empleado.getNombre());
						((EmpleadoTC) empAntiguo).setDietas(((TEmpleadoCompleto) empleado).getDietas());
						((EmpleadoTC) empAntiguo).setSueldoBase(((TEmpleadoCompleto) empleado).getSueldoBase());
						retorno = idEmpleado;
						entityTransaction.commit();

					} else
						entityTransaction.rollback();

				} else {
					if (nuevoDepartamento == null) {
						// Departamento no existe
						retorno = -2;
					} else if (!nuevoDepartamento.getActivo()) {
						// Departamento inactivo
						retorno = -3;
					} else {
						// Departamento lleno
						retorno = -4;
					}
					entityTransaction.rollback();
				}
			} else {
				entityTransaction.rollback();
			}
			entityManager.close();
			emfactory.close();
		}
		return retorno;
	}

	public int borrarEmpleado(int id) {
		int retorno = -1;
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Sensacar");
		EntityManager entityManager = emfactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Empleado empleado = entityManager.find(Empleado.class, id);
		if (empleado != null) {
			entityManager.lock(empleado.getDepartamento(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			if (empleado.getActivo()) {
				TypedQuery<Tiene> consulta = entityManager.createNamedQuery("Negocio.Competencia.Tiene.readByEmpleado",
						Tiene.class);
				consulta.setParameter("empleado", empleado);
				List<Tiene> competenciasDeEmpleado = consulta.getResultList();
				if (competenciasDeEmpleado.isEmpty()) {
					empleado.setActivo(false);
					entityTransaction.commit();
					retorno = id;
				} else {
					for (Tiene t : competenciasDeEmpleado) {
						t.setActivo(false);
					}
					empleado.setActivo(false);
					entityTransaction.commit();
					retorno = id;
				}
			} else
				entityTransaction.rollback();
		} else
			entityTransaction.rollback();
		entityManager.close();
		emfactory.close();

		return retorno;
	}

	public TEmpleado leerEmpleado(int id) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Sensacar");
		EntityManager entityManager = emfactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Empleado empleado = entityManager.find(Empleado.class, id, LockModeType.OPTIMISTIC);
		entityTransaction.commit();
		entityManager.close();
		emfactory.close();
		if (empleado != null)
			return empleado.toTransfer();
		else
			return null;
	}

	public List<TEmpleado> leerListaEmpleados() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Sensacar");
		EntityManager entityManager = emfactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		TypedQuery<Empleado> consulta = entityManager.createNamedQuery("Negocio.Empleado.Empleado.readAll",
				Empleado.class);
		List<Empleado> retornoAux = consulta.getResultList();
		List<TEmpleado> retorno = new ArrayList<>();
		for (Empleado e : retornoAux)
			retorno.add(e.toTransfer());
		entityTransaction.commit();
		entityManager.close();
		emfactory.close();
		return retorno;
	}

}