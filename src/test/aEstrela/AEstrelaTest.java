package aEstrela;

import game8puzzle.Board;
import game8puzzle.Direction;

import java.util.PriorityQueue;

import junit.framework.Assert;

import org.junit.Test;

public class AEstrelaTest
{

    @Test
    public void testname() throws Exception
    {
        AEstrela aEstrela = new AEstrela();

        PriorityQueue<NodeState> openNodeList = new PriorityQueue<>();
        Board b1 = new Board();
        b1.move(Direction.Left);

        Board b2 = new Board();
        b2.move(Direction.Up);

        NodeState n1 = new NodeState(b1, 2);
        NodeState n2 = new NodeState(b2, 2);

        //when
        openNodeList.add(n1);
        openNodeList.add(n2);

        Assert.assertTrue(aEstrela.notInList(b1, openNodeList));
    }

}
