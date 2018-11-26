package tree.countoccurrences;

import java.util.InputMismatchException;
import java.util.Scanner;
import tree.tree.Tree;

/**
 * This class extends class Tree<T>. This class contains two new methods. The
 * method count(TreeNode<T> root, int search) uses Depth-first search to give an
 * answer to the question how many times a given number is assigned as a value
 * of node of given tree. The method count() gives the user opportunity to enter
 * an integer as a parameter of the search, calls the aformentioned method and
 * prints the result.
 * 
 * @author a
 *
 * @param <T> - the type of the values in the tree.
 */
public class CountOccurrences<T> extends Tree<T> {

	@SuppressWarnings("hiding")
	public class CountOccurrencesNode<T> extends TreeNode<T> {
		/**
		 * 
		 * @param value - the value of the tree node.
		 */
		public CountOccurrencesNode(T value) {
			super(value);
		}

	}

	public CountOccurrences(T value) {
		super(value);
	}

	public CountOccurrences(T value, @SuppressWarnings("unchecked") Tree<T>... children) {
		super(value, children);
	}

	// Counter of all occurrences of a specific value in tree nodes.
	private int count = 0;
	// Counter of all nodes excluding the root.
	private int countAllDescendants = 0;
	// Counter of all leafs
	private int countAllLeafs = 0;
	// Counter of all inside nodes
	private int countAllInternalNodes = 0;

	/**
	 * Uses Depth-first search to give an answer to the question how many times a
	 * given number is assigned as a value of node of given tree.
	 * 
	 * @param root   - the root of the tree.
	 * @param search - the number we are looking for.
	 * @return the number of occurrences of a given number in a tree with elements
	 *         which have integer values
	 */
	private int count(TreeNode<T> root, int search) {
		if (root == null) {
			return 0;
		}
		if ((Integer) root.getValue() == search) {
			count++;
		}
		TreeNode<T> child = null;
		for (int i = 0; i < root.getChildrenCount(); i++) {
			child = root.getChild(i);
			count(child, search);
		}
		return count;
	}

	

	/**
	 * Prints the roots of all subtrees that meet the following condition: the sum
	 * of the nodes of the subtree equals given integer number.
	 * 
	 * @param root       - the root of the tree.
	 * @param desiredSum - the reference number of nodes.
	 */
	private void printSubtreesRoots(TreeNode<T> root, int desiredSum) {
		if ((root.getChildrenCount() + 1) == desiredSum) { // We add 1 because we have to add the root to the sum of all
															// children of this root in order to receive the sum of all
															// nodes in the subtree
			System.out.println((Integer) root.getValue() + " (" + root.toString() + ")");
		}

		TreeNode<T> child = null;
		for (int i = 0; i < root.getChildrenCount(); i++) {
			child = root.getChild(i);
			printSubtreesRoots(child, desiredSum);
		}
	}

	/**
	 * Allows the user to enter an integer as a parameter of the search and prints
	 * the result.
	 */
	@SuppressWarnings("unused")
	private void printSubtreesRoots() {
		Scanner input1 = null;
		try {
			input1 = new Scanner(System.in);
			System.out.println("Enter the number you want to search for:");
			int desiredSum = input1.nextInt();
			System.out
					.println("The roots of all subtrees the sums of their nodes are equal to the number you entered:");
			this.printSubtreesRoots(this.root, desiredSum);
		} catch (InputMismatchException ime) {
			System.out.println("Not an integer number! Please enter an integer number!");
			ime.printStackTrace();
		} finally {
			input1.close();
		}
	}

	/**
	 * 
	 * @param root - the root of the tree.
	 * @return the number of all descendants of the root.
	 */
	private int countAllDescendants(TreeNode<T> root) {
		countAllDescendants += root.getChildrenCount();

		TreeNode<T> child = null;
		for (int i = 0; i < root.getChildrenCount(); i++) {
			child = root.getChild(i);
			countAllDescendants(child);
		}
		return countAllDescendants;
	}

	/**
	 * Prints the number of all descendants of the root.
	 */
	private void printNumberOfAllDescendants() {
		System.out
				.println("The number of all descendants of the root is: " + this.countAllDescendants(this.root) + ".");
	}

	/**
	 * Counts the number of all leafs of the tree.
	 * 
	 * @param root - the root of the tree.
	 * @return the number of all leafs of the tree.
	 */
	private int countAllLeafs(TreeNode<T> root) {
		if (root.getChildrenCount() == 0) {
			countAllLeafs++;
		}
		TreeNode<T> child = null;
		for (int i = 0; i < root.getChildrenCount(); i++) {
			child = root.getChild(i);
			countAllLeafs(child);
		}

		return countAllLeafs;
	}

	/**
	 * Prints the number of all leafs of the tree.
	 */
	private void printNumberOfAllLeafs() {
		System.out.println("The number of all leafs of the tree is: " + this.countAllLeafs(this.root) + ".");
	}

	/**
	 * 
	 * @param root - the root of the tree.
	 * @return the number of all internal nodes of the tree.
	 */
	private int countAllInternalNodes(TreeNode<T> root) {
		if (root.getChildrenCount() != 0) {
			countAllInternalNodes++;
		}
		TreeNode<T> child = null;
		for (int i = 0; i < root.getChildrenCount(); i++) {
			child = root.getChild(i);
			countAllInternalNodes(child);
		}
		return countAllInternalNodes - 1; // We decrement the variable by 1 because we want to exclude the tree root
											// from the sum.
	}

	/**
	 * Prints the number of all internal nodes of the tree.
	 */
	private void printNumberOfAllInternalNodes() {
		System.out.println(
				"The number of all internal nodes of the tree is: " + this.countAllInternalNodes(this.root) + ".");
	}

	public static void main(String[] args) {
		// Implementation example
		@SuppressWarnings("unchecked")
		CountOccurrences<Integer> nums = new CountOccurrences<Integer>(2,
				new CountOccurrences<Integer>(2, new CountOccurrences<Integer>(1, new CountOccurrences<Integer>(3)),
						new CountOccurrences<Integer>(3, new CountOccurrences<Integer>(1,
								new CountOccurrences<Integer>(4), new CountOccurrences<Integer>(32)),
								new CountOccurrences<Integer>(1))));

		// I cannot apply count() and printSubtreesRoots() together although they work
		// fine separately, because both of them use instance of class Scanner and
		// when the first method finishes and I close this instance of class Scanner I
		// close also System.in and when I start execution of the second method I
		// receive NoSuchElementException. So for the purpose of the exercise I am
		// going to create instance of class Scanner in the main method and I am going
		// to use the basic custom methods with parameters instead.

		// nums.count();
		// System.out.println();
		// nums.printSubtreesRoots();

		nums.printNumberOfAllDescendants();
		nums.printNumberOfAllLeafs();
		nums.printNumberOfAllInternalNodes();

		System.out.println();
		Scanner input = new Scanner(System.in);
		System.out.println("*******************************************************************");
		System.out.println("Use Depth-first search to receive an answer to the question how many");
		System.out.println("times a given number is assigned as a value of node of this tree.");
		System.out.println("*******************************************************************");
		System.out.println("Enter the number you want to search for:");
		int search = input.nextInt();
		System.out.printf("The number %d was found %d times.", search, nums.count(nums.root, search));
		System.out.println();
		System.out.println();
		System.out.println("*******************************************************************");
		System.out.println("Print the roots of all subtrees that meet the following condition:");
		System.out.println("the sum of the nodes of the subtree equals given integer number.");
		System.out.println("*******************************************************************");
		System.out.println("Enter the number you want to search for:");
		int desiredSum = input.nextInt();
		System.out.println("The roots of all subtrees the sums of their nodes are equal to the number you entered:");
		nums.printSubtreesRoots(nums.root, desiredSum);
		input.close();

	}

}
