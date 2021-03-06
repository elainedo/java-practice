import java.util.*;

class Graph {
    Map<Integer, Set<Integer>> map;

    public Graph() {
        map = new HashMap<>();
    }

    public void addVertex(int vertex) {
        if (!map.containsKey(vertex)) {
            map.put(vertex, new HashSet<>());
        }
    }

    public void addEdge(int source, int destination) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }
        if (!map.containsKey(destination)) {
            addVertex(destination);
        }
        map.get(source).add(destination);
    }

    public List<Integer> getVertices() {
        List<Integer> vertices = new LinkedList<>();
        for (int vertex : map.keySet()) {
            vertices.add((vertex));
        }
        return vertices;
    }

    public List<Integer> getNeighbors(int vertex) {
        List<Integer> neighbors = new LinkedList<>();
        if (map.containsKey(vertex)) {
            for (Integer edge : map.get(vertex)) {
                neighbors.add(edge);
            }
        }
        return neighbors;
    }

    public void printGraph() {
        for (Integer vertex : map.keySet()) {
            System.out.println("Vertex: " + vertex);
            for (int neighbor : map.get(vertex)) {
                System.out.print("Edge: " + neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.printGraph();

        TopologicalSort sort = new TopologicalSort(graph);
        List<Integer> topologicalOrder = sort.topologicalSort();
        System.out.print("Topological order: ");
        for (int vertex : topologicalOrder) {
            System.out.print(vertex + " ");
        }
        System.out.println();
    }
}