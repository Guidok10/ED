package TDAColaCP;

/**
 * Comisión número 10.
 * @author Virkel Federico LU 99648.
 * @author Kestel Guido LU 90482.
 *
 * @param <K> Tipo de dato generico destinado a las claves.
 * @param <V> Tipo de dato generico destinado a los valores.
 */
public interface Entry<K,V>
{
	/**
	 * @return La clave de la entrada.
	 */
	public K getKey();
	
	/**
	 * @return El valor de la entrada.
	 */
	public V getValue();
}
