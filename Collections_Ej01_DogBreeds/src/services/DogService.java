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
    
    public Dog createDog(String breed) {
        if (dogsList.stream().anyMatch(d -> d.getBreed().equalsIgnoreCase(breed))) {
            System.out.println(breed + " is already in the list");
            return null;
        } else {
            System.out.println("Adding " + breed + " to the list");
            Dog d = new Dog(breed);
            return d;
        }
    }
    
    public void addDog(Dog dog){
        dogsList.add(dog);
    }
    
    public void showDogsList(){
        dogsList.forEach((dog) -> {
            System.out.println(dog.getBreed());
        });
    }
    
    public int showIndexDogList(){
        for(int i=0; i<dogsList.size(); i++){
            Dog dog= dogsList.get(i);
            System.out.println((i+1)+". "+dog.getBreed());
        }
        
        return dogsList.size();
    }
    
    public void readDogBreeds(){
        Scanner input= new Scanner(System.in);
        String choice;
        
        do{
            System.out.println("Enter the breed of the dog:");
            String breed= input.nextLine();
            Dog addedDog= createDog(breed);
            addDog(addedDog);
            
            if(addedDog!=null){
                System.out.println("Successfully added: " + addedDog.getBreed());
            }
            
            System.out.print("Do you want to add another dog? (y/n): ");
            choice = input.nextLine();
        }while(choice.equalsIgnoreCase("y"));
    }
    
    public void updateDogBreed(int index, String breed){
        Dog dog= createDog(breed);
        
        dogsList.set(index, dog);
    }
}
