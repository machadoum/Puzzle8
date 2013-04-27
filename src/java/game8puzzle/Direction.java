package game8puzzle;
public enum Direction {
    Right(0,1),
    Left(0,-1),
    Down(1,0),
    Up(-1,0);

    private final int x;
    private final int y;

    Direction(int y, int x) {
        this.x = x;
        this.y = y;
    }

    int getXIncrement() {
        return x;
    }

    int getYIncrement() {
        return y;
    }
}
