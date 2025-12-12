import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Tugas3StrukturDataDFS {

    private int V;
    private LinkedList<Integer> adj[];

    Tugas3StrukturDataDFS(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // DFS Util (rekursif)
    boolean DFSUtil(int current, int target, boolean visited[]) {

        System.out.println("Kunjungi node: a" + (current + 1));
        visited[current] = true;

        if (current == target) {
            System.out.println("==> Node ditemukan: a" + (current + 1));
            return true;
        }

        Iterator<Integer> i = adj[current].listIterator();

        while (i.hasNext()) {
            int next = i.next();
            System.out.println("  Periksa tetangga a" + (current + 1) + " → a" + (next + 1));

            if (!visited[next]) {
                System.out.println("   Masuk ke a" + (next + 1));

                if (DFSUtil(next, target, visited)) {
                    return true;
                }

                System.out.println("   Kembali (backtrack) ke a" + (current + 1));
            } else {
                System.out.println("   (Sudah dikunjungi) a" + (next + 1));
            }
        }

        return false;
    }

    void searchDFS(int start, int target) {
        boolean visited[] = new boolean[V];

        System.out.println("=== PROSES PENCARIAN DFS ===");
        boolean found = DFSUtil(start, target, visited);

        if (!found) {
            System.out.println("Node a" + (target + 1) + " TIDAK ditemukan dalam graf.");
        }
    }

    public static void main(String[] args) {

        Tugas3StrukturDataDFS g = new Tugas3StrukturDataDFS(8);

        // Bentuk graf 8 node
        g.addEdge(0, 1);
        g.addEdge(0, 2);

        g.addEdge(1, 3);
        g.addEdge(1, 4);

        g.addEdge(2, 4);
        g.addEdge(2, 5);

        g.addEdge(3, 6);

        g.addEdge(4, 6);
        g.addEdge(4, 7);

        g.addEdge(5, 2);
        g.addEdge(5, 7);

        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan angka yang ingin dicari (1-8): ");
        int target = sc.nextInt() - 1;

        System.out.println();
        g.searchDFS(0, target);
    }
}
