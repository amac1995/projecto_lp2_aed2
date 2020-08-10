package projeto.recursos_alt;

import projeto.FlowEdge;
import projeto.NetworkGraph;
import projeto.recursos.Bag;
import projeto.recursos.Stack;


public class EdgeWeightedDigraph extends NetworkGraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private int V;                // number of vertices in this digraph
    private int E;                      // number of edges in this digraph
    private Bag<FlowEdge>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;             // indegree[v] = indegree of vertex v

    public EdgeWeightedDigraph(NetworkGraph G) {
        //this(G.V());
        this.E = G.E();
        /*for (int v = 0; v < G.V(); v++) {
            this.indegree[v] = G.indegree(v);
        }*/
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<FlowEdge> reverse = new Stack<>();
            for (FlowEdge e : G.adj(v)) {
                reverse.push(e);
            }
            for (FlowEdge e : reverse) {
                adj[v].add(e);
            }

        }
    }

    public EdgeWeightedDigraph(In in) {
        //this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            validateVertex(v);
            validateVertex(w);
            double weight = in.readDouble();
            addEdge(new FlowEdge(v, w, weight));
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }


    public void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public Iterable<FlowEdge> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public void addEdge(FlowEdge e) {
        int v = e.from();
        int w = e.to();
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        indegree[w]++;
        E++;
    }

    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }

    public Iterable<FlowEdge> edges() {
        Bag<FlowEdge> list = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (FlowEdge e : adj(v)) {
                list.add(e);
            }
        }
        return list;
    }

    public void setAdj(Bag<FlowEdge>[] adj) {
        this.adj = adj;
    }

    @Override
    public void setIndegree(int[] indegree) {
        this.indegree = indegree;
    }
}
