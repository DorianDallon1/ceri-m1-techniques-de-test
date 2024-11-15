package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        metadataProvider = new PokemonMetadataProvider();

    }

    @Test
    public void testGetPokemonMetadataValidIndex() {
        try {
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(0);
            assertNotNull("La métadonnée du Pokémon ne doit pas être nulle", metadata);
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
    public void testGetPokemonMetadataInvalidIndex() {
        try {
            metadataProvider.getPokemonMetadata(-1);
            fail("Une PokedexException doit être lancée pour un index invalide.");
        } catch (PokedexException e) {
            assertEquals("Invalid Pokemon index: -1", e.getMessage());
        }
    }

    @Test
    public void testGetPokemonMetadataOutOfBoundsIndex() {
        try {
            metadataProvider.getPokemonMetadata(999);
            fail("Une PokedexException doit être lancée pour un index hors limites.");
        } catch (PokedexException e) {
            assertEquals("Invalid Pokemon index: 999", e.getMessage());
        }
    }

    @Test
    public void testGetPokemonMetadataEdgeCases() {
        try {
            PokemonMetadata metadataLow = metadataProvider.getPokemonMetadata(0);
            assertNotNull(metadataLow);
            assertEquals(0, metadataLow.getIndex());
            assertEquals("Bulbasaur", metadataLow.getName());

            PokemonMetadata metadataHigh = metadataProvider.getPokemonMetadata(133);
            assertNotNull(metadataHigh);
            assertEquals(133, metadataHigh.getIndex());
            assertEquals("Aquali", metadataHigh.getName());
        } catch (PokedexException e) {
            fail("Aucune exception ne doit être lancée pour les cas aux limites valides.");
        }
    }
}
