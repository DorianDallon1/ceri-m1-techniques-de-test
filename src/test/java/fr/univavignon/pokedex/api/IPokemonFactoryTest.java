package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {
    @Mock
    private IPokemonFactory pokemonFactory;

    private Pokemon bulbasaur;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 3, 56.0);
    }

    @Test
    public void testCreatePokemon() {
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 3)).thenReturn(bulbasaur);

        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 3);
        assertNotNull(result);
        assertEquals("Bulbasaur", result.getName());
        assertEquals(613, result.getCp());
        assertEquals(64, result.getHp());

        verify(pokemonFactory).createPokemon(0, 613, 64, 4000, 3);
    }
}
