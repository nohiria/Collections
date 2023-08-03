/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nohyv
 */
public class ServicioAlumno {
    private final ArrayList<Alumno> listaDeAlumnos;
    private final Scanner input;

    public ServicioAlumno() {
        listaDeAlumnos= new ArrayList<>();
        input= new Scanner(System.in);
    }
   
    //Método para crear alumno
    public Alumno crearALumno(){
        Alumno alumno= new Alumno();
        ArrayList<Integer> notas= new ArrayList<>();
        
        System.out.println("Ingresa el nombre del alumno");
        alumno.setNombre(input.nextLine());
        System.out.println("Ingresa la primera nota");
        notas.add(Integer.parseInt(input.nextLine()));
        System.out.println("Ingresa la segunda nota");
        notas.add(Integer.parseInt(input.nextLine()));
        System.out.println("Ingresa la tercera nota");
        notas.add(Integer.parseInt(input.nextLine()));
        alumno.setNotas(notas);
        
        return alumno;
    }
    
    //Añadir alumno a la lista
    public void agregarAlumno(Alumno alumno){
        listaDeAlumnos.add(alumno);
    }
    
    //Bucle para agregar alumnos
    public void crearListaAlumnos(){
        System.out.println("¿Desea agregar un alumno a la lista de alumnos?");
        String respuesta= input.nextLine();
        while(respuesta.equalsIgnoreCase("y")){
            agregarAlumno(crearALumno());
            System.out.println("¿Desea agregar otro alumno a la lista?");
            respuesta= input.nextLine();
        }
    }
    
    public void notaFinal(){
        System.out.println("Ingrese el nombre del alumno a buscar");
        String alumnoIngresado= input.nextLine();
        Alumno alumno= buscarAlumno(alumnoIngresado);
        if(alumno!=null){
            calcularNota(alumno);
        }else{
            System.out.println("Alumno no encontrado");
        }
    }
    
    public Alumno buscarAlumno(String alumnoIngresado){
        for(Alumno alumno: listaDeAlumnos){
            if(alumnoIngresado.equalsIgnoreCase(alumno.getNombre())){
                return alumno;
            }
        }
        return null;
    }
    
    public void calcularNota(Alumno alumno){
        int suma= 0;
        int cantidadDeNotas= alumno.getNotas().size();
        double promedioFinal;
        suma = alumno.getNotas().stream().map((nota) -> nota).reduce(suma, Integer::sum);
        
        promedioFinal= (double)suma/cantidadDeNotas;
        
        System.out.println("La nota final de"+alumno.getNombre()+"es: "+promedioFinal);
    }
}
