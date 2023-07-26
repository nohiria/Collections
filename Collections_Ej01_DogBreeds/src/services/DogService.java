/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Dog;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nohyv
 */
public class DogService {
    private final ArrayList<Dog> dogsList;
    
    public DogService(){
        dogsList= new ArrayList<>();
    }
    
    public Dog addDog(String breed){
        System.out.println("Adding "+breed+" to the list");
        Dog d= new Dog(breed);
        dogsList.add(d);
        return d;
    }
    
    public void showDogsList(){
        dogsList.forEach((dog) -> {
            System.out.println(dog.getBreed());
        });
    }
    
    public void readDogBreeds(){
        Scanner input= new Scanner(System.in);
        String choice;
        
        do{
            System.out.println("Enter the breed of the dog:");
            String breed= input.nextLine();
            addDog(breed);
            
            System.out.print("Do you want to add another dog? (y/n): ");
            choice = input.nextLine();
        }while(choice.equalsIgnoreCase("y"));
    }
}
