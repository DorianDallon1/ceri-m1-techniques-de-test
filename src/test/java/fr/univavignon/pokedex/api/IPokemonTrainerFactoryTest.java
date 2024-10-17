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

    private PokemonTrainer pierre;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        pierre = new PokemonTrainer("Pierre", Team.MYSTIC, mock(IPokedex.class));
    }

    @Test
    public void testCreateTrainer() {
        when(trainerFactory.createTrainer("Pierre", Team.MYSTIC, pokedexFactory)).thenReturn(pierre);

        assertEquals(pierre, trainerFactory.createTrainer("Pierre", Team.MYSTIC, pokedexFactory));
    }
}
