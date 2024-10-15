package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {

    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider;

    private PokemonMetadata bulbasaurMetadata;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        bulbasaurMetadata = new PokemonMetadata(0, "Bulbasaur", 126,126, 90);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(bulbasaurMetadata);

        PokemonMetadata result = pokemonMetadataProvider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals("Bulbasaur", result.getName());
        assertEquals(126, result.getAttack());
        assertEquals(126, result.getDefense());
        assertEquals(90, result.getStamina());

        verify(pokemonMetadataProvider).getPokemonMetadata(0);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetaDataThrowsException() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(999)).thenThrow(new PokedexException("invalid index"));
        pokemonMetadataProvider.getPokemonMetadata(999);
    }
}
