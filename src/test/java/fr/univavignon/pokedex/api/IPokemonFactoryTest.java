package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokemon() {

        // Vérification pour Bulbasaur
        Pokemon createdBulbasaur = pokemonFactory.createPokemon(0, 613, 64, 4000, 3);
        assertEquals("Bulbasaur", createdBulbasaur.getName());
        assertEquals(0, createdBulbasaur.getIndex());
        assertTrue(createdBulbasaur.getAttack() >= 49 && createdBulbasaur.getAttack() <= 64); // Basé sur l'ajustement avec IV
        assertTrue(createdBulbasaur.getDefense() >= 49 && createdBulbasaur.getDefense() <= 64);
        assertTrue(createdBulbasaur.getStamina() >= 45 && createdBulbasaur.getStamina() <= 60);
        assertEquals(613, createdBulbasaur.getCp());
        assertEquals(64, createdBulbasaur.getHp());
        assertEquals(4000, createdBulbasaur.getDust());
        assertEquals(3, createdBulbasaur.getCandy());
        assertTrue(createdBulbasaur.getIv() >= 0 && createdBulbasaur.getIv() <= 100); // Vérification de l'IV entre 0 et 100

        // Vérification pour Aquali
        Pokemon createdAquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals("Aquali", createdAquali.getName());
        assertEquals(133, createdAquali.getIndex());
        assertTrue(createdAquali.getAttack() >= 186 && createdAquali.getAttack() <= 201);
        assertTrue(createdAquali.getDefense() >= 168 && createdAquali.getDefense() <= 183);
        assertTrue(createdAquali.getStamina() >= 260 && createdAquali.getStamina() <= 275);
        assertEquals(2729, createdAquali.getCp());
        assertEquals(202, createdAquali.getHp());
        assertEquals(5000, createdAquali.getDust());
        assertEquals(4, createdAquali.getCandy());
        assertTrue(createdAquali.getIv() >= 0 && createdAquali.getIv() <= 100);
    }
}
