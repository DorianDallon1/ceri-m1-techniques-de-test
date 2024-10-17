package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {

    @Mock
    private IPokemonTrainerFactory trainerFactory;

    @Mock
    private IPokedexFactory pokedexFactory;

    private PokemonTrainer ash;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ash = new PokemonTrainer("Ash", Team.MYSTIC, mock(IPokedex.class));
    }

    @Test
    public void testCreateTrainer() {
        when(trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory)).thenReturn(ash);

        assertEquals(ash, trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory));
    }
}
