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
        System.out.println("Surf: standaard naam: " + name.getName() + "enemy name: " + enemy.getName());
    }
    void hydroPump(Pokemon name, Pokemon enemy){
        System.out.println("HydroPump: standaard naam: " + name.getName() + "enemy name: " + enemy.getName());
    }
    void hydroCanon(Pokemon name, Pokemon enemy){
        System.out.println("hydroCanon: standaard naam: " + name.getName() + "enemy name: " + enemy.getName());
    }

    void rainDance(Pokemon name, Pokemon enemy){
        System.out.println("RainDance: standaard naam: " + name.getName() + "enemy name: " + enemy.getName());
    }
}
