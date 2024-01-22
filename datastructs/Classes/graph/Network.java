package datastructs.Classes.graph;

import java.util.Iterator;

import datastructs.Interfaces.NetworkADT;

public class Network<T> implements NetworkADT<T> {
    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices; // number of vertices in the graph
    protected double[][] adjMatrix; // adjacency matrix
    protected T[] vertices; // values of vertices

    /**
     * Creates an empty Network.
     */
    public Network() {
        numVertices = 0;
        this.adjMatrix = new double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void addEdge(T vertex1, T vertex2, double weight) {
        int index1 = getIndex(vertex1), index2 = getIndex(vertex2);
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = weight;
            adjMatrix[index2][index1] = weight;
        }

    }

    /**
     * {@inheritdoc}
     */
    @Override
    public double shortestPathWeight(T vertex1, T vertex2) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * @hidden
     */
    @Override
    public void addEdge(T vertex1, T vertex2) {
        // this method shouldn't exist
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void addVertex(T vertex) {
        if (numVertices == vertices.length)
            expandCapacity();
        vertices[numVertices] = vertex;
        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = -1;
            adjMatrix[i][numVertices] = -1;
        }
        numVertices++;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public boolean isConnected() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public boolean isEmpty() {
        if (this.numVertices == 0) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public Iterator<T> iteratorBFS(T startVertex) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public Iterator<T> iteratorDFS(T startVertex) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void removeEdge(T vertex1, T vertex2) {
        int index1 = getIndex(vertex1), index2 = getIndex(vertex2);
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = -1;
            adjMatrix[index2][index1] = -1;
        }
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void removeVertex(T vertex) {
        for (int i = getIndex(vertex); i < this.numVertices - 1; i++) {
            this.vertices[i] = this.vertices[i + 1];
        }
        this.numVertices--;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public int size() {
        return this.numVertices;
    }

    private void expandCapacity() {

    }

    private boolean indexIsValid(int index) {
        return getIndex(vertices[index]) != -1;
    }

    private int getIndex(T vertex) {
        int index = -1;
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].equals(vertex)) {
                index = i;
            }
        }
        return index;
    }
}
