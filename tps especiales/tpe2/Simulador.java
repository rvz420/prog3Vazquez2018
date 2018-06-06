package tpe2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Simulador {
	
	final static String CSVPATH = "datasets-2da etapa/dataset1.csv";
	
	public static void reader (Grafo g){
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(CSVPATH))) {
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
		long startTime;
		long totalTime;
		ArrayList<String> consignaUnoResultado;
		ArrayList<Nodo> consignaDosResultado;
		String generoABuscar = "viajes";
		Grafo grafo = new Grafo();
		
		reader(grafo);
		System.out.println(grafo.toString());
		System.out.println();
		System.out.println("Obtener los N géneros más buscados luego de buscar por el género "+generoABuscar);
		System.out.println();
		
		startTime = System.nanoTime();
		consignaUnoResultado = grafo.getNmasBuscadosDe(2, generoABuscar);
		totalTime = System.nanoTime() - startTime;
		System.out.println("Se tardo "+totalTime+" nanosegundos para obtener:");
		System.out.println(consignaUnoResultado);
		
		System.out.println();
		System.out.println("Obtener todos los géneros que fueron buscados luego de buscar por el género "+generoABuscar);
		
		startTime = System.nanoTime();
		consignaDosResultado = grafo.getGenerosLuegoDeBuscar(generoABuscar);
		totalTime = System.nanoTime() - startTime;
		System.out.println("Se tardo "+totalTime+" nanosegundos para obtener:");
		System.out.println(consignaDosResultado);
		
		System.out.println();
		System.out.println("Afines de "+generoABuscar);
		System.out.println(grafo.generosAfines(generoABuscar));
		System.out.println();
		
	}

}
