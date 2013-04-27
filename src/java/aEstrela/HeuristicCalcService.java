package aEstrela;

import game8puzzle.Board;

public class HeuristicCalcService {

    /**
     * Quantas pecas n�o est�o  no seu lugar correto.
     * @param mapa
     */
    public static int unitaryDistanceHeuristic(Board board) {
        int errados = 0;
        for(int i = 0; i < board.getSize(); i++) {
            for(int j = 0; j < board.getSize(); j++) {
                if (!board.getPiece(i, j).isPosicaoOriginal(i, j)) {
                    errados++;
                }
            }
        }
        return errados;
    }

    /**
     * Soma da distancia necess�ria para todas pecas irem para sua posi��o correta.
     * Utiliza distancia Manhattan para o calculo.
     * @param board
     * @return
     */
    public static int manhattanDistanceHeuristic(Board board) {
        int distanciaManhattanTotal = 0;
        for(int i = 0; i < board.getSize(); i++) {
            for(int j = 0; j < board.getSize(); j++) {
                    distanciaManhattanTotal+= board.getPiece(i, j).getManhattanDistanceToOrigin(i, j);
            }
        }
        return distanciaManhattanTotal;
    }
}
