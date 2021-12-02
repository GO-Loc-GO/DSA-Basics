import dsa.iface.INode;
import dsa.impl.AbstractBinaryTree;

public class ProperLinkedBinaryTree<T> extends AbstractBinaryTree<T> {

	/**
	 * Constructor - create an empty tree
	 */
	public ProperLinkedBinaryTree() {
		// Part 1
	    root = newNode(null,null);
	}

	/**
	 * Expand an external node - Store a value in the external node - Create two
	 * external nodes as children, making {@code n} an internal node
	 * 
	 * @param n
	 *            The node to expand. An exception will be thrown if it is not
	 *            external.
	 * @param e
	 *            The element to be stored in node {@code n}.
	 */
	public void expandExternal(INode<T> n, T e) {
		// Part 2
		BTNode node = (BTNode) n;
		if(isInternal(n)) {
			throw new RuntimeException("The node to be expanded is internal!");
		}
		else {
			 replace(n,e);
			 node.left = new BTNode(null,node);
			 node.right = new BTNode(null, node);
		}
	}

	/**
	 * Remove a node from the tree
	 * 
	 * @param n
	 *            The node to be removed. An exception will be thrown if it cannot
	 *            be removed (i.e. if it has two internal children).
	 * @return The element that was stored in the removed node.
	 */
	public T remove(INode<T> n) {
		// Part 3
		BTNode node = (BTNode) n;
		if(isInternal(left(node))&&isInternal(right(node))) {
			throw new RuntimeException("Removal Unsuccessful!Both children of the node to be removed are internal!");
		}else if(isRoot(node)) {
			if(isInternal(left(node))&&isExternal(right(node))) {
				node.left.parent = null;
				root = node.left;
			}else {
				node.right.parent = null;
				root = node.right;
			}
		}else if(isInternal(left(node))&&isExternal(right(node))) {
			BTNode p = node.parent;
			BTNode temp_left = p.left;
			BTNode temp_right = p.right;
			if(node.equals(temp_right)) {
				p.right = node.left;
			}else if(node.equals(temp_left)) {
				p.left = node.left;
			}
			node.left.parent = p;
		}else {
			BTNode p = node.parent;
			BTNode temp_left = p.left;
			BTNode temp_right = p.right;
			if(node.equals(temp_right)) {
				p.right = node.right;
			}else if(node.equals(temp_left)) {
				p.left = node.right;
			}
			node.right.parent = p;
		}
		return null; // <-- this is just so the class compiles: remove it from your code
	}
}
