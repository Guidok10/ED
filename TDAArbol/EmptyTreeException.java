package TDAArbol;

/**
 * Comisión número 10.
 * @author Virkel Federico LU 99648.
 * @author Kestel Guido LU 90482.
 *
 *Clase que extiende a la clase Exception
 */
public class EmptyTreeException extends Exception {
	
	/**
	 * constructor de la clase
	 * @param s mensaje que recibe el usuario
	 */
	public EmptyTreeException(String s){
		super(s);
	}

}
