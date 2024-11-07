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
    private IPokedex mockPokedex;

    @Before
    public void setUp() {
        // Création de mocks pour les dépendances
        trainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
        mockPokedex = mock(IPokedex.class);

        // Configuration du comportement du mock du PokedexFactory
        when(pokedexFactory.createPokedex(any(), any())).thenReturn(mockPokedex);

        // Configuration du comportement du mock du TrainerFactory
        when(trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory))
                .thenReturn(new PokemonTrainer("Ash", Team.VALOR, mockPokedex));
        when(trainerFactory.createTrainer("Misty", Team.MYSTIC, pokedexFactory))
                .thenReturn(new PokemonTrainer("Misty", Team.MYSTIC, mockPokedex));
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

    @Test
    public void testCreateTrainerNullName() {
        // Tester si la création d'un dresseur avec un nom null lève une exception ou retourne null selon l'implémentation
        when(trainerFactory.createTrainer(null, Team.INSTINCT, pokedexFactory)).thenReturn(null);
        PokemonTrainer trainer = trainerFactory.createTrainer(null, Team.INSTINCT, pokedexFactory);

        assertNull("Le dresseur doit être nul pour un nom null", trainer);
    }

    @Test
    public void testCreateTrainerNullTeam() {
        // Tester si la création d'un dresseur avec une équipe null lève une exception ou retourne null selon l'implémentation
        when(trainerFactory.createTrainer("Brock", null, pokedexFactory)).thenReturn(null);
        PokemonTrainer trainer = trainerFactory.createTrainer("Brock", null, pokedexFactory);

        assertNull("Le dresseur doit être nul pour une équipe null", trainer);
    }

    @Test
    public void testCreateTrainerNullPokedexFactory() {
        // Tester si la création d'un dresseur avec une factory de pokédex null lève une exception ou retourne null selon l'implémentation
        when(trainerFactory.createTrainer("Jessie", Team.VALOR, null)).thenReturn(null);
        PokemonTrainer trainer = trainerFactory.createTrainer("Jessie", Team.VALOR, null);

        assertNull("Le dresseur doit être nul pour une factory de pokédex null", trainer);
    }
}
