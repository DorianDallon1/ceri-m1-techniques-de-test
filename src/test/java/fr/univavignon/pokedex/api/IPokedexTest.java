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
    @Mock
    private IPokedex pokedex;

    private Pokemon bulbasaur;
    private Pokemon aquali;
//
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 3, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);
    }

    @Test
    public void testAddPokemon() {
        when(pokedex.addPokemon(bulbasaur)).thenReturn(0);
        when(pokedex.addPokemon(aquali)).thenReturn(1);

        assertEquals(0, pokedex.addPokemon(bulbasaur));
        assertEquals(1, pokedex.addPokemon(aquali));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        when(pokedex.getPokemon(0)).thenReturn(bulbasaur);
        when(pokedex.getPokemon(133)).thenReturn(aquali);

        assertEquals(bulbasaur, pokedex.getPokemon(0));
        assertEquals(aquali, pokedex.getPokemon(133));
    }

    @Test
    public void testGetPokemonThrowsException() throws PokedexException {
        when(pokedex.getPokemon(999)).thenThrow(new PokedexException("invalid index"));
        PokedexException exception = assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(999);
        });
        assertEquals("invalid index", exception.getMessage());
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = Arrays.asList(bulbasaur, aquali);
        when(pokedex.getPokemons()).thenReturn(Collections.unmodifiableList(pokemons));

        assertEquals(pokemons, pokedex.getPokemons());
        assertEquals(2, pokedex.getPokemons().size());
        assertEquals("Bulbasaur", pokedex.getPokemons().get(0).getName());
        assertEquals("Aquali", pokedex.getPokemons().get(1).getName());
    }
}
