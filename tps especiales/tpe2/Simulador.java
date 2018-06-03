package tpe2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import tpe1.Libro;

public class Simulador {

	public static void reader (Grafo g){
		String csvFile = "datasets-2da etapa/dataset1.csv";
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] generos = line.split(cvsSplitBy);
				g.addVertice(generos[0]);
				for (int i = 1; i < generos.length; i++) {
					g.addVertice(generos[i]);
					g.insertarArista(generos[i-1], generos[i]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		reader(grafo);
		System.out.println(grafo.toString());

	}

}
