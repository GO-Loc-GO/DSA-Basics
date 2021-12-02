package graph.impl;

import graph.core.IEdge;
import graph.core.INode;
import graph.core.IVertex;
import graph.util.DLinkedList;

public class AdjacencyListVertex<V, E> implements IVertex<V> {

	// reference to a node in the vertex list
	INode<IVertex<V>> node;
    
	// reference to its edge list
	DLinkedList<IEdge<E>> edgeList;
	
	// element stored in this vertex
	V element;
	
	public AdjacencyListVertex(V element) {
		this.element = element;
		edgeList = new DLinkedList<IEdge<E>>();
	}
	
	@Override
	public V element() {
		// TODO Auto-generated method stub
		return element;
	}

}
