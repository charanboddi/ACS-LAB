import java.util.*;

class DeliveryOptimization {

    static final int INF = 9999;

    public static void main(String[] args) {

        int[][] graph = {
            {0, 4, 2, 0, 0},
            {4, 0, 1, 5, 0},
            {2, 1, 0, 8, 10},
            {0, 5, 8, 0, 2},
            {0, 0, 10, 2, 0}
        };

        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int count = 0; count < n; count++) {

            int u = -1;
            int min = INF;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }
            }

            if (u == -1)
                break;

            visited[u] = true;

            for (int v = 0; v < n; v++) {

                if (graph[u][v] != 0 &&
                    dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Shortest delivery distances from City 0:");

        for (int i = 0; i < n; i++) {
            System.out.println("City " + i + " = " + dist[i]);
        }
    }
}
