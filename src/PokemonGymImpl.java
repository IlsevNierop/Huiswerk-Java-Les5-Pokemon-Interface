import java.util.*;

// Los in deze klasse alle foutmeldingen op door (abstracte) klassen met variabelen en methodes te maken en een interface met methodes (en soms een import).
public class PokemonGymImpl implements PokemonGym {


    // Een methode gemaakt om alle pokemons (van player en trainer) in 1 lijst te doen, zodat bij throwfood random eten gekozen kan worden van alle pokemons (levend en dood):
    public List<Pokemon> allPokemonsInOneList(PokemonTrainer player1, PokemonGymOwner owner) {
        List<Pokemon> allPokemons = new ArrayList<>();
        for (int i = 0; i < player1.getPokemons().size(); i++) {
            allPokemons.add(player1.getPokemons().get(i));
        }
        for (int j = 0; j < owner.getPokemons().size(); j++) {
            allPokemons.add(owner.getPokemons().get(j));
        }

        return allPokemons;
    }

    @Override
    public void enteredTheGymFirstRound(PokemonTrainer player1) {
        PokemonGymOwner gymOwner = new PokemonGymOwner("Brock", "Pewter City");
        System.out.println("You have entered the " + gymOwner.getTown() + " gym");
        System.out.println("In front of you stands a pokemontrainer");
        System.out.println(Main.ANSI_RED + gymOwner.getName() + Main.ANSI_RESET + ": Hello stranger, I'm " + gymOwner.getName() + ", the owner of this gym. Who are you?");
        System.out.println(Main.ANSI_GREEN + player1.getName() + Main.ANSI_RESET + ": I'm " + player1.getName() + " and i'm here to challenge you for a battle");
        System.out.println(Main.ANSI_RED + gymOwner.getName() + Main.ANSI_RESET + ": So you're after my badge too, lets fight!!!");

        Pokemon gymPokemon = chooseGymPokemon(gymOwner);
        System.out.println(Main.ANSI_RED + gymOwner.getName() + Main.ANSI_RESET + ": I'll choose you, " + gymPokemon.getName());
        Pokemon pokemon = choosePokemon(player1);
        System.out.println(Main.ANSI_GREEN + player1.getName() + Main.ANSI_RESET + ": I'll choose you, " + pokemon.getName());

        fightRound(player1, gymOwner, pokemon, gymPokemon);

    }

    //Extra methode aangemaakt, omdat ik andere print statements wil (tov van entered the gym de eerste keer) als de player, na de dood van een pokemon, ervoor kiest om door te gaan.
    @Override
    public void enteredTheGymNextRounds(PokemonTrainer player1, PokemonGymOwner gymOwner) {
        System.out.println(Main.ANSI_RED + gymOwner.getName() + Main.ANSI_RESET + ": So you want to fight again??!! Let's go and see who wins this time!");
        Pokemon gymPokemon = chooseGymPokemon(gymOwner);
        System.out.println(Main.ANSI_RED + gymOwner.getName() + Main.ANSI_RESET + ": I'll choose you, " + gymPokemon.getName());
        Pokemon pokemon = choosePokemon(player1);
        System.out.println(Main.ANSI_GREEN + player1.getName() + Main.ANSI_RESET + ": I'll choose you, " + pokemon.getName());

        fightRound(player1, gymOwner, pokemon, gymPokemon);

    }

    @Override
    public void printPokemon(List<Pokemon> pokemons) {
        for (Pokemon p : pokemons) {
            System.out.println(p.getName());
        }
    }

    @Override
    public Pokemon selectPokemon(String pokemon, PokemonTrainer trainer) {
        List<Pokemon> trainerPokemons1 = trainer.getPokemons();
        int number = 0;
        for (int i = 0; i < trainerPokemons1.size(); i++) {
            if (trainerPokemons1.get(i).getName().equalsIgnoreCase(pokemon)) {
                number = i;
            }
        }
        return trainerPokemons1.get(number);
    }

    @Override
    public void fightRound(PokemonTrainer trainer, PokemonGymOwner owner, Pokemon pokemon, Pokemon gymPokemon) {
        List<Pokemon> allPokemons = allPokemonsInOneList(trainer, owner);
        boolean continueFighting = true;

        // aangepast - origineel ging eerste beide kanten laten attacken, en dan pas checken of een van de twee pokemons dood was. Hieronder wordt na elke attack gecheckt of er een pokemon dood is.
        while (continueFighting) {
            if (pokemon.getHp() <= 0 || gymPokemon.getHp() <= 0) {
                continueFighting = false;
                break;
            } else {
                System.out.println("Its " + owner.getName() + "'s turn to attack");
                gymOwnerAttacks(gymPokemon, pokemon, allPokemons);
                if (pokemon.getHp() <= 0 || gymPokemon.getHp() <= 0) {
                    continueFighting = false;
                    break;
                } else {
                    System.out.println("Its " + trainer.getName() + "'s turn to attack");
                    attackOrChange(pokemon, gymPokemon, trainer, owner);
                }
            }
        }
        if (pokemon.getHp() <= 0) {
            System.out.println(gymPokemon.getName() + " has defeated " + pokemon.getName() + ". \nYou will have to fight with another pokemon to continue.");
        } else if (gymPokemon.getHp() <= 0) {
            // als de gymowner verliest wordt dit meerdere keren geprint, omdat hij constant tussen fightround methode en enterednewgymnextrounds gaat. Ik kan er niet achterkomen waar het aan ligt. Met verschillende if en while statements geprobeerd om het te omzeilen, maar het wil allemaal niet werken. Ik snap de loop niet.
            System.out.println(pokemon.getName() + " has defeated " + gymPokemon.getName() + ".\n" + owner.getName() + " will have to fight with another pokemon to continue.");
        }

        if (checkIfNewFightRound(trainer, owner)) {
            enteredTheGymNextRounds(trainer, owner);
        }

    }

    public boolean checkIfNewFightRound(PokemonTrainer trainer, PokemonGymOwner owner) {
        Scanner speler_A = new Scanner(System.in);
        boolean newRound = false;
        if (new ArrayList<>(alivePokemons(trainer)).size() == 0) {
            System.out.println("But.... all your pokemons are dead, you need to leave the premises now! Toodelooooo!");
            newRound = false;
            System.exit(0);
        } else if (new ArrayList<>(alivePokemons(owner)).size() == 0) {
            // als de gymowner verliest wordt dit meerdere keren geprint, omdat hij constant tussen fightround methode en enterednewgymnextrounds gaat. Ik kan er niet achterkomen waar het aan ligt. Met verschillende if en while statements geprobeerd om het te omzeilen, maar het wil allemaal niet werken. Ik snap de loop niet.
            System.out.println("But... all the pokemons of " + owner.getName() + " are dead. \nYou won. You can pickup your trophee at the desk. \n" + owner.getName() + " will drink away his sorrows in the bar. \nYou can join and buy him a pint.");
            newRound = false;
            System.exit(0);
        } else if (new ArrayList<>(alivePokemons(trainer)).size() != 0 && new ArrayList<>(alivePokemons(owner)).size() != 0) {
            System.out.println("Would you like to keep playing? Type yes or no.");
            String keepPlaying = speler_A.nextLine();
            if (keepPlaying.equals("yes")) {
                newRound = true;
            } else {
                System.out.println("Thank you for playing");
                newRound = false;
                System.exit(0);
            }
        }
        return newRound;
    }


    @Override
    public List<Pokemon> alivePokemons(PokemonTrainer ownerOrTrainer) {
        List<Pokemon> ownerOrTrainerPokemons = new ArrayList<>();
        for (Pokemon p : ownerOrTrainer.getPokemons()) {
            if (p.getHp() > 0) {
                ownerOrTrainerPokemons.add(p);
            }
        }
        return ownerOrTrainerPokemons;
    }

    @Override
    public Pokemon chooseGymPokemon(PokemonGymOwner gymOwner) {
        Random rand = new Random();
        List<Pokemon> gymOwnerPokemons = new ArrayList<>(alivePokemons(gymOwner));

        int randomNumber = rand.nextInt(gymOwnerPokemons.size());
        return gymOwnerPokemons.get(randomNumber);
    }

    @Override
    public Pokemon choosePokemon(PokemonTrainer trainer) {
        Scanner speler_A = new Scanner(System.in);
        List<Pokemon> pokemons = new ArrayList<>(alivePokemons(trainer));

        System.out.println("Please make your choice of pokemon to attack");
        for (Pokemon p : pokemons) {
            System.out.println(p.getName());
        }
        String pokemon = speler_A.nextLine();

        // hiermee check ik of de persoon daadwerkelijk een levende pokemon kiest.
        boolean correctPokemonChosen = false;
        while (!correctPokemonChosen) {
            for (int i = 0; i < pokemons.size(); i++) {
                if (pokemons.get(i).getName().equalsIgnoreCase(pokemon)) {
                    correctPokemonChosen = true;
                    break;
                }
                if (i == pokemons.size() - 1) {
                    System.out.println("Either this pokemon doesn't exist, or this pokemon died. \nPlease choose another pokemon.");
                    pokemon = speler_A.nextLine();
                    continue;
                }
            }
        }
        return selectPokemon(pokemon, trainer);

    }

    @Override
    public int randomAttackByGymOwner(Pokemon pokemon) {
        Random rand = new Random();
        // origineel was max attacks een getal, met .size is het flexibeler voor uitbreiding met eventuele attacks.
        // + 1 gedaan, zodat de pokemon van gymowner ook de mogelijkheid heeft om te eten. Bij de switch van de attacks ook de methode voor eatfood toegevoegd.
        int maxAttacks = pokemon.getAttacks().size() + 1;
        return rand.nextInt(maxAttacks);
    }

    @Override
    public String chooseAttackPlayer(Pokemon p) {
        Scanner speler_A = new Scanner(System.in);
        String type = p.getType();
        switch (type) {
            case "fire" -> {
                FirePokemon fp = (FirePokemon) p;
                System.out.println("Choose your attack");
                System.out.println(fp.getAttacks());
                return speler_A.nextLine();
            }
            case "water" -> {
                WaterPokemon wp = (WaterPokemon) p;
                System.out.println("Choose your attack");
                System.out.println(wp.getAttacks());
                return speler_A.nextLine();
            }
            case "electric" -> {
                ElectricPokemon ep = (ElectricPokemon) p;
                System.out.println("Choose your attack");
                System.out.println(ep.getAttacks());
                return speler_A.nextLine();
            }
            default -> {
                GrassPokemon gp = (GrassPokemon) p;
                System.out.println("Choose your attack");
                System.out.println(gp.getAttacks());
                return speler_A.nextLine();
            }
        }
    }

    @Override
    public void performAttackPlayer(Pokemon pokemon, Pokemon gymPokemon, String
            attack, List<Pokemon> allPokemons) {
        FirePokemon fire;
        ElectricPokemon electric;
        GrassPokemon grass;
        WaterPokemon water;

        String choosenAttack = attack.toLowerCase(Locale.ROOT);

        switch (pokemon.getType()) {
            case "fire" -> {
                fire = new FirePokemon(pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getFood(), pokemon.getSound());
                switch (choosenAttack) {
                    case "inferno" -> fire.inferno(pokemon, gymPokemon);
                    case "pyroball" -> fire.pyroBall(pokemon, gymPokemon);
                    case "firelash" -> fire.fireLash(pokemon, gymPokemon);
                    case "throwfood" ->
                            fire.throwFood(pokemon, gymPokemon, createListFoods(allPokemons).get(randomFoodForAttack(allPokemons)));
                    default -> fire.flameThrower(pokemon, gymPokemon);
                }
            }
            case "water" -> {
                water = new WaterPokemon(pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getFood(), pokemon.getSound());
                switch (choosenAttack) {
                    case "surf" -> water.surf(pokemon, gymPokemon);
                    case "hydropump" -> water.hydroPump(pokemon, gymPokemon);
                    case "hydrocanon" -> water.hydroCanon(pokemon, gymPokemon);
                    case "throwfood" ->
                            water.throwFood(pokemon, gymPokemon, createListFoods(allPokemons).get(randomFoodForAttack(allPokemons)));
                    default -> water.rainDance(pokemon, gymPokemon);
                }
            }
            case "grass" -> {
                grass = new GrassPokemon(pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getFood(), pokemon.getSound());
                switch (choosenAttack) {
                    case "leafstorm" -> grass.leafStorm(pokemon, gymPokemon);
                    case "solarbeam" -> grass.solarBeam(pokemon, gymPokemon);
                    case "leechseed" -> grass.leechSeed(pokemon, gymPokemon);
                    case "throwfood" ->
                            grass.throwFood(pokemon, gymPokemon, createListFoods(allPokemons).get(randomFoodForAttack(allPokemons)));
                    default -> grass.leaveBlade(pokemon, gymPokemon);
                }
            }
            default -> {
                electric = new ElectricPokemon(pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getFood(), pokemon.getSound());
                switch (choosenAttack) {
                    case "thunderpunch" -> electric.thunderPunch(pokemon, gymPokemon);
                    case "electroball" -> electric.electroBall(pokemon, gymPokemon);
                    case "thunder" -> electric.thunder(pokemon, gymPokemon);
                    case "throwfood" ->
                            electric.throwFood(pokemon, gymPokemon, createListFoods(allPokemons).get(randomFoodForAttack(allPokemons)));
                    default -> electric.voltTackle(pokemon, gymPokemon);
                }
            }
        }
    }

    @Override
    public void gymOwnerAttacks(Pokemon gymPokemon, Pokemon pokemon, List<Pokemon> allPokemons) {
        FirePokemon fire;
        ElectricPokemon electric;
        GrassPokemon grass;
        WaterPokemon water;

        int randomNumberForAttackOrEat = randomAttackByGymOwner(gymPokemon);
        if (randomNumberForAttackOrEat == (gymPokemon.getAttacks().size())) {
            //eat food toegevoegd als optie ipv attack.
            eatFood(gymPokemon);
        } else {

            switch (gymPokemon.getType()) {
                case "fire" -> {
                    fire = new FirePokemon(gymPokemon.getName(), gymPokemon.getLevel(), gymPokemon.getHp(), gymPokemon.getFood(), gymPokemon.getSound());
                    String attack = fire.getAttacks().get(randomNumberForAttackOrEat);
                    switch (attack) {
                        case "inferno" -> fire.inferno(gymPokemon, pokemon);
                        case "pyroBall" -> fire.pyroBall(gymPokemon, pokemon);
                        case "fireLash" -> fire.fireLash(gymPokemon, pokemon);
                        case "throwfood" ->
                                fire.throwFood(pokemon, gymPokemon, createListFoods(allPokemons).get(randomFoodForAttack(allPokemons)));
                        default -> fire.flameThrower(gymPokemon, pokemon);
                    }
                }
                case "water" -> {
                    water = new WaterPokemon(gymPokemon.getName(), gymPokemon.getLevel(), gymPokemon.getHp(), gymPokemon.getFood(), gymPokemon.getSound());
                    String attack = water.getAttacks().get(randomNumberForAttackOrEat);
                    switch (attack) {
                        case "surf" -> water.surf(gymPokemon, pokemon);
                        case "hydroPump" -> water.hydroPump(gymPokemon, pokemon);
                        case "hydroCanon" -> water.hydroCanon(gymPokemon, pokemon);
                        case "throwfood" ->
                                water.throwFood(pokemon, gymPokemon, createListFoods(allPokemons).get(randomFoodForAttack(allPokemons)));
                        default -> water.rainDance(gymPokemon, pokemon);
                    }
                }
                case "grass" -> {
                    grass = new GrassPokemon(gymPokemon.getName(), gymPokemon.getLevel(), gymPokemon.getHp(), gymPokemon.getFood(), gymPokemon.getSound());
                    String attack = grass.getAttacks().get(randomNumberForAttackOrEat);
                    switch (attack) {
                        case "leafStorm" -> grass.leafStorm(gymPokemon, pokemon);
                        case "solarBeam" -> grass.solarBeam(gymPokemon, pokemon);
                        case "leechSeed" -> grass.leechSeed(gymPokemon, pokemon);
                        case "throwfood" ->
                                grass.throwFood(pokemon, gymPokemon, createListFoods(allPokemons).get(randomFoodForAttack(allPokemons)));
                        default -> grass.leaveBlade(gymPokemon, pokemon);
                    }
                }
                default -> {
                    electric = new ElectricPokemon(gymPokemon.getName(), gymPokemon.getLevel(), gymPokemon.getHp(), gymPokemon.getFood(), gymPokemon.getSound());
                    String attack = electric.getAttacks().get(randomNumberForAttackOrEat);
                    switch (attack) {
                        case "thunderPunch" -> electric.thunderPunch(gymPokemon, pokemon);
                        case "electroBall" -> electric.electroBall(gymPokemon, pokemon);
                        case "thunder" -> electric.thunder(gymPokemon, pokemon);
                        case "throwfood" ->
                                electric.throwFood(pokemon, gymPokemon, createListFoods(allPokemons).get(randomFoodForAttack(allPokemons)));
                        default -> electric.voltTackle(gymPokemon, pokemon);
                    }
                }
            }
        }
    }

    @Override
    public void attackOrChange(Pokemon pokemon, Pokemon gymPokemon, PokemonTrainer trainer, PokemonGymOwner gym) {
        Scanner speler_A = new Scanner(System.in);
        List<Pokemon> allPokemons = allPokemonsInOneList(trainer, gym);

        System.out.println("Do you want to eat, attack or change your pokemon?");
        System.out.println("Type e for eat, a for attack or c for change");
        String choice = speler_A.nextLine();

        if (choice.equalsIgnoreCase("e")) {
            eatFood(pokemon);
            fightRound(trainer, gym, pokemon, gymPokemon);
        } else if (choice.equalsIgnoreCase("a")) {
            String attack = chooseAttackPlayer(pokemon);
            performAttackPlayer(pokemon, gymPokemon, attack, allPokemons);
        } else {
            pokemon = choosePokemon(trainer);
            System.out.println(Main.ANSI_GREEN + trainer.getName() + Main.ANSI_RESET + ": I'll choose you, " + pokemon.getName());
            attackOrChange(pokemon, gymPokemon, trainer, gym);
            fightRound(trainer, gym, pokemon, gymPokemon);
        }
    }

    // Lijst van eten gemaakt, van alle pokemons (levend of dood), zodat bij een throw food attack - random eten wordt gegooid.
    @Override
    public List<String> createListFoods(List<Pokemon> allPokemons) {
        List<String> foods = new ArrayList<>();
        for (Pokemon a : allPokemons) {
            foods.add(a.getFood());
        }

        return foods;
    }

    //Random food gekozen van al het eten van alle pokemons - te gebruiken voor de throwfood attack.
    @Override
    public int randomFoodForAttack(List<Pokemon> allPokemons) {
        Random rand = new Random();
        int maxFood = allPokemons.size();
        return rand.nextInt(maxFood);
    }

    @Override
    public void eatFood(Pokemon p) {
        p.setHp(p.getHp() + 10);
        System.out.println(p.getName() + " is eating his favourite food: " + p.getFood() + " and gains new energy. \nHe gets a boost of 10 hp. \nHe now has " + p.getHp() + " hp.");
    }

}
