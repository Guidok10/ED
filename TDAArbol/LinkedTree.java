package TDAArbol;

import java.util.Iterator;
import TDALista.*;

/**
 * Comisión número 10.
 * @author Virkel Federico LU 99648.
 * @author Kestel Guido LU 90482.
 *
 * Clase utilizada para representar un arbol.
 * Implementa a la clase Tree
 *
 * @param <E> Parametro generico de los rotulos de cada componente del arbol.
 */
public class LinkedTree<E> implements Tree<E> {
	
	private TNode<E> root;
	private int cant;
	
	/**
	 * Constructor de la clase. No recibe parametros 
	 */
	public LinkedTree(){
		root = null;
		cant = 0;
	}
	
	/**
	 * Crea una raiz a un arbol vacio cuyo rotulo es 'elem'.
	 */
	public void createRoot(E elem) throws InvalidOperationException{
		if (cant > 0) throw new InvalidOperationException("ERROR: La raiz ya existe");
		root = new TNode<E>(elem);
		cant = 1;
	}
	
	/**
	 * Indica si el arbol esta vacio.
	 */
	public boolean isEmpty(){
		return cant==0;
	}
	
	/**
	 * Consulta si la posicion pasada por parametro corresponde a la raiz del arbol.
	 */
	public boolean isRoot(Position<E> p) throws InvalidPositionException{
		TNode<E> nodo = checkPosition(p);
		return nodo == root;
	}
	
	/**
	 * Metodo auxiliar para castear una Position a nodo.
	 * Verifica si el casteo es correcto
	 * Verifica si la posicion pasada por parametro es nula.
	 */
	private TNode<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if (p == null) throw new InvalidPositionException("ERROR: Posicion nula");
		try{
			TNode<E> nodo = (TNode<E>) p;
			if (nodo != root && nodo.getParent() == null) throw new InvalidPositionException("ERROR: Posicion no perteneciente al arbol");
			return nodo;
		}
		catch (ClassCastException e){
			throw new InvalidPositionException("ERROR: No es una posicion de arbol");}
 	}
	
	/**
	 * Devuelve la posición de la raíz del árbol. 
	 */
	public Position<E> root() throws EmptyTreeException{
		if (isEmpty()) throw new EmptyTreeException("ERROR: Arbol vacio no tiene raiz");
		return root;
	}
	
	/**
	 * Agrega un nodo con rótulo rot como primer hijo de un nodo dado.
	 */
	public Position<E> addFirstChild(Position<E> dad, E rot) throws InvalidPositionException{
		if (isEmpty()) throw new InvalidPositionException("ERROR: Arbol vacio");
		TNode<E> padre = checkPosition(dad);
		TNode<E> hijo = new TNode<E>(rot);
		hijo.setParent(padre);
		padre.getChildren().addFirst(hijo);
		cant++;
		return hijo;
	}
	
	/**
	 * Agrega un nodo con rótulo rot como útimo hijo de un nodo dado.
	 */
	public Position<E> addLastChild(Position<E> dad, E rot) throws InvalidPositionException{
		if (isEmpty()) throw new InvalidPositionException("ERROR: Arbol vacio");
		TNode<E> padre = checkPosition(dad);
		TNode<E> hijo = new TNode<E>(rot);
		hijo.setParent(padre);
		padre.getChildren().addLast(hijo);
		cant++;
		return hijo;
	}
	
	/**
	 * Retorna la cantidad de nodos del arbol.
	 */
	public int size(){
		return cant;
	}
	
	/**
	 * Reemplaza el rotulo de una posicion de nodo pasada por parametro, por otro elemento 'elem'.
	 */
	public E replace(Position<E> p, E elem) throws InvalidPositionException{
		TNode<E> nodo = checkPosition(p);
		E salida = nodo.element();
		nodo.setElement(elem);
		return salida;
	}
	
	/**
	 * Retorna la posicion del padre de un nodo dado. Si el nodo dado es la raiz lanza una excepcion.
	 */
	public Position<E> parent(Position<E> pos) throws InvalidPositionException, BoundaryViolationException{
		TNode<E> nodo = checkPosition(pos);
		if (nodo == root) throw new BoundaryViolationException("ERROR: La raiz no tiene padre");
		return nodo.getParent();
	}
	/**
	 * Agrega un nuevo nodo a la derecha de un nodo 'lb' como hijo del nodo con posicion 'dad'.
	 * Aumenta la cantidad de elementos en uno.
	 */
	public Position<E> addAfter(Position<E> dad, Position<E> lb, E rot) throws InvalidPositionException{
		if (isEmpty()) throw new InvalidPositionException("ERROR: Arbol vacio");
		TNode<E> padre = checkPosition(dad);
		TNode<E> hijoIzq = checkPosition(lb);
		TNode<E> hijo = new TNode<E>(rot);
		PositionList<TNode<E>> hermanos = padre.getChildren();
		try{
			if (hermanos.isEmpty()) throw new InvalidPositionException("ERROR: Posicion invalida");
			Position<TNode<E>> her = hermanos.first();
			boolean encontre = her.element() == hijoIzq;
			while (her != hermanos.last() && !encontre){
				her = hermanos.next(her);
				encontre = her.element() == hijoIzq;
			}
			if (!encontre) throw new InvalidPositionException("ERROR: padre o hijo invalidos");
			hermanos.addAfter(her, hijo);
			hijo.setParent(padre);
		}
		catch(EmptyListException e){System.out.println(e.getMessage());}
		catch(BoundaryViolationException e){System.out.println(e.getMessage());}
		
		cant++;
		return hijo;
	}
	
	/**
	 * Agrega un nuevo nodo a la izquierda de un nodo 'rb' como hijo del nodo con posicion 'dad'.
	 * Aumenta la cantidad de elementos en uno.
	 */
	public Position<E> addBefore(Position<E> dad, Position<E> rb, E rot) throws InvalidPositionException{
		if (isEmpty()) throw new InvalidPositionException("ERROR: Arbol vacio");
		TNode<E> padre = checkPosition(dad);
		TNode<E> hijoDer = checkPosition(rb);
		TNode<E> hijo = new TNode<E>(rot);
		PositionList<TNode<E>> hermanos = padre.getChildren();
		try{
			if (hermanos.isEmpty()) throw new InvalidPositionException("ERROR: Posicion invalida");
			Position<TNode<E>> her = hermanos.first();
			boolean encontre = her.element() == hijoDer;
			while (her != hermanos.last() && !encontre){
				her = hermanos.next(her);
				encontre = her.element() == hijoDer;
			}
			if (!encontre) throw new InvalidPositionException("ERROR: padre o hijo invalidos");
			hermanos.addBefore(her, hijo);
			hijo.setParent(padre);
		}
		catch(EmptyListException e){System.out.println(e.getMessage());}
		catch(BoundaryViolationException e){System.out.println(e.getMessage());}
		
		cant++;
		return hijo;
	}
	
	/**
	 * Indica si una posicion del arbol corresponde a la de un nodo externo.
	 */
	public boolean isExternal(Position<E> p) throws InvalidPositionException{
		if (isEmpty()) throw new InvalidPositionException("ERROR: Arbol vacio");
		TNode<E> nodo = checkPosition(p);
		return (nodo.getChildren().isEmpty());
	}
	
	/**
	 * Indica si una posicion del arbol corresponde a la de un nodo interno.
	 */
	public boolean isInternal(Position<E> p) throws InvalidPositionException{
		if (isEmpty()) throw new InvalidPositionException("ERROR: Arbol vacio");
		return (!isExternal(p));
	}

	/**
	 * Crea una coleccion iterable de las posiciones de los hijos del nodo con posicion 'p'.
	 */
	public Iterable<Position<E>> children(Position<E> p) throws InvalidPositionException{
		PositionList<Position<E>> list = new DoubleLinkedList<Position<E>>();
		TNode<E> nodo=checkPosition(p);
		if(!nodo.getChildren().isEmpty())
			for(Position<E> v : nodo.getChildren())
				list.addLast(v);
		return list;
	}
	
	/**
	 * Remueve del arbol el nodo externo pasado por parametro. 
	 * Si el nodo es la raiz, el arbol queda vacio.
	 * Reduce la cantidad de elementos en uno.
	 */
	public void removeExternalNode(Position<E> p) throws InvalidPositionException{
		if (isEmpty()) throw new InvalidPositionException("ERROR: Arbol vacio");
		if (isInternal(p)) throw new InvalidPositionException("ERROR: Posicion de un nodo interno");
		TNode<E> nodo = checkPosition(p);
		
		try{
			if (isRoot(p)) 
				root = null;
			else{
				TNode<E> padre = nodo.getParent();
				PositionList< TNode<E> > hermanos = padre.getChildren();
				
				if (hermanos.isEmpty()) throw new InvalidPositionException("ERROR: posicion invalida");
				Position<TNode<E>> pos = hermanos.first();
				boolean encontre = pos.element() == nodo;
				while (pos != hermanos.last() && !encontre){
					pos = hermanos.next(pos);
					encontre = pos.element() == nodo;
					
				}
				if (!encontre) throw new InvalidPositionException("ERROR: Nodo no figura entre los hermanos");
				nodo.setParent(null);
				hermanos.remove(pos);
			}
		}
		catch (InvalidPositionException e){System.out.println(e.getMessage());}
		catch (EmptyListException e){System.out.println(e.getMessage());}
		catch (BoundaryViolationException e){System.out.println(e.getMessage());}
		
		cant--;
	}
	
	/**
	 * Remueve del arbol el nodo interno pasado por parametro. 
	 * Los hijos del nodo a eliminar suben un nivel y pasan a tener como padre, al padre de 'p'.
	 * Si el nodo es la raiz, solo se puede eliminar cuando tiene un unico hijo (en este caso el hijo pasa a ser la nueva raiz).
	 * Reduce la cantidad de elementos en uno.
	 */
	public void removeInternalNode(Position<E> p) throws InvalidPositionException{
		if (isEmpty()) throw new InvalidPositionException("ERROR: Arbol vacio");
		if (isExternal(p)) throw new InvalidPositionException("ERROR: Posicion de un nodo externo");
		TNode<E> nodo = checkPosition(p);
		
		if (nodo == root && root.getChildren().size() > 1) throw new InvalidPositionException("ERROR: no se puede borrar esta raiz");
		try{
			if (nodo == root && root.getChildren().size() == 1){
				Position<TNode<E>> poshijo = root.getChildren().first();
				TNode<E> hijo = poshijo.element();
				root.getChildren().remove(poshijo);
				hijo.setParent(null);
				root = hijo;
			}
			else{
				PositionList<TNode<E>> hermanos = nodo.getParent().getChildren();
				if (hermanos.isEmpty()) throw new InvalidPositionException("ERROR: posicion invalida");
				Position<TNode<E>> pos = hermanos.first();
				boolean encontre = nodo==pos.element();
				while (pos != hermanos.last() && !encontre){
					pos = hermanos.next(pos);
					encontre = nodo == pos.element();
				}
				if (!encontre) throw new InvalidPositionException("ERROR: Posicion no perteneciente a la lista de hermanos");
				agregarHijos(pos,hermanos);
				nodo.setParent(null);
				hermanos.remove(pos);
			}
		}
		catch (Exception e){System.out.println(e.getMessage());}
		cant--;
	}
	
	/**
	 * Metodo auxiliar utilizado para eliminar un nodo interno. Sube un nivel los hijos de un nodo que sera posteriormente eliminado.
	 */
	private void agregarHijos(Position<TNode<E>> pos, PositionList<TNode<E>> hermanos) throws InvalidPositionException{
		PositionList<TNode<E>> hijos = pos.element().getChildren();
		if (hijos.isEmpty()) throw new InvalidPositionException("ERROR: El nodo no es interno");
		try{
			for (TNode<E> hi : hijos){
				hermanos.addBefore(pos, hi);
				hi.setParent(pos.element().getParent());
			}
		}
		catch (InvalidPositionException  e){System.out.println(e.getMessage());}
	}
	
	/**
	 * Elimina del arbol una posicion dada. Ya sea interno o externo.
	 */
	public void removeNode(Position<E> p) throws InvalidPositionException{
		if (isEmpty()) throw new InvalidPositionException ("ERROR: arbol vacio");
		if (isExternal(p))
			removeExternalNode(p);
		else
			removeInternalNode(p);
	}
	
	/**
	 * Crea un iterador con todos los nodos del arbol.
	 */
	public Iterator<E> iterator(){
		PositionList<E> list=new DoubleLinkedList<E>();
		for( Position<E> p : positions() ) 
			list.addLast( p.element() );
		return list.iterator();
	}
	
	/**
	 * Crea una coleccion interable con todas las posiciones del arbol en orden previo.
	 */
	public Iterable<Position<E>> positions(){
		PositionList<Position<E>> list=new DoubleLinkedList<Position<E>>();
		if(!isEmpty()) pre(list,root);
		return list;
	}
	
	/**
	 * Metodo auxiliar para agregar a una lista todas las posiciones del arbol en pre-orden.
	 * @param lista Lista vacia a la cual se le agregaran posiciones del arbol.
	 * @param raiz Posicion de la raiz del arbol.
	 */
	private void pre(PositionList<Position<E>> lista, Position<E> raiz){
		lista.addLast(raiz);
		try{
			for (Position<E> p : children(raiz))
				pre(lista, p);
		}
		catch (InvalidPositionException e){System.out.println(e.getMessage());}
	}

}
