package game8puzzle;
public class Piece
{

    private String value = "";
    private final int xOriginal;
    private final int yOriginal;

    public Piece(String value, int x, int y)
    {
        this.value = value;
        this.xOriginal = x;
        this.yOriginal = y;
    }

    public int getXOriginal()
    {
        return xOriginal;
    }

    public int getYOriginal()
    {
        return yOriginal;
    }

    public String getValor()
    {
        return value;
    }

    public boolean isPosicaoOriginal(int x, int y) {
        return getXOriginal() == x && getYOriginal() == y;
    }

    public int getManhattanDistanceToOrigin(int x, int y) {
        return (Math.abs(x - getXOriginal()) + Math.abs(y - getYOriginal()));
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Piece) {
            Piece piece = (Piece) obj;
            return piece.getValor().equals(this.getValor());
        }

        return false;
    }
}
