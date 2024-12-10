package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokemon() {

        Pokemon createdBulbasaur = pokemonFactory.createPokemon(1, 613, 64, 4000, 3);
        assertEquals("Bulbasaur", createdBulbasaur.getName());
        assertEquals(1, createdBulbasaur.getIndex());
        assertTrue(createdBulbasaur.getAttack() >= 49 && createdBulbasaur.getAttack() <= 64);
        assertTrue(createdBulbasaur.getDefense() >= 49 && createdBulbasaur.getDefense() <= 64);
        assertTrue(createdBulbasaur.getStamina() >= 45 && createdBulbasaur.getStamina() <= 60);
        assertEquals(613, createdBulbasaur.getCp());
        assertEquals(64, createdBulbasaur.getHp());
        assertEquals(4000, createdBulbasaur.getDust());
        assertEquals(3, createdBulbasaur.getCandy());
        assertTrue(createdBulbasaur.getIv() >= 1 && createdBulbasaur.getIv() <= 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatePokemonWithInvalidIndex() {
        pokemonFactory.createPokemon(999, 500, 50, 3000, 2);
    }
}
