package tresenraya;

public class NoughtsAndCrossesBoardImplementation implements NoughtsAndCrossesBoard{

    Color color;
    
    Color[][] posicion = new Color[3][3];
    
    /* R  V  B
     * B  R  V
     * R  V  B*/
    
    public NoughtsAndCrossesBoardImplementation() {
        posicion[2][0] = color.RED; posicion[2][1] = color.VOID; posicion[2][2] = color.WHITE;
        posicion[1][0] = color.WHITE; posicion[1][1] = color.RED; posicion[1][2] = color.VOID;
        posicion[0][0] = color.RED; posicion[0][1] = color.VOID; posicion[0][2] = color.WHITE;
    }
    
    @Override
    public boolean isGameOver() {
        if (isThreeInLine(0,0,0,1,0,2)) {
            return true;
        }
        if (isThreeInLine(1,0,1,1,1,2)) {
            return true;
        }
        if (isThreeInLine(2,0,2,1,2,2)) {
            return true;
        }
        if (isThreeInLine(0,0,1,1,2,2)) {
            return true;
        }
        if (isThreeInLine(0,2,1,1,2,0)) {
            return true;
        }
        if (isThreeInLine(0,0,1,0,2,0)) {
            return true;
        }
        if (isThreeInLine(0,1,1,1,2,1)) {
            return true;
        }
        if (isThreeInLine(0,2,1,2,2,2)) {
            return true;
        }
        return false;
    }
    
    private boolean isThreeInLine(int x1, int y1, int x2, int y2, int x3, int y3) {
        if (posicion[y1][x1] == posicion[y2][x2] && posicion[y1][x1] == posicion[y3][x3] &&
                posicion[y1][x1] != color.VOID && posicion[y2][x2] != color.VOID && 
                posicion[y3][x3] != color.VOID) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean movePiece(int fromX, int fromY, int toX, int toY) {
        if (canMovePieceAt(fromX, fromY) && toX >= 0 && toX <= 2 &&
                toY >= 0 && toY <= 2 && posicion[toY][toX] == Color.VOID) {
            posicion[toY][toX] = posicion[fromY][fromX];
            posicion[fromY][fromX] = color.VOID;
            return true;
        }
        return false;
    }

    @Override
    public Color getPieceAt(int x, int y) {
        if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
            return posicion[y][x];
        }
        return null;
    }
    
    @Override
    public boolean canMovePieceAt(int x, int y) {
        if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
            if (posicion[y][x] != color.VOID) {
                return true;
            }
        }
        return false; 
    }
}
	