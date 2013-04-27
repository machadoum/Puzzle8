package aEstrela;

import game8puzzle.Board;
import game8puzzle.Direction;

import java.util.Iterator;
import java.util.PriorityQueue;

import junit.framework.Assert;

import org.junit.Test;

public class NodeStateTest {

    @Test
    public void shouldBeOrderedInTreeSet() throws Exception {
        //given
        PriorityQueue<NodeState> openNodeList = new PriorityQueue<>();
        openNodeList.add(new NodeState(new Board(), 2));
        openNodeList.add(new NodeState(new Board(), 1));

        //when
        Iterator<NodeState> iterator = openNodeList.iterator();
        NodeState first = iterator.next();
        NodeState second = iterator.next();

        //then
        Assert.assertTrue(first.getCumulativeDistance() < second.getCumulativeDistance());
    }

    @Test
    public void should() throws Exception {
        //given
        PriorityQueue<NodeState> openNodeList = new PriorityQueue<>();
        Board b1 = new Board();
        b1.move(Direction.Left);

        Board b2 = new Board();
        b2.move(Direction.Up);

        NodeState n1 = new NodeState(b1, 2);
        NodeState n2 = new NodeState(b1, 2);

        //when
        openNodeList.add(n1);
        //openNodeList.add(n2);

        //then
        Assert.assertTrue(openNodeList.contains(n1));
        Assert.assertTrue(openNodeList.contains(n2));

        //Assert.assertEquals(openNodeList.size(), 2);

    }


}
