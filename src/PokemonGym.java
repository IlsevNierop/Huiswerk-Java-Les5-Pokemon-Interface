import java.util.List;
import java.util.Random;

public interface PokemonGym {

    void enteredTheGymFirstRound(PokemonTrainer trainer);

    void enteredTheGymNextRounds(PokemonTrainer player1, PokemonGymOwner gymowner);

    void printPokemon(List<Pokemon> pokemons);

    Pokemon selectPokemon(String pokemon, PokemonTrainer trainer);

    public void fightRound(PokemonTrainer trainer, PokemonGymOwner owner, Pokemon pokemon, Pokemon gymPokemon);

    Pokemon chooseGymPokemon(PokemonGymOwner gymOwner);

    Pokemon choosePokemon(PokemonTrainer trainer);

    int randomAttackByGymOwner(Pokemon pokemon);

    String chooseAttackPlayer(Pokemon p);

    void performAttackPlayer(Pokemon pokemon, Pokemon gymPokemon, String attack, List<Pokemon> allPokemons);

    void gymOwnerAttacks(Pokemon gymPokemon, Pokemon pokemon, List<Pokemon> allPokemons);

    void attackOrChange(Pokemon pokemon, Pokemon gymPokemon, PokemonTrainer trainer, PokemonGymOwner gym);

    int randomFoodForAttack(List<Pokemon> pokemons);

    List<String> createListFoods(List<Pokemon> pokemons);

    void eatFood(Pokemon p);

    List<Pokemon> alivePokemons(PokemonTrainer ownerOrTrainer);


}
