package ej7;

public class TableroMagico {

	public int[][] resolverTablero(int n, int k, int s) {	//n = tablero de n*n - k>n*n
		if (k>n*n) {
			int[][] matrizSolucion = new int[n][n];
			int[] sumaFila = new int[n];
			int[] sumaCol = new int[n];
			boolean[] opcUsadas = new boolean[k+1]; // k+1 por que la opciones van de 1 a k



			boolean hasSolution = resolverTableroBack(n, k, s, 0, matrizSolucion, sumaFila, sumaCol, opcUsadas);
			if (hasSolution) {
				return matrizSolucion;
			} 
		}
		return new int[0][0];
	}

	public boolean resolverTableroBack(int n, int k, int s, int paso, int[][] matriz, int[] sumaFila, int[] sumaCol, boolean[] opcUsadas) {

		if(paso == n*n ) {
			return(esSolucion(matriz,sumaFila,sumaCol,n,s));
		}else {

			for (int val = 1; val <= opcUsadas.length-1; val++) {
				if (opcUsadas[val]) {
					continue; 
				}
				opcUsadas[val] = true;
				matriz[paso/n][paso%n] = val;
				sumaFila[paso/n] += val;
				sumaCol[paso%n] += val;
				if (resolverTableroBack(n, k, s, paso+1, matriz, sumaFila, sumaCol, opcUsadas)) {
					return true;
				}
				matriz[paso/n][paso%n] = 0;
				sumaFila[paso/n] -= val;
				sumaCol[paso%n] -= val;
				opcUsadas[val] = false;

			}
		}
		return false;
	}

	public boolean esSolucion(int[][] matriz, int[] sumaFila, int[] sumaCol, int n, int s) {

		for (int i = 0; i < sumaCol.length; i++) {
			if (sumaCol[i]!=s) {
				return false;
			}
		}

		for (int i = 0; i < sumaFila.length; i++) {
			if (sumaFila[i]!=s) {
				return false;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(matriz[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}

	public void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz[0].length; i++) {
			for (int j = 0; j < matriz[1].length; j++) {
				System.out.print("["+matriz[i][j]+"]");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		TableroMagico t = new TableroMagico();
		int[][] matriz = t.resolverTablero(3,12,18);
		if(matriz.length>0) {
			t.imprimirMatriz(matriz);
		}else {
			System.out.println("Sin solucion");
		}
	}

}
