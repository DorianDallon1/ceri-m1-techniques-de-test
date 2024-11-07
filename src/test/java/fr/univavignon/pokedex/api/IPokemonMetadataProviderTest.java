package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;
    private PokemonMetadata metadataSample;

    @Before
    public void setUp() {
        // Création d'un mock de IPokemonMetadataProvider
        metadataProvider = mock(IPokemonMetadataProvider.class);

        // Exemples de données pour un Pokémon fictif
        metadataSample = new PokemonMetadata(1, "Bulbasaur", 49, 49, 45);

        // Configuration du comportement du mock
        try {
            when(metadataProvider.getPokemonMetadata(1)).thenReturn(metadataSample);
            when(metadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Index invalide"));
            when(metadataProvider.getPokemonMetadata(999)).thenThrow(new PokedexException("Index hors limites"));
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPokemonMetadataValidIndex() {
        try {
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(1);
            assertNotNull("La métadonnée du Pokémon ne doit pas être nulle", metadata);
            assertEquals(1, metadata.getIndex());
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
            assertEquals("Index invalide", e.getMessage());
        }
    }

    @Test
    public void testGetPokemonMetadataOutOfBoundsIndex() {
        try {
            metadataProvider.getPokemonMetadata(999);
            fail("Une PokedexException doit être lancée pour un index hors limites.");
        } catch (PokedexException e) {
            assertEquals("Index hors limites", e.getMessage());
        }
    }

    @Test
    public void testGetPokemonMetadataEdgeCases() {
        // Si l'implémentation a des index valides entre 0 et 150 par exemple, nous testons les limites
        try {
            when(metadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "EdgeCaseZero", 50, 50, 50));
            when(metadataProvider.getPokemonMetadata(150)).thenReturn(new PokemonMetadata(150, "EdgeCaseMax", 100, 100, 100));

            PokemonMetadata metadataLow = metadataProvider.getPokemonMetadata(0);
            assertNotNull(metadataLow);
            assertEquals(0, metadataLow.getIndex());
            assertEquals("EdgeCaseZero", metadataLow.getName());

            PokemonMetadata metadataHigh = metadataProvider.getPokemonMetadata(150);
            assertNotNull(metadataHigh);
            assertEquals(150, metadataHigh.getIndex());
            assertEquals("EdgeCaseMax", metadataHigh.getName());
        } catch (PokedexException e) {
            fail("Aucune exception ne doit être lancée pour les cas aux limites valides.");
        }
    }
}
