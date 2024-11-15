package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        trainerFactory = new PokemonTrainerFactory();
        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void testCreateTrainerValid() {
        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);

        assertNotNull("Le dresseur ne doit pas être nul", trainer);
        assertEquals("Ash", trainer.getName());
        assertEquals(Team.VALOR, trainer.getTeam());
        assertNotNull("Le pokédex du dresseur ne doit pas être nul", trainer.getPokedex());
    }

    @Test
    public void testCreateTrainerWithDifferentTeam() {
        PokemonTrainer trainer = trainerFactory.createTrainer("Misty", Team.MYSTIC, pokedexFactory);

        assertNotNull("Le dresseur ne doit pas être nul", trainer);
        assertEquals("Misty", trainer.getName());
        assertEquals(Team.MYSTIC, trainer.getTeam());
        assertNotNull("Le pokédex du dresseur ne doit pas être nul", trainer.getPokedex());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTrainerNullName() {
        trainerFactory.createTrainer(null, Team.INSTINCT, pokedexFactory);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTrainerNullTeam() {
        trainerFactory.createTrainer("Brock", null, pokedexFactory);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTrainerNullPokedexFactory() {
        trainerFactory.createTrainer("Jessie", Team.VALOR, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTrainerEmptyName() {
        trainerFactory.createTrainer("", Team.VALOR, pokedexFactory);
    }
}
