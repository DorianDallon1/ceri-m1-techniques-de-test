package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.UnmodifiableMap;

/**
 * Classe implémentant une usine de création de Pokémon.
 */
public class PokemonFactory implements IPokemonFactory {
    /* Ancien code
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        try {
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);

            int individualAttack = generateIndividualValue();
            int individualDefense = generateIndividualValue();
            int individualStamina = generateIndividualValue();

            int totalIV = individualAttack + individualDefense + individualStamina;
            double maxIV = 3 * 15;
            double iv = (totalIV / maxIV) * 100;

            return new Pokemon(
                    index,
                    metadata.getName(),
                    metadata.getAttack() + individualAttack,
                    metadata.getDefense() + individualDefense,
                    metadata.getStamina() + individualStamina,
                    cp,
                    hp,
                    dust,
                    candy,
                    iv
            );
        } catch (PokedexException e) {
            throw new IllegalArgumentException("Failed to create Pokemon due to invalid index.", e);
        }
    }

    private int generateIndividualValue() {
        return (int) (Math.random() * 16);
    }
    */

    /**
     * Map associant les indices des Pokémon à leurs noms.
     */
    private static Map<Integer, String> index2name;

    static {
        Map<Integer, String> aMap = new HashMap<Integer, String>();
        aMap.put(-1, "Ash's Pikachu");
        aMap.put(0, "MISSINGNO");
        aMap.put(1, "Bulbasaur");
        index2name = UnmodifiableMap.unmodifiableMap(aMap);
    }

    /**
     * Génère une statistique aléatoire pour un Pokémon.
     *
     * @return Une valeur aléatoire entre 0 et 15.
     */
    private static int generateRandomStat() {
        int total = 0;
        for (int i = 0; i < 1000000; i++) {
            Random rn = new Random();
            int r = rn.nextInt(2);
            total = total + r;
        }
        return total / 10000;
    }

    /**
     * Crée une instance de Pokémon en fonction des paramètres fournis.
     *
     * @param index L'indice du Pokémon dans le Pokédex.
     * @param cp Les points de combat (Combat Power) du Pokémon.
     * @param hp Les points de vie (Health Points) du Pokémon.
     * @param dust La quantité de poussière d'étoiles nécessaire pour améliorer ce Pokémon.
     * @param candy La quantité de bonbons nécessaire pour améliorer ce Pokémon.
     * @return Une instance de {@link Pokemon}.
     * @throws IllegalArgumentException Si l'indice du Pokémon est invalide.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        String name;
        if (!index2name.containsKey(index)) {
            throw new IllegalArgumentException("Invalid Pokemon index: " + index);
        } else {
            name = index2name.get(index);
        }
        int attack;
        int defense;
        int stamina;
        double iv;
        if (index < 0) {
            attack = 1000;
            defense = 1000;
            stamina = 1000;
            iv = 0;
        } else {
            attack = PokemonFactory.generateRandomStat();
            defense = PokemonFactory.generateRandomStat();
            stamina = PokemonFactory.generateRandomStat();
            iv = 1;
        }
        return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
    }
}
