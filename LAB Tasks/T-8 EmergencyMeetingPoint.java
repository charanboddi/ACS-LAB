import java.util.*;

public class EmergencyMeetingPoint {

    static List<Integer> bfs(List<List<Integer>> graph, int start) {

        int[] dist = new int[graph.size()];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int next : graph.get(current)) {

                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    queue.add(next);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int d : dist) {
            result.add(d);
        }

        return result;
    }

    public static void main(String[] args) {

        int n = 6;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 3},
            {2, 3},
            {3, 4},
            {4, 5}
        };

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int emergency1 = 0;
        int emergency2 = 5;

        List<Integer> d1 = bfs(graph, emergency1);
        List<Integer> d2 = bfs(graph, emergency2);

        int meetingPoint = -1;
        int bestDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (d1.get(i) != -1 && d2.get(i) != -1) {

                int maxDistance =
                    Math.max(d1.get(i), d2.get(i));

                if (maxDistance < bestDistance) {
                    bestDistance = maxDistance;
                    meetingPoint = i;
                }
            }
        }

        System.out.println("Emergency Location 1: " + emergency1);
        System.out.println("Emergency Location 2: " + emergency2);
        System.out.println("Recommended Meeting Point: " + meetingPoint);
        System.out.println("Maximum Distance: " + bestDistance);
    }
}