package ej7;

import java.util.ArrayList;

public class TableroMagico {

	class Position {
		int row, col, val;
		Position(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}

	public Position[] resolverReinasUnaSolucion(int n, int k, int s) {	//n = tablero de n*n - k>n*n
		if (k>n*n) {
			Position[] vectorResultados = new Position[n*n];
			ArrayList<Integer> opc = new ArrayList<Integer>();
			for (int i = 1; i <= k; i++) {
				opc.add(i);
			}
			boolean hasSolution = resolverTableroBack(n, k, s, vectorResultados, opc, 0);
			if (hasSolution) {
				return vectorResultados;
			} 
		}
		return new Position[0];
	}
	
	public boolean resolverTableroBack(int n, int k, int s, Position[] e, ArrayList<Integer> opc, int row ) {
		if (n == row) {
            return true;
        }
		
		int col;
        for (col = 0; col < n; col++) {
        	
        }
		return false;
	}
	
	public static void main(String args[]) {

	}

}
