package Integración.Competencia;

import Integración.Empleado.TEmpleado;

public class TTiene {

	private Boolean activo;
	private Integer nivel;
	private TEmpleado empleado;
	private TCompetencia competencia;
	
	public TTiene(Boolean activo, Integer nivel, TEmpleado empleado, TCompetencia competencia){
		this.activo=activo;
		this.nivel=nivel;
		this.empleado=empleado;
		this.competencia=competencia;
	}
	
	public Boolean getActivo() {
		return activo;
	}
	public Integer getNivel() {
		return nivel;
	}
	public TEmpleado getEmpleado() {
		return empleado;
	}
	public TCompetencia getCompetencia() {
		return competencia;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public void setEmpleado(TEmpleado empleado) {
		this.empleado = empleado;
	}
	public void setCompetencia(TCompetencia competencia) {
		this.competencia = competencia;
	}
	
	
	
}
