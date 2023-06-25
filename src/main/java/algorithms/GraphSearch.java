package algorithms;

import java.util.*;
import java.util.stream.IntStream;

public class GraphSearch<T> {

    private ArrayDeque<T> searchStack = new ArrayDeque<>();
    private Map<T, LinkedList<T>> adj;
    private Set<T> visited = new HashSet<>();
    boolean result = false;
    SearchEngine engine = new SearchEngine();

    GraphSearch(List<T> vertices) {
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

        engine.search(value, searchStack.pollLast(), type);

        return result;
    }

    private void cleanUp() {
        searchStack.clear();
        visited.clear();
        result = false;
    }

    private class SearchEngine {

        public boolean search(T value, T root, SearchType type) {

            if (root == null) return false;
            if (Objects.equals(value, root)) {
                System.out.printf("Match for value %s found%n", value);
                return true;
            }

            System.out.printf("Root node %s doesn't match requested %s, continue searching ....%n", root, value);

            visited.add(root);
            adj.get(root).forEach(searchStack::offer);

            T item;
            do {
                item = SearchType.DFS.equals(type) ? searchStack.pollLast() : searchStack.pollFirst();
                if (!visited.contains(item))
                    result = search(value, item, type);
                if (result) break;
            } while (item != null);

            return result;
        }

    }

    public static void main(String[] args) {

        GraphSearch<Integer> g = new GraphSearch<>(IntStream.range(0, 5).boxed().toList());

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);

        System.out.println("DFS -----------------------");
        System.out.println(g.search(4, SearchType.DFS));
        System.out.println(g.search(9, SearchType.DFS));

        System.out.println("BFS -----------------------");
        System.out.println(g.search(4, SearchType.BFS));
        System.out.println(g.search(9, SearchType.BFS));
    }

}


enum SearchType {
    DFS, BFS
}
