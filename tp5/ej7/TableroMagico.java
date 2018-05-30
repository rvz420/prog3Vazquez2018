package ej7;

import java.util.ArrayList;

import nReinas.NReinas.Position;

public class TableroMagico {

	class Position {
		int row, col, val;
		Position(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}

	public Position[] resolverTablero(int n, int k, int s) {	//n = tablero de n*n - k>n*n
		if (k>n*n) {
			Position[] vectorResultados = new Position[n*n];
			int[] sumaFila = new int[n];
			int[] sumaCol = new int[n];
			
			for (int i = 0; i < n; i++) {
				sumaFila[i] = 0;
				sumaCol[i] = 0;
			}
			
			ArrayList<Integer> opc = new ArrayList<Integer>();
			for (int i = 1; i <= k; i++) {
				opc.add(i);
			}
			boolean hasSolution = resolverTableroBack(n, k, s, vectorResultados, opc, 0, sumaFila, sumaCol);
			if (hasSolution) {
				return vectorResultados;
			} 
		}
		return new Position[0];
	}
	
	public boolean resolverTableroBack(int n, int k, int s, Position[] e, ArrayList<Integer> opc, int row, int[] sumaFila, int[] sumaCol  ) {
		if (n == row) {
            return true;
        }
		
		int col;
        for (col = 0; col < n; col++) {
        	boolean foundSafe = true;
        	int valor = opc.get(col);
        	if(sumaFila[row]+valor <= s && sumaCol[col]+valor <= s) {
        		e[(n*row)+col] = new Position(row, col, opc.remove(col));
        		sumaFila[row] +=  valor;
        		sumaCol[col] +=  valor;
        	} else {
        		foundSafe = false;
        	}
        	if (foundSafe) {
        		
                if (resolverTableroBack(n, k, s, e, opc, row+1, sumaFila, sumaCol)) {
                    return true;
                }
            }
        	
        }
		return false;
	}
	
	public static void main(String args[]) {

	}

}
