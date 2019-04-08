package TDAArbol;
import TDALista.*;

/**
 * Comisión número 10.
 * @author Virkel Federico LU 99648.
 * @author Kestel Guido LU 90482.
 *
 * Clase utilizada para representar los nodos de un arbol.
 * Implementa a la clase Position
 *
 * @param <E> parametro generico que representa el rotulo del nodo.
 */
public class TNode<E> implements Position<E> 
{
	protected E element;
	protected TNode<E> parent;
	protected PositionList<TNode<E>> children;
	
	/**
	 * Constructor de la clase.
	 * @param elemento El rotulo del nodo
	 */
	public TNode(E elemento)
	{
		element=elemento;
		parent=null;
		children = new DoubleLinkedList<TNode<E>>();
	}
	
	/**
	 * Segundo constructor de la clase que inicializa el nodo sin rotulo.
	 */
	public TNode()
	{
		element=null;
		parent=null;
		children = new DoubleLinkedList<TNode<E>>();
	}
	
	//Setters
	public void setElement(E elemento){	element=elemento;}
	public void setParent(TNode<E> padre){	parent=padre;}
	public void setChildren(PositionList<TNode<E>> hijos){	children=hijos;}
	
	//Getters
	public E element(){	return element;}
	public TNode<E> getParent(){	return parent;}
	public PositionList<TNode<E>> getChildren(){	return children;}
	
}
