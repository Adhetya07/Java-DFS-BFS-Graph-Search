import java.util.*;

public class Tugas3StrukturDataBFS {

    public static void main(String[] args) {

        // nilai pada tiap node a1-a8
        int[] values = {10, 5, 7, 3, 9, 2, 15, 9};

        // adjacency list graf (hubungan antar node)
        int[][] graph = {
                {1, 2},      // a1 terhubung ke a2, a3
                {0, 3, 4},   // a2 terhubung ke a1, a4, a5
                {0, 5},      // a3 terhubung ke a1, a6
                {1, 6},      // a4 terhubung ke a2, a7
                {1, 7},      // a5 terhubung ke a2, a8
                {2, 7},      // a6 terhubung ke a3, a8
                {3},         // a7 terhubung ke a4
                {4, 5}       // a8 terhubung ke a5, a6
        };

        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nilai n yang dicari: ");
        int n = input.nextInt();

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[8];

        queue.add(0);          // mulai dari node a1 (index 0)
        visited[0] = true;

        System.out.println("\n=== PROSES BFS ===");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println("Mengunjungi node a" + (current + 1) +
                               " dengan nilai: " + values[current]);

            if (values[current] == n) {
                System.out.println("\n>> Nilai " + n + " ditemukan pada node a" + (current + 1));
                return;
            }

            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    System.out.println("  -> enqueue a" + (neighbor + 1));
                }
            }
        }

        System.out.println("\n>> Nilai " + n + " TIDAK ditemukan dalam graf.");
    }
}
