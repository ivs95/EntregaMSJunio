
package Integración.Departamento;

import java.util.ArrayList;
import java.util.List;

import Integración.Empleado.TEmpleado;


public class TDepartamento {


	private Boolean activo;
	
	private Integer capacidad_max;
	
	private String funcion;
	
	private Integer id;
	
	private List<TEmpleado> empleados = new ArrayList<>();

	public TDepartamento(Boolean activo, Integer capacidad, String funcion, Integer id) {
		this.activo=activo;
		this.capacidad_max=capacidad;
		this.funcion=funcion;
		this.id=id;
	}

	public Boolean getActivo() {
		return activo;
	}

	public Integer getCapacidad_max() {
		return capacidad_max;
	}

	public String getFuncion() {
		return funcion;
	}

	public Integer getId() {
		return id;
	}

	public List<TEmpleado> getEmpleados() {
		return empleados;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public void setCapacidad_max(Integer capacidad_max) {
		this.capacidad_max = capacidad_max;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setEmpleados(List<TEmpleado> empleados) {
		this.empleados = empleados;
	}
}