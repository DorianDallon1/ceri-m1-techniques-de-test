package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {
    @Mock
    private IPokemonFactory pokemonFactory;

    private Pokemon bulbasaur;
    private Pokemon aquali;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 3, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);
    }

    @Test
    public void testCreatePokemon() {
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 3)).thenReturn(bulbasaur);
        when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);

        // Vérification pour Bulbasaur
        Pokemon createdBulbasaur = pokemonFactory.createPokemon(0, 613, 64, 4000, 3);
        assertEquals("Bulbasaur", createdBulbasaur.getName());
        assertEquals(0, createdBulbasaur.getIndex());
        assertEquals(126, createdBulbasaur.getAttack());
        assertEquals(126, createdBulbasaur.getDefense());
        assertEquals(90, createdBulbasaur.getStamina());
        assertEquals(613, createdBulbasaur.getCp());
        assertEquals(64, createdBulbasaur.getHp());
        assertEquals(4000, createdBulbasaur.getDust());
        assertEquals(3, createdBulbasaur.getCandy());
        assertEquals(56.0, createdBulbasaur.getIv(), 0.001);

        // Vérification pour Aquali
        Pokemon createdAquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        assertEquals("Aquali", createdAquali.getName());
        assertEquals(133, createdAquali.getIndex());
        assertEquals(186, createdAquali.getAttack());
        assertEquals(168, createdAquali.getDefense());
        assertEquals(260, createdAquali.getStamina());
        assertEquals(2729, createdAquali.getCp());
        assertEquals(202, createdAquali.getHp());
        assertEquals(5000, createdAquali.getDust());
        assertEquals(4, createdAquali.getCandy());
        assertEquals(100.0, createdAquali.getIv(), 0.001);
    }
}
