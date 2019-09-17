package Negocio.Empleado;

import Integración.Empleado.TEmpleadoCompleto;
import Negocio.Departamento.Departamento;

import java.io.Serializable;

import javax.persistence.Entity;

import Integración.Empleado.TEmpleado;

@Entity
public class EmpleadoTC extends Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer sueldo_base;

	private Integer dietas;

	public EmpleadoTC(){}
	public EmpleadoTC(Integer id, String nombre, String DNI, Boolean activo, Integer sueldo_base, Integer dietas) {
		super(id, nombre, DNI, activo, null);
		this.sueldo_base = sueldo_base;
		this.dietas = dietas;
	}

	public EmpleadoTC(String nombre, String DNI, Boolean activo, Departamento departamento, Integer sueldo_base, Integer dietas) {
		super(nombre, DNI, activo, departamento);
		this.sueldo_base = sueldo_base;
		this.dietas = dietas;
	}

	public EmpleadoTC(TEmpleadoCompleto empleado) {
		super(empleado.getID(), empleado.getNombre(), empleado.getDNI(), empleado.getActivo(), null);
		this.dietas = empleado.getDietas();
		this.sueldo_base = empleado.getSueldoBase();
	}

	public Integer getSueldoBase() {
		return this.sueldo_base;
	}

	public Integer getDietas() {
		return this.dietas;
	}

	public void setSueldoBase(Integer sueldo_base) {
		this.sueldo_base = sueldo_base;
	}

	public void setDietas(Integer dietas) {
		this.dietas = dietas;
	}

	public Integer calcularNomina() {
		return this.dietas + this.sueldo_base;
	}

	public TEmpleado toTransfer() {
		return new TEmpleadoCompleto(getActivo(), getDNI(), getNombre(), getId(), getDepartamento().getID(),
				getDietas(), getSueldoBase());
	}

}