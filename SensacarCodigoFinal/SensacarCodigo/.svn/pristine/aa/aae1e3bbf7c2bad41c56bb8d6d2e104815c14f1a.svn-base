
package Negocio.Competencia;

import java.util.List;

import Integración.Competencia.TCompetencia;
import Integración.Competencia.TTiene;

public interface SACompetencia {

	public int crearCompetencia(TCompetencia competencia);

	public int eliminarCompetencia(Integer id);

	public int añadirCompetenciaAEmpleado(Integer idCompetencia, Integer idEmpleado, Integer nivel);

	public int eliminarCompetenciaDeEmpleado(Integer idCompetencia, Integer idEmpleado);

	public int actualizarCompetenciaDeEmpleado(Integer idCompetencia, Integer idEmpleado, Integer nivel);
	
	public List<TTiene> leerEmpleadosDeCompetencia(Integer idCompetencia);
}