package tpe1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IndiceGenero {
	
	List<Genero> generos = new ArrayList<Genero>();

	public IndiceGenero(List<Genero> generos) {
		this.generos = generos;
	}
	
	public ArrayList<Libro> buscarLibros(String genero) {
		ArrayList<Libro> retorno = new ArrayList<Libro>();
		Iterator<Genero> it = generos.iterator();
		while (it.hasNext()) {
			Genero actual = it.next();
			if(actual.getNombre().equals(genero)){
				return actual.getLibros();
			}
		}
		
		return retorno;
	}
	
}



final class Genero {
	String nombre;
	ArrayList<Libro> libros = new ArrayList<Libro>();

	public Genero(String nombre, ArrayList<Libro> libros) {
		this.nombre = nombre;
		this.libros = libros;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	
}
