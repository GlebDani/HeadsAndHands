
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Hi. Welcome to our battle royal game.\nYou have to create Magic Creatures: your avatar and your rivals, i.e Monsters.\n" +
               "All Creatures have Health, Defence, Attack and Damage value. First of all, set the maximum health value and the number of monsters." );
        int numOfMonsters=-1;
        do{
            System.out.println("Enter the maximum health value:");
            try{
                Engine.maxHealthValue = scanner.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Try again");
                scanner.nextLine();
            }
        }while((Engine.maxHealthValue<0));
        do{
            System.out.println("How many monsters would you like to create?");
            try{
                numOfMonsters = scanner.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Try again");
                scanner.nextLine();
            }

        }while((numOfMonsters<0));



        Engine en = new Engine(numOfMonsters);
        scanner.nextLine();
        String quit="";
        while (!quit.equalsIgnoreCase("Q")) {
            System.out.println("If you would  like to attack anybody, type Y\nIf you would kile to heal yourself, type H\n" +
                    "If you would like to quit, type Q");
            quit = scanner.nextLine().toLowerCase();
            switch (quit) {
                case "y" -> {
                    if (Engine.listOfMonsters.size() == 0)
                        System.out.println("There is no monsters left");
                    else
                        en.CreatureAttack(Engine.player, Engine.listOfMonsters.get(random.nextInt(Engine.listOfMonsters.size())));
                }
                case "h" -> Engine.player.Heal();
                case "q" -> System.out.println("You are quiting");
                default -> System.out.println("Choose something");
            }




        }
    }
}