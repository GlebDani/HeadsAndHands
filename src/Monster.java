public class Monster extends Creature{


    public void setName(){
        System.out.println("Type the Monster's name");
        String name = scanner.nextLine();
        super.setName(name);

    }
}
