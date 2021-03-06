package tree.tree;

import java.util.ArrayList;

/**
 * Represents a tree data structure.
 * 
 * @author a
 *
 * @param <T> - the type of the values in the tree.
 */

public class Tree<T> {
	/**
	 * Represents a tree node.
	 * 
	 * @author a
	 *
	 * @param <T> - the type of the values in the tree.
	 */

	public static class TreeNode<T> {

		// Contains the value of the node
		private T value;

		// Shows whether the current node has parent
		private boolean hasParent;

		// Contains the children of the node
		ArrayList<TreeNode<T>> children;

		/**
		 * Constructs a tree node.
		 * 
		 * @param value - the value of the node.
		 */
		public TreeNode(T value) {
			if (value == null) {
				throw new IllegalArgumentException("Cannot insert null value!");
			}
			this.value = value;
			this.children = new ArrayList<TreeNode<T>>();
		}

		/**
		 * @return the value of the node.
		 */
		public T getValue() {
			return this.value;
		}

		/**
		 * Sets the value of the node.
		 * 
		 * @param value - the value to be set.
		 */
		public void setValue(T value) {
			this.value = value;
		}

		/**
		 * Adds child to the node.
		 * 
		 * @param child - child to be added.
		 */
		public void addChild(TreeNode<T> child) {
			if (child == null) {
				throw new IllegalArgumentException("Cannot insert null value!");
			}

			if (child.hasParent) {
				throw new IllegalArgumentException("The node already has a parent!");
			}

			child.hasParent = true;
			this.children.add(child);
		}

		/**
		 * Gets the child of the node at given index.
		 * 
		 * @param index - the index of the desired child.
		 * @return the child on the given position
		 */

		public TreeNode<T> getChild(int index) {
			return this.children.get(index);
		}

		/**
		 * @return the number of node's children.
		 */
		public int getChildrenCount() {
			return this.children.size();
		}
	}

	// The root of the tree
	protected TreeNode<T> root;

	/**
	 * Constructs the tree.
	 * 
	 * @param value - the value of the node.
	 */

	public Tree(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Cannot insert null value!");
		}
		this.root = new TreeNode<T>(value);
	}

	/**
	 * Constructs the tree.
	 * 
	 * @param value    - the value of the root node.
	 * @param children - the children of the root node.
	 */

	public Tree(T value, Tree<T>... children) {
		this(value);
		for (Tree<T> child : children) {
			this.root.addChild(child.root);
		}
	}

	/**
	 * @return the root node or null if the tree is empty.
	 */
	public TreeNode<T> getRoot() {
		return this.root;
	}

	/**
	 * @return the child nodes of the tree
	 */
	public ArrayList<TreeNode<T>> getChildren() {
		if (this.root != null) {
			return this.root.children;
		}
		return new ArrayList<TreeNode<T>>();
	}

	/**
	 * Traverses and prints the tree in Depth First Search (DFS) manner.
	 * 
	 * @param root   - the root of the tree to be traversed.
	 * @param spaces - the spaces used for representation of the parent-child
	 *               relation.
	 */
	private void printDFS(TreeNode<T> root, String spaces) {
		if (this.root == null) {
			return;
		}
		System.out.println(spaces + root.getValue());

		TreeNode<T> child = null;

		for (int i = 0; i < root.getChildrenCount(); i++) {
			child = root.getChild(i);
			printDFS(child, spaces + " ");
		}
	}

	/**
	 * Traverses and prints the tree in Depth First Search (DFS) manner.
	 */
	public void printDFS() {
		this.printDFS(this.root, new String());
	}

	/**
	 * Shows a sample usage of the Tree<T> class.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree<String> tree = 
				new Tree<String>("ROOT", 
						new Tree<String>("Depth 1 A",
								new Tree<String>("Depth 2 A1"),
								new Tree<String>("Depth 2 A2"),
								new Tree<String>("Depth 2 A3")),
						new Tree<String>("Depth 1 B"),
						new Tree<String>("Depth 1 C",
								new Tree<String>("Depth 2 C1"),
								new Tree<String>("Depth 2 C2")));
		
		tree.printDFS();

	}

}
