package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokedexFactoryTest {
    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider pokemonMetadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokedexFactory = new PokedexFactory();
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        assertNotNull(pokedex);
        assertTrue(pokedex instanceof Pokedex);
    }
}
