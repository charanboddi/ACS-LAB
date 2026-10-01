import java.util.*;

class Warehouseproduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> map = new HashMap<>();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        System.out.println("Enter product names:");

        for (int i = 0; i < n; i++) {
            String product = sc.next();
            map.put(product, map.getOrDefault(product, 0) + 1);
        }

        System.out.println("\nProduct Frequency:");

        for (String product : map.keySet()) {
            System.out.println(product + " : " + map.get(product));
        }

        sc.close();
    }
}