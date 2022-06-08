public class Prims {

  private int getMinKey(boolean[] mst, int[] key) {

    int min = Integer.MAX_VALUE;
    int min_index = -1;

    for (int i = 0; i < key.length; i++) {
      if (key[i] < min && mst[i] == false) {
        min = key[i];
        min_index = i;
      }
    }

    return min_index;
  }

  private int[] PrimMST(int[][] graph) {
    int V = graph.length;
    int[] parent = new int[V];  //array to store mst
    boolean mst[] = new boolean[V];
    int[] key = new int[V];
    for (int i = 1; i < V; i++) {
      key[i] = Integer.MAX_VALUE;
      mst[i] = false;
    }
    key[0] = 0;
    parent[0] = -1;

    for (int i = 0; i < V - 1; i++) {
      int u = getMinKey(mst, key);
      mst[u] = true;

      for (int v = 0; v < V; v++) {
        if (graph[u][v] != 0 && mst[v] == false && graph[u][v] < key[v]) {
          parent[v] = u;
          key[v] = graph[u][v];
        }
      }
    }

    return parent;
  }

  public static void main(String[] args) {
    int graph[][] = new int[][]
            {
                    {0, 2, 0, 6, 0},
                    {2, 0, 3, 8, 5},
                    {0, 3, 0, 0, 7},
                    {6, 8, 0, 0, 9},
                    {0, 5, 7, 9, 0}
            };


    Prims prims = new Prims();
    int[] res = prims.PrimMST(graph);

    for (int i = 1; i < graph.length; i++) {
      System.out.print(res[i] + " - " + i + " ---> " + graph[i][res[i]]);
      System.out.println();
    }

  }
}
