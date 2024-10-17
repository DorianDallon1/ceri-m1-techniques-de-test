package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {
    @Mock
    private IPokemonFactory pokemonFactory;

    private Pokemon bulbasaur;
    private Pokemon aquali;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 3, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);
    }

    @Test
    public void testCreatePokemon() {
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 3)).thenReturn(bulbasaur);
        when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);

        assertEquals(bulbasaur, pokemonFactory.createPokemon(0, 613, 64, 4000, 3));
        assertEquals(aquali, pokemonFactory.createPokemon(133, 2729, 202, 5000, 4));
    }
}
