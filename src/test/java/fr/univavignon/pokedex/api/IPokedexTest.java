package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokedexTest {
    private IPokedex pokedex;
    private Pokemon bulbasaur;
    private Pokemon aquali;
//
    @Before
    public void setUp() {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
        bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 3, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);
    }

    @Test
    public void testAddPokemon() {
        assertEquals(0, pokedex.addPokemon(bulbasaur));
        assertEquals(1, pokedex.addPokemon(aquali));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        pokedex.addPokemon(bulbasaur);
        pokedex.addPokemon(aquali);
        assertEquals(bulbasaur, pokedex.getPokemon(0));
        assertEquals(aquali, pokedex.getPokemon(1));
    }

    @Test
    public void testGetPokemonThrowsException() throws PokedexException {
        PokedexException exception = assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(999);
        });
        assertEquals("Invalid Pokemon ID: 999", exception.getMessage());
    }

    @Test
    public void testGetPokemons() {
        pokedex.addPokemon(bulbasaur);
        pokedex.addPokemon(aquali);

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(Arrays.asList(bulbasaur, aquali), pokemons);
        assertEquals(2, pokemons.size());
        assertEquals("Bulbasaur", pokemons.get(0).getName());
        assertEquals("Aquali", pokemons.get(1).getName());
    }
}
