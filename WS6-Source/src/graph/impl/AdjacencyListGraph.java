package graph.impl;

import graph.core.IEdge;
import graph.core.IGraph;
import graph.core.IIterator;
import graph.core.IList;
import graph.core.INode;
import graph.core.IVertex;
import graph.util.DLinkedList;

public class AdjacencyListGraph<V,E> implements IGraph<V,E> {

	// vertex list
	private IList<IVertex<V>> vertices;

	// edge list
	private IList<IEdge<E>> edges;
	
	/**
	 * Constructor
	 */
	public AdjacencyListGraph() {
		// create new (empty) lists of edges and vertices
		vertices = new DLinkedList<IVertex<V>>();
		edges = new DLinkedList<IEdge<E>>();
	}

	
	@Override
	public IVertex<V>[] endVertices(IEdge<E> e) {
		// need to cast Edge type to EdgeListEdge
		@SuppressWarnings("unchecked")
		AdjacencyListEdge<E,V> edge = (AdjacencyListEdge<E,V>) e;

		// create new array of length 2 that will contain
		// the edge's end vertices
		@SuppressWarnings("unchecked")
		IVertex<V>[] endpoints = new IVertex[2];

		// fill array
		endpoints[0] = edge.start;
		endpoints[1] = edge.end;

		return endpoints;
	}

	@Override
	public IVertex<V> opposite(IVertex<V> v, IEdge<E> e) {
		// find end points of Edge e
		IVertex<V>[] endpoints = endVertices(e);

		// return the end point that is not v
		if (endpoints[0].equals(v)) {
			return endpoints[1];
		} else if (endpoints[1].equals(v)) {
			return endpoints[0];
		}

		// Problem! e is not connected to v.
		throw new RuntimeException("Error: cannot find opposite vertex.");
	}

	@Override
	public boolean areAdjacent(IVertex<V> v, IVertex<V> w) {
		// iterate through all the edges of one of the given vertices
	    @SuppressWarnings("unchecked")
		AdjacencyListVertex<V,E> vertex = (AdjacencyListVertex<V,E>) v;
		IIterator<IEdge<E>> it = vertex.edgeList.iterator();

		while (it.hasNext()) {
			// must cast Object type to EdgeListEdge type
			@SuppressWarnings("unchecked")
			AdjacencyListEdge<E,V> edge = (AdjacencyListEdge<E,V>) it.next();

			// edge connects v -> w (so they are adjacent)
			if ((edge.start.equals(v)) && (edge.end.equals(w)))
				return true;

			// edge connects w -> v (so they are adjacent)
			if ((edge.end.equals(v)) && (edge.start.equals(w)))
				return true;
		    }
			// no edge was found that connects v to w.
			return false;
	}

	@Override
	public V replace(IVertex<V> v, V x) {
		@SuppressWarnings("unchecked")
		AdjacencyListVertex<V,E> vertex = (AdjacencyListVertex<V,E>) v;
		// store old element that we should return
		V temp = (V) vertex.element();

		// do the replacement
		vertex.element = x;

		// return the old value
		return temp;
	}

	@Override
	public E replace(IEdge<E> e, E x) {
		@SuppressWarnings("unchecked")
		AdjacencyListEdge<E,V> edge = (AdjacencyListEdge<E,V>) e;
		E temp = (E) edge.element();
		edge.element = x;
		return temp;
	}

	@Override
	public IVertex<V> insertVertex(V v) {
		// create new vertex
		AdjacencyListVertex<V,E> vertex = new AdjacencyListVertex<V,E>(v);

		// insert the vertex into the vertex list
		// (returns a reference to the new Node that was created)
		INode<IVertex<V>> node = vertices.insertLast(vertex);

		// this reference must be stored in the vertex,
		// to make it easier to remove the vertex later.
		vertex.node = node;

		// return the new vertex that was created
		return vertex;
	}
	
	
	@Override
	public IEdge<E> insertEdge(IVertex<V> v, IVertex<V> w, E o) {
		@SuppressWarnings("unchecked")
		AdjacencyListVertex<V,E> V = (AdjacencyListVertex<V,E>) v;
		@SuppressWarnings("unchecked")
		AdjacencyListVertex<V,E> W = (AdjacencyListVertex<V,E>) w;
		// create new edge object
		AdjacencyListEdge<E,V> edge = new AdjacencyListEdge<E,V>(V, W, o);

		// insert into the edge list and store the reference to the node
		// in the edge object
		edge.node = edges.insertLast(edge);
		edge.snode = V.edgeList.insertLast(edge);
		edge.snode = W.edgeList.insertLast(edge);
		return edge;
	}

	@Override
	public V removeVertex(IVertex<V> v) {
		@SuppressWarnings("unchecked")
		AdjacencyListVertex<V,E> vertex = (AdjacencyListVertex<V,E>) v;
		IList<IEdge<E>> incidentEdges = vertex.edgeList;
		
		while (!incidentEdges.isEmpty())
			removeEdge(incidentEdges.remove(incidentEdges.first()));

		// now we can remove the vertex from the vertex list of the graph
		vertices.remove(vertex.node);

		// return the element of the vertex that was removed
		return (V) vertex.element();
	}

	@Override
	public E removeEdge(IEdge<E> e) {
		// remove edge from edge list and return its element
	    @SuppressWarnings("unchecked")
		AdjacencyListEdge<E,V> edge = (AdjacencyListEdge<E,V>) e;
		edges.remove(edge.node);
		return (E) edge.element();
	}

	@Override
	public IIterator<IEdge<E>> incidentEdges(IVertex<V> v) {
		// strategy:
		// find all edges that are connected to v and
		// add them to "list".
		// Later, use the iterator() method in List to
		// get an iterator over these edges.
		@SuppressWarnings("unchecked")
		AdjacencyListVertex<V,E> vertex = (AdjacencyListVertex<V,E>) v;
		IIterator<IEdge<E>> it = vertex.edgeList.iterator();
		return it;
	}

	@Override
	public IIterator<IVertex<V>> vertices() {
		return vertices.iterator();
	}

	@Override
	public IIterator<IEdge<E>> edges() {
		return edges.iterator();
	}

}
