package view;

import game8puzzle.Piece;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PieceView extends JLabel {

    private static final long serialVersionUID = 1787576131727444101L;
    private final Piece piece;

    public PieceView(Piece piece) {
        this.piece = piece;
        initGui();
    }

    private void initGui() {
        setOpaque(true);
        setPreferredSize(new Dimension(100,100));
        setText(piece.getValor());
        setFont(new Font("Serif", Font.BOLD, 40));
        setHorizontalAlignment(SwingConstants.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
