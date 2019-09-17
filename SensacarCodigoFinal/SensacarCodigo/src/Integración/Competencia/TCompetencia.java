
package Integración.Competencia;


public class TCompetencia {

	private Boolean activo;
	
	private Integer id;
	
	private String nombre;

	public TCompetencia(Boolean activo, Integer id, String nombre) {
		this.activo=activo;
		this.id=id;
		this.nombre=nombre;
	}

	public Boolean getActivo() {
		return activo;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}