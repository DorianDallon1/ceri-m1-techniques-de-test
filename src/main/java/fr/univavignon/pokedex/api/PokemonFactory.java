package fr.univavignon.pokedex.api;

import org.apache.commons.collections4.map.UnmodifiableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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

    private static Map<Integer, String> index2name;
    static {
        Map<Integer, String> aMap = new HashMap<Integer, String>();
        aMap.put(-1, "Ash's Pikachu");
        aMap.put(0, "MISSINGNO");
        aMap.put(1, "Bulbasaur");
        //TODO : Gotta map them all !
        index2name = UnmodifiableMap.unmodifiableMap(aMap);
    }

    static int generateRandomStat() {
        int total = 0;
        for(int i=0; i < 1000000; i++)
        {
            Random rn = new Random();
            int r = rn.nextInt(2);
            total = total + r;
        }
        return total / 10000;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        String name;
        if(!index2name.containsKey(index)) {
            name = index2name.get(0);
        } else {
            name = index2name.get(index);
        }
        int attack;
        int defense;
        int stamina;
        double iv;
        if(index < 0) {
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
