import java.util.*;

public class Main {

    static final int INF = 999999;

    public static void dijkstra(int[][] graph, int start) {

        int n = graph.length;

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            dist[i] = INF;
        }

        dist[start] = 0;

        for(int count = 0; count < n - 1; count++) {

            int u = -1;
            int min = INF;
            for(int i = 0; i < n; i++) {

                if(!visited[i] && dist[i] < min) {

                    min = dist[i];
                    u = i;
                }
            }

            visited[u] = true;
            for(int v = 0; v < n; v++) {

                if(!visited[v]
                        && graph[u][v] != 0
                        && dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        for(int i = 0; i < n; i++) {
            System.out.println("Vertex " + i +
                    " Distance = " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 1, 0},
                {4, 0, 2, 5},
                {1, 2, 0, 8},
                {0, 5, 8, 0}
        };

        dijkstra(graph, 0);
    }
}