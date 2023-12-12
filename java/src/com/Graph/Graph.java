package com.Graph;

public interface Graph<T> {
     int getNumOfVertices();
     int getNumbOfEdges();
     T getValue(int v) throws Exception;
     int getWeight(int v1,int v2) throws Exception;
     void insertVertex(T vertex)throws Exception;
     void insertEdge(int v1,int v2,int weight) throws Exception;
     void deleteEdge(int v1,int v2)throws Exception;
     int getFirstNeighbor(int v) throws Exception;
     int getNextNeighbor(int v1,int v2) throws Exception;
}
