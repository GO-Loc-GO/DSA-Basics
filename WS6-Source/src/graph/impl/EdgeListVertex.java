package graph.impl;

import graph.core.INode;
import graph.core.IVertex;

public class EdgeListVertex<V> implements IVertex<V> {
	// reference to a node in the vertex list
	INode<IVertex<V>> node;

	// element stored in this vertex
	V element;

	public EdgeListVertex(V element) {
		this.element = element;
	}

	@Override
	public V element() {
		return element;
	}

	// It's useful to have a toString() method that can
	// return details about this object, so you can
	// print the object later and get useful information.
	// This one prints the element
	public String toString() {
		return element.toString();
	}
}