package com.Graph;

import java.util.AbstractSequentialList;

public class AMGraph<Vertex> implements Graph {
    static final int maxWeight = 10000;
    private AbstractSequentialList<Vertex> vertices;

    @Override
    public int getNumOfVertices() {
        return 0;
    }

    @Override
    public int getNumbOfEdges() {
        return 0;
    }

    @Override
    public Object getValue(int v) throws Exception {
        return null;
    }

    @Override
    public int getWeight(int v1, int v2) throws Exception {
        return 0;
    }

    @Override
    public void insertVertex(Object vertex) throws Exception {

    }

    @Override
    public void insertEdge(int v1, int v2, int weight) throws Exception {

    }

    @Override
    public void deleteEdge(int v1, int v2) throws Exception {

    }

    @Override
    public int getFirstNeighbor(int v) throws Exception {
        return 0;
    }

    @Override
    public int getNextNeighbor(int v1, int v2) throws Exception {
        return 0;
    }
}
