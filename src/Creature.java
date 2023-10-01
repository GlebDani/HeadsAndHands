import java.util.*;

public abstract class Creature {

    private int attack;
    private int health;
    private int defence;
    private String name;
    int[] damage = new int[2];

    private Map<String, int[]> param = Map.of("attack",new int[]{0, 1, 30},  "defence", new int[]{0, 1, 30}, "health",  new int[]{0, 1, Engine.maxHealthValue},"lower damage bound",new int[]{0, 1, Integer.MAX_VALUE}, "upper damage bound",new int[]{0,0,Integer.MAX_VALUE});

    Creature(){
        this.name = setName();
        setParam(param);
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

    public void changeHealth(int healthValue, boolean action){
        if(action) // add health value
            health = Math.min(health + healthValue, Engine.maxHealthValue);

        else // remove health value
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


    public void setParam(Map<String, int[]> param){
        param = new TreeMap<>(param);
        for(Map.Entry<String, int[]> e: param.entrySet()){
            String key = e.getKey();
            int [] values = e.getValue();
            if (key.equals("upper damage bound")) values[1] = param.get("lower damage bound")[0]+1;

            do{
                System.out.println("Choose "+name+"'s "+key+" value within ["+values[1]+","+((values[2]==Integer.MAX_VALUE)?"N":values[2])+"]:");
                values[0] = Engine.correctInput();
            }while(values[0] <values[1] || values[0]>values[2]);

        }
        attack = param.get("attack")[0];
        defence = param.get("defence")[0];
        health = param.get("health")[0];
        damage[0] = param.get("lower damage bound")[0];
        damage[1] = param.get("upper damage bound")[0];

    }


}
