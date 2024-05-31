package TUBESPP1;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {
    private List<Vertex<T>> vertexList;
    private int[][] adjMat;

    public Graph(int maxVerts) {
        vertexList = new ArrayList<>(maxVerts);
        adjMat = new int[maxVerts][maxVerts];
    }

    public void addVertex(T data) {
        vertexList.add(new Vertex<>(data));
    }

    public void addEdge(int start, int end) {
        if (start < 0 || start >= vertexList.size() || end < 0 || end >= vertexList.size()) {
            System.out.println("Error: Index vertex tidak valid.");
            return;
        }
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void adjacencyMatrix() {
        int nVerts = vertexList.size();
        System.out.println("Matriks Adjacency:");
        for (int i = 0; i < nVerts; i++) {
            for (int j = 0; j < nVerts; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void displayVertices() {
        for (int i = 0; i < vertexList.size(); i++) {
            System.out.println(i + ". " + vertexList.get(i).getData().toString());
        }
    }

    public int getNVerts() {
        return vertexList.size();
    }

    public List<Vertex<T>> getVertexList() {
        return vertexList;
    }

    public int[][] getAdjMat() {
        return adjMat;
    }
}
