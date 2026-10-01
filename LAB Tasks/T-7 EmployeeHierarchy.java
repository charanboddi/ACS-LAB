import java.util.*;

class EmployeeHierarchy {

    static class Node {
        String name;
        ArrayList<Node> children = new ArrayList<>();

        Node(String name) {
            this.name = name;
        }
    }

    static void display(Node root, int level) {

        for (int i = 0; i < level; i++)
            System.out.print("  ");

        System.out.println(root.name);

        for (Node child : root.children) {
            display(child, level + 1);
        }
    }

    public static void main(String[] args) {

        Node ceo = new Node("CEO");
        Node manager = new Node("Manager");
        Node developer = new Node("Developer");
        Node tester = new Node("Tester");

        ceo.children.add(manager);
        manager.children.add(developer);
        manager.children.add(tester);

        System.out.println("Employee Hierarchy:");

        display(ceo, 0);
    }
}