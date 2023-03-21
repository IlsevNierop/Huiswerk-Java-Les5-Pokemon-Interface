import java.util.Arrays;
import java.util.List;

public class FirePokemon extends Pokemon {

    private final String type = "fire";

    @Override
    public String getType() {
        return type;
    }

    private List<String> attacks = Arrays.asList("inferno", "pyroBall", "fireLash", "flameThrower", "throwFood");

    public FirePokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound);
    }

    @Override
    public List<String> getAttacks() {
        return attacks;
    }

    void pyroBall(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with pyroBall.");
        switch (enemy.getType()) {
            case "grass":
                System.out.println(enemy.getName() + " loses 8 hp.");
                enemy.setHp(enemy.getHp() - 8);
                break;
            case "water":
                System.out.println(enemy.getName() + " loses 4 hp.");
                enemy.setHp(enemy.getHp() - 4);
                break;
            case "electric":
                System.out.println(enemy.getName() + " loses 2 hp. ");
                enemy.setHp(enemy.getHp() - 2);
                break;
            default:
                System.out.println(enemy.getName() + " loses 1 hp.");
                enemy.setHp(enemy.getHp() - 1);
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
    }


    void inferno(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with inferno.");
        switch (enemy.getType()) {
            case "grass":
                System.out.println(enemy.getName() + " loses 15 hp.");
                enemy.setHp(enemy.getHp() - 15);
                break;
            case "water":
                System.out.println(enemy.getName() + " loses 10 hp.");
                enemy.setHp(enemy.getHp() - 10);
                break;
            case "electric":
                System.out.println(enemy.getName() + " loses 5 hp. ");
                enemy.setHp(enemy.getHp() - 5);
                break;
            default:
                System.out.println(enemy.getName() + " loses 2 hp.");
                enemy.setHp(enemy.getHp() - 2);
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
    }

    void fireLash(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with fireLash.");
        switch (enemy.getType()) {
            case "grass":
                System.out.println(enemy.getName() + " loses 20 hp.");
                enemy.setHp(enemy.getHp() - 20);
                break;
            case "water":
                System.out.println(enemy.getName() + " loses 15 hp.");
                enemy.setHp(enemy.getHp() - 15);
                break;
            case "electric":
                System.out.println(enemy.getName() + " loses 10 hp. ");
                enemy.setHp(enemy.getHp() - 10);
                break;
            default:
                System.out.println(enemy.getName() + " loses 5 hp.");
                enemy.setHp(enemy.getHp() - 5);
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
    }


    void flameThrower(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with flameThrower.");
        switch (enemy.getType()) {
            case "grass":
                System.out.println(enemy.getName() + " loses 10 hp.");
                enemy.setHp(enemy.getHp() - 10);
                break;
            case "water":
                System.out.println(enemy.getName() + " loses 8 hp.");
                enemy.setHp(enemy.getHp() - 8);
                break;
            case "electric":
                System.out.println(enemy.getName() + " loses 4 hp. ");
                enemy.setHp(enemy.getHp() - 4);
                break;
            default:
                System.out.println(enemy.getName() + " loses 2 hp.");
                enemy.setHp(enemy.getHp() - 2);
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
    }

}
