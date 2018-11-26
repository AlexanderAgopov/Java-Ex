package graph.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a directed unweighed graph structure.
 * 
 * @author a
 *
 */
public class Graph {
	// Contains the vertices of the graph
	private int vertices[][];

	/**
	 * Constructs the graph.
	 * 
	 * @param vetices
	 */
	public Graph(int vertices[][]) {
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
}
