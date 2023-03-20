import java.util.Arrays;
import java.util.List;

public class WaterPokemon extends Pokemon {

    private String type = "water";
    private List<String> attacks = Arrays.asList("surf", "hydroPump", "hydroCanon", "rainDance");
    public WaterPokemon(String name, int level, int hp, String food, String sound) {
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




    void surf(Pokemon name, Pokemon enemy){
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with surf.");
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
            default:
                System.out.println(enemy.getName() + " loses 3 hp.");
                enemy.setHp(enemy.getHp() - 3);
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
    }
    void hydroPump(Pokemon name, Pokemon enemy){
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with hydroPump.");
        switch (enemy.getType()) {
            case "fire":
                System.out.println(enemy.getName() + " loses 20 hp.");
                enemy.setHp(enemy.getHp() - 20);
                break;
            case "electric":  System.out.println(enemy.getName() + " loses 15 hp. ");
                enemy.setHp(enemy.getHp() - 15);
                break;
            case "grass":
                System.out.println(enemy.getName() + " loses 10 hp.");
                enemy.setHp(enemy.getHp() - 10);
                break;
            default:
                System.out.println(enemy.getName() + " loses 5 hp.");
                enemy.setHp(enemy.getHp() - 5);
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
    }
    void hydroCanon(Pokemon name, Pokemon enemy){
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with hydroCanon.");
        switch (enemy.getType()) {
            case "fire":
                System.out.println(enemy.getName() + " loses 10 hp.");
                enemy.setHp(enemy.getHp() - 10);
                break;
            case "electric":  System.out.println(enemy.getName() + " loses 8 hp. ");
                enemy.setHp(enemy.getHp() - 8);
                break;
            case "grass":
                System.out.println(enemy.getName() + " loses 4 hp.");
                enemy.setHp(enemy.getHp() - 4);
                break;
            default:
                System.out.println(enemy.getName() + " loses 2 hp.");
                enemy.setHp(enemy.getHp() - 2);
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
    }

    void rainDance(Pokemon name, Pokemon enemy){
        System.out.println(name.getName() + " attacks " + enemy.getName() + " with rainDance.");
        switch (enemy.getType()) {
            case "fire":
                System.out.println(enemy.getName() + " loses 8 hp.");
                enemy.setHp(enemy.getHp() - 8);
                break;
            case "electric":  System.out.println(enemy.getName() + " loses 4 hp. ");
                enemy.setHp(enemy.getHp() - 4);
                break;
            case "grass":
                System.out.println(enemy.getName() + " gets a boost of 5 hp.");
                enemy.setHp(enemy.getHp() + 5);
                break;
            default:
                System.out.println("Raindance has no effect on " + enemy.getName());
        }
        System.out.println(enemy.getName() + " now has " + enemy.getHp() + " hp.");
    }
}
