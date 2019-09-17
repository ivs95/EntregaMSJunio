/**
 * 
 */
package Presentación.Factorias;

import Presentación.Comandos.Command;
import Presentación.Comandos.Evento;
import Presentación.Comandos.Cliente.ActualizarClienteCommand;
import Presentación.Comandos.Cliente.AñadirClienteCommand;
import Presentación.Comandos.Cliente.EliminarClienteCommand;
import Presentación.Comandos.Cliente.MostrarClienteCommand;
import Presentación.Comandos.Cliente.MostrarListaClienteCommand;
import Presentación.Comandos.Cliente.QueryClienteCommand;
import Presentación.Comandos.Competencia.ActualizarCompetenciaCommand;
import Presentación.Comandos.Competencia.AsignarCompetenciaCommand;
import Presentación.Comandos.Competencia.BorrarCompetenciaCommand;
import Presentación.Comandos.Competencia.CrearCompetenciaCommand;
import Presentación.Comandos.Competencia.DesasignarCompetenciaCommand;
import Presentación.Comandos.Competencia.MostrarEmpleadosCompentenciaCommand;
import Presentación.Comandos.Departamento.AñadirDepartamentoCommand;
import Presentación.Comandos.Departamento.CalcularNominaCommand;
import Presentación.Comandos.Departamento.EliminarDepartamentoCommand;
import Presentación.Comandos.Departamento.LeerDepartamentoCommand;
import Presentación.Comandos.Empleado.ActualizarEmpleadoCommand;
import Presentación.Comandos.Empleado.AñadirEmpleadoCommand;
import Presentación.Comandos.Empleado.EliminarEmpleadoCommand;
import Presentación.Comandos.Empleado.MostrarEmpleadoCommand;
import Presentación.Comandos.Empleado.MostrarTodoEmpleadoCommand;
import Presentación.Comandos.Modelo.ActualizarModeloCommand;
import Presentación.Comandos.Modelo.AñadirModeloCommand;
import Presentación.Comandos.Modelo.EliminarModeloCommand;
import Presentación.Comandos.Modelo.MostrarListaModeloCommand;
import Presentación.Comandos.Modelo.MostrarModeloCommand;
import Presentación.Comandos.Modelo.QueryModeloCommand;
import Presentación.Comandos.Venta.AbrirVentaCommand;
import Presentación.Comandos.Venta.DevolverVentaCommand;
import Presentación.Comandos.Venta.AñadirModeloAVentaCommand;
import Presentación.Comandos.Venta.CerrarVentaCommand;
import Presentación.Comandos.Venta.EliminarModeloDeVentaCommand;
import Presentación.Comandos.Venta.EliminarVentaCommand;
import Presentación.Comandos.Venta.MostrarListaVentasCommand;
import Presentación.Comandos.Venta.MostrarVentaCommand;
import Presentación.Comandos.Venta.ObtenerDetallesVentaCommand;
import Presentación.Comandos.Vistas.VentanaClienteCommand;
import Presentación.Comandos.Vistas.VentanaCompetenciaCommand;
import Presentación.Comandos.Vistas.VentanaDepartamentoCommand;
import Presentación.Comandos.Vistas.VentanaEmpleadoCommand;
import Presentación.Comandos.Vistas.VentanaModeloCommand;
import Presentación.Comandos.Vistas.VentanaPrincipalCommand;
import Presentación.Comandos.Vistas.VentanaVentaCommand;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author nacho710
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaCommandImp extends FactoriaCommand {

	@Override
	public Command generarCommand(Evento evento) {
		switch (evento) {
		// Ventana Principal
		case CrearVentanaPrincipal:
			return new VentanaPrincipalCommand();
		// Modulo cliente
		case crearVentanaCliente:
			return new VentanaClienteCommand();
		case AñadirClienteCommand:
			return new AñadirClienteCommand();
		case EliminarClienteCommand:
			return new EliminarClienteCommand();
		case ActualizarClienteCommand:
			return new ActualizarClienteCommand();
		case MostrarClienteCommand:
			return new MostrarClienteCommand();
		case MostrarListaClienteCommand:
			return new MostrarListaClienteCommand();
		case QueryClienteCommand:
			return new QueryClienteCommand();
		// Modulo Modelo
		case crearVentanaModelo:
			return new VentanaModeloCommand();
		case AñadirModeloCommand:
			return new AñadirModeloCommand();
		case EliminarModeloCommand:
			return new EliminarModeloCommand();
		case ActualizarModeloCommand:
			return new ActualizarModeloCommand();
		case MostrarModeloCommand:
			return new MostrarModeloCommand();
		case MostrarListaModeloCommnad:
			return new MostrarListaModeloCommand();
		case QueryModeloCommand:
			return new QueryModeloCommand();
		// Modulo Empleado
		case crearVentanaEmpleado:
			return new VentanaEmpleadoCommand();
		case AñadirEmpleadoCommand:
			return new AñadirEmpleadoCommand();
		case EliminarEmpleadoCommand:
			return new EliminarEmpleadoCommand();
		case MostrarEmpleadoCommand:
			return new MostrarEmpleadoCommand();
		case MostrarListaEmpleadoCommand:
			return new MostrarTodoEmpleadoCommand();
		case ActualizarEmpleadoCommand:
			return new ActualizarEmpleadoCommand();
		// Modulo Departamento
		case crearVentanaDepartamento:
			return new VentanaDepartamentoCommand();
		case AñadirDepartamentoCommand:
			return new AñadirDepartamentoCommand();
		case EliminarDepartamentoCommand:
			return new EliminarDepartamentoCommand();
		case LeerDepartamentoCommand:
			return new LeerDepartamentoCommand();
		// Modulo Competencia
		case crearVentanaCompetencia:
			return new VentanaCompetenciaCommand();
		case CrearCompetenciaCommmand:
			return new CrearCompetenciaCommand();
		case AñadirCompetenciaCommand:
			return new AsignarCompetenciaCommand();
		case EliminarCompetenciaCommand:
			return new BorrarCompetenciaCommand();
		case CalcularNominaCommand:
			return new CalcularNominaCommand();
		case DesasignarCompetenciaCommand:
			return new DesasignarCompetenciaCommand();
		case MostrarEmpleadosCompetenciaCommand:
			return new MostrarEmpleadosCompentenciaCommand();
		case ActualizarCompetenciaCommand:
			return new ActualizarCompetenciaCommand();
		// Modulo Venta
		case crearVentanaVentas:
			return new VentanaVentaCommand();
		case AbrirVentaCommand:
			return new AbrirVentaCommand();
		case DevolverVentasCommand:
			return new DevolverVentaCommand();
		case AñadirModelosVentaCommand:
			return new AñadirModeloAVentaCommand();
		case EliminarVentasCommand:
			return new EliminarVentaCommand();
		case MostrarListaVentasCommand:
			return new MostrarListaVentasCommand();
		case MostrarVentasCommand:
			return new MostrarVentaCommand();
		case EliminarModeloVentaCommand:
			return new EliminarModeloDeVentaCommand();
		case ObtenerDetallesVentaCommand:
			return new ObtenerDetallesVentaCommand();
		case CerrarVentaCommand:
			return new CerrarVentaCommand();
		default:
			return null;
		}

	}

	@Override
	public Command actualizarVista(Evento evento) {

		switch (evento) {
		case AñadirClienteCommand:
		case EliminarClienteCommand:
		case ActualizarClienteCommand:
		case ActualizarClienteCommand2Vueta:
		case MostrarClienteCommand:
		case MostrarListaClienteCommand:
		case QueryClienteCommand:
		case AñadirClienteCommandError:
		case EliminarClienteCommandError:
		case ActualizarClienteCommandError:
		case MostrarClienteCommandError:
		case MostrarListaClienteCommandError:
		case QueryClienteCommandError:
			return new VentanaClienteCommand();
		case AñadirModeloCommand:
		case EliminarModeloCommand:
		case ActualizarModeloCommand:
		case ActualizarModeloCommand2Vuelta:
		case MostrarModeloCommand:
		case MostrarListaModeloCommnad:
		case QueryModeloCommand:
		case AñadirModeloCommandError:
		case EliminarModeloCommandError:
		case ActualizarModeloCommandError:
		case MostrarModeloCommandError:
		case MostrarListaModeloCommandError:
		case QueryModeloCommandError:
			return new VentanaModeloCommand();

		case AñadirEmpleadoCommand:
		case EliminarEmpleadoCommand:
		case MostrarEmpleadoCommand:
		case MostrarListaEmpleadoCommand:
		case ActualizarEmpleadoCommand:
		case AñadirEmpleadoCommandError:
		case EliminarEmpleadoCommandError:
		case MostrarEmpleadoCommandError:
		case MostrarListaEmpleadoCommandError:
		case ActualizarEmpleadoCommandError:
		case ActualizarEmpleadoCommand2Vueta:
			return new VentanaEmpleadoCommand();

		case AñadirDepartamentoCommand:
		case EliminarDepartamentoCommand:
		case LeerDepartamentoCommand:
		case AñadirDepartamentoCommandError:
		case EliminarDepartamentoCommandError:
		case LeerDepartamentoCommandError:
		case CalcularNominaCommand:
		case CalcularNominaCommandError:
			return new VentanaDepartamentoCommand();

		case AbrirVentaCommand:
		case DevolverVentasCommand:
		case AñadirModelosVentaCommand:
		case EliminarVentasCommand:
		case MostrarListaVentasCommand:
		case MostrarVentasCommand:
		case EliminarModeloVentaCommand:
		case ObtenerDetallesVentaCommand:
		case AbrirVentaCommandError:
		case DevolverVentaCommandError:
		case AñadirModelosVentaCommandError:
		case EliminarVentasCommandError:
		case MostrarListaVentasCommandError:
		case MostrarVentasCommandError:
		case EliminarModelosVentaCommandError:
		case ObtenerDetallesVentaCommandError:
		case CerrarVentaCommand:
		case CerrarVentaCommandError:
			return new VentanaVentaCommand();

		case CrearCompetenciaCommmand:
		case AñadirCompetenciaCommand:
		case EliminarCompetenciaCommand:
		case DesasignarCompetenciaCommand:
		case MostrarEmpleadosCompetenciaCommand:
		case ActualizarCompetenciaCommand:
		case CrearCompetenciaCommandError:
		case AñadirCompetenciaCommandError:
		case EliminarCompetenciaCommandError:
		case DesasignarCompetenciaCommandError:
		case MostrarEmpleadosCompetenciaCommandError:
		case ActualizarCompetenciaCommandError:

			return new VentanaCompetenciaCommand();

		default:
			return null;
		}
	}
}