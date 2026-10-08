import java.util.*;

class CampusNetwork {

    static void dfs(List<List<Integer>> graph,
                    boolean[] visited, int node) {

        visited[node] = true;
        System.out.print(node + " ");

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(graph, visited, next);
            }
        }
    }

    public static void main(String[] args) {

        int n = 5;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 4}
        };

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];

        System.out.println("DFS Traversal:");
        dfs(graph, visited, 0);

        boolean connected = true;

        for (boolean v : visited) {
            if (!v) {
                connected = false;
                break;
            }
        }

        if (connected)
            System.out.println("\nCampus Network is CONNECTED");
        else
            System.out.println("\nCampus Network is NOT CONNECTED");
    }
}