package tpe1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Simulador {

	public static ArrayList<Libro> reader (){
		ArrayList<Libro> libros = new ArrayList<Libro>();
		String csvFile = "dataset3.csv";
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] items = line.split(cvsSplitBy);
				Libro l = new Libro(items[0],items[1],Integer.parseInt(items[2]));
				String[] generos = items[3].split(" ");
				for (int i = 0; i < generos.length; i++) {
					if(generos[i] != null) {						
						l.addGenero(generos[i]);
					}
				}
				libros.add(l);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return libros;
	}

	public static void main(String[] args) throws FileNotFoundException {
		long startTime;
		long totalTime;
		ArrayList<Libro> libros = reader();
		IndiceGenero ig = new IndiceGenero(libros);
		ArrayList<Libro> librosGenero = new ArrayList<Libro>();
		
//		System.out.println("Lista de libros:");
//		System.out.println(libros.toString());
//
//		System.out.println("Lista de generos:");
//		System.out.println(ig.getGeneros());
		
		//BUSQUEDA LINEAL
//		startTime = System.nanoTime();
//		librosGenero = ig.buscarLibros("viajes");
//		totalTime = System.nanoTime() - startTime;
//		System.out.println("busqueda lineal:");
//		System.out.println("Comparaciones: "+ig.comparacionesLineales);
//		System.out.println("tiempo total de busqueda:");
//		System.out.println(totalTime);
//		System.out.println();
		
		//BUSQUEDA BINARIA
		startTime = System.nanoTime();
		librosGenero = ig.busquedaBinariaLibro("viajes");
		totalTime = System.nanoTime() - startTime;
		System.out.println("busqueda binaria");
		System.out.println("Comparaciones: "+ig.comparacionesBinarias);
		System.out.println("tiempo total de busqueda:");
		System.out.println(totalTime);
		System.out.println();
		
		//Creacion de csv
		PrintWriter pw = new PrintWriter(new File("test.csv"));
		StringBuilder sb = new StringBuilder();
		sb.append("Titulo");
		sb.append('\n');
		for (Libro libro : librosGenero) {
			sb.append(libro.getTitulo());
			sb.append('\n');
		}
		pw.write(sb.toString());
		pw.close();
		
		
		
	}

}
