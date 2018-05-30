package nReinas;

import java.util.Arrays;

public class NReinas {

	class Position {
		int row, col;
		Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public Position[] resolverReinasUnaSolucion(int n) {	//n = tablero de n*n & n= cantidad de reinas
		Position[] positions = new Position[n];
		boolean hasSolution = resolverReinasBack(n, 0, positions);
		if (hasSolution) {
			return positions;
		} else {
			return new Position[0];
		}
	}
	
	private boolean resolverReinasBack(int n, int row, Position[] positions) {
        if (n == row) {
            return true;
        }
        int col;
        for (col = 0; col < n; col++) {
            boolean foundSafe = true;

            //Chequear si esta fila y columna no se encuentra amenazada por alguna reina.
            for (int queen = 0; queen < row; queen++) {
                if (positions[queen].col == col || positions[queen].row - positions[queen].col == row - col ||
                        positions[queen].row + positions[queen].col == row + col) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                positions[row] = new Position(row, col);
                if (resolverReinasBack(n, row + 1, positions)) {
                    return true;
                }
            }
        }
        return false;
    }

	
	public static void main(String args[]) {
		NReinas s = new NReinas();
		Position[] positions = s.resolverReinasUnaSolucion(8);
		Arrays.stream(positions).forEach(position -> System.out.println(position.row + " " + position.col));
	}

}

