package tree.binarytreeex;

public class BinaryTreeEx<T> {

	public static class BinaryTreeExNode<T> {
		// Contains the value of the node
		private T value;

		private int level = 0;

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		// Shows whether the current node has parent
		private boolean hasParent;

		// Contains the left child of the node
		private BinaryTreeExNode<T> leftChild;

		// Contains the right child of the node
		private BinaryTreeExNode<T> rightChild;

		private BinaryTreeExNode<T> parent;

		/**
		 * Constructs a binary tree node.
		 * 
		 * @param value      - the value of the node.
		 * @param leftChild  - the left child of the node.
		 * @param rightChild - the right child of the node.
		 */
		public BinaryTreeExNode(T value, BinaryTreeExNode<T> leftChild, BinaryTreeExNode<T> rightChild) {
			if (value == null) {
				throw new IllegalArgumentException("Cannot insert null value!");
			}
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			// this.level = level;
			// this.leftChild.level = this.level + 1;
			// this.rightChild.level = this.level + 1;
			leftChild.parent = this;
		}

		/**
		 * Constructs a binary tree node with no children
		 * 
		 * @param value - the value of the node.
		 */
		public BinaryTreeExNode(T value) {
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
		public BinaryTreeExNode<T> getLeftChild() {
			return this.leftChild;
		}

		/**
		 * Sets the left child
		 * 
		 * @param leftChild - the new left child to be set
		 */
		public void setLeftChild(BinaryTreeExNode<T> leftChild) {
			if (leftChild == null || leftChild.hasParent) {
				throw new IllegalArgumentException();
			}
			this.leftChild = leftChild;
		}

		/**
		 * @return the right child or null if it does not exist
		 */
		public BinaryTreeExNode<T> getRightChild() {
			return this.rightChild;
		}

		/**
		 * Sets the right child
		 * 
		 * @param leftChild - the new right child to be set
		 */
		public void setRightChild(BinaryTreeExNode<T> rightChild) {
			if (rightChild == null || rightChild.hasParent) {
				throw new IllegalArgumentException("Cannot insert null value!");
			}
			this.rightChild = rightChild;
		}
	}

	// THe root of the tree
	private BinaryTreeExNode<T> root;

	/**
	 * Constructs the tree.
	 * 
	 * @param value      - the value of the node.
	 * @param leftChild  - the leftChildren of the node.
	 * @param rightChild - the right children of the node.
	 */
	public BinaryTreeEx(T value, BinaryTreeEx<T> leftChild, BinaryTreeEx<T> rightChild) {
		if (value == null) {
			throw new IllegalArgumentException("Cannot insert null value!");
		}
		BinaryTreeExNode<T> leftChildNode = (leftChild != null) ? (leftChild.root) : (null);
		BinaryTreeExNode<T> rightChildNode = (rightChild != null) ? (rightChild.root) : (null);
		this.root = new BinaryTreeExNode<T>(value, leftChildNode, rightChildNode);
	}

	/**
	 * Constructs the tree.
	 * 
	 * @param value - the value of the node.
	 */
	public BinaryTreeEx(T value) {
		this(value, null, null);
	}

	/**
	 * 
	 * @return the root of the tree
	 */
	public BinaryTreeExNode<T> getRoot() {
		return root;
	}

	/**
	 * 
	 * @return the left child of the root
	 */
	public BinaryTreeExNode<T> getLeftChildNode() {
		if (this.root != null) {
			return this.root.getLeftChild();
		}
		return null;
	}

	/**
	 * 
	 * @return the right child of the root
	 */
	public BinaryTreeExNode<T> getRightChildNode() {
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
	public void printPreOrder(BinaryTreeExNode<T> root) {
		if (root == null) {
			return;
		}
		// WE CAN CHANGE THE NEXT ORDER TO DEFINE DIFFERENT TRAVERSING PATHS
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

	@SuppressWarnings("unused")
	private int sumThisLevelNodesValues(BinaryTreeExNode<T> root) {
		int x = (Integer) root.getLeftChild().getValue() + (Integer) root.getRightChild().getValue();
		return x;
	}

	int lev = 1;

	@SuppressWarnings("unused")
	private int assignLevel1(BinaryTreeExNode<T> node) {
		if (node.hasParent == false) {
			return 0;
		}
		int level = 1;
		while (node.hasParent) {
			level++;
			node = this.root;
		}
		return level;
	}

	public int getLevel(BinaryTreeExNode<T> n) {
		int level = 1;
		while (n != null && n.parent != null) {
			level++;
			n = n.parent;
		}
		return level;
	}

	private void assignLevel(BinaryTreeExNode<T> root) {
		if (root == null) {
			return;
		}
		assignLevel(root.getLeftChild());

		root.level = root.getLevel();

		assignLevel(root.getRightChild());

	}

	private void printLeafs(BinaryTreeExNode<T> root) {
		if (root == null) {
			return;
		}
		printLeafs(root.getLeftChild());
		if (root.getLeftChild() == null && root.getRightChild() == null) {
			System.out.println(root.getValue());
		}

		printLeafs(root.getRightChild());
	}

	private void printLeafs() {
		printLeafs(this.root);
		System.out.println();
	}

	// private boolean isIdealBalancedTree(BinaryTreeExNode<T> root)

	public static void main(String[] args) {
		// Implementation example

		BinaryTreeEx<Integer> nums = new BinaryTreeEx<Integer>(22,
				new BinaryTreeEx<Integer>(10,
						new BinaryTreeEx<Integer>(2, new BinaryTreeEx<Integer>(5, null, null),
								new BinaryTreeEx<Integer>(6, null, null)),
						new BinaryTreeEx<Integer>(3, new BinaryTreeEx<Integer>(21, null, null),
								new BinaryTreeEx<Integer>(9, null, null))),
				new BinaryTreeEx<Integer>(10,
						new BinaryTreeEx<Integer>(54, new BinaryTreeEx<Integer>(3, null, null),
								new BinaryTreeEx<Integer>(8, null, null)),
						new BinaryTreeEx<Integer>(3, new BinaryTreeEx<Integer>(12, null, null),
								new BinaryTreeEx<Integer>(4, null, null))));

		nums.assignLevel(nums.getRoot());
		// System.out.println(nums.assignLevel1(nums.root.getLeftChild()));

		// nums.printPreOrder();
		nums.printLeafs();

	}

}
