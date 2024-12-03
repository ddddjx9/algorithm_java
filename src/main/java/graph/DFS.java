package graph;

import graph.dataStructure.Edge;
import graph.dataStructure.Vertex;

import java.util.LinkedList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        //测试
        Vertex v1 = new Vertex("V1");
        Vertex v2 = new Vertex("V2");
        Vertex v3 = new Vertex("V3");
        Vertex v4 = new Vertex("V4");
        Vertex v5 = new Vertex("V5");
        Vertex v6 = new Vertex("V6");

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

        //dfsRecursion(v1);
        dfs(v1);
    }

    public static void dfsRecursion(Vertex v) {
        v.visited = true;
        System.out.println(v.name);
        for (Edge edge : v.edges) {
            if (!edge.linked.visited) {
                dfsRecursion(edge.linked);
            }
        }
    }

    public static void dfs(Vertex v) {
        LinkedList<Vertex> stack = new LinkedList<>();
        stack.push(v);
        while (!stack.isEmpty()) {
            Vertex pop = stack.pop();
            pop.visited = true;
            System.out.println(pop.name);
            for (Edge edge : pop.edges) {
                //如果相邻顶点还没有被访问过，加入栈，以便下次再次进行遍历
                if (!edge.linked.visited) {
                    stack.push(edge.linked);
                }
            }
        }
    }
}
