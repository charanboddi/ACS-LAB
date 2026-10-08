import java.util.*;

class ForestFire {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        int[][] forest = new int[rows][cols];

        System.out.println("Enter forest grid:");
        System.out.println("0 = Safe, 1 = Tree");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                forest[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter fire row: ");
        int r = sc.nextInt();

        System.out.print("Enter fire column: ");
        int c = sc.nextInt();

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        forest[r][c] = 2;

        int[][] directions = {
            {-1, 0}, {1, 0},
            {0, -1}, {0, 1}
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            for (int[] d : directions) {

                int nr = current[0] + d[0];
                int nc = current[1] + d[1];

                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols &&
                    forest[nr][nc] == 1) {

                    forest[nr][nc] = 2;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        System.out.println("\nFinal Forest:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(forest[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
