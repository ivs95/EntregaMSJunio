
package Integración.Empleado;

public class TEmpleadoCompleto extends TEmpleado {
	


	private Integer dietas;
	
	private Integer sueldo_base;


	public TEmpleadoCompleto(Boolean activo, String DNI, String nombre, Integer id, Integer departamento) {
		super(activo, DNI, nombre, id, departamento);
	}
	
	public TEmpleadoCompleto(Boolean activo, String DNI, String nombre, Integer id, Integer departamento,Integer dietas,Integer sueldo_base) {
		super(activo, DNI, nombre, id, departamento);
		this.dietas=dietas;
		this.sueldo_base=sueldo_base;
	}
	
	public Integer getNomina(){
		
		return this.sueldo_base+this.dietas;
	}
	
	public Integer getDietas() {
		
		return this.dietas;
	}

	
	public Integer getSueldoBase() {
		
		return this.sueldo_base;
	}

	public void setDietas(Integer dietas) {
		this.dietas=dietas;
	}

	
	public void setSueldoBase(Integer sueldo_base) {
		this.sueldo_base=sueldo_base;
	}
}