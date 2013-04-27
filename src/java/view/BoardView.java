package view;

import game8puzzle.Board;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardView extends JFrame
{

    private static final long serialVersionUID = 3684374486890855238L;
    private static final int size_x = 316;
    private static final int size_y = 338;
    private static Board board;

    public static void main(String args[]) {
        new BoardView();
    }

    public BoardView() {
        board = new Board();

        setVisible(true);
        add(getMainPanel());
        setSize(size_x, size_y);
    }

    private JPanel getMainPanel()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        panel.setSize(size_x, size_y);

        initialize(panel);

        FlowLayout mgr = new FlowLayout();
        mgr.setVgap(0);
        mgr.setHgap(0);
        panel.setLayout(mgr);

        return panel;
    }

    private void initialize(JPanel panel)
    {
        for(int i = 0; i < board.getSize(); i++) {
            for(int j = 0; j < board.getSize(); j++) {
                panel.add(new PieceView (board.getPiece(i, j)));
            }
        }
    }
}
