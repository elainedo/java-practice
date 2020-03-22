import java.util.List;

class Main {
    public Main() {
        
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