package graph;

import graph.dataStructure.Edge;
import graph.dataStructure.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小生成树 - Prim算法
 */
public class Prim {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");
        Vertex v7 = new Vertex("v7");

        v1.edges = List.of(new Edge(v2, 2), new Edge(v3, 4), new Edge(v4, 1));
        v2.edges = List.of(new Edge(v1, 2), new Edge(v4, 3), new Edge(v5, 10));
        v3.edges = List.of(new Edge(v1, 4), new Edge(v4, 2), new Edge(v6, 5));
        v4.edges = List.of(new Edge(v1, 1), new Edge(v2, 3), new Edge(v3, 2),
                new Edge(v5, 7), new Edge(v6, 8), new Edge(v7, 4));
        v5.edges = List.of(new Edge(v2, 10), new Edge(v4, 7), new Edge(v7, 6));
        v6.edges = List.of(new Edge(v3, 5), new Edge(v4, 8), new Edge(v7, 1));
        v7.edges = List.of(new Edge(v4, 4), new Edge(v5, 6), new Edge(v6, 1));

        List<Vertex> graph = List.of(v1, v2, v3, v4, v5, v6, v7);

        prim(graph, v1);
    }

    /**
     * 最小生成树，和dijkstra算法不同，prim算法不计算累加距离
     */
    public static void prim(List<Vertex> graph, Vertex source) {
        ArrayList<Vertex> list = new ArrayList<>(graph);
        source.dist = 0;

        while (!list.isEmpty()) {
            //选取当前顶点
            Vertex curr = chooseMinDistVertex(list);
            //更新当前顶点距离
            updateNeighbourDist(curr);
            //更新完毕后，移除当前顶点
            list.remove(curr);
            curr.visited = true;
        }

        for (Vertex vertex : graph) {
            System.out.println(vertex);
        }
    }

    private static void updateNeighbourDist(Vertex curr) {
        for (Edge edge : curr.edges) {
            Vertex linked = edge.linked;
            if (!linked.visited) {
                int dist = edge.weight;
                if (dist < linked.dist) {
                    linked.dist = dist;
                    linked.prev = curr;
                }
            }
        }
    }

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
