package Aplicaciones;
import java.util.Iterator;
import TDAArbol.*;
import TDADiccionario.*;
import TDADiccionario.InvalidKeyException;
import TDAColaCP.*;
import TDALista.*;
import TDACola.*;

public class Ejercicio4 {

	private Tree<Integer> Arbol;
	private Dictionary<Integer,Integer> Diccionario;
	private PositionList<Position<Integer>> Lista;
	
	public Ejercicio4(){
		Arbol=new LinkedTree<Integer>();
		Diccionario=new HashDictionary<Integer,Integer>();
		Lista=new DoubleLinkedList<Position<Integer>>();
	}
	
	/**
	 * Crea la raiz del arbol con rotulo P pasado como parametro.
	 * @param P rotulo para la raiz del arbol
	 */
	public void crearRaiz(Integer P){
		try{
			Arbol.createRoot(P);
			Lista.addLast(Arbol.root());
		}
		catch(InvalidOperationException e){
			System.out.println("El arbol ya tiene Raiz");
		}
		catch(EmptyTreeException e){
			System.out.println("El arbol esta vacio.");
		}
	}
	/**
	 * Se busca la posicion en el Arbol del padre con rotulo P y se agrega como Ultimo hijo de P un rotulo R.
	 * En caso de no encontrarse el padre P, se lanza una excepcion.
	 * @param R rotulo a agregar al arbol
	 * @param P rotulo del padre de R
	 * @throws Ejercicio4Exception
	 */
	public void agregarNodo(Integer R, Integer P) throws Ejercicio4Exception{
			try{
				Position<Position<Integer>> pos = Lista.first();
				boolean encontre = pos.element().element()==P;
				while (!encontre && pos!=null){
					pos=Lista.last()!=pos ? Lista.next(pos):null;
					if(pos!=null)
						encontre=pos.element().element()==P;
				}
				if(encontre){
					Position<Integer> nN=Arbol.addLastChild(pos.element(), R);
					Lista.addLast(nN);
				}
				else
					throw new Ejercicio4Exception("No se encuentra el rotulo ingresado como Padre");
			}
			catch (BoundaryViolationException e) {
				System.out.println(e.getMessage());
			}
			catch(EmptyListException e){
				System.out.println(e.getMessage());
			}
			catch(InvalidPositionException e){
				System.out.println(e.getMessage());
			} 
			
	}
	/**
	 * Muestra todos los nodos del árbol por niveles
	 * @return String con los rótulos del árbol
	 */
	
	
	public String mostrarNiveles(){
	String s=new String("");
	   try{
		Queue<Position<Integer>> cola=new ArrayQueue<Position<Integer>>();
		cola.enqueue(Arbol.root());
		cola.enqueue(null);		
		while(!cola.isEmpty()){
			Position<Integer> p=cola.dequeue();
			if(p!=null){
				s+=(p.element()+" ");
				for(Position<Integer> w:Arbol.children(p))
					cola.enqueue(w);
			}
			else{
				s+=("| ");
				if(!cola.isEmpty())
					cola.enqueue(null);
				}
		}		
	  }
	   catch(EmptyQueueException e){
		   System.out.println(e.getMessage());
	   }
	   catch(InvalidPositionException e){
		   System.out.println(e.getMessage());
	   } 
	   catch (EmptyTreeException e){
		   System.out.println(e.getMessage());
	   }
	   return s.substring(0, s.length()-2);
	}
	
	/**
	 * Crea un Diccionario con todos nodos del árbol con entradas(P,R) en el cual P es la profundidad del rótulo R
	 * @return dicc El diccionario especificado
	 */
	public Dictionary<Integer,Integer> crearDiccionario(){
		try{
			for(Position<Integer> p:Arbol.positions()){
				Diccionario.insert(profundidad(p), p.element());
			}
		}
		catch (TDADiccionario.InvalidKeyException e) {
			System.out.println(e.getMessage());
		}	
		return Diccionario;
	}


/**
	 * Método auxiliar que calcula la profundidad de un nodo
	 * @param p Posición del nodo
	 * @return prof Profundidad del nodo
	 */
	private int profundidad(Position<Integer> p){
		int prof=0;
		try {
			if(Arbol.isRoot(p))
				prof= 0;
			else{
				prof= profundidad(Arbol.parent(p)) + 1;
			}
		} 
		catch (InvalidPositionException e) {e.getMessage();} 
		catch (BoundaryViolationException e) {e.getMessage();}
		return prof;
	}
	
	private int altura(Position<Integer> p){
		int out=0;
		try{
			if(Arbol.isExternal(p))
				out= 0;
			else{
				for(Position<Integer> h: Arbol.children(p))
					out= Math.max(out, altura(h));
				out++;
			}
		}	
		catch(InvalidPositionException e){
			System.out.println(e.getMessage());
		}
		return out;
	}
	
	/**
	 * Muestra todos los nodos del árbol en orden descendente en función de la altura.
	 * @return String con los rótulos del árbol.
	 */
	public String ordenPorAltura(){
		String s = "";
		Comparador<Integer> c = new Comparador<Integer>();
		PriorityQueue<Integer,Integer> CCP = new HeapPQueue<Integer,Integer>(c);
		try{
			for (Position<Integer> i : Arbol.positions())
				CCP.insert(altura(i), i.element());
			while (!CCP.isEmpty())
				s += CCP.removeMin().getValue()+"-";
		}
		catch(TDAColaCP.InvalidKeyException e){
			System.out.println(e.getMessage());
		}
		catch(EmptyPriorityQueueException e){
			System.out.println(e.getMessage());
		}
		
		return s.substring(0, s.length()-1);
	}
	/**
	 * 
	 * @param p profundidad deseada.
	 * @return un string con los nodos con la profundidad pasada como parametro.
	 */
	public String mostrarNodosConProfundidad(int p){
		String s="";
		try{
			for(TDADiccionario.Entry<Integer,Integer> e: Diccionario.findAll(p) )
					s+=e.getValue()+" ";
		}
		catch(InvalidKeyException e){
			System.out.println(e.getMessage());
		}
		return s;
	}
}	