package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {

    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider;

    private PokemonMetadata bulbasaurMetadata;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
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

    @Test
    public void testGetPokemonMetaDataThrowsException() throws PokedexException{
        when(pokemonMetadataProvider.getPokemonMetadata(999)).thenThrow(new PokedexException("invalid index"));
        PokedexException exception = assertThrows(PokedexException.class, () -> {
                pokemonMetadataProvider.getPokemonMetadata(999);
        });

        assertEquals("invalid index", exception.getMessage());
    }
}
