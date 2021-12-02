package graph.impl;

import graph.core.IEdge;
import graph.core.INode;

public class AdjacencyListEdge<E,V> implements IEdge<E> {

	// element stored in this edge
	E element;
	
	// reference to a node in the edge list of the graph
	INode<IEdge<E>> node;
	// reference to two nodes in the edge lists of its two endpoints
	INode<IEdge<E>> snode;
	INode<IEdge<E>> enode;
	
	// the start and end vertices that this edge connects
	AdjacencyListVertex<V,E> start;
	AdjacencyListVertex<V,E> end;
	
	public AdjacencyListEdge(AdjacencyListVertex<V,E> start, AdjacencyListVertex<V,E> end, E element) {
		this.start = start;
		this.end = end;
		this.element = element;
	}
	
	@Override
	public E element() {
		// TODO Auto-generated method stub
		return element;
	}

}
