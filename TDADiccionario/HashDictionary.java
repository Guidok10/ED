package TDADiccionario;

import TDALista.BoundaryViolationException;
import TDALista.DoubleLinkedList;
import TDALista.EmptyListException;
import TDALista.InvalidPositionException;
import TDALista.Position;
import TDALista.PositionList;

/**
 * 
 * Comisión número 10.
 * @author Virkel Federico LU 99648.
 * @author Kestel Guido LU 90482.
 *
 * Clase que implementa la interfaz Dictionary
 * @param <K> Tipo de dato generico destinado a las claves.
 * @param <V> Tipo de dato generico destinado a los valores.
 */
public class HashDictionary<K,V> implements Dictionary<K,V> {
	private final int N=13;
	private PositionList<Entry<K,V>>[] A;
	private int cant;
	
	/**
	 * Constructor de la clase.
	 */
	public HashDictionary(){
		A = (PositionList<Entry<K,V>>[]) new DoubleLinkedList[N];
		cant = 0;
		for (int i = 0; i<N ; i++){
			A[i] = new DoubleLinkedList<Entry<K,V>>();
		}
	}
	
	/**
	 * Consulta el número de entradas del diccionario.
	 */
	public int size(){
		return cant;
	}
	
	/**
	 * Consulta si el diccionario está vacío.
	 */
	public boolean isEmpty(){
		return cant==0;
	}
	
	/**
	 * Inserta una entrada con una clave y un valor dado en el diccionario y retorna la entrada creada.
	 * La nueva entrada creada se inserta segun un codigo de compresion. 
	 */
	public Entry<K,V> insert(K key, V value) throws InvalidKeyException{
		if(key==null) throw new InvalidKeyException("ERROR:Clave nula");
		int i = key.hashCode() % N;
		Entry<K,V> ent = new Entrada<K,V>(key,value);
		A[i].addLast(ent);
		cant++;
		
		return ent;
	}
	
	/**
	 * Retorna una colección iterable con todas las entradas en el diccionario.
	 * La estructura iterable utilizada es una lista doblemente enlazada.
	 */
	public Iterable<Entry<K,V>> entries(){
		PositionList<Entry<K,V>> salida = new DoubleLinkedList<Entry<K,V>>();
		for (int i = 0 ; i<N ; i++){
			for (Entry<K,V> ent : A[i]){
				salida.addLast(ent);
			}
		}
		return salida;
	}
	
	/**
	 * Busca una entrada con clave igual a una clave dada y la devuelve, si no existe retorna nulo.
	 * La clave se busca en la posicion obtenida a partir de su codigo de compresion.
	 */
	public Entry<K,V> find(K key) throws InvalidKeyException{
		if(key==null) throw new InvalidKeyException("ERROR:Clave nula");
		Entry<K,V> salida = null;
		int i = key.hashCode() % N;
		try{
			if (!A[i].isEmpty()) salida = A[i].first().element();
		}
		catch (EmptyListException ex){System.out.println(ex.getMessage());}
		return salida;
	}
	
	/**
	 * Retorna una colección iterable que contiene todas las entradas con clave igual a una clave dada.
	 * La estructura iterable utilizada es una lista doblemente enlazada.
	 */
	public Iterable<Entry<K,V>> findAll(K key) throws InvalidKeyException{
		if(key==null) throw new InvalidKeyException("ERROR:Clave nula");
		PositionList<Entry<K,V>> salida = new DoubleLinkedList<Entry<K,V>>();
		int i = key.hashCode() % N;
		for (Entry<K,V> ent : A[i]){
			if (ent.getKey().equals(key))
				salida.addLast(ent);
		}		
		return (salida);
	}
	
	/**
	 * Remueve una entrada dada en el diccionario y devuelve la entrada removida.
	 */
	public Entry<K,V> remove(Entry<K,V> e) throws InvalidEntryException{
		if (e == null) throw new InvalidEntryException("ERROR: clave nula");
		K key = e.getKey();
		if (key == null || e.getValue() == null) throw new InvalidEntryException("ERROR: clave nula");
		Entry<K,V> salida = null; 
		int i = key.hashCode() % N;
		if (A[i].isEmpty()) throw new InvalidEntryException("ERROR: Entrada no encontrada");
		boolean encontre = false; 
		try{
			Position<Entry<K,V>> pos = A[i].first(); 
			encontre = (pos.element().getKey().equals(e.getKey()) & pos.element().getValue().equals(e.getValue()));
			while (pos != A[i].last() && !encontre){
				pos = A[i].next(pos);
				if (pos.element().getKey().equals(e.getKey()) & pos.element().getValue().equals(e.getValue())){
					encontre = true;
				}
			}
			if (encontre){
				salida = pos.element();
				A[i].remove(pos);
				cant--;
			}
			else
				throw new InvalidEntryException("ERROR: Entrada no encontrada");
		}
		catch (InvalidPositionException ex){System.out.println(ex.getMessage());}
		catch (BoundaryViolationException ex){System.out.println(ex.getMessage());}
		catch (EmptyListException ex){System.out.println(ex.getMessage());}
		
		return salida;
	}
	
	
}
