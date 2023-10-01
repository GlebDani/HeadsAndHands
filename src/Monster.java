public class Monster extends Creature{

    static int counter = 1;

    Monster(){
        counter++;
    }

    public String setName(){
        System.out.println("Type the Monster's name");
        Engine.scanner.nextLine(); // skip /n after nextInt
        String name =  Engine.scanner.nextLine();
        name = (name.isBlank())? "Monster"+counter: name; //default name
        return name;

    }
}
