import java.util.*;
import java.util.stream.Collectors;

public abstract class Creature {

    private int attack;
    private double health;
    private int defence;
    private String name;
    int[] damage = new int[2];

    private Map<String, int[]> param = Map.of("attack",new int[]{0, 1, 30},  "defence", new int[]{0, 1, 30}, "health",  new int[]{0, 1, Engine.maxHealthValue},"lower damage bound",new int[]{0, 0, Integer.MAX_VALUE}, "upper damage bound",new int[]{0,0,Integer.MAX_VALUE});

    Creature(){
        this.name = setName();
        setParam(param);
        setAttack();
        setDefence();
        setHealth();
        setDamage();
    }

    public int getAttack(){
        return attack;
    }
    public int getDefence(){
        return defence;
    }
    public int[] getDamage(){
        return damage;
    }
    public double getHealth(){
        return health;
    }
    public String getName(){
        return name;
    }

    public void changeHealth(double healthValue, boolean action){
        if(action)
            health = ( health + healthValue>Engine.maxHealthValue) ? Engine.maxHealthValue :health + healthValue;

        else
            health -= healthValue;
    }

    public boolean checkHealth(){
        if(health<=0) {
            System.out.println("The creature " + name + " is dead.");
            return false;
        }
        else
            return true;
    }

    abstract public String setName();

    public void setAttack(){
        this.attack = param.get("attack")[0];
    }
    public void setDefence(){
        this.defence = param.get("defence")[0];
    }
    public void setHealth(){
        this.health = param.get("health")[0];
    }
    public void setDamage(){
        this.damage[0] = param.get("lower damage bound")[0];
        this.damage[1] = param.get("upper damage bound")[0];
    }

    public void setParam(Map<String, int[]> param){
       Map.Entry.comparingByValue();
//        Map.Entry.comparingByKey();
        for(Map.Entry<String, int[]> e: param.entrySet()){
            String key = e.getKey();
            int [] values = e.getValue();
            if (key.equals("upper damage bound")) values[1] = param.get("lower damage bound")[0];

            do{
                System.out.println("Choose "+name+"'s "+key+" value:");
                values[0] = Engine.correctInput();
            }while(values[0] <values[1] || values[0]>values[2]);

        }

    }

}
