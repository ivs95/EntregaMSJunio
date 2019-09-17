
package Negocio.Empleado;

import Integración.Empleado.TEmpleadoParcial;
import Negocio.Departamento.Departamento;

import java.io.Serializable;

import javax.persistence.Entity;

import Integración.Empleado.TEmpleado;

@Entity
public class EmpleadoTP extends Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer sueldo_hora;

	private Integer horas_semana;

	public EmpleadoTP(){}

	public EmpleadoTP(Integer id, String nombre, String DNI, Boolean activo, Integer sueldo_hora,
			Integer horas_semana) {
		super(id, nombre, DNI, activo, null);
		this.sueldo_hora = sueldo_hora;
		this.horas_semana = horas_semana;
	}

	public EmpleadoTP(String nombre, String DNI, Boolean activo, Departamento departamento, Integer sueldo_hora, Integer horas_semana) {
		super(nombre, DNI, activo, departamento);
		this.sueldo_hora = sueldo_hora;
		this.horas_semana = horas_semana;
	}

	public EmpleadoTP(TEmpleadoParcial empleado) {
		super(empleado.getID(), empleado.getNombre(), empleado.getDNI(), empleado.getActivo(),
				null);
		this.sueldo_hora = empleado.getSueldoHora();
		this.horas_semana = empleado.getHorasSemana();
	}

	public Integer getSueldoHora() {
		return this.sueldo_hora;
	}

	public Integer getHorasSemana() {
		return this.horas_semana;
	}

	public void setSueldoHora(Integer sueldo_hora) {
		this.sueldo_hora = sueldo_hora;
	}

	public void setHorasSemana(Integer horas_semana) {
		this.horas_semana = horas_semana;
	}

	public Integer calcularNomina() {
		return this.horas_semana * this.sueldo_hora;
	}

	public TEmpleado toTransfer() {
		return new TEmpleadoParcial(getActivo(), getDNI(), getNombre(), getId(), getDepartamento().getID(),
				getSueldoHora(), getHorasSemana());
	}
}