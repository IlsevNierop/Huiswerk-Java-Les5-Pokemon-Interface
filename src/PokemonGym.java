import java.util.List;
import java.util.Random;

public interface PokemonGym {

    void enteredTheGymFirstRound(PokemonTrainer trainer);

    void enteredTheGymNextRounds(PokemonTrainer player1);

    void printPokemon(List<Pokemon> pokemons);

    Pokemon selectPokemon(String pokemon, PokemonTrainer trainer);

    public void fightRound(PokemonTrainer trainer, PokemonGymOwner owner, Pokemon pokemon, Pokemon gymPokemon);

    Pokemon chooseGymPokemon(PokemonGymOwner gymOwner);

    Pokemon choosePokemon(PokemonTrainer trainer);

    int randomAttackByGymOwner(Pokemon pokemon);

    String chooseAttackPlayer(Pokemon p);

    void performAttackPlayer(Pokemon pokemon, Pokemon gymPokemon, String attack);

    void gymOwnerAttacks(Pokemon gymPokemon, Pokemon pokemon);

    void attackOrChange(Pokemon pokemon, Pokemon gymPokemon, PokemonTrainer trainer, PokemonGymOwner gym);

    int randomFoodForAttack(List<Pokemon> pokemons);
    List<String> createListFoods(List<Pokemon> pokemons);

    void eatFood(Pokemon p);

//    List<Pokemon> pokemonDied(Pokemon p, List<Pokemon> pokemons);












}
