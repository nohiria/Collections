/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Entidad.Pelicula;
import java.util.Comparator;

/**
 *
 * @author nohyv
 */
public class Comparators {
    
    //Según duración
        public static Comparator<Pelicula> ordenarDuracionDeMenorAMayor= new Comparator<Pelicula>() {
            @Override
            public int compare(Pelicula o1, Pelicula o2) {
                return o1.getHorasDuracion().compareTo(o2.getHorasDuracion());
            }
        };

        public static Comparator<Pelicula> ordenarDuracionDeMayorAMenor= new Comparator<Pelicula>() {
            @Override
            public int compare(Pelicula o1, Pelicula o2) {
                return o2.getHorasDuracion().compareTo(o1.getHorasDuracion());
            }
        };
    
    
    //Según título
        public static Comparator<Pelicula> ordenarTituloAlfabeticamente= new Comparator<Pelicula>() {
            @Override
            public int compare(Pelicula o1, Pelicula o2) {
                return o1.getTitulo().compareTo(o2.getTitulo());
            }
        };
        
        public static Comparator<Pelicula> ordenarTituloAlfabeticamenteRev= new Comparator<Pelicula>() {
            @Override
            public int compare(Pelicula o1, Pelicula o2) {
                return o2.getTitulo().compareTo(o1.getTitulo());
            }
        };
}
