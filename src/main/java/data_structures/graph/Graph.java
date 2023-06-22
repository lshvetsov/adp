package data_structures.graph;

import java.util.*;
import java.util.stream.IntStream;

public class Graph<T> {
    private ArrayDeque<T> searchStack = new ArrayDeque<>();
    private Map<T, LinkedList<T>> adj;
    private Set<T> visited = new HashSet<>();
    boolean result = false;

    Graph(List<T> vertices) {
        adj = new HashMap<>();
        vertices.forEach(x -> adj.put(x, new LinkedList<>()));
    }

    void addEdge(T vertex1, T vertex2) {

        if (!adj.containsKey(vertex1) || !adj.containsKey(vertex2)) return;

        adj.merge(vertex1, new LinkedList<>(List.of(vertex2)), (oldV, newV) -> {
            newV = new LinkedList<>(oldV);
            newV.offer(vertex2);
            return newV;
        });
    }

    public synchronized boolean search(T value, SearchType type) {

        this.cleanUp();

        adj.keySet().stream().findFirst().ifPresent(x -> searchStack.offer(x));

        switch (type) {
            case DFS -> dfs(value);
            case BFS -> bfs(value);
        }

        return result;
    }

    public boolean bfs(T value) {

        this.cleanUp();
        return false;
    }

    public boolean dfs(T value) {

        T root = searchStack.poll();
        if (root == null) return false;
        if (Objects.equals(value, root)) {
            System.out.printf("Match for value %s found%n", value);
            return true;
        }

        System.out.printf("Root node %s doesn't match requested %s, continue searching ....%n", root, value);

        visited.add(root);
        LinkedList<T> adjacent = adj.get(root);

        for (T item: adjacent) {
            searchStack.offer(item);
            if (!visited.contains(item)) {
                result = dfs(value);
            }
        }

        return result;
    }

    private void cleanUp() {
        visited.clear();
        result = false;
    }

    public static void main(String[] args) {

        Graph<Integer> g = new Graph<>(IntStream.range(0, 5).boxed().toList());

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);

        System.out.println(g.search(4, SearchType.DFS));
        System.out.println(g.search(9, SearchType.DFS));
    }

}


enum SearchType {
    DFS, BFS
}
