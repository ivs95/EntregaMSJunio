
package Negocio.Competencia;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import Integración.Competencia.TCompetencia;

@Entity
@NamedQueries({
		@NamedQuery(name = "Negocio.Competencia.Competencia.readAll", query = "select obj from Competencia obj where obj.activo = true"),
		@NamedQuery(name = "Negocio.Competencia.Competencia.readByName", query = "select obj from Competencia obj where obj.nombre = :nombre") })
public class Competencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	private Boolean activo;

	@Version
	private Integer version;

	@OneToMany(mappedBy = "competencia", fetch = FetchType.EAGER)
	private List<Tiene> tiene;

	public Competencia() {
	}

	public Competencia(Integer id, String nombre, Boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
	}

	public Competencia(TCompetencia competencia) {
		this.id = competencia.getId();
		this.nombre = competencia.getNombre();
		this.activo = competencia.getActivo();
	}

	public Competencia(String nombre, boolean activo) {
		this.nombre = nombre;
		this.activo = activo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public void setTiene(List<Tiene> tiene) {
		this.tiene = tiene;
	}

	public List<Tiene> getTiene() {
		return tiene;
	}

	public Integer getId() {

		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public TCompetencia toTransfer() {
		return new TCompetencia(activo, id, nombre);
	}
}