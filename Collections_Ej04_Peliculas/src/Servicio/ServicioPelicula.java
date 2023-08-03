/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Pelicula;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nohyv
 */
public class ServicioPelicula {
    private final Scanner input;
    private final ArrayList<Pelicula> listaPeliculas;

    public ServicioPelicula() {
        this.input= new Scanner(System.in);
        this.listaPeliculas= new ArrayList<>();
    }    
    
    public Pelicula crearPelicula(){
        Pelicula pelicula= new Pelicula();
        System.out.println("Ingrese el título de la película");
        pelicula.setTitulo(input.nextLine());
        System.out.println("Ingrese el nombre del director");
        pelicula.setDirector(input.nextLine());
        System.out.println("Ingrese la duración en horas");
        pelicula.setHorasDuracion(Double.parseDouble(input.nextLine()));
        return pelicula;
    } 
    
    public void agregarPeliculaLista(Pelicula pelicula){
        listaPeliculas.add(pelicula);
    }
    
    public void crearListaPeliculas(){
        String respuesta;
        do{
            System.out.print("¿Desea añadir una película a la lista? s/n");
            respuesta= input.nextLine();
            if(respuesta.equalsIgnoreCase("s")){
                agregarPeliculaLista(crearPelicula());
            }
        }while(respuesta.equalsIgnoreCase("y"));
    }
    
    public void mostrarTodasLasPeliculas(){
        listaPeliculas.forEach((pelicula) -> {
            System.out.println(pelicula.toString());
        });
    }
    
    public void mostrarPeliculasMayorAHora(){
        listaPeliculas.stream().filter((pelicula) -> (pelicula.getHorasDuracion()>1)).forEachOrdered((pelicula) -> {
            System.out.println(pelicula.toString());
        });
    }
}
