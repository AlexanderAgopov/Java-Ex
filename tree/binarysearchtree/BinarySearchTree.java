package tree.binarysearchtree;

public class BinarySearchTree<T extends Comparable<T>> {

	private static class BinaryTreeNode<T extends Comparable<T>> implements Comparable<BinaryTreeNode<T>> {
		// Contains the value of the node
		T value;
		// Contains the parent of the node
		BinaryTreeNode<T> parent;
		// Contains the left child of the node
		BinaryTreeNode<T> leftChild;
		// Contains the right child of the node
		BinaryTreeNode<T> rightChild;

		/**
		 * Construct the tree node
		 * 
		 * @param value - the value of the node.
		 */
		public BinaryTreeNode(T value) {
			this.value = value;
			this.parent = null;
			this.leftChild = null;
			this.rightChild = null;
		}

		@Override
		public String toString() {
			return this.value.toString();
		}

		@Override
		public int hashCode() {
			return this.value.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			@SuppressWarnings("unchecked")
			BinaryTreeNode<T> other = (BinaryTreeNode<T>) obj;
			return this.compareTo(other) == 0;
		}

		@Override
		public int compareTo(BinaryTreeNode<T> other) {
			return this.value.compareTo(other.value);
		}

	}

	/**
	 * The root of the tree.
	 */
	private BinaryTreeNode<T> root;

	/**
	 * Constructs the tree.
	 */
	public BinarySearchTree() {
		this.root = null;
	}

	/**
	 * Inserts new value in the binary search tree.
	 * 
	 * @param value - tha value to be inserted.
	 */
	public void insert(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Cannot insert null value!");
		}
		this.root = insert(value, null, root);
	}

	/**
	 * Inserts node in the binary search tree by given value.
	 * 
	 * @param value      - the new value.
	 * @param parentNode - the parent of the new node.
	 * @param node       - current node.
	 * @return the inserted node
	 */
	private BinaryTreeNode<T> insert(T value, BinaryTreeNode<T> parentNode, BinaryTreeNode<T> node) {
		if (node == null) {
			node = new BinaryTreeNode<T>(value);
			node.parent = parentNode;
		} else {
			int compareTo = value.compareTo(node.value);
			if (compareTo < 0) {
				node.leftChild = insert(value, node, node.leftChild);
			} else {
				if (compareTo > 0) {
					node.rightChild = insert(value, node, node.rightChild);
				}
			}
		}
		return node;
	}

	private BinaryTreeNode<T> find(T value) {
		BinaryTreeNode<T> node = this.root;

		while (node != null) {
			int compareTo = value.compareTo(node.value);
			if (compareTo < 0) {
				node = node.leftChild;
			} else {
				if (compareTo > 0) {
					node = node.rightChild;
				} else {
					break;
				}
			}
		}
		return node;
	}

	/**
	 * Removes an element from the tree if such element exists.
	 * 
	 * @param value - the value of the node.
	 */
	public void remove(T value) {
		BinaryTreeNode<T> nodeToDelete = find(value);
		if (nodeToDelete == null) {
			return;
		}
		remove(nodeToDelete);
	}

	public void remove(BinaryTreeNode<T> node) {
		// Case 1: The node has 2 children. (Note that if we do this in the end the node
		// will always be with at most one child.
		if (node.leftChild != null && node.rightChild != null) {
			BinaryTreeNode<T> replacement = node.rightChild;
			while (replacement.leftChild != null) {
				replacement = replacement.leftChild;
			}
			node.value = replacement.value;
			node = replacement;
		}

		// Case 2 and 3: The node has only 1 child.
		BinaryTreeNode<T> theChild = node.leftChild != null ? node.leftChild : node.rightChild;

		// If the element to be deleted has one child
		if (theChild != null) {
			theChild.parent = node.parent;

			// Handle the case when the element is the root
			if (node.parent == null) {
				root = theChild;
			} else {
				// Replace the element with its child subtree
				if (node.parent.leftChild == node) {
					node.parent.leftChild = theChild;
				} else {
					node.parent.rightChild = theChild;
				}
			}
		} else {
			// Handle the case when the element is the root
			if (node.parent == null) {
				root = null;
			} else {
				// Remove the element. It is a leaf.
				if (node.parent.leftChild == node) {
					node.parent.leftChild = null;
				} else {
					node.parent.rightChild = null;
				}
			}
		}

	}

}
