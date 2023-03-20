import java.util.Arrays;
import java.util.List;

public class FirePokemon extends Pokemon {

    private String type = "fire";

    @Override
    public String getType() {
        return type;
    }
    private List<String> attacks = Arrays.asList("inferno", "pyroBall", "fireLash", "flameThrower");
    public FirePokemon(String name, int level, int hp, String food, String sound) {
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

    void pyroBall(Pokemon name, Pokemon enemy){
        System.out.println("PyroBall: standaard naam: " + name.getName() + "enemy name: " + enemy.getName());
    }

    void inferno(Pokemon name, Pokemon enemy){
        System.out.println("Inferno: standaard naam: " + name.getName() + "enemy name: " + enemy.getName());
    }

    void fireLash(Pokemon name, Pokemon enemy){
        System.out.println("fireLash: standaard naam: " + name.getName() + "enemy name: " + enemy.getName());
    }

    void flameThrower(Pokemon name, Pokemon enemy){
        System.out.println("FlameThrower: standaard naam: " + name.getName() + "enemy name: " + enemy.getName());
    }

}
