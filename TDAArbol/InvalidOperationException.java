package TDAArbol;

/**
 * Comisión número 10.
 * @author Virkel Federico LU 99648.
 * @author Kestel Guido LU 90482.
 *
 *Clase que extiende a la clase Exception
 */
public class InvalidOperationException extends Exception {

	/**
	 * Constructor del metodo
	 * @param s mensaje que recibira el usuario.
	 */
	public InvalidOperationException(String s){
		super(s);
	}
}
