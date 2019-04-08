package Aplicaciones;

import java.util.Comparator;

/**
 * Clase para comparar objetos según su orden natural.
 * @author Virkel Federico LU 99648.
 * @author Kestel Guido LU 90482.
 * @param <E> Parámetro genérico E.
 */
public class Comparador<E extends Comparable<E>> implements Comparator<E>{
	 /**
	  * Compara al objeto a con el objeto b.
	  * @param a objeto a comparar.
	  * @param b objeto a comparar.
	  * @return un número mayor que 0 si a > b, menor que 0 si a < b ó 0 si a es igual a b.  
	  */

	public int compare(E a, E b) throws ClassCastException{
		return -a.compareTo(b);
	}
}