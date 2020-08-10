package projeto;

import javax.sound.sampled.Line;
import java.io.Serializable;

public class NetworkLine extends FlowEdge  implements Serializable {
/*
    public void addLine(Line) {

    }*/

    public NetworkLine(int v, int w, double capacity) {
        super(v, w, capacity);
    }

    public NetworkLine(int v, int w, double capacity, double flow) {
        super(v, w, capacity, flow);
    }

    public NetworkLine(FlowEdge e) {
        super(e);
    }

    public NetworkLine(GraphNode from, GraphNode to, int cost) {
        super(from.getId(), to.getId(), cost);
    }


    public NetworkLine(GraphNode from, GraphNode to, double power) {
        super(from.getId(), to.getId(), power);
    }
}

