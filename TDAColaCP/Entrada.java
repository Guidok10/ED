package TDAColaCP;

/**
 * Comisión número 10.
 * @author Virkel Federico LU 99648.
 * @author Kestel Guido LU 90482.
 *
 *Clase que implementa la interfaz Entry
 * @param <K> Tipo de dato generico destinado a las claves.
 * @param <V> Tipo de dato generico destinado a los valores.
 */
public class Entrada<K,V> implements Entry<K,V>
{
	protected K key;
	protected V value;
	
	/**
	 * Constructor de la clase
	 * Inicializa los atributos.
	 */
	public Entrada(K k, V v)
	{
		key=k;
		value=v;
	}
	
	//Getters
	public K getKey(){	return key;}
	public V getValue(){	return value;}
	
	//Setters
	public void setKey(K k){	key=k;}
	public void setValue(V v){	value=v;}
}
