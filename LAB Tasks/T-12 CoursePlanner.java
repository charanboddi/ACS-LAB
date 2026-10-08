import java.util.*;

class CoursePlanner {

    public static void main(String[] args) {

        int n = 6;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] prerequisites = {
            {0, 1},
            {1, 2},
            {1, 3},
            {3, 4},
            {4, 5}
        };

        int[] indegree = new int[n];

        // Create graph and calculate indegree
        for (int[] edge : prerequisites) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add courses having no prerequisites
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        // Topological sorting
        while (!queue.isEmpty()) {

            int course = queue.poll();
            order.add(course);

            for (int next : graph.get(course)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // Check for cycle
        if (order.size() == n) {
            System.out.println("Valid Course Order:");
            System.out.println(order);
        } else {
            System.out.println(
                "Cycle detected. Course planning not possible."
            );
        }
    }
}