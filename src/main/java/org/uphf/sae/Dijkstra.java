package org.uphf.sae;

import java.util.*;

public class Dijkstra {
    private final Monde monde;

    public Dijkstra(Monde monde) {
        this.monde = monde;
    }

    public List<int[]> cheminPlusCourt(int startX, int startY, int endX, int endY) {
        int[][] dist = new int[10][10];
        int[][][] prev = new int[10][10][2];
        boolean[][] visited = new boolean[10][10];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[startX][startY] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(p -> dist[p[0]][p[1]]));
        queue.add(new int[]{startX, startY});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            if (visited[x][y]) continue;
            visited[x][y] = true;
            if (x == endX && y == endY) break;

            for (int[] voisin : monde.getVoisins(x, y)) {
                int nx = voisin[0], ny = voisin[1];
                if (monde.leMonde[ny][nx].accueilRobot() && !monde.leMonde[ny][nx].secteurEau()){
                    int newDist = dist[x][y] + monde.getCout(x, y, nx, ny);
                    if (newDist < dist[nx][ny]) {
                        dist[nx][ny] = newDist;
                        prev[nx][ny] = new int[]{x, y};
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        List<int[]> path = new ArrayList<>();
        for (int[] at = {endX, endY}; at != null; at = prev[at[0]][at[1]]) {
            path.add(at);
            if (Arrays.equals(at, new int[]{startX, startY})) break;
        }
        Collections.reverse(path);
        return path;
    }
}
