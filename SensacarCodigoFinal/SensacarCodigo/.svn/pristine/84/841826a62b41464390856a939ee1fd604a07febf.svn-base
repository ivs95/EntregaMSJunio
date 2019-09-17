
package Negocio.ParseadorVariables;

public class ParseadorVariables {

	public Boolean comprobarNumeroPositivo(Integer numero) {

		return numero.intValue() >= 0;
	}

	public Boolean comprobarNumeroPositivo(Float numero) {
		return numero.floatValue() >= 0;
	}

	public Boolean comprobarDNI(String DNI) {
		DNI = DNI.toLowerCase();
		String numeros = "0123456789";
		String letras = "abcdefghijklmnopqrstuvwxyz";
		if (DNI.length() == 9) {
			for (int i = 0; i < DNI.length() - 1; i++) {
				if (numeros.indexOf(DNI.charAt(i)) == -1)
					return false;
			}
			return (letras.indexOf(DNI.charAt(DNI.length() - 1)) != -1);
		} else
			return false;
	}

	public Boolean comprobarTelefono(Integer telefono) {
		String s = String.valueOf(telefono);
		return s.length() == 9;
	}
}