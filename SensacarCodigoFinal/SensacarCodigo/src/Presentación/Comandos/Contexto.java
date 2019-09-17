
package Presentación.Comandos;


public class Contexto {
	
	private Evento evento;

	private Object dato;
	
	public Contexto(Evento evento, Object dato) {
		super();
		this.evento = evento;
		this.dato = dato;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public Object getDato() {
		return dato;
	}
	public void setDato(Object dato) {
		this.dato = dato;
	}


}