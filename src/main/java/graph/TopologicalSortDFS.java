package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSortDFS {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("PHP");
        Vertex v2 = new Vertex("JavaSE");
        Vertex v3 = new Vertex("JavaWeb");
        Vertex v4 = new Vertex("Spring");
        Vertex v5 = new Vertex("SpringBoot");
        Vertex v6 = new Vertex("MySQL");
        Vertex v7 = new Vertex("DataProject");

        v1.edges = List.of(new Edge(v3));
        v2.edges = List.of(new Edge(v3));
        v3.edges = List.of(new Edge(v4));
        v6.edges = List.of(new Edge(v4));
        v4.edges = List.of(new Edge(v5));
        v5.edges = List.of(new Edge(v7));
        v7.edges = List.of();

        List<Vertex> graph = new ArrayList<>(List.of(v1, v2, v3, v4, v5, v6, v7));
        dfsTopologicalSort(graph);
    }

    public static void dfsTopologicalSort(List<Vertex> graph) {
        LinkedList<String> stack = new LinkedList<>();
        for (Vertex vertex : graph) {
            dfs(vertex, stack);
        }
    }

    private static void dfs(Vertex v, LinkedList<String> stack) {
        if (v.status == 2) {
            return;
        }
        for (Edge edge : v.edges) {
            dfs(edge.linked, stack);
        }
    }
}
