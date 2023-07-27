/*
Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El
programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide
salir, se mostrará todos los perros guardados en el ArrayList.
 */
package collections_ej01_dogbreeds;

import java.util.Scanner;
import services.DogService;

/**
 *
 * @author nohyv
 */
public class Collections_Ej01_DogBreeds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        DogService ds= new DogService();
        String choice;
        do{
            System.out.println("Menu");
            System.out.println("1. Add breeds");
            System.out.println("2. Show list");
            System.out.println("3. Update breed");
            System.out.println("Choice an option");
            int option = Integer.parseInt(input.nextLine());
            while (option < 1 || option > 3) {
                System.out.println("Enter a valid option");
                option = Integer.parseInt(input.nextLine());
            }
            switch (option) {
                case 1:
                    ds.readDogBreeds();
                    break;
                case 2:
                    ds.showDogsList();
                    break;
                case 3:
                    int listSize= ds.showIndexDogList();
                    System.out.println("Choose the item to update");
                    int item= Integer.parseInt(input.nextLine());
                    while(item>listSize){
                        System.out.println("Enter a valid number");
                        item= Integer.parseInt(input.nextLine());
                    }
                    System.out.println("Enter the new breed");
                    String newBreed= input.nextLine();
                    ds.updateDogBreed((item-1), newBreed);
                    break;
            }
            
            System.out.print("Do you want to go back to the menu? y/n:");
            choice= input.nextLine();
            if(!choice.equalsIgnoreCase("y")){
                System.out.println("Run finished");
            }
        }while(choice.equalsIgnoreCase("y"));
        
    }
    
}
