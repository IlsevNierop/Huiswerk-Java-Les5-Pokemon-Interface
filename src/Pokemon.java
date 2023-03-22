import java.util.Arrays;
import java.util.List;

public abstract class Pokemon {

    private final String name;
    private final int level;
    private int hp;
    private final String food;
    private final String sound;

    private String type;

    private final List<String> attacks = Arrays.asList();


    public Pokemon(String name, int level, int hp, String food, String sound) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.food = food;
        this.sound = sound;
    }

    void throwFood(Pokemon name, Pokemon enemy, String randomFood) {
       if (enemy.getFood().equals(randomFood)){
            enemy.setHp(enemy.getHp() + 15);
            System.out.println(name.getName() + " throws " + randomFood + " at " + enemy.getName() + ". \nThis is the kind of food that " + enemy.getName() + " loves! \nHis hp is boosted with 10 points.");
        }
        else {
            enemy.setHp(enemy.getHp() - 5);
            System.out.println(name.getName() + " throws " + randomFood + " at " + enemy.getName() + ". \nOuch that hurt, and " + enemy.getName() + " hates this food! \nHe lost 5 hp");
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");

    }





    public String getName() {
        return name;
    }


    public int getLevel() {
        return level;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getFood() {
        return food;
    }


    public String getSound() {
        return sound;
    }


    public List<String> getAttacks() {
        return attacks;
    }

    public String getType() {
        return type;
    }

}
