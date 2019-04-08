package TDAColaCP;

/**
 * Comisión número 10.
 * @author Virkel Federico LU 99648.
 * @author Kestel Guido LU 90482.
 *
 * Clase que extiende a la clase Exception.
 * Lanza excepciones relacionadas a claves invalidas en una Cola Con Prioridad.
 *
 */
public class InvalidKeyException extends Exception 
{
	
	/**
	 * Constructor de la clase.
	 * @param error Mensaje que recibe el usuario
	 */
	public InvalidKeyException(String error)
	{
		super(error);
	}
}
