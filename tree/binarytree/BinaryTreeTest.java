package tree.binarytree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		// Creates an example of binary tree
		BinaryTree<String> bt = new BinaryTree<String>("Root",
				new BinaryTree<String>("LC1",
						new BinaryTree<String>("LC2", new BinaryTree<String>("LC3", null, null),
								new BinaryTree<String>("RC3", null, null)),
						new BinaryTree<String>("RC2", null, null)),
				new BinaryTree<String>("RC1", null, null));

		// Traverses and prints the tree in pre-order manner (i.e. left child - root -
		// right child)
		bt.printPreOrder();

	}

}
