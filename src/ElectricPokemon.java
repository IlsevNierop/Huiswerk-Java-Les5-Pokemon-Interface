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
        System.out.println("thunderPunch: standaard naam: " + name.getName() + "enemy name: " + enemy.getName());
    }

    void electroBall(Pokemon name, Pokemon enemy){
        System.out.println("electroBall: standaard naam: " + name.getName() + "enemy name: " + enemy.getName());
    }
    void thunder(Pokemon name, Pokemon enemy){
        System.out.println("thunder: standaard naam: " + name.getName() + "enemy name: " + enemy.getName());
    }

    void voltTackle(Pokemon name, Pokemon enemy){
        System.out.println("voltTackle: standaard naam: " + name.getName() + "enemy name: " + enemy.getName());
    }
}
