import java.util.*;

class Circulardelivery {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of locations: ");
        int n = sc.nextInt();

        Node head = null;
        Node last = null;

        System.out.println("Enter locations:");

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.next());

            if (head == null) {
                head = newNode;
            } else {
                last.next = newNode;
            }

            last = newNode;
        }

        last.next = head;

        System.out.println("\nCircular Delivery Route:");

        Node temp = head;

        for (int i = 0; i < n; i++) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("BACK TO " + head.data);

        sc.close();
    }
}