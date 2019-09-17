
package Integración.Empleado;

public class TEmpleadoParcial extends TEmpleado {

	private Integer sueldo_hora;

	private Integer horas_semana;

	public TEmpleadoParcial(Boolean activo, String DNI, String nombre, Integer id, Integer departamento) {
		super(activo, DNI, nombre, id, departamento);
	}

	public TEmpleadoParcial(Boolean activo, String DNI, String nombre, Integer id, Integer departamento,Integer sueldo_hora,Integer horas_semana) {
		super(activo, DNI, nombre, id, departamento);
		this.sueldo_hora=sueldo_hora;
		this.horas_semana=horas_semana;
	}
	
	public Integer getNomina(){
		return this.sueldo_hora*this.horas_semana;
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
}