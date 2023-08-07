/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Pelicula;
import Utilidades.Comparators;
import java.util.ArrayList;
import java.util.Collections;
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
    
    //Métodos crear objeto/añadir a la lista
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
                }else if(listaPeliculas.isEmpty()){
                    System.out.println("La lista debe tener al menos una película para continuar");
                }
            }while(respuesta.equalsIgnoreCase("y"));
        }

    //Métodos para mostrar películas
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
    
    //Métodos para ordenar lista
        public void ordenarPeliculasSegunHoraAsc(){
            Collections.sort(listaPeliculas, Comparators.ordenarDuracionDeMenorAMayor);
        }

        public void ordenarPeliculasSegunHoradDesc(){
            Collections.sort(listaPeliculas, Comparators.ordenarDuracionDeMayorAMenor);
        }

        public void ordenarPeliculasSegunTituloAlf(){
            Collections.sort(listaPeliculas, Comparators.ordenarTituloAlfabeticamente);
        }

        public void ordenarPeliculasSegunTituloAlfRev(){
            Collections.sort(listaPeliculas, Comparators.ordenarTituloAlfabeticamenteRev);
        }
        
    //Menú de opciones
        public void menuPeliculas(){
            String respuesta="";
            
            do{
                System.out.println("MENÚ");
                System.out.println("1. Añadir películas");
                System.out.println("2. Mostrar todas las películas en la lista");
                System.out.println("3. Mostrar películas con más de 1h");
                System.out.println("4. Ordenar Peliculas según Hora de menor a mayor");
                System.out.println("5. Ordenar Peliculas según Hora de mayor a menor");
                System.out.println("6. Ordenar Peliculas según Titulo de menor a mayor");
                System.out.println("7. Ordenar Peliculas según Titulo de mayor a menor");
                System.out.println("Sellecione una opción");
                int opcion= Integer.parseInt(input.nextLine());
                while(opcion<1||opcion>7){
                    System.out.println("Ingrese un número válido");
                    opcion= Integer.parseInt(input.nextLine());
                }
            }while(!respuesta.equalsIgnoreCase("y"));
        }
}
