package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {

    @Mock
    private IPokemonTrainerFactory trainerFactory;

    @Mock
    private IPokedexFactory pokedexFactory;

    private PokemonTrainer trainer;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        trainer = new PokemonTrainer("Ash", Team.MYSTIC, mock(IPokedex.class));
    }

    @Test
    public void testCreateTrainer() {
        when(trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory)).thenReturn(trainer);

        PokemonTrainer result = trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory);
        assertEquals("Ash", result.getName());
        assertEquals(Team.MYSTIC, result.getTeam());

        verify(trainerFactory).createTrainer("Ash", Team.MYSTIC, pokedexFactory);
    }
}
