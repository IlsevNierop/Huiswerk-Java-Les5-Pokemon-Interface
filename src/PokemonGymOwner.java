import java.util.Arrays;
import java.util.List;

public class PokemonGymOwner extends PokemonTrainer {

    private String town;
    private static final FirePokemon charmeleon = new FirePokemon("Charmeleon", 93, 60, "Charcoal", "HMMMMMMMMMMM");
    private static final WaterPokemon wartortle = new WaterPokemon("Wartortle", 25, 80, "Fish", "WAWAWAWAWAWAWAW");
    private static final GrassPokemon bulbasaur = new GrassPokemon("Bulbasaur", 99, 30, "Daisies", "BLUUUBLULLLULU");
    private static final GrassPokemon ivysaur = new GrassPokemon("Ivysaur", 55, 40, "Weed", "IIIEEEEHHHHHH ");
    private static final ElectricPokemon pikachu = new ElectricPokemon("Pikachu", 75, 55, "Electrons", "PIKIPIKIPIKI!!!!");
    private static final WaterPokemon squirtle = new WaterPokemon("Squirtle", 88, 45, "Algae", "SQRRRRRRRRHAHHA");

    private static List<Pokemon> gymOwnerPokemons = Arrays.asList(charmeleon, wartortle, bulbasaur, ivysaur, pikachu, squirtle);


    public PokemonGymOwner(String name, String town) {
        super(name);
        this.town = town;
    }

    public List<Pokemon> getPokemons() {
        return gymOwnerPokemons;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

}
