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
    
    public Dog addDog(String breed) {
        if (dogsList.stream().anyMatch(d -> d.getBreed().equalsIgnoreCase(breed))) {
            System.out.println(breed + " is already in the list");
            return null;
        } else {
            System.out.println("Adding " + breed + " to the list");
            Dog d = new Dog(breed);
            dogsList.add(d);
            return d;
        }
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
            Dog addedDog= addDog(breed);
            
            if(addedDog!=null){
                System.out.println("Successfully added: " + addedDog.getBreed());
            }
            
            System.out.print("Do you want to add another dog? (y/n): ");
            choice = input.nextLine();
        }while(choice.equalsIgnoreCase("y"));
    }
    
    public void updateDogBreed(String oldBreed, String newBreed){
        Dog dogToUpdate = dogsList.stream()
            .filter(d -> d.getBreed().equalsIgnoreCase(oldBreed))
            .findFirst()
            .orElse(null);

        if (dogToUpdate != null) {
            System.out.println("Updating " + oldBreed + " to " + newBreed);
            dogToUpdate.setBreed(newBreed);
        } else {
            System.out.println(oldBreed + " not found in the list");
        }
    }
}
