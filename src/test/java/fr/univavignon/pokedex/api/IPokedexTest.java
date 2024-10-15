package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IPokedexTest {
    @Mock
    private IPokedex pokedex;

    private Pokemon bulbasaur;
    private Pokemon aquali;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 3, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);
    }

    @Test
    public void testAddPokemon() {
        when(pokedex.addPokemon(bulbasaur)).thenReturn(0);

        int index = pokedex.addPokemon(bulbasaur);
        assertEquals(0, index);

        verify(pokedex).addPokemon(bulbasaur);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        when(pokedex.getPokemon(0)).thenReturn(bulbasaur);
        Pokemon result = pokedex.getPokemon(0);
        assertEquals("Bulbasaur", result.getName());

        verify(pokedex).getPokemon(0);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonThrowsException() throws PokedexException {
        when(pokedex.getPokemon(999)).thenThrow(new PokedexException("invalid index"));
        pokedex.getPokemon(999);
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = Arrays.asList(bulbasaur, aquali);
        when(pokedex.getPokemons()).thenReturn(Collections.unmodifiableList(pokemons));

        List<Pokemon> result = pokedex.getPokemons();
        assertEquals(2, result.size());
        assertEquals("Bulbasaur", result.get(0).getName());

        verify(pokedex).getPokemons();
    }
}
