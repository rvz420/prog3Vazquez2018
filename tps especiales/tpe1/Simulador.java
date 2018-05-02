package tpe1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Simulador {
	
	public static ArrayList<Libro> reader (){
		ArrayList<Libro> libros = new ArrayList<Libro>();
		String csvFile = "dataset1.csv";
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
	
	public static void main(String[] args) {
		ArrayList<Libro> libros = reader();
		System.out.println(libros.toString());
		
		IndiceGenero ig = new IndiceGenero(libros);
		System.out.println(ig.getGeneros());
		
		ArrayList<Libro> librosGenero = ig.buscarLibros("infantil");
		System.out.println(librosGenero);
		
	}

}
