package tpe1;

import java.util.ArrayList;

public class Libro {
	String titulo;
	String autor;
	ArrayList<String> generos;
	int cantPaginas;
	
	public Libro(String titulo, String autor, int cantPaginas) {
		this.titulo = titulo;
		this.autor = autor;
		this.cantPaginas = cantPaginas;
		this.generos = new ArrayList<String>();
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}

	public ArrayList<String> getGeneros() {
		return generos;
	}


	public void setGeneros(ArrayList<String> genero) {
		this.generos = genero;
	}


	public int getCantPaginas() {
		return cantPaginas;
	}


	public void setCantPaginas(int cantPaginas) {
		this.cantPaginas = cantPaginas;
	}
	
	public void addGenero(String genero) {
		generos.add(genero);
	}
	
}
