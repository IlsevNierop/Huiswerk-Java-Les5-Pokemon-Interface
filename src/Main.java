import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Deze 4 constanten worden gebruikt om tekst met kleur te printen in de console.
    // Hier hoef je niks mee te doen
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    // Dit zijn de Pokemons die je tot je beschikking hebt
    private static final FirePokemon charizard = new FirePokemon("Charrizard", 76, 2, "firenougats", "GRRRRRRRRRRRRRRR");
    private static final WaterPokemon blastoise = new WaterPokemon("Blastoise", 40, 2, "Pokeflakes", "Blaaaaasssssstooooiiiiissss");
    private static final GrassPokemon venusaur = new GrassPokemon("Venusaur", 50, 2, "Pokeleafs", "Veeeeeeeeennnnnuuuuuusaur");
    private static final GrassPokemon ditto = new GrassPokemon("Ditto", 60, 2, "Everything", "Dittto diiiito ");
    private static final ElectricPokemon raichu = new ElectricPokemon("Raichu", 80, 2, "Pokebrocks", "Raaaaiiiiicccchhhhuuuuuuu!!!!");
    private static final WaterPokemon gyarados = new WaterPokemon("Gyarados", 85, 2, "Plankton", "Gyaaaaaaaaarrrraaaadoooos");

    private static final FirePokemon charmeleon = new FirePokemon("Charmeleon", 93, 2, "Charcoal", "HMMMMMMMMMMM");
    private static final WaterPokemon wartortle = new WaterPokemon("Wartortle", 25, 2, "Fish", "WAWAWAWAWAWAWAW");
    private static final GrassPokemon bulbasaur = new GrassPokemon("Bulbasaur", 99, 2, "Daisies", "BLUUUBLULLLULU");
    private static final GrassPokemon ivysaur = new GrassPokemon("Ivysaur", 55, 2, "Weed", "IIIEEEEHHHHHH ");
    private static final ElectricPokemon pikachu = new ElectricPokemon("Pikachu", 75, 2, "Electrons", "PIKIPIKIPIKI!!!!");
    private static final WaterPokemon squirtle = new WaterPokemon("Squirtle", 88, 2, "Algae", "SQRRRRRRRRHAHHA");

    private static List<Pokemon> gymOwnerPokemons = Arrays.asList(charmeleon, wartortle, bulbasaur, ivysaur, pikachu, squirtle);
    private static List<Pokemon> trainerPokemons = Arrays.asList(charizard, blastoise, venusaur, ditto, raichu, gyarados);
    private static List<Pokemon> allPokemons = Arrays.asList(charizard, blastoise, venusaur, ditto, raichu, gyarados, charmeleon, wartortle, bulbasaur, ivysaur, pikachu, squirtle);


    // Los in de main methode alle foutmeldigen op door (abstracte) klassen met variabelen en methoden te maken (en soms een import).
    // In de main methode en de Main klasse hoef je niks te veranderen.
    public static void main(String[] args) {
        Scanner speler_A = new Scanner(System.in);
        PokemonGymImpl pokemonGym = new PokemonGymImpl(gymOwnerPokemons, trainerPokemons, allPokemons);
        System.out.println("First player please enter your name: ");
        String userA = speler_A.nextLine();
        PokemonTrainer player1 = new PokemonTrainer(userA, trainerPokemons);
        System.out.println("To start your game, we have given you 6 Pokemons use");
        System.out.println("these are the Pokemons you get:");
        pokemonGym.printPokemon(trainerPokemons);
        System.out.println("Would you like to enter a gym looking for a fight?");
        System.out.println("Please enter yes or no");
        if (speler_A.nextLine().equals("yes")) {
            pokemonGym.enteredTheGymFirstRound(player1);
        }
        else {
            System.out.println("Have a good day and hope to see you another time!");
        }

    }


}
