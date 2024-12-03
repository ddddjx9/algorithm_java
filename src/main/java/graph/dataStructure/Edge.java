package graph.dataStructure;

/**
 * 图 - 关联的边
 */
public class Edge {
    public Vertex linked; //连接的顶点
    public int weight; //权重

    public Edge(Vertex linked) {
        this(linked, 1);
    }

    public Edge(Vertex linked, int weight) {
        this.linked = linked;
        this.weight = weight;
    }
}
