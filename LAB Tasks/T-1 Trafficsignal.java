import java.util.*;

class Trafficsignal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();

        System.out.println("Enter vehicle numbers:");
        for (int i = 0; i < n; i++) {
            queue.add(sc.next());
        }

        System.out.println("Vehicles waiting: " + queue);

        String passed = queue.poll();

        System.out.println("Vehicle allowed to pass: " + passed);
        System.out.println("Remaining vehicles: " + queue);
        System.out.println("Vehicles waiting: " + queue.size());

        sc.close();
    }
}