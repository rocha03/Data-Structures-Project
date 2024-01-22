package datastructs.Classes.graph;

import java.util.Iterator;

import datastructs.Interfaces.GraphADT;

/**
 * Graph represents an adjacency matrix implementation of a graph.
 *
 * @author Alexandre Rocha, Gabriel Klotz
 */
public class Graph<T> implements GraphADT<T> {
    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices; // number of vertices in the graph
    protected boolean[][] adjMatrix; // adjacency matrix
    protected T[] vertices; // values of vertices

    /**
     * Creates an empty graph.
     */
    public Graph() {
        numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    public void addEdge(T vertex1, T vertex2) {
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }

    /*Alo */

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param index1 the first index
     * @param index2 the second index
     */
    public void addEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
        }
    }

    /**
     * Adds a vertex to the graph, expanding the capacity of the graph
     * if necessary. It also associates an object with the vertex.
     *
     * @param vertex the vertex to add to the graph
     */
    public void addVertex(T vertex) {
        if (numVertices == vertices.length)
            expandCapacity();
        vertices[numVertices] = vertex;
        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
    }

    @Override
    public boolean isConnected() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (this.numVertices == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iteratorBFS(T startVertex) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<T> iteratorDFS(T startVertex) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeVertex(T vertex) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int size() {
        return this.numVertices;
    }

    private void expandCapacity(){

    }

    private boolean indexIsValid(int index){
        return getIndex(vertices[index]) != -1;
    }

    private int getIndex(T vertex){
        int index = -1;
        for(int i = 0; i < numVertices;i++){
            if(vertices[i].equals(vertex)){
                index = i;
            }
        }
        return index;
    }
}
