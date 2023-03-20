import java.util.Arrays;
import java.util.List;

public class ElectricPokemon extends Pokemon {

    private String type = "electric";

    private List<String> attacks = Arrays.asList("thunderPunch", "electroBall", "thunder", "voltTackle");
    public ElectricPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound);
    }

    @Override
    public String getType() {
        return type;
    }
    @Override
    public List<String> getAttacks() {
        return attacks;
    }

    @Override
    public void setAttacks(List<String> attacks) {
        this.attacks = attacks;
    }



    void thunderPunch(Pokemon name, Pokemon enemy){
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with thunderPunch");
        switch (enemy.getType()) {
            case "water":
                System.out.println(enemy.getName() + " loses 15 hp.");
                enemy.setHp(enemy.getHp() - 15);
                break;
            case "grass":
                System.out.println(enemy.getName() + " loses 10 hp.");
                enemy.setHp(enemy.getHp() - 10);
                break;
            case "fire":
                System.out.println(enemy.getName() + " loses 5 hp.");
                enemy.setHp(enemy.getHp() - 5);
                break;
            default:
                System.out.println(enemy.getName() + " loses 3 hp. ");
                enemy.setHp(enemy.getHp() - 3);
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
    }

    void electroBall(Pokemon name, Pokemon enemy){
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with electroBall");
        switch (enemy.getType()) {
            case "water":
                System.out.println(enemy.getName() + " loses 20 hp.");
                enemy.setHp(enemy.getHp() - 20);
                break;
            case "grass":
                System.out.println(enemy.getName() + " loses 15 hp.");
                enemy.setHp(enemy.getHp() - 15);
                break;
            case "fire":
                System.out.println(enemy.getName() + " loses 10 hp.");
                enemy.setHp(enemy.getHp() - 10);
                break;
            default:
                System.out.println(enemy.getName() + " loses 5 hp. ");
                enemy.setHp(enemy.getHp() - 5);
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
    }
    void thunder(Pokemon name, Pokemon enemy){
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with thunder");
        switch (enemy.getType()) {
            case "water":
                System.out.println(enemy.getName() + " loses 20 hp.");
                enemy.setHp(enemy.getHp() - 20);
                break;
            case "grass":
                System.out.println(enemy.getName() + " loses 15 hp.");
                enemy.setHp(enemy.getHp() - 15);
                break;
            case "fire":
                System.out.println(enemy.getName() + " loses 10 hp.");
                enemy.setHp(enemy.getHp() - 10);
                break;
            default:
                System.out.println(enemy.getName() + " gets a hp boost of 10");
                enemy.setHp(enemy.getHp() + 10);
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
    }

    void voltTackle(Pokemon name, Pokemon enemy){
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with voltTackle.");
        switch (enemy.getType()) {
            case "water":
                System.out.println(enemy.getName() + " loses 10 hp.");
                enemy.setHp(enemy.getHp() - 10);
                break;
            case "grass":
                System.out.println(enemy.getName() + " loses 8 hp.");
                enemy.setHp(enemy.getHp() - 8);
                break;
            case "fire":
                System.out.println(enemy.getName() + " loses 4 hp.");
                enemy.setHp(enemy.getHp() - 4);
                break;
            default:
                System.out.println(enemy.getName() + " loses 1 hp. ");
                enemy.setHp(enemy.getHp() - 1);
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
    }
}
