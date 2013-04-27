package aEstrela;
import game8puzzle.Board;


public class NodeState implements Comparable<NodeState>{


    private final Board board;
    private final int heuristicDistance;
    private final int cumulativeDistance;

    public NodeState(Board board, int cumulativeDistance) {
        this.board = board;
        this.heuristicDistance = HeuristicCalcService.manhattanDistanceHeuristic(board);
        this.cumulativeDistance = cumulativeDistance;
    }

    public Board getBoard()
    {
        return board;
    }

    public int getHeuristicDistance()
    {
        return heuristicDistance;
    }

    public int getCumulativeDistance()
    {
        return cumulativeDistance;
    }

    @Override
    public String toString() {
        return cumulativeDistance + ", " + heuristicDistance + "\n" + board + "\n";
    }

    @Override
    public int compareTo(NodeState nodeState)
    {
        int otherNodeValue = nodeState.getCumulativeDistance() + nodeState.getHeuristicDistance();
        int nodeValue = getCumulativeDistance() + getHeuristicDistance();
        return nodeValue - otherNodeValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NodeState) {
            NodeState nodeState = (NodeState) obj;
            return nodeState.getBoard().equals(this.getBoard());
        }
        return false;
    }

}
