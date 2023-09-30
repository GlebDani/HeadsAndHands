import java.util.*;

public class Engine {

    Random random = new Random();
    static int maxHealthValue = -1;
    static List<Creature> listOfMonsters = new ArrayList<>();
    static Player player;

    Engine(int numOfMonsters){
        for (int i =1; i<=numOfMonsters;i++){
            listOfMonsters.add(new Monster());
        }
        player = new Player();
    }

    public void CreatureAttack(Creature creature1, Creature creature2){
        int attackModifier;
        System.out.println("You are attacking "+ creature2.getName());
        if((attackModifier = creature1.getAttack() - creature2.getDefence() + 1) > 0){
            Damage(creature1, creature2, attackModifier);
        }
        else
            System.out.println("Sorry, you are too weak to attack. Work out!");

    }

    public void Damage(Creature creature1,  Creature creature2, int attackModifier){
        System.out.println("You have "+attackModifier+" dice");
        for(int i = 1; i<= attackModifier; i++){
            int diceRollingResult = random.nextInt(5)+1;
            System.out.println("Dice #"+i+": "+diceRollingResult);
            if (diceRollingResult >=5) {
                System.out.println("You are succeed");
                creature2.changeHealth(random.nextInt(creature1.getDamage()[0]+1)+creature1.getDamage()[1]-creature1.getDamage()[0], false);
                System.out.println(creature2.getName()+" has "+creature2.getHealth()+" value of health");
                if (!creature2.checkHealth())
                    listOfMonsters.remove(creature2);
                break;
            }
        }

    }




}
