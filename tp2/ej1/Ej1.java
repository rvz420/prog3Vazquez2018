package ej1;

public class Ej1 {
	
	public static boolean arreglOrdenado(int[] arr, int i) {
		
		if (i >= arr.length-1) {
			return true;
		}else {
			if (arr[i]<arr[i+1]) {
				return arreglOrdenado(arr, i+1);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		//arr[3] = 99;
		System.out.println("arreglo ordenado?: "+arreglOrdenado(arr, 0));
	}

}
