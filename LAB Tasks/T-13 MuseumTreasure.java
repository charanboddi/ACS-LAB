import java.util.*;

class MuseumTreasure {

    static int rows = 4;
    static int cols = 4;

    static int[][] maze = {
        {1, 1, 0, 0},
        {0, 1, 1, 0},
        {0, 0, 1, 0},
        {0, 0, 1, 1}
    };

    static boolean[][] visited = new boolean[rows][cols];

    static boolean findPath(int r, int c) {

        if (r < 0 || r >= rows ||
            c < 0 || c >= cols ||
            maze[r][c] == 0 ||
            visited[r][c]) {

            return false;
        }

        visited[r][c] = true;

        if (r == rows - 1 && c == cols - 1) {
            System.out.println("Treasure Found at (" + r + "," + c + ")");
            return true;
        }

        if (findPath(r + 1, c) ||
            findPath(r, c + 1) ||
            findPath(r - 1, c) ||
            findPath(r, c - 1)) {

            System.out.println("Visited: (" + r + "," + c + ")");
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("Searching for treasure...");

        if (!findPath(0, 0))
            System.out.println("No route to treasure found.");
    }
}