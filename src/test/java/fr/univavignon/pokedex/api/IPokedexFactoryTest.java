package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePokedex() {
        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);

        IPokedex result = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        assertNotNull(result);

        verify(pokedexFactory).createPokedex(pokemonMetadataProvider, pokemonFactory);
    }
}
