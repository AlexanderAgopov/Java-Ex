package graph.ex;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
/**
 * Represents a directed unweighed graph structure.
 * 
 * @author a
 *
 */
public class GraphEx {
	// Contains the vertices of the graph
	private int vertices[][];

	/**
	 * Constructs the graph.
	 * 
	 * @param vetices
	 */
	public GraphEx(int vertices[][]) {
		this.vertices = vertices;
	}

	/**
	 * Adds new edge from i to j
	 * 
	 * @param i - the starting vertex
	 * @param j - the ending vertex
	 */
	public void addEdge(int i, int j) {
		vertices[i][j] = 1;
	}

	/**
	 * Deletes existing edge (if such exists at all).
	 * 
	 * @param i - the starting vertex.
	 * @param j - the ending vertex.
	 */
	public void removeEdge(int i, int j) {
		vertices[i][j] = 0;
	}

	/**
	 * Checks if an edge exists.
	 * 
	 * @param i - the starting vertex.
	 * @param j - the ending vertex.
	 * @return true if there is an edge between i and j.
	 */
	public boolean hasEdge(int i, int j) {
		return vertices[i][j] == 1;
	}

	public List<Integer> getSuccessors(int i) {
		List<Integer> successors = new LinkedList<Integer>();

		for (int j = 0; j < vertices[i].length; j++) {
			if (vertices[i][j] == 1) {
				successors.add(j);
			}
		}
		return successors;
	}
	
	public static void main(String[] args) {
		
		int[][] matrix = new int[5][5];
		
		GraphEx graph = new GraphEx(matrix);
		
		//matrix[0][3] = 1;
		//matrix[1][3] = 1;
		//matrix[2][3] = 1;
		//matrix[2][2] = 1;
		//matrix[2][1] = 1;
		//matrix[1][1] = 1;
		
		graph.addEdge(0, 3);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 2);
		graph.addEdge(2, 1);
		graph.addEdge(1, 1);
		graph.addEdge(0, 4);
		graph.addEdge(4, 3);
		
		for(int i = 0 ; i < graph.vertices.length; i ++) {
			System.out.println();
			for(int j = 0; j < graph.vertices.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
		
		//The shortest path between 0 and 1 should be 0-3, 3-2, 2-1
		
	}
}