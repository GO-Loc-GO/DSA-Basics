package graph.impl;

import graph.core.IEdge;
import graph.core.INode;

public class EdgeListEdge<E> implements IEdge<E> {
	// reference to a node in the edge list
	INode<IEdge<E>> node;

	// element stored in this edge
	E element;

	// the start and end vertices that this edge connects
	EdgeListVertex start;
	EdgeListVertex end;

	// constructor to set the three fields
	public EdgeListEdge(EdgeListVertex start, EdgeListVertex end, E element) {
		this.start = start;
		this.end = end;
		this.element = element;
	}

	@Override
	public E element() {
		return element;
	}

	public String toString() {
		return element.toString();
	}
}
