package TDAColaCP;
import java.util.*;

/**
 * Comisión número 10.
 * @author Virkel Federico LU 99648.
 * @author Kestel Guido LU 90482.
 *
 * Clase utilizada para representar una cola con prioridad.
 * Implementa a la clase PriorityQueue
 *
 * @param <K> Parametro generico para las claves.
 * @param <V> Parametro generico para los valores.
 */
public class HeapPQueue<K, V> implements PriorityQueue<K,V>
	{
	 protected ArrayList<Entry<K, V>> heap;
	 protected int size;
	 protected Comparator<K> comp;
	
	 /**
	  * Constructor de la clase
	  * @param c Un elemento de tipo Comparator que sera implementado por el cliente de la clase segun crea conveniente. 
	  */
	 public HeapPQueue(Comparator<K> c){
		 heap = new ArrayList<Entry<K,V>>();
		 comp = c;
		 size = 0;
		 heap.add(0,null);
	 }
	 
	/**
	 * Retorna la cantidad de elementos de la cola.
	 * @return La cantidad de elementos de la cola.
	 */
	public int size()
		{ return (heap.size() - 1); }

	/**
	 * Chequea si la cola esta vacia.
	 * @return Verdadero si la cola esta vacia o falso en caso contrario.
	 */
	public boolean isEmpty()
		{ return(size()==0); }

	/**
	 * Retorna el minimo elemento de la cola.
	 */
	public Entry<K, V> min() throws EmptyPriorityQueueException
		{
		 if (isEmpty())
			 throw new EmptyPriorityQueueException("La estructura está vacia.");
		 return(heap.get(1));
		}

	/**
	 * Crea una nueva entrada segun los parametros recibidos y la inserta ordenadamente.
	 */
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException
		{
		 checkKey(key);
		 Entry<K,V> entrada = new Entrada<K,V>(key,value);
		 heap.add(entrada);
		
		 int i=size(), indicePadre = i/2;
		 boolean seguir = true;
		 while( (i > 0) && seguir )
			{
			 Entrada<K,V> entradaActual = (Entrada<K,V>) heap.get(i);
			 if(i != 1) //Chequea que no se haya llegado a la raiz.
			 	{
				 Entrada<K, V> padre = (Entrada<K,V>)heap.get(indicePadre);
				 if(comp.compare(entradaActual.getKey(), padre.getKey())<0)	//Si la clave del nodo actual es menor que la del padre.
				 	{
					 Collections.swap(heap, i, indicePadre);
					 i = indicePadre;
					 indicePadre = i/2;
				 	}
				 else
					 seguir=false;	//La clave del nodo actual es mayor o igual que la del padre.
			 	}
			else
				seguir = false;	//Se llego a la raiz.
			}
		return (entrada);
		}

	/**
	 * Remueve el minimo elemento de la cola y lo retorna.
	 */
	public Entry<K, V> removeMin() throws EmptyPriorityQueueException
		{
		 Entry<K, V> min = min();
		 //Swapeo el primer (el minimo) elemento por el último.
		 Collections.swap(heap, 1, size());
		 heap.remove(size());	//Remueve el nodo swapeado.
		 int i = 1;
		 boolean seguir = true;
		
		 while( (i <= size()/2) && seguir )
		 	{
			 int hijoMC=1;
			 int indiceHI= 2*i;		//Indice del hijo izquierdo.
			 if(2*i+1 <= size()) 		//Chequea que tenga hijo derecho.
			 	{ 
				 int indiceHD = 2*i + 1;
				 if(comp.compare(heap.get(indiceHI).getKey(), heap.get(indiceHD).getKey())<=0)	//Chequea si la clave del hijo izquierdo es menor que la del derecho.
					 hijoMC=indiceHI;
				 else
					 hijoMC=indiceHD;	//Si el hijo derecho es menor que el izquierdo.
				 }
			 	else
			 		hijoMC = indiceHI;	//Si solo tiene un hijo y es izquierdo.
			 	if(comp.compare(heap.get(i).getKey(), heap.get(hijoMC).getKey())>0) //Si la clave del indice actual es mayor que la clave del hijo menor, swapeo.
			 		{
			 		 Collections.swap(heap, i, hijoMC);
			 		 i = hijoMC;
			 		}
			 	else
			 		seguir = false;
		 	}
		 return (min);			
		}
	
	/**
	 * Chequea si la clave key es valida.
	 */
	public K checkKey(K key) throws InvalidKeyException
		{
		 if (key==null)
			 throw new InvalidKeyException("La clave es nula.");
		 K clave;
		 try
		 	{ clave=(K)key; }
		 catch (ClassCastException e)
		 	{ throw new InvalidKeyException("La clave es invalida."); }
		 return(clave);
		}
}
