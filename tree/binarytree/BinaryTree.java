package tree.binarytree;

/**
 * Represents a binary tree structure.
 * 
 * @author a
 *
 * @param <T> - the type of the values.
 */
public class BinaryTree<T> {
	/**
	 * Represents a binary tree node.
	 * 
	 * @author a
	 *
	 * @param <T> - the type of the values of nodes
	 */
	public static class BinaryTreeNode<T> {
		// Contains the value of the node
		private T value;

		// Shows whether the current node has parent
		private boolean hasParent;

		// Contains the left child of the node
		private BinaryTreeNode<T> leftChild;

		// Contains the right child of the node
		private BinaryTreeNode<T> rightChild;

		/**
		 * Constructs a binary tree node.
		 * 
		 * @param value      - the value of the node.
		 * @param leftChild  - the left child of the node.
		 * @param rightChild - the right child of the node.
		 */
		public BinaryTreeNode(T value, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
			if (value == null) {
				throw new IllegalArgumentException("Cannot insert null value!");
			}
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		/**
		 * Constructs a binary tree node with no children
		 * 
		 * @param value - the value of the node.
		 */
		public BinaryTreeNode(T value) {
			this(value, null, null);
		}

		/**
		 * @return the value of the node
		 */

		public T getValue() {
			return this.value;
		}

		/**
		 * Sets the value of the node.
		 * 
		 * @param value - the value of the node
		 */
		public void setValue(T value) {
			this.value = value;
		}

		/**
		 * @return the left child or null if it does not exist
		 */
		public BinaryTreeNode<T> getLeftChild() {
			return this.leftChild;
		}

		/**
		 * Sets the left child
		 * 
		 * @param leftChild - the new left child to be set
		 */
		public void setLeftChild(BinaryTreeNode<T> leftChild) {
			if (leftChild == null || leftChild.hasParent) {
				throw new IllegalArgumentException();
			}
			this.leftChild = leftChild;
		}

		/**
		 * @return the right child or null if it does not exist
		 */
		public BinaryTreeNode<T> getRightChild() {
			return this.rightChild;
		}

		/**
		 * Sets the right child
		 * 
		 * @param leftChild - the new right child to be set
		 */
		public void setRightChild(BinaryTreeNode<T> rightChild) {
			if (rightChild == null || rightChild.hasParent) {
				throw new IllegalArgumentException("Cannot insert null value!");
			}
			this.rightChild = rightChild;
		}
	}

	// THe root of the tree
	private BinaryTreeNode<T> root;

	/**
	 * Constructs the tree.
	 * 
	 * @param value      - the value of the node.
	 * @param leftChild  - the leftChildren of the node.
	 * @param rightChild - the right childreb of the node.
	 */
	public BinaryTree(T value, BinaryTree<T> leftChild, BinaryTree<T> rightChild) {
		if (value == null) {
			throw new IllegalArgumentException("Cannot insert null value!");
		}
		BinaryTreeNode<T> leftChildNode = (leftChild != null) ? (leftChild.root) : (null);
		BinaryTreeNode<T> rightChildNode = (rightChild != null) ? (rightChild.root) : (null);
		this.root = new BinaryTreeNode<T>(value, leftChildNode, rightChildNode);
	}

	/**
	 * Constructs the tree.
	 * 
	 * @param value - the value of the node.
	 */
	public BinaryTree(T value) {
		this(value, null, null);
	}

	/**
	 * 
	 * @return the root of the tree
	 */
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * 
	 * @return the left child of the root
	 */
	public BinaryTreeNode<T> getLeftChildNode() {
		if (this.root != null) {
			return this.root.getLeftChild();
		}
		return null;
	}

	/**
	 * 
	 * @return the right child of the root
	 */
	public BinaryTreeNode<T> getRightChildNode() {
		if (this.root != null) {
			return this.root.getRightChild();
		}
		return null;
	}

	/**
	 * Traverses the binary tree in pre-order manner
	 * 
	 * @param root - the binary tree to be traversed
	 */
	public void printPreOrder(BinaryTreeNode<T> root) {
		if (root == null) {
			return;
		}
		//WE CAN CHANGE THE NEXT ORDER TO DEFINE DIFFERENT TRAVERSING PATHS
		// 1.Visit the left child.
		printPreOrder(root.getLeftChild());
		// 2. Visit the root of the tree.
		System.out.println(root.getValue() + " ");
		// 3. Visit the right child.
		printPreOrder(root.getRightChild());
	}

	/**
	 * Traverses and prints the binary tree in pre-order manner.
	 */
	public void printPreOrder() {
		printPreOrder(this.root);
		System.out.println();
	}

}
