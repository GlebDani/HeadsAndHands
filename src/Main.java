import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("Hi. Welcome to our battle royal game.\nYou have to create Magic Creatures: your avatar and your rivals, i.e Monsters.\n" +
               "All Creatures have Health, Defence, Attack and Damage value. First of all, set the maximum health value and the number of monsters." );
        int numOfMonsters;
        do{
            System.out.println("Enter the maximum health value:");
            Engine.maxHealthValue = Engine.correctInput();
        }while((Engine.maxHealthValue<0));
        do{
            System.out.println("How many monsters would you like to create?");
            numOfMonsters = Engine.correctInput();
        }while((numOfMonsters<0));


        Engine en = new Engine(numOfMonsters);

        String quit="";
        Engine.scanner.nextLine(); // skip \n after nextInt
        while (!quit.equalsIgnoreCase("Q")) {
            System.out.println("Type a - to attack, type h- to heal yourself, type q - to quit.");
            quit = Engine.scanner.nextLine().toLowerCase();
            switch (quit) {
                case "a" -> {
                    if (Engine.listOfMonsters.size() == 0)
                        System.out.println("There is no monsters left");
                    else
                        en.CreatureAttack(Engine.player, Engine.listOfMonsters.get(random.nextInt(Engine.listOfMonsters.size())));
                }
                case "h" -> Engine.player.Heal();
                case "q" -> System.out.println("You are quiting\nThanks for the game!");
                default -> System.out.println("Choose something");
            }
        }
    }
}