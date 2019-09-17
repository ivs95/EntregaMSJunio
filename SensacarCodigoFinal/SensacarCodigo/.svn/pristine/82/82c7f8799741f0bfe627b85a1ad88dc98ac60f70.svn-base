package Negocio.Competencia;

import java.io.Serializable;


public class TieneID implements Serializable {

	private static final long serialVersionUID = 1L;

	private int competencia;

	private int empleado;

	public TieneID(){}
	public TieneID(Integer competencia, int empleado) {
		this.competencia = competencia;
		this.empleado = empleado;
	}

	public int getCompetencia() {
		return competencia;
	}


	public int getEmpleado() {
		return empleado;
	}


	public void setCompetencia(int competencia) {
		this.competencia = competencia;
	}


	public void setEmpleado(int empleado) {
		this.empleado = empleado;
	}


	public boolean equals(Object o) {
		return (o instanceof TieneID && competencia == ((TieneID) o).getCompetencia()
				&& empleado == ((TieneID) o).getEmpleado());
	}

	public int hashCode() {
		return competencia * 10000 + empleado;
	}
}