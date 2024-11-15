package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokedexTest {
    private IPokedex pokedex;
    private Pokemon bulbasaur;
    private Pokemon aquali;
//
    @Before
    public void setUp() {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
        bulbasaur = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 3, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);
    }

    @Test
    public void testAddPokemon() {
        assertEquals(0, pokedex.addPokemon(bulbasaur));
        assertEquals(1, pokedex.addPokemon(aquali));
    }
    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(bulbasaur);
        assertEquals(1, pokedex.size());
        pokedex.addPokemon(aquali);
        assertEquals(2, pokedex.size());
    }
    @Test
    public void testGetPokemon() throws PokedexException {
        pokedex.addPokemon(bulbasaur);
        pokedex.addPokemon(aquali);
        assertEquals(bulbasaur, pokedex.getPokemon(0));
        assertEquals(aquali, pokedex.getPokemon(1));
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonThrowsExceptionForInvalidId() throws PokedexException {
        pokedex.getPokemon(-1);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonThrowsExceptionForOutOfBoundsId() throws PokedexException {
        pokedex.addPokemon(bulbasaur);
        pokedex.getPokemon(1); // Index hors limites
    }

    @Test
    public void testGetPokemons() {
        pokedex.addPokemon(bulbasaur);
        pokedex.addPokemon(aquali);

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(Arrays.asList(bulbasaur, aquali), pokemons);
        assertEquals(2, pokemons.size());
        assertEquals("Bulbasaur", pokemons.get(0).getName());
        assertEquals("Aquali", pokemons.get(1).getName());
    }

    @Test
    public void testCreatePokemon() {
        Pokemon createdPokemon = pokedex.createPokemon(0, 613, 64, 4000, 3);
        assertNotNull(createdPokemon);
        assertEquals("Bulbasaur", createdPokemon.getName());
        assertEquals(0, createdPokemon.getIndex());
        assertTrue(createdPokemon.getAttack() >= 49 && createdPokemon.getAttack() <= 64);
        assertTrue(createdPokemon.getDefense() >= 49 && createdPokemon.getDefense() <= 64);
        assertTrue(createdPokemon.getStamina() >= 45 && createdPokemon.getStamina() <= 60);
    }

    @Test
    public void testGetPokemonMetadata() {
        try {
            PokemonMetadata metadata = pokedex.getPokemonMetadata(0);
            assertNotNull(metadata);
            assertEquals(0, metadata.getIndex());
            assertEquals("Bulbasaur", metadata.getName());
            assertEquals(49, metadata.getAttack());
            assertEquals(49, metadata.getDefense());
            assertEquals(45, metadata.getStamina());
        } catch (PokedexException e) {
            fail("Aucune exception ne doit être lancée pour un index valide.");
        }
    }

    @Test
    public void testGetPokemonsWithCustomOrder() {
        pokedex.addPokemon(aquali);
        pokedex.addPokemon(bulbasaur);

        List<Pokemon> sortedPokemons = pokedex.getPokemons(Comparator.comparingInt(Pokemon::getCp).reversed());
        assertEquals(Arrays.asList(aquali, bulbasaur), sortedPokemons);
    }

    @Test
    public void testGetPokemonsWithDefaultOrder() {
        pokedex.addPokemon(aquali);
        pokedex.addPokemon(bulbasaur);

        List<Pokemon> defaultOrderPokemons = pokedex.getPokemons(null);
        assertEquals(Arrays.asList(aquali, bulbasaur), defaultOrderPokemons);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        pokedex.getPokemonMetadata(999);
    }
}
