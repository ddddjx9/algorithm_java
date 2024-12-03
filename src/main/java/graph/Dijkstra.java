package graph;

import graph.dataStructure.Edge;
import graph.dataStructure.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * 迪克斯特拉 - 单源最短路径算法（从一个顶点出发到另一个顶点的最短路径）
 */
public class Dijkstra {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = List.of(
                new Edge(v3, 9),
                new Edge(v2, 7),
                new Edge(v6, 14)
        );
        v2.edges = List.of(new Edge(v4, 15));
        v3.edges = List.of(
                new Edge(v4, 11),
                new Edge(v6, 2)
        );
        v4.edges = List.of(new Edge(v5, 6));
        v5.edges = List.of();
        v6.edges = List.of(new Edge(v5, 9));

        List<Vertex> graph = List.of(v1, v2, v3, v4, v5, v6);

        dijkstra(graph, v1);
    }

    public static void dijkstra(List<Vertex> graph, Vertex source) {
        //表示未访问的顶点集合
        ArrayList<Vertex> list = new ArrayList<>(graph);
        //初始顶点距离设置为0
        source.dist = 0;

        while (!list.isEmpty()) {
            //选取当前顶点
            Vertex curr = chooseMinDistVertex(list);
            //更新当前顶点的邻居顶点的距离
            updateNeighbourDist(curr);
            //处理完毕，移除当前顶点
            list.remove(curr);
            //改进查询条件，如果当集合中包含相应元素，说明还没处理，或者visited状态为false，表明还没有被访问
            curr.visited = true;
        }

        for (Vertex vertex : graph) {
            System.out.println(vertex);
        }
    }

    /**
     * 更新当前节点的邻居节点的距离
     *
     * @param curr 当前节点
     */
    private static void updateNeighbourDist(Vertex curr) {
        for (Edge edge : curr.edges) {
            Vertex linked = edge.linked;
            /*
            if (list.contains(linked)) {
                int dist = curr.dist + edge.weight;
                if (dist < linked.dist) {
                    linked.dist = dist;
                    linked.prev = curr;
                }
            }
            */
            if (!linked.visited) {
                int dist = curr.dist + edge.weight;
                if (dist < linked.dist) {
                    linked.dist = dist;
                    linked.prev = curr;
                }
            }
        }
    }

    /**
     * 在未访问的顶点中选取距离最小的顶点进行处理
     *
     * @param list 未访问的顶点的集合
     * @return 返回未访问的顶点中距离最小的顶点
     */
    private static Vertex chooseMinDistVertex(ArrayList<Vertex> list) {
        Vertex min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).dist < min.dist) {
                min = list.get(i);
            }
        }
        return min;
    }
}
