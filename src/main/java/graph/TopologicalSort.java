package graph;

import graph.dataStructure.Edge;
import graph.dataStructure.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSort {
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
        topologicalSort(graph);
    }

    private static void topologicalSort(List<Vertex> graph) {
        //统计每个顶点的入度
        for (Vertex vertex : graph) {
            for (Edge edge : vertex.edges) {
                edge.linked.inDegree++;
            }
        }

        //将入度为0的顶点加入到队列中
        LinkedList<Vertex> queue = new LinkedList<>();
        for (Vertex vertex : graph) {
            if (vertex.inDegree == 0) {
                queue.offer(vertex);
            }
        }

        //将队列中的顶点不断移除，每移除一个顶点，就将它相邻顶点的入度-1，直到减到0，入队
        while (!queue.isEmpty()) {
            Vertex poll = queue.poll();
            System.out.println(poll.name);
            for (Edge edge : poll.edges) {
                edge.linked.inDegree--;
                if (edge.linked.inDegree == 0) {
                    queue.offer(edge.linked);
                }
            }
        }
    }
}
