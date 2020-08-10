package projeto;


import java.io.Serializable;


public class NetworkNode extends GraphNode implements Serializable{


    public NetworkNode() {
        super();
    }
    public NetworkNode(int id) {
        super(id);
    }
    public NetworkNode(String string) {
        super(string);
    }


    @Override
    public int compareTo(GraphNode o) {
        return 0;
    }
}
