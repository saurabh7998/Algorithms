import java.util.LinkedList;

public class Graph {

  private int V;
  private LinkedList<LinkedList<Integer>> adjList = new LinkedList<>();

  public Graph(int V) {
    this.V = V;
    for (int i = 0; i < V; i++) {
      adjList.add(new LinkedList<Integer>());
    }
  }


  public void addDirEdge(int a, int b) {
    adjList.get(a).add(b);
  }

  public void addEdge(int a, int b) {
    adjList.get(a).add(b);
    adjList.get(b).add(a);
  }

  public LinkedList<LinkedList<Integer>> getAdjList() {
    return this.adjList;
  }

}
