import java.util.*;
import java.lang.*;;

/*

In computer science, a topological sort or topological ordering of a directed graph is a 
linear ordering of its vertices such that for every directed edge uv from vertex u to vertex 
v, u comes before v in the ordering. - Wikipedia

*/

class TopologicalSort {
    Graph graph;

    public TopologicalSort(Graph g) {
        graph = g;
    }

    public List<Integer> topologicalSort() {
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int vertex : graph.getVertices()) {
            inDegree.put(vertex, 0);
        }

        for (int vertex : graph.getVertices()) {
            List<Integer> neighbors = graph.getNeighbors(vertex);
            for (int neighbor : neighbors) {
                inDegree.put(neighbor, inDegree.get(neighbor)+1);
            }
        }

        Queue<Integer> zeroInDegree = new LinkedList<>();
        for (int vertex : inDegree.keySet()) {
            if (inDegree.get(vertex)==0) {
                zeroInDegree.add(vertex);
            }
        }

        List<Integer> topologicalOrders = new ArrayList<>();

        while (!zeroInDegree.isEmpty()) {
            Integer v = zeroInDegree.poll();
            for (Integer n : graph.getNeighbors(v)) {
                inDegree.put(n, inDegree.get(n)-1);
                if (inDegree.get(n)==0) {
                    zeroInDegree.offer(n);
                }
            }
            topologicalOrders.add(v);
        }

        if (topologicalOrders.size()<graph.getVertices().size()) {
            return new LinkedList<>();
        }

        return topologicalOrders;
    }
}

