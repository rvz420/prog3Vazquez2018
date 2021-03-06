package tpe1;

import java.util.ArrayList;
import java.util.Iterator;

final class Genero implements Comparable<Genero>{
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

	public void addLibro(Libro l) {
		this.libros.add(l);
	}

	@Override
	public int compareTo(Genero o) {
		return this.nombre.compareTo(o.getNombre());
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public String getNombre() {
		return nombre;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Genero [nombre=" + nombre + "]";
	}


}

// CLASE GENERO

public class IndiceGenero {

	ArrayList<Genero> generos; 
	public int comparacionesLineales = 0;
	public int comparacionesBinarias = 0;
	public IndiceGenero(ArrayList<Libro> libros) {
		this.generos = new ArrayList<Genero>();
		for (Libro libro : libros) {
			ArrayList<String> generosLibro = libro.getGeneros();
			for (String generoLibro : generosLibro) {
				if (!contiene(generoLibro)) {
					Genero g = new Genero(generoLibro);
					g.addLibro(libro);
					insertarGeneroOrdenado(g);//aca va  add para comparar
					//generos.add(g);
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
			comparacionesLineales++;
			Genero actual = it.next();
			if(actual.getNombre().equals(genero)){
				return actual.getLibros();
			}
		}
		return retorno;
	}

	public ArrayList<Libro> busquedaBinariaLibro(String genero) {
		return busquedaBinariaLibro(genero, 0, this.generos.size()-1);
	}

	private ArrayList<Libro> busquedaBinariaLibro(String genero, int min, int max) {
		comparacionesBinarias++;
		ArrayList<Libro> retorno;
		int medio = (max+min)/2;

		if (max < min) {
			return new ArrayList<Libro>();
		}

		if (generos.get(medio).getNombre().compareTo(genero) == 0) {
			retorno = generos.get(medio).getLibros();
		} else if (generos.get(medio).getNombre().compareTo(genero) < 0) {
			min = medio + 1;
			retorno = busquedaBinariaLibro(genero, min, max);
		} else {
			max = medio - 1;
			retorno = busquedaBinariaLibro(genero, min, max);
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

	public void insertarGeneroOrdenado(Genero g) {
		Iterator<Genero> it = generos.iterator();
		if (!this.generos.isEmpty()) {
			int i = 0;
			while(it.hasNext()) {
				if (g.compareTo(it.next())<0) {
					generos.add(i, g);
					return;
				}else {
					i++;
				}
			}
		}
		this.generos.add(g);
	}



	public void setGeneros(ArrayList<Genero> generos) {
		this.generos = generos;
	}



}
