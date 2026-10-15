import java.util.*;

public class CPUtask {

    static class Task {
        String name;
        int priority;

        Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PriorityQueue<Task> pq = new PriorityQueue<Task>(
            new Comparator<Task>() {
                public int compare(Task a, Task b) {
                    return a.priority - b.priority;
                }
            }
        );

        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter task name: ");
            String name = sc.next();

            System.out.print("Enter priority: ");
            int priority = sc.nextInt();

            pq.add(new Task(name, priority));
        }

        System.out.println("\nCPU Execution Order:");

        while (!pq.isEmpty()) {

            Task task = pq.poll();

            System.out.println(
                task.name + " - Priority " + task.priority
            );
        }

        sc.close();
    }
}
