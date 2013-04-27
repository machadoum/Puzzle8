package aEstrela;
import game8puzzle.Board;
import game8puzzle.CantMoveToDirectionException;
import game8puzzle.Direction;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * TODO o algoritmo aconselha a verificar se já está na lista aberta antes de inserir, e trocar se for menor
 * pode dar merda se não fizer isso, já que o set pode substituir.
 * @author
 */

public class AEstrela {

    private static final int UNITARY_MOVEMENT_COST = 1;
    private static final Board SOLVED_BOARD = new Board();


    public static void main (String args[]) throws CantMoveToDirectionException, NoSolutionException {

        NodeState result = aEstrela();
        System.out.println(result);
    }

    private static NodeState aEstrela() throws CantMoveToDirectionException, NoSolutionException {
        PriorityQueue<NodeState> openNodeList = new PriorityQueue<>();
        PriorityQueue<NodeState> closedNodeList = new PriorityQueue<>();
        initializeOpenNodeList(openNodeList);


        while(!openNodeList.isEmpty()) {
            NodeState nodeState = openNodeList.iterator().next();

            if(isBoardSolved(nodeState.getBoard())) {
                System.out.println("Estados percorridos: " + closedNodeList.size());
                return nodeState;
            }

            Board actualBoard = nodeState.getBoard();
            openNodeList.remove(nodeState);
            closedNodeList.add(nodeState);

            for(Direction direction : Direction.values()) {
                if (actualBoard.canMoveToDirection(direction)) {
                    Board tempBoard = actualBoard.clone();
                    tempBoard.move(direction);
                    if (notInList(tempBoard, closedNodeList) && notInList(tempBoard, openNodeList)) {
                        int newCumulativeDistance = nodeState.getCumulativeDistance() + UNITARY_MOVEMENT_COST;
                        NodeState newNodeState = new NodeState(tempBoard, newCumulativeDistance);
                        openNodeList.add(newNodeState);
                    }
                }
            }
        }
        throw new NoSolutionException();
    }

    private static boolean isBoardSolved(Board actualBoard) {
        return SOLVED_BOARD.equals(actualBoard);
    }

    protected static boolean notInList(Board tempBoard, PriorityQueue<NodeState> nodeList) {
        for(NodeState nodeState : nodeList) {
            if(nodeState.getBoard().equals(tempBoard)) {
                return false;
            }
        }
        return true;
    }

    private static void initializeOpenNodeList(PriorityQueue<NodeState> openNodeList) throws CantMoveToDirectionException {
        Board board = SOLVED_BOARD.clone();
        shuffle(board);
        openNodeList.add(new NodeState(board, 0));
    }

    private static void shuffle(Board board) throws CantMoveToDirectionException {
        Direction directions[] = Direction.values();
        Random random = new Random();

        for(int i = 0; i < 1000; i++) {
            Direction direction = directions[random.nextInt(4)];
            if (board.canMoveToDirection(direction)) {
                board.move(direction);
            }
        }
        System.out.println(board);
        System.out.println("------");
    }
}
