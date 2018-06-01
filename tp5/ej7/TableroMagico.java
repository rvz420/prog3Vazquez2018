package ej7;

import java.util.ArrayList;

public class TableroMagico {

	public ArrayList<int[][]> resolverTablero(int n, int k, int s) {	//n = tablero de n*n - k>n*n
		ArrayList<int[][]> retorno = new ArrayList<int[][]>();
		if (k>n*n) {
			int[][] matrizSolucion = new int[n][n];
			int[] sumaFila = new int[n];
			int[] sumaCol = new int[n];
			boolean[] opcUsadas = new boolean[k+1]; // k+1 por que la opciones van de 1 a k

			resolverTableroBack(n, k, s, 0, matrizSolucion, sumaFila, sumaCol, opcUsadas, retorno);
			if (!retorno.isEmpty()) {
				return retorno;
			} 
		}
		return null;
	}

	public void resolverTableroBack(int n, int k, int s, int paso, int[][] matriz, int[] sumaFila, int[] sumaCol, boolean[] opcUsadas, ArrayList<int[][]> retorno) {

		if(paso == n*n) {
			if (esSolucion(matriz, sumaFila, sumaCol, n, s)) {
				retorno.add(matriz);
				imprimirMatriz(matriz);
			}		
		}else {
			for (int val = 1; val <= opcUsadas.length-1; val++) {
				if (opcUsadas[val]) {
					continue; 
				}
				opcUsadas[val] = true;
				matriz[paso/n][paso%n] = val;
				sumaFila[paso/n] += val;
				sumaCol[paso%n] += val;
		
				resolverTableroBack(n, k, s, paso+1, matriz, sumaFila, sumaCol, opcUsadas, retorno); 


				matriz[paso/n][paso%n] = 0;
				sumaFila[paso/n] -= val;
				sumaCol[paso%n] -= val;
				opcUsadas[val] = false;

			}
		}
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
		System.out.println();
	}

	public static void main(String args[]) {
		ArrayList<int[][]> sol = new ArrayList<int[][]>();
		TableroMagico t = new TableroMagico();
		sol.addAll(t.resolverTablero(3,10,15));
	}

}
