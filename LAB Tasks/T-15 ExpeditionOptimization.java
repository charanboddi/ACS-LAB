import java.util.*;

class ExpeditionOptimization {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of resources: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        System.out.println("Enter weights:");

        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        System.out.println("Enter values:");

        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        System.out.print("Enter maximum capacity: ");
        int capacity = sc.nextInt();

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {

            for (int w = 0; w <= capacity; w++) {

                if (weight[i - 1] <= w) {

                    dp[i][w] = Math.max(
                        value[i - 1] +
                        dp[i - 1][w - weight[i - 1]],

                        dp[i - 1][w]
                    );

                } else {

                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println(
            "Maximum Resource Value: " +
            dp[n][capacity]
        );

        sc.close();
    }
}
