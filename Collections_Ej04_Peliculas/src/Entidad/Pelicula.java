/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author nohyv
 */
public class Pelicula {
    private String titulo;
    private String director;
    private Double horasDuracion;
    
    //Constructors
    public Pelicula() {
    }

    public Pelicula(String titulo, String director, double horasDuracion) {
        this.titulo = titulo;
        this.director = director;
        this.horasDuracion = horasDuracion;
    }
    
    //Getters&Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Double getHorasDuracion() {
        return horasDuracion;
    }

    public void setHorasDuracion(Double horasDuracion) {
        this.horasDuracion = horasDuracion;
    }
    
    //toString

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", director=" + director + ", horasDuracion=" + horasDuracion + '}';
    }
    
    
    
}
