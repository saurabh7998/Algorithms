import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class BFS {

  private void BFSUtil(int s, boolean[] visited, Graph graph) {
    LinkedList<Integer> queue = new LinkedList<>();

    visited[s] = true;
    queue.add(s);

    while (queue.size() != 0) {
      s = queue.poll();
      System.out.println(s);

      Iterator<Integer> iterator = graph.getAdjList().get(s).listIterator();
      while (iterator.hasNext()) {
        int next = iterator.next();
        if (!visited[next]) {
          visited[next] = true;
          queue.add(next);
        }
      }

    }

  }

  public void BFSearch(Graph graph, int V) {
    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      visited[i] = false;
    }

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        BFSUtil(i, visited, graph);
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

    BFS bfs = new BFS();
    bfs.BFSearch(graph,4);
  }
}
