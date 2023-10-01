public class Player extends Creature{
    int numOfHeals = 4;

    public void Heal(){
        if (numOfHeals > 0){
            changeHealth( (int) (0.3 * Engine.maxHealthValue), true);
            numOfHeals--;
            System.out.println(getHealth());
        }
        else
            System.out.println("Ops, you don't have any heals :(( ");
    }

    public String setName() {
        System.out.println("Type your Avatar's name");
        Engine.scanner.nextLine(); // skip /n after nextInt
        String name = Engine.scanner.nextLine();
        name = (name.isBlank())? "Player": name;//default name
        return name;
    }
}
