package TDADiccionario;

/**
 * 
 * Comisión número 10.
 * @author Virkel Federico LU 99648.
 * @author Kestel Guido LU 90482.
 *
 * Clase que extiende a la clase Exception.
 * Lanza excepciones relacionadas a claves invalidas de una entrada en un diccionario.
 *
 */
public class InvalidKeyException extends Exception {
	
	/**
	 * Constructor de la clase
	 * @param s Mensaje que recibira el usuario.
	 */
	public InvalidKeyException(String s){
		super(s);
	}

}
