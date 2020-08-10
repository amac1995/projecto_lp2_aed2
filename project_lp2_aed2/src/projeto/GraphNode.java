package projeto;

import java.io.Serializable;

public abstract class GraphNode  implements Serializable, Comparable<GraphNode> {

    private int id;
    private String idString;
    private static int ACTUAL_ID = 0;

    public GraphNode() {
        this.id = ACTUAL_ID++;
    }

    public GraphNode(int id) {
        this.id = id;
    }

    public GraphNode(String string) {
        this.idString=string;
    }

    public int getId() {
        return id;
    }

    public String getIdString(){
        return idString;
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GraphNode other = (GraphNode) obj;
        return this.id == other.id;
    }



}