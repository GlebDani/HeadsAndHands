import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Creature {

    private int attack;
    private double health;
    private int defence;
    private String name;

    int[] damage = new int[2];



    Scanner scanner = new Scanner(System.in);

    Creature(){
        setName();
        setAttack();
        setDefence();
        setHealth();
        setDamage();
    }


    public boolean checkHealth(){
        if(health<=0) {
            System.out.println("The creature " + name + " is dead.");
            return false;
        }
        else
            return true;
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

    public void setName(String name){
        this.name = name;
    };

    public void setAttack(){
        do{
            System.out.println("Choose "+name+"'s attack value:");
            try{
                attack = scanner.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Try again");
                scanner.nextLine();
            }
        }while(getAttack() <1 || getAttack()>30);
    }
    public void setDefence(){
        do{
            System.out.println("Choose "+name+"'s defence value:");
            try{
                defence = scanner.nextInt();;
            }
            catch(InputMismatchException e){
                System.out.println("Try again");
                scanner.nextLine();
            }
        }while(getDefence() <1 || getDefence()>30);
    }
    public void setHealth(){
        do{
            System.out.println("Choose "+name+"'s health value:");
            try{
                health = scanner.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Try again");
                scanner.nextLine();
            }
        }while(getHealth() <0 || getHealth()>Engine.maxHealthValue);
    }
    public void setDamage(){
        do{
            System.out.println("Choose "+name+"'s lower damage value:");
            try{
                damage[0] = scanner.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Try again");
                scanner.nextLine();
            }

        }while(getDamage()[0]<0 );
        do{
            System.out.println("Choose "+name+"'s upper damage value:");
            try{
                damage[1] = scanner.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Try again");
                scanner.nextLine();
            }
        }while(getDamage()[1]<getDamage()[0]);
    }


    public






}
