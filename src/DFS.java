import java.util.Iterator;

public class DFS {


  private void DFSUtil(int s, Graph g, boolean[] visited) {
    visited[s] = true;
    System.out.println(s);

    Iterator<Integer> iterator = g.getAdjList().get(s).listIterator();
    while (iterator.hasNext()) {
      int next = iterator.next();
      if (!visited[next]) {
        visited[next] = true;
        DFSUtil(next, g, visited);
      }
    }
  }

  public void DFSearch(Graph graph, int V) {
    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      visited[i] = false;
    }

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        DFSUtil(i, graph, visited);
      }
    }
  }


  public static void main(String[] args) {
    Graph graph = new Graph(4);

    graph.addDirEdge(0, 1);
    graph.addDirEdge(1, 2);
    graph.addDirEdge(2, 3);
    graph.addDirEdge(3, 3);
    graph.addDirEdge(2, 0);
    graph.addDirEdge(0, 2);

    DFS dfs = new DFS();
    dfs.DFSearch(graph, 4);
  }
}
