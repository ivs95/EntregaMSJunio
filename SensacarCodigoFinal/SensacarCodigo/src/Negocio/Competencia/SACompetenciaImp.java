
package Negocio.Competencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Integración.Competencia.TCompetencia;
import Integración.Competencia.TTiene;
import Negocio.Empleado.Empleado;
import Negocio.ParseadorVariables.ParseadorVariables;

public class SACompetenciaImp implements SACompetencia {

	public int crearCompetencia(TCompetencia comp) {
		int retorno = -1;

		if (comp != null) {
			Competencia competencia = new Competencia(comp);
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Sensacar");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			TypedQuery<Competencia> consulta = entityManager
					.createNamedQuery("Negocio.Competencia.Competencia.readByName", Competencia.class)
					.setParameter("nombre", comp.getNombre());
			List<Competencia> existe = consulta.getResultList();
			if (existe.isEmpty()) {
				competencia.setActivo(true);
				entityManager.persist(competencia);
				entityTransaction.commit();
				retorno = competencia.getId();
			} else {
				Competencia compAntigua = existe.get(0);
				if (!compAntigua.getActivo()) {
					compAntigua.setActivo(true);
					entityTransaction.commit();
					retorno = compAntigua.getId();
				} else {
					retorno = -2;
					entityTransaction.rollback();
				}
			}
			entityManager.close();
			emfactory.close();

		}

		return retorno;
	}

	public int eliminarCompetencia(Integer id) {
		int retorno = -1;
		if (id != null) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Sensacar");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Competencia competencia = entityManager.find(Competencia.class, id);
			if (competencia != null) {
				if (competencia.getActivo()) {
					TypedQuery<Tiene> consulta = entityManager
							.createNamedQuery("Negocio.Competencia.Tiene.readByCompetencia", Tiene.class);
					consulta.setParameter("competencia", competencia);
					if (consulta.getResultList().isEmpty()) {
						competencia.setActivo(false);
						entityTransaction.commit();
						retorno = id;
					} else {
						boolean empleadoActivo = false;
						for (Tiene t : consulta.getResultList()) {
							if (t.getActivo()) {
								empleadoActivo = true;
							}
						}
						if (!empleadoActivo) {
							competencia.setActivo(false);
							entityTransaction.commit();
							retorno = id;
						} else {
							retorno = -2;
							entityTransaction.rollback();
						}
					}
				} else
					entityTransaction.rollback();
			} else
				entityTransaction.rollback();
			entityManager.close();
			emfactory.close();
		}
		return retorno;
	}

	public int añadirCompetenciaAEmpleado(Integer idCompetencia, Integer idEmpleado, Integer nivel) {
		int retorno = -1;
		ParseadorVariables parseador = new ParseadorVariables();
		if (idCompetencia != null && idEmpleado != null && nivel != null && parseador.comprobarNumeroPositivo(nivel)) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Sensacar");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Competencia competencia = entityManager.find(Competencia.class, idCompetencia,
					LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			Empleado empleado = entityManager.find(Empleado.class, idEmpleado, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			if (competencia != null && empleado != null && competencia.getActivo() && empleado.getActivo()) {
				TieneID tieneID = new TieneID(idCompetencia, idEmpleado);
				Tiene tiene = entityManager.find(Tiene.class, tieneID);
				if (tiene == null) {
					tiene = new Tiene(competencia, empleado, nivel);
					entityManager.persist(tiene);
				} else {
					if (!tiene.getActivo()) {
						tiene.setActivo(true);
					}
					tiene.setNivel(nivel);
				}
				retorno = nivel;
				entityTransaction.commit();
			} else {
				entityTransaction.rollback();
			}
			entityManager.close();
			emfactory.close();
		} else if (!parseador.comprobarNumeroPositivo(nivel))
			retorno = -2;
		return retorno;
	}

	public int eliminarCompetenciaDeEmpleado(Integer idCompetencia, Integer idEmpleado) {
		int retorno = -1;
		ParseadorVariables parseador = new ParseadorVariables();
		if (idCompetencia != null && idEmpleado != null && parseador.comprobarNumeroPositivo(idCompetencia)
				&& parseador.comprobarNumeroPositivo(idEmpleado)) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Sensacar");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Competencia competencia = entityManager.find(Competencia.class, idCompetencia,
					LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			Empleado empleado = entityManager.find(Empleado.class, idEmpleado, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			if (competencia != null && empleado != null && competencia.getActivo() && empleado.getActivo()) {
				TieneID tieneID = new TieneID(idCompetencia, idEmpleado);
				Tiene tiene = entityManager.find(Tiene.class, tieneID);
				if (tiene != null && tiene.getActivo()) {
					tiene.setActivo(false);
					retorno = idCompetencia;
					entityTransaction.commit();
				} else
					entityTransaction.rollback();
			}
			entityManager.close();
			emfactory.close();
		}
		return retorno;
	}

	public int actualizarCompetenciaDeEmpleado(Integer idCompetencia, Integer idEmpleado, Integer nivel) {
		int retorno = -1;
		ParseadorVariables parseador = new ParseadorVariables();
		if (idCompetencia != null && idEmpleado != null && nivel != null && parseador.comprobarNumeroPositivo(nivel)) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Sensacar");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Competencia competencia = entityManager.find(Competencia.class, idCompetencia,
					LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			Empleado empleado = entityManager.find(Empleado.class, idEmpleado, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			if (competencia != null && empleado != null && competencia.getActivo() && empleado.getActivo()) {
				TieneID tieneID = new TieneID(idCompetencia, idEmpleado);
				Tiene tiene = entityManager.find(Tiene.class, tieneID);
				if (tiene != null) {
					tiene.setNivel(nivel);
					if (!tiene.getActivo())
						tiene.setActivo(true);
					retorno = nivel;
					entityTransaction.commit();
				} else
					entityTransaction.rollback();
			}
			entityManager.close();
			emfactory.close();
		}
		else if (!parseador.comprobarNumeroPositivo(nivel))
			retorno = -2;
		return retorno;
	}

	@Override
	public List<TTiene> leerEmpleadosDeCompetencia(Integer idCompetencia) {
		ParseadorVariables parseador = new ParseadorVariables();
		List<TTiene> retorno = new ArrayList<>();
		if (idCompetencia != null && parseador.comprobarNumeroPositivo(idCompetencia)) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Sensacar");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Competencia competencia = entityManager.find(Competencia.class, idCompetencia);
			if (competencia != null && competencia.getActivo()) {
				TypedQuery<Tiene> consulta = entityManager
						.createNamedQuery("Negocio.Competencia.Tiene.readByCompetencia", Tiene.class);
				consulta.setParameter("competencia", competencia);
				if (!consulta.getResultList().isEmpty()) {
					for (Tiene t : consulta.getResultList()) {
						retorno.add(t.toTransfer());
					}
					entityTransaction.commit();
				} else
					entityTransaction.rollback();

			} else {
				entityTransaction.rollback();
			}
			entityManager.close();
			emfactory.close();
		}
		return retorno;
	}
}