package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {

    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider;

    private PokemonMetadata bulbasaurMetadata;
    private PokemonMetadata aqualiMetadata;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        bulbasaurMetadata = new PokemonMetadata(0, "Bulbasaur", 126,126, 90);
        aqualiMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(bulbasaurMetadata);
        when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(aqualiMetadata);

        assertEquals(bulbasaurMetadata, pokemonMetadataProvider.getPokemonMetadata(0));
        assertEquals(aqualiMetadata, pokemonMetadataProvider.getPokemonMetadata(133));
    }

    @Test
    public void testGetPokemonMetaDataThrowsException() throws PokedexException{
        when(pokemonMetadataProvider.getPokemonMetadata(999)).thenThrow(new PokedexException("invalid index"));
        PokedexException exception = assertThrows(PokedexException.class, () -> {
                pokemonMetadataProvider.getPokemonMetadata(999);
        });

        assertEquals("invalid index", exception.getMessage());
    }
}
