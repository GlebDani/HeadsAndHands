public class Player extends Creature{

    int numOfHeals = 4;

    public void Heal(){
        if (numOfHeals > 0){
            changeHealth( 0.3 * Engine.maxHealthValue, true);
            numOfHeals--;
            System.out.println(getHealth());
        }
        else
            System.out.println("Ops, you don't have any heals :(( ");
    }



    public void setName() {
        System.out.println("Type your Avatar's name");
        String name = scanner.nextLine();
        super.setName(name);
    }
}
