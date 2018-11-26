package file.search;

import java.io.File;

/**
 * This class traverses recursively given directory based on the
 * Depth-First-Search (DFS) algorithm
 * 
 * @author a
 *
 */
public class FileSystemSearch {
	/**
	 * Traverses and print given directory recursively.
	 * 
	 * @param dir    - the directory to be traversed.
	 * @param spaces - the spaces used for representation of the parent-child
	 *               relation
	 */

	private static void traverseDir(String startDirectory, String spaces) {
		// If the current element is a directory, we get all of its subdirectories and
		// files
		File dir = new File(startDirectory);
		if (dir.isDirectory()) {
			System.out.println(spaces + dir.getAbsolutePath());
			File[] children = dir.listFiles();
			// For each child of the directory go and visit its subtree
			if (children != null) {
				for (File child : children) {
					if (child.isDirectory()) {
						traverseDir(child.getAbsolutePath(), spaces + "   ");
					}
				}
			}
		} else {
			System.out.println("Not directory!");
		}
	}

	public static void traverseDir(String directoryPath) {
		traverseDir(directoryPath, new String());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		traverseDir("bin", " ");

	}

}
