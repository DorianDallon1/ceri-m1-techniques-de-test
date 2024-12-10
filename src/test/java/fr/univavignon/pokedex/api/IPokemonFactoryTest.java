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
        assertTrue(createdBulbasaur.getAttack() >= 0 && createdBulbasaur.getAttack() <= 15);
        assertTrue(createdBulbasaur.getDefense() >= 0 && createdBulbasaur.getDefense() <= 15);
        assertTrue(createdBulbasaur.getStamina() >= 0 && createdBulbasaur.getStamina() <= 15);
        assertEquals(613, createdBulbasaur.getCp());
        assertEquals(64, createdBulbasaur.getHp());
        assertEquals(4000, createdBulbasaur.getDust());
        assertEquals(3, createdBulbasaur.getCandy());
        assertEquals(1, createdBulbasaur.getIv(), 0);

        Pokemon createdAquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals("Aquali", createdAquali.getName());
        assertEquals(133, createdAquali.getIndex());
        assertTrue(createdAquali.getAttack() >= 0 && createdAquali.getAttack() <= 15);
        assertTrue(createdAquali.getDefense() >= 0 && createdAquali.getDefense() <= 15);
        assertTrue(createdAquali.getStamina() >= 0 && createdAquali.getStamina() <= 15);
        assertEquals(2729, createdAquali.getCp());
        assertEquals(202, createdAquali.getHp());
        assertEquals(5000, createdAquali.getDust());
        assertEquals(4, createdAquali.getCandy());
        assertEquals(1, createdAquali.getIv(), 0);
    }

    @Test
    public void testCreatePokemonWithNegativeIndex() {
        // Test avec un index négatif
        Pokemon createdPokemon = pokemonFactory.createPokemon(-1, 500, 50, 3000, 2);
        assertEquals("Ash's Pikachu", createdPokemon.getName());
        assertEquals(-1, createdPokemon.getIndex());
        assertEquals(1000, createdPokemon.getAttack());
        assertEquals(1000, createdPokemon.getDefense());
        assertEquals(1000, createdPokemon.getStamina());
        assertEquals(500, createdPokemon.getCp());
        assertEquals(50, createdPokemon.getHp());
        assertEquals(3000, createdPokemon.getDust());
        assertEquals(2, createdPokemon.getCandy());
        assertEquals(0, createdPokemon.getIv(), 0);
    }

    @Test
    public void testCreatePokemonWithInvalidIndex() {
        // Test avec un index inconnu dans index2name
        Pokemon createdPokemon = pokemonFactory.createPokemon(999, 500, 50, 3000, 2);
        assertEquals("MISSINGNO", createdPokemon.getName());
        assertEquals(999, createdPokemon.getIndex());
        assertTrue(createdPokemon.getAttack() >= 0 && createdPokemon.getAttack() <= 15);
        assertTrue(createdPokemon.getDefense() >= 0 && createdPokemon.getDefense() <= 15);
        assertTrue(createdPokemon.getStamina() >= 0 && createdPokemon.getStamina() <= 15);
    }

    @Test
    public void testPerformanceGenerateRandomStat() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            PokemonFactory.generateRandomStat();
        }
        long elapsedTime = System.currentTimeMillis() - startTime;

        // Assurez-vous que la méthode ne prend pas trop de temps
        assertTrue("Performance issue in generateRandomStat()", elapsedTime < 1000);
    }

    @Test
    public void testCreatePokemonWithBoundaryIndices() {
        // Test avec l'indice 0 (MISSINGNO)
        Pokemon missingNo = pokemonFactory.createPokemon(0, 100, 10, 1000, 1);
        assertEquals("MISSINGNO", missingNo.getName());
        assertEquals(0, missingNo.getIndex());

        // Test avec un indice très élevé
        Pokemon unknown = pokemonFactory.createPokemon(Integer.MAX_VALUE, 200, 20, 2000, 2);
        assertEquals("MISSINGNO", unknown.getName());
        assertEquals(Integer.MAX_VALUE, unknown.getIndex());
    }
}
