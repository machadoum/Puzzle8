package game8puzzle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Board implements Cloneable {

    private final int size = 3;
    private int xBlankField = 2;
    private int yBlankField = 2;
    private final String[] initialPiecesValues = {"A", "B", "C", "D", "E", "F", "G", "H", " "};

    private ArrayList<ArrayList<Piece>> matrix =  new ArrayList<>(size);

    public Board() {
        inicializeMatrix();
    }

    private Board(ArrayList<ArrayList<Piece>> newMatrix, int yBlankField, int xBlankField, int size) {
        this.matrix = newMatrix;
        this.yBlankField = yBlankField;
        this.xBlankField = xBlankField;
    }

    public void move(Direction direction) throws CantMoveToDirectionException {
        validateDirection(direction);

        int xFinalBlankField= xBlankField + direction.getXIncrement();
        int yFinalBlankField = yBlankField + direction.getYIncrement();

        swapPecas(yFinalBlankField, xFinalBlankField, yBlankField, xBlankField);

        this.xBlankField = xFinalBlankField;
        this.yBlankField = yFinalBlankField;
    }

    public boolean canMoveToDirection(Direction direction) {
        int xFinalPosition = xBlankField + direction.getXIncrement();
        int yFinalPosition = yBlankField + direction.getYIncrement();

        return isValueInBound(xFinalPosition) && isValueInBound(yFinalPosition);
    }

    public int getSize() {
        return size;
    }

    public Piece getPiece(int y, int x) {
        return matrix.get(y).get(x);
    }

    private void validateDirection(Direction direction) throws CantMoveToDirectionException {
        if (!canMoveToDirection(direction)) {
            throw new CantMoveToDirectionException();
        }
    }

    private void swapPecas(int yFirstPiece, int xFirstPiece, int ySecondPiece, int xSecondPiece) {
        Piece secondPeca = getPiece(ySecondPiece, xSecondPiece);
        setPiece(ySecondPiece, xSecondPiece, getPiece(yFirstPiece, xFirstPiece));
        setPiece(yFirstPiece, xFirstPiece, secondPeca);
    }

    private boolean isValueInBound(int value) {
        return value < getSize() && value >= 0;
    }

    private void setPiece(int y, int x, Piece piece) {
        matrix.get(y).set(x, piece);
    }

    private void inicializeMatrix() {
        Iterator<String> iterator = Arrays.asList(initialPiecesValues).iterator();

        for(int i = 0; i < getSize(); i++) {
            ArrayList<Piece> list = new ArrayList<>(size);
            for(int j = 0; j < getSize(); j++) {
                list.add(new Piece(iterator.next(), i, j));
            }
            matrix.add(list);
        }
    }

    public ArrayList<ArrayList<Piece>> copyMatrix() {
        ArrayList<ArrayList<Piece>> newMatrix = new ArrayList<>();

        for(ArrayList<Piece> arrayList : matrix) {
            ArrayList<Piece> line = new ArrayList<>(size);
            for(Piece piece : arrayList) {
                line.add(new Piece(piece.getValor(), piece.getXOriginal(), piece.getYOriginal()));
            }
            newMatrix.add(line);
        }
        return newMatrix;
    }

    @Override
    public String toString() {
        String board = "";
        for(ArrayList<Piece> line : matrix)
        {
            for(Piece cell : line)
            {
                board += cell + " ";
            }
            board += "\n";
        }
        return board;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Board) {
            Board board = (Board) obj;
            return board.matrix.equals(this.matrix);
        }
        return false;
    }

    @Override
    public Board clone() {
        return new Board(copyMatrix(), yBlankField, xBlankField, size);
    }
}
