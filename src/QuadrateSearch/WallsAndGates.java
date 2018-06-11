package QuadrateSearch;

/*You are given a m x n 2D grid initialized with these three possible values.

        -1 - A wall or an obstacle.
        0 - A gate.
        INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
        Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.*/

/*Example:

        Given the 2D grid:

        INF  -1  0  INF
        INF INF INF  -1
        INF  -1 INF  -1
        0  -1 INF INF
        After running your function, the 2D grid should be:

        3  -1   0   1
        2   2   1  -1
        1  -1   2  -1
        0  -1   3   4*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    static final int INF = Integer.MAX_VALUE;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, -1, 0, 1};
    static final int NUM_OF_DIRECTIONS = 4;

    public static void main(String args[]) {
        //for testing only
        int[][] testArray =
                {{INF, -1, 0, INF},
                 {INF, INF, INF, -1},
                 {INF, -1, INF, -1},
                 {0, -1, INF, INF}};

        wallsAndGates(testArray);
        Arrays.stream(testArray).forEach(i -> {
            Arrays.stream(i).forEach(j -> {
                System.out.print(j + " ");
            });
            System.out.println();
        });
    }


    public static void wallsAndGates(int[][] rooms) {
        //corner case
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            return;
        }

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    searchAndCalculateDistance(rooms, i, j);
                }
            }
        }
    }

    private static void searchAndCalculateDistance(int[][] rooms, int i, int j) {
        Queue<Pair> searchQueue = new LinkedList<>();
        searchQueue.offer(new Pair(i, j));
        int distance = 0;
        while (!searchQueue.isEmpty()) {
            int size = searchQueue.size();
            for (int loop = 0; loop < size; loop++) {
                Pair pos = searchQueue.poll();
                rooms[pos.x][pos.y] = distance;

                for (int direction = 0; direction < NUM_OF_DIRECTIONS; direction++) {
                    int newX = pos.x + dx[direction];
                    int newY = pos.y + dy[direction];
                    if (isValidPos(rooms, newX, newY)
                            && rooms[newX][newY] != 0
                            && rooms[newX][newY] != -1
                            && distance < rooms[newX][newY]
                            ) {
                        searchQueue.offer(new Pair(newX, newY));
                    }
                }
            }
            distance++;
        }
    }

    private static boolean isValidPos(int[][] rooms, int newX, int newY) {
        int xLen = rooms.length;
        int yLen = rooms[0].length;
        if (newX < 0 || newX >= xLen || newY < 0 || newY >= yLen) {
            return false;
        }
        return true;
    }
}

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
