package tpe1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IndiceGenero {
	
	ArrayList<Genero> generos; 

	public IndiceGenero(ArrayList<Libro> libros) {
		this.generos = new ArrayList<Genero>();
		for (Libro libro : libros) {
			ArrayList<String> generosLibro = libro.getGeneros();
			for (String generoLibro : generosLibro) {
				if (!contiene(generoLibro)) {
					Genero g = new Genero(generoLibro);
					g.addLibro(libro);
					this.generos.add(g);
				}else {
					Iterator<Genero> it = this.generos.iterator();
					while (it.hasNext()) {
						Genero generoi = it.next();
						if (generoi.getNombre().equals(generoLibro)) {
							generoi.addLibro(libro);
						}
					}
				}
			}
		}
		
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
	
	public boolean contiene (String _genero) {
		for (Genero genero : generos) {
			if(genero.getNombre().equals(_genero)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(ArrayList<Genero> generos) {
		this.generos = generos;
	}
	
	
	
}



final class Genero {
	String nombre;
	ArrayList<Libro> libros;

	public Genero(String nombre) {
		this.nombre = nombre;
		this.libros= new ArrayList<Libro>();
	}
	
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
	
	public void addLibro(Libro l) {
		this.libros.add(l);
	}
	
}
