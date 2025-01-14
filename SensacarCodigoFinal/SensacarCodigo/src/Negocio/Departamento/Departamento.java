
package Negocio.Departamento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import Negocio.Empleado.Empleado;
import Integración.Departamento.TDepartamento;
import Integración.Empleado.TEmpleado;

@Entity
@NamedQueries({
		@NamedQuery(name = "Negocio.Departamento.Departamento.readByFuncion", query = "select obj from Departamento obj where obj.funcion = :funcion") })

public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String funcion;

	private Integer capacidad_maxima;

	private Boolean activo;

	@Version
	private Integer version;

	@OneToMany(mappedBy = "departamento")
	private List<Empleado> empleados;

	public Departamento() {
	}

	public Departamento(Integer id, String funcion, Integer capacidad_maxima, Boolean activo) {
		this.id = id;
		this.funcion = funcion;
		this.capacidad_maxima = capacidad_maxima;
		this.activo = activo;
	}

	public Departamento(String funcion, Integer capacidad_maxima, Boolean activo) {
		this.funcion = funcion;
		this.capacidad_maxima = capacidad_maxima;
		this.activo = activo;
	}

	public Departamento(TDepartamento departamento) {
		this.id = departamento.getId();
		this.capacidad_maxima = departamento.getCapacidad_max();
		this.funcion = departamento.getFuncion();
		this.activo = departamento.getActivo();

	}

	public Integer getID() {
		return this.id;
	}

	public String getFuncion() {
		return this.funcion;
	}

	public Integer getCapacidadMaxima() {
		return this.capacidad_maxima;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setID(Integer id) {
		this.id = id;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public void setCapacidadMaxima(Integer capacidad_maxima) {
		this.capacidad_maxima = capacidad_maxima;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public Integer calcularTotalNominas() {
		Integer retorno = 0;
		for (Empleado e : empleados) {
			if (e.getActivo())
				retorno += e.calcularNomina();
		}
		return retorno;
	}

	public TDepartamento toTransfer() {
		TDepartamento retorno = new TDepartamento(this.activo, this.capacidad_maxima, this.funcion, this.id);
		if (!this.empleados.isEmpty()) {
			List<TEmpleado> listaEmpleados = new ArrayList<TEmpleado>();
			for (Empleado e : this.empleados)
				if (e.getActivo())
					listaEmpleados.add(e.toTransfer());
			retorno.setEmpleados(listaEmpleados);
		}
		return retorno;
	}
}