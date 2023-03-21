import java.util.Arrays;
import java.util.List;

public class GrassPokemon extends Pokemon {

    private final String type = "grass";

    private List<String> attacks = Arrays.asList("leafStorm", "solarBeam", "leechSeed", "leaveBlade", "throwFood");

    public GrassPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound);
    }



    @Override
    public List<String> getAttacks() {
        return attacks;
    }

    public void leafStorm(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with leafStorm");
        switch (enemy.getType()) {
            case "electric":
                System.out.println(enemy.getName() + " loses 15 hp. ");
                enemy.setHp(enemy.getHp() - 15);
                break;
            case "fire":
                System.out.println(enemy.getName() + " loses 10 hp.");
                enemy.setHp(enemy.getHp() - 10);
                break;
            case "water":
                System.out.println(enemy.getName() + " loses 5 hp.");
                enemy.setHp(enemy.getHp() - 5);
                break;
            default:
                System.out.println(enemy.getName() + " loses 3 hp.");
                enemy.setHp(enemy.getHp() - 3);
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
    }

    public void solarBeam(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with solarBeam");
        switch (enemy.getType()) {
            case "electric":
                System.out.println(enemy.getName() + " loses 20 hp. ");
                enemy.setHp(enemy.getHp() - 20);
                break;
            case "fire":
                System.out.println(enemy.getName() + " loses 15 hp.");
                enemy.setHp(enemy.getHp() - 15);
                break;
            case "water":
                System.out.println(enemy.getName() + " loses 10 hp.");
                enemy.setHp(enemy.getHp() - 10);
                break;
            default:
                System.out.println(enemy.getName() + " loses 8 hp.");
                enemy.setHp(enemy.getHp() - 8);
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
    }

    public void leechSeed(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with leechSeed");
        switch (enemy.getType()) {
            case "electric":
                System.out.println(name.getName() + " gets 12 hp from " + enemy.getName());
                enemy.setHp(enemy.getHp() - 12);
                name.setHp(name.getHp() + 12);

                break;
            case "fire":
                System.out.println(name.getName() + " gets 9 hp from " + enemy.getName());
                enemy.setHp(enemy.getHp() - 9);
                name.setHp(name.getHp() + 9);
                break;
            case "water":
                System.out.println(name.getName() + " gets 6 hp from " + enemy.getName());
                enemy.setHp(enemy.getHp() - 6);
                name.setHp(name.getHp() + 6);
                break;
            default:
                System.out.println(name.getName() + " gets 3 hp from " + enemy.getName());
                enemy.setHp(enemy.getHp() - 3);
                name.setHp(name.getHp() + 3);
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
        System.out.println(name.getName() + " now has " + name.getHp() + " hp.") ;
    }

    public void leaveBlade(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with leaveBlade");
        switch (enemy.getType()) {
            case "electric":
                System.out.println(enemy.getName() + " loses 10 hp. ");
                enemy.setHp(enemy.getHp() - 10);
                break;
            case "fire":
                System.out.println(enemy.getName() + " loses 8 hp.");
                enemy.setHp(enemy.getHp() - 8);
                break;
            case "water":
                System.out.println(enemy.getName() + " loses 5 hp.");
                enemy.setHp(enemy.getHp() - 5);
                break;
            default:
                System.out.println(enemy.getName() + " loses 2 hp.");
                enemy.setHp(enemy.getHp() - 2);
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
    }

    @Override
    public String getType() {
        return type;
    }
}
