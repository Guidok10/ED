package TDADiccionario;

/**
 * Comisión número 10.
 * @author Virkel Federico LU 99648.
 * @author Kestel Guido LU 90482.
 *
 *Clase que implementa la interfaz Entry
 * @param <K> Tipo de dato generico destinado a las claves.
 * @param <V> Tipo de dato generico destinado a los valores.
 */
public class Entrada<K, V> implements Entry<K,V> {
	private K key;
	private V value;
	
	/**
	 * Constructor de la clase
	 */
	public Entrada(K k, V v){
		key = k;
		value = v;
	}
	
	/**
	 * @return La clave de la entrada.
	 */
	public K getKey(){
		return key;
	}
	
	/**
	 * @return El valor de la entrada.
	 */
	public V getValue(){
		return value;
	}
	
	/**
	 * Asigna una nueva clave a la entrada que recibe el mensaje.
	 */
	public void setKey(K k){
		key = k;
	}
	
	/**
	 * Asigna un nuevo valor a la entrada que recibe el mensaje.
	 */
	public void setValue(V v){
		value = v;
	}
	
}
