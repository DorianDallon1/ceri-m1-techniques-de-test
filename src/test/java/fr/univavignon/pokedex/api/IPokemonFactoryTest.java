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

    @Test
    public void testCreatePokemonWithNegativeIndex() {
        // Test pour un Pokémon avec un index négatif (-1 correspond à Ash's Pikachu)
        Pokemon ashPikachu = pokemonFactory.createPokemon(-1, 500, 60, 4000, 3);

        // Vérifiez que le nom est correct
        assertEquals("Ash's Pikachu", ashPikachu.getName());

        // Vérifiez les statistiques spécifiques pour les indices négatifs
        assertEquals(1000, ashPikachu.getAttack());
        assertEquals(1000, ashPikachu.getDefense());
        assertEquals(1000, ashPikachu.getStamina());
        assertEquals(0, ashPikachu.getIv(), 0); // Vérifiez que l'IV est 0

        // Vérifiez les autres valeurs passées en paramètres
        assertEquals(-1, ashPikachu.getIndex());
        assertEquals(500, ashPikachu.getCp());
        assertEquals(60, ashPikachu.getHp());
        assertEquals(4000, ashPikachu.getDust());
        assertEquals(3, ashPikachu.getCandy());
    }
}
