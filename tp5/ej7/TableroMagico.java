package ej7;

import java.util.ArrayList;

public class TableroMagico {

	public int[][] resolverTablero(int n, int k, int s) {	//n = tablero de n*n - k>n*n
		if (k>n*n) {
			int[][] matrizSolucion = new int[n][n];
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
			boolean hasSolution = resolverTableroBack(n, k, s, matrizSolucion, opc, 0, 0, sumaFila, sumaCol);
			if (hasSolution) {
				return matrizSolucion;
			} 
		}
		return new int[0][0];
	}

	public boolean resolverTableroBack(int n, int k, int s, int[][] matriz, ArrayList<Integer> opc, int row, int col, int[] sumaFila, int[] sumaCol  ) {
		if (solucion(sumaFila, sumaCol, s)) {
			return true;
		}else{
			for (int i = row; i < n; i++) {
				for (int j = col; j < n; j++) {
					if (matriz[i][j] == 0) {
						matriz[i][j] = opc.remove(0);
						sumaFila[col] += matriz[i][j];
						sumaFila[row] += matriz[i][j];
						
						if (resolverTableroBack(n, k, s, matriz, opc, row+1, col+1, sumaFila, sumaCol)) {
							
						}
					}
				}

			}
		}

		return false;
	}

	public boolean solucion(int[] sumaFila, int[] sumaCol, int s) {
		boolean esSol=true;
		for (int i = 0; i < sumaCol.length; i++) {
			if(sumaCol[i] != s && sumaFila[i] != s) {
				return false;
			}
		}
		return esSol;
	}

	public static void main(String args[]) {

	}

}
