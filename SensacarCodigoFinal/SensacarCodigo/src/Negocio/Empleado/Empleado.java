package Negocio.Empleado;

import Negocio.Departamento.Departamento;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import Negocio.Competencia.Tiene;
import Integración.Empleado.TEmpleado;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@NamedQueries({
	@NamedQuery(name = "Negocio.Empleado.Empleado.findByDepartamento", query = "select obj from Empleado obj where obj.departamento = :departamento and obj.activo = true"),
	@NamedQuery(name = "Negocio.Empleado.Empleado.findByDNI", query = "select obj from Empleado obj where obj.DNI = :DNI"),
	@NamedQuery(name = "Negocio.Empleado.Empleado.readAll", query = "select obj from Empleado obj where obj.activo = true")

	}) 

public abstract class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	private String DNI;

	private Boolean activo;

	@Version
	private Integer version;

	@ManyToOne
	private Departamento departamento;

	@OneToMany(mappedBy = "empleado")
	private List<Tiene> tiene;

	public abstract Integer calcularNomina();

	public abstract TEmpleado toTransfer();

	public Empleado() {
	}

	public Empleado(Integer id, String nombre, String DNI, Boolean activo, Departamento departamento) {
		this.id = id;
		this.nombre = nombre;
		this.DNI = DNI;
		this.activo = activo;
		this.departamento = departamento;
	}

	public Empleado(String nombre, String DNI, Boolean activo, Departamento departamento) {
		this.nombre = nombre;
		this.DNI = DNI;
		this.activo = activo;
		this.departamento = departamento;
	}

	public Integer getId() {
		return this.id;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDNI() {
		return this.DNI;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}