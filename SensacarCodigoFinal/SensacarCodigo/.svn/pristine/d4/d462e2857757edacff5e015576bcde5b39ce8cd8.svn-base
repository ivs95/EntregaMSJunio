package Negocio.Competencia;

import Negocio.Empleado.Empleado;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import Integración.Competencia.TTiene;

@Entity
@IdClass(TieneID.class)
@NamedQueries({
		@NamedQuery(name = "Negocio.Competencia.Tiene.readByEmpleado", query = "select obj from Tiene obj where obj.empleado = :empleado and obj.activo = true"),
		@NamedQuery(name = "Negocio.Competencia.Tiene.readByCompetencia", query = "select obj from Tiene obj where obj.competencia = :competencia and obj.activo = true") })
public class Tiene {

	private Boolean activo;

	private Integer nivel;

	@Id
	@ManyToOne
	private Competencia competencia;

	@Id
	@ManyToOne
	private Empleado empleado;

	public Tiene() {
	}

	public Tiene(Competencia competencia, Empleado empleado, Integer nivel) {
		this.competencia = competencia;
		this.empleado = empleado;
		this.nivel = nivel;
		this.activo = true;
	}

	public Boolean getActivo() {

		return this.activo;
	}

	public Integer getNivel() {

		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

	public Competencia getCompetencia() {
		return this.competencia;
	}

	public TTiene toTransfer() {
		// TODO Auto-generated method stub
		return new TTiene(activo, nivel, empleado.toTransfer(), competencia.toTransfer());
	}
}