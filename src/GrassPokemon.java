import java.util.Arrays;
import java.util.List;

public class GrassPokemon extends Pokemon {

    private String type = "grass";

    private List<String> attacks = Arrays.asList("leafStorm", "solarBeam", "leechSeed", "leaveBlade");

    public GrassPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound);
    }

    @Override
    public List<String> getAttacks() {
        return attacks;
    }

    @Override
    public void setAttacks(List<String> attacks) {
        this.attacks = attacks;
    }


    public void leafStorm(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with leafStorm");
        switch (name.getType()) {
            case "fire":
                switch (enemy.getType()) {
                    case "grass":
                        System.out.println(enemy.getName() + " loses 15 hp.");
                        enemy.setHp(enemy.getHp() - 15);
                        break;
                    case "water":
                        System.out.println(enemy.getName() + " loses 10 hp.");
                        enemy.setHp(enemy.getHp() - 10);
                        break;
                    case "electric":  System.out.println(enemy.getName() + " loses 5 hp. ");
                        enemy.setHp(enemy.getHp() - 5);
                        break;

                    case "fire":
                        System.out.println(enemy.getName() + " loses 3 hp.");
                        enemy.setHp(enemy.getHp() - 3);
                        break;
                    default:
                        System.out.println("Something is wrong on the level of the enemy switch, please contact your administrator");
                }
                case "grass":
                switch (enemy.getType()) {
                    case "electric":  System.out.println(enemy.getName() + " loses 15 hp. ");
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
                    case "grass":
                        System.out.println(enemy.getName() + " loses 3 hp.");
                        enemy.setHp(enemy.getHp() - 3);
                        break;

                    default:
                        System.out.println("Something is wrong on the level of the enemy switch, please contact your administrator");
                }
                case "electric":
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
                    case "electric":
                        System.out.println(enemy.getName() + " loses 3 hp. ");
                        enemy.setHp(enemy.getHp() - 3);
                        break;
                    default:
                        System.out.println("Something is wrong on the level of the enemy switch, please contact your administrator");
                }
                case "water":
                switch (enemy.getType()) {
                    case "fire":
                        System.out.println(enemy.getName() + " loses 15 hp.");
                        enemy.setHp(enemy.getHp() - 15);
                        break;
                    case "electric":  System.out.println(enemy.getName() + " loses 10 hp. ");
                        enemy.setHp(enemy.getHp() - 10);
                        break;
                    case "grass":
                        System.out.println(enemy.getName() + " loses 5 hp.");
                        enemy.setHp(enemy.getHp() - 5);
                        break;
                    case "water":
                        System.out.println(enemy.getName() + " loses 3 hp.");
                        enemy.setHp(enemy.getHp() - 3);
                        break;
                    default:
                        System.out.println("Something is wrong on the level of the enemy switch, please contact your administrator");
                }
            default:
                System.out.println("Something is wrong on the level of the attacker switch, please contact your administrator");
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
    }

    public void solarBeam(Pokemon name, Pokemon enemy) {
        System.out.println("solarBeam: standaard naam: " + name.getName() + "enemy name: " + enemy.getName());
    }

    public void leechSeed(Pokemon name, Pokemon enemy) {
        System.out.println("leechSeed: standaard naam: " + name.getName() + "enemy name: " + enemy.getName());
    }

    public void leaveBlade(Pokemon name, Pokemon enemy) {
        System.out.println("leaveBlade: standaard naam: " + name.getName() + "enemy name: " + enemy.getName());
    }

    @Override
    public String getType() {
        return type;
    }
}
