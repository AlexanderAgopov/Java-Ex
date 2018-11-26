package tree.bfs;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
public class BFS {
	
	public static void traverseDir(String startDirectory) {
		Queue<File> visitedDirs = new LinkedList<File>();
		visitedDirs.add(new File(startDirectory));
		while(visitedDirs.size() > 0) {
			File currentDir = visitedDirs.remove();
			System.out.println(currentDir.getAbsolutePath());
			File[] children = currentDir.listFiles();
			if(children != null) {
				for (File child : children) {
					if(child.isDirectory()) {
						visitedDirs.add(child);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		traverseDir("bin");
	}

}
