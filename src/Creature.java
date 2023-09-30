
public abstract class Creature {

    private int attack;
    private double health;
    private int defence;
    private String name;
    int[] damage = new int[2];

    Creature(){
        this.name = setName();
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
        do{
            System.out.println("Choose "+name+"'s attack value:");
            this.attack = Engine.correctInput();
        }while(getAttack() <1 || getAttack()>30);
    }
    public void setDefence(){
        do{
            System.out.println("Choose "+name+"'s defence value:");
            this.defence = Engine.correctInput();
        }while(getDefence() <1 || getDefence()>30);
    }
    public void setHealth(){
        do{
            System.out.println("Choose "+name+"'s health value:");
            this.health = Engine.correctInput();
        }while(getHealth() <0 || getHealth()>Engine.maxHealthValue);
    }
    public void setDamage(){
        do{
            System.out.println("Choose "+name+"'s lower damage value:");
            this.damage[0] = Engine.correctInput();

        }while(getDamage()[0]<0 );
        do{
            System.out.println("Choose "+name+"'s upper damage value:");
            this.damage[1] = Engine.correctInput();
        }while(getDamage()[1]<=getDamage()[0]);
    }






}
