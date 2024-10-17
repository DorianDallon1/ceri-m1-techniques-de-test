package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokedexFactoryTest {
    @Mock
    private IPokedexFactory pokedexFactory;
    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider;
    @Mock
    private IPokemonFactory pokemonFactory;
    @Mock
    private IPokedex pokedex;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreatePokedex() {
        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);

        assertEquals(pokedex, pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory));
    }
}
