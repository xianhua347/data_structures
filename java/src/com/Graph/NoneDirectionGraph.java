package com.Graph;

import com.stack_queue.queue.LinkedQueue;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 33891
 */
public class NoneDirectionGraph<T> implements Graph<T> {

    private final ArrayList<T> vertices; //值

    private final int[][] edges; //边
    private final boolean[] isVisited;
    private int numbEdges; //边的总数

    public NoneDirectionGraph(int n) {
        this.vertices = new ArrayList<>(n);
        this.edges = new int[n][n];
        this.isVisited = new boolean[n];
        this.numbEdges = 0;
    }

    public static void main(String[] args) throws Exception {
        NoneDirectionGraph<String> graph = new NoneDirectionGraph<>(5);
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("F");

        //a-b b-c c-d d-f 插入边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(2, 3, 1);
        graph.insertEdge(3, 4, 1);

        //打印邻接矩阵
        graph.print();

        /*        graph.dfs();*/
        System.out.println("-------");
        graph.bfs();

    }

    @Override
    public int getNumOfVertices() {
        return this.vertices.size();
    }

    @Override
    public int getNumbOfEdges() {
        return this.numbEdges;
    }

    @Override
    public T getValue(int v) {
        return this.vertices.get(v);
    }

    @Override
    public int getWeight(int v1, int v2) {
        return this.edges[v1][v2];
    }

    @Override
    public void insertVertex(T vertex) {
        this.vertices.add(vertex);
    }

    @Override
    public void insertEdge(int v1, int v2, int weight) {
        this.edges[v1][v2] = weight;
        this.edges[v2][v1] = weight;
        this.numbEdges++;
    }

    public void print() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    @Override
    public void deleteEdge(int v1, int v2) {
        this.edges[v1][v2] = 0;
        this.edges[v2][v1] = 0;
    }

    @Override
    public int getFirstNeighbor(int v) {
        for (int i = 0; i < this.vertices.size(); i++) {
            if (edges[v][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    @Override
    //2 3
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < this.vertices.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 私有方法实现dfs
     *
     * @param isVisited 是否被访问
     * @param i         图节点下标
     */
    private void dfs(boolean[] isVisited, int i) {
        //访问节点i,并标记已访问
        System.out.print(getValue(i) + "->");
        isVisited[i] = true;
        //访问i的第一个邻接节点
        int neighbor = getFirstNeighbor(i);
        //若neighbor存在则说明有下一个邻接节点
        while (neighbor != -1) {
            if (!isVisited[i]) {
                //如果没有被访问那就递归遍历
                dfs(isVisited, i);
            } else {
                //如果已经被访问查找i的下一个节点
                neighbor = getNextNeighbor(i, neighbor);
            }
        }
    }

    private void bfs(boolean[] isVisited, int i) {
        int head; //队列头节点
        int neighbor; //下一个邻接节点

        //记录访问顺序
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        //访问当前节点的值
        System.out.print(getValue(i)+"->");
        //标记当前已被访问
        isVisited[i] = true;
        //入队列
        queue.enqueue(i);

        //如果队列不为空
        while (!queue.isEmpty()) {
            //从队列取出节点
            head = queue.dequeue();
            //获取头节点的邻接节点
            neighbor = getFirstNeighbor(head);
            //如果节点有邻接节点
            while (neighbor != -1) {
                //如果没有被访问到
                if (!isVisited[neighbor]) {
                    //访问节点
                    System.out.print(getValue(neighbor)+"->");
                    //标记以访问
                    isVisited[neighbor] = true;
                    //进队列 记录以访问的节点
                    queue.enqueue(neighbor);
                } else { //如果被访问到
                    neighbor = getNextNeighbor(head, neighbor);
                }
            }
        }
    }

    /**
     * 深度优先遍历
     */
    public void dfs() {
        //遍历所以图的节点
        for (int i = 0; i < getNumOfVertices(); i++) {
            //判断是否被访问到
            if (!this.isVisited[i]) {//对i进行深度优先遍历
                dfs(isVisited, i);
            }
        }
    }

    public void bfs() {
        for (int i = 0; i < this.vertices.size(); i++) {
            if (!this.isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }
}
