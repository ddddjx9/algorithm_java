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

    public Vertex(String name) {
        this.name = name;
    }
}
