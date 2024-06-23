package graph;

import java.util.List;

/**
 * 图-顶点类
 */
public class Vertex {
    /*
      ——> B ——>
    A           D
      ——> C ——>
     */
    String name;
    List<Edge> edges; //顶点关联的边的集合
    boolean visited; //代表该顶点在遍历过程中是否被访问过

    int inDegree; //顶点的入度
    int status; //状态 0-未访问 1-访问中 2-访问过  1的状态主要是用于检测拓扑排序中环的出现

    int dist = INF; //用于dijkstra算法和prim算法中计算距离，临时距离设置为无穷大
    static final Integer INF = Integer.MAX_VALUE;
    Vertex prev = null; //用于记录图中到达某一个节点的前一个节点

    public Vertex(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.dist + " " + (this.prev != null ? this.prev.name : "null");
    }
}
