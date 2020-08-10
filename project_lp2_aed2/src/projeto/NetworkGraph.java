package projeto;

import projeto.recursos.Bag;
import projeto.recursos_alt.In;

import java.io.Serializable;
import java.util.ArrayList;

public class NetworkGraph extends FlowNetwork implements Serializable {

    private final ArrayList<GraphNode> nodes = new ArrayList<>();

    protected NetworkGraph() {
        super(0);
    }

    public NetworkGraph(int V) {
        super(V);
    }

    public NetworkGraph(int V, int E) {
        super(V, E);
    }

    public NetworkGraph(In in) {
        super(in);
    }




    void addNode(GraphNode node) {
        if (this.nodes.size() >= this.V()) {
            throw new IllegalArgumentException();
        }
        this.nodes.add(node);
    }

    public int indegree(int v) {
        validateVertex(v);
        return indegree(v);
    }

    void addEdge(GraphNode from, GraphNode to, double power) {
        if (!(this.nodes.contains(from) || this.nodes.contains(to))) {
            throw new IllegalArgumentException();
        }
        NetworkLine cl = new NetworkLine(from, to, power);
        this.addEdge(cl);
    }

    public Iterable<FlowEdge> edges() {
        Bag<FlowEdge> list = new Bag<>();
        for (int v = 0; v < this.V(); v++) {
            for (FlowEdge e : adj(v)) {
                list.add(e);
            }
        }
        return list;
    }




    @Override
    public String toString() {
        return "Nós do graph: \n" + nodes;
    }
}
