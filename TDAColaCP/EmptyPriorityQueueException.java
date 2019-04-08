package TDAColaCP;

/**
 * Comisión número 10.
 * @author Virkel Federico LU 99648.
 * @author Kestel Guido LU 90482.
 *
 * Clase que extiende a la clase Exception.
 * Lanza una excepcion cuando se realiza una operacion invalida en una Cola Con Prioridad vacia.
 *
 */
public class EmptyPriorityQueueException extends Exception 
{
	/**
	 * Constructor de la clase.
	 * @param error Mensaje que recibe el usuario.
	 */
	public EmptyPriorityQueueException(String error)
	{
		super(error);
	}
}
