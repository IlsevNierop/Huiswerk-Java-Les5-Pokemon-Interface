import java.util.Arrays;
import java.util.List;

public class PokemonTrainer {

   private  String name;

    private static final FirePokemon charizard = new FirePokemon("Charrizard", 76, 30, "firenougats", "GRRRRRRRRRRRRRRR");
    private static final WaterPokemon blastoise = new WaterPokemon("Blastoise", 40, 30, "Pokeflakes", "Blaaaaasssssstooooiiiiissss");
    private static final GrassPokemon venusaur = new GrassPokemon("Venusaur", 50, 30, "Pokeleafs", "Veeeeeeeeennnnnuuuuuusaur");
    private static final GrassPokemon ditto = new GrassPokemon("Ditto", 60, 30, "Everything", "Dittto diiiito ");
    private static final ElectricPokemon raichu = new ElectricPokemon("Raichu", 80, 30, "Pokebrocks", "Raaaaiiiiicccchhhhuuuuuuu!!!!");
    private static final WaterPokemon gyarados = new WaterPokemon("Gyarados", 85, 30, "Plankton", "Gyaaaaaaaaarrrraaaadoooos");

    private static List<Pokemon> trainerPokemons = Arrays.asList(charizard, blastoise, venusaur, ditto, raichu, gyarados);

    public PokemonTrainer( String name) {
        this.name = name;
    }
    public List<Pokemon> getPokemons() {
        return trainerPokemons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
