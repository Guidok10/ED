package TDADiccionario;

/**
 * Comisión número 10.
 * @author Virkel Federico LU 99648.
 * @author Kestel Guido LU 90482.
 *
 * Clase que extiende a la clase Exception.
 * Lanza excepciones relacionadas a entradas invalidas en un diccionario.
 */
public class InvalidEntryException extends Exception {
	
	/**
	 * Constructor de la clase.
	 * @param s Mensaje que recibira el usuario.
	 */
	public InvalidEntryException(String s){
		super(s);
	}

}
