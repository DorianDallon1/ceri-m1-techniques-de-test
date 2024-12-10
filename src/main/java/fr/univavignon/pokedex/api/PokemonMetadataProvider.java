package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides metadata for Pokemon based on their index.
 * The metadata includes basic attributes such as the Pokemon's name, attack,
 * defense, and stamina.
 *
 * <p>
 * This implementation uses a predefined map to store metadata for specific
 * Pokemon. Additional Pokemon can be added to the map as needed.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     IPokemonMetadataProvider provider = new PokemonMetadataProvider();
 *     PokemonMetadata metadata = provider.getPokemonMetadata(0);
 *     System.out.println(metadata.getName()); // Output: Bulbasaur
 * </pre>
 * </p>
 *
 * @see PokemonMetadata
 * @see IPokemonMetadataProvider
 * @see PokedexException
 *
 * @author fv
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    /** Map storing metadata for Pokemon, keyed by their index. */
    private final Map<Integer, PokemonMetadata> metadataMap;

    /**
     * Constructs a new {@link PokemonMetadataProvider} instance and initializes
     * the metadata for predefined Pokemon.
     */
    public PokemonMetadataProvider() {
        metadataMap = new HashMap<>();
        initializeMetadata();
    }

    /**
     * Initializes the metadata for predefined Pokemon.
     * This method populates the {@code metadataMap} with data for specific
     * Pokemon, including their index, name, attack, defense, and stamina.
     */
    private void initializeMetadata() {
        metadataMap.put(0, new PokemonMetadata(0, "Bulbasaur", 49, 49, 45));
        metadataMap.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the Pokemon to retrieve metadata for.
     * @return The metadata of the Pokemon with the specified index.
     * @throws PokedexException If the given index is invalid or not found in the metadata.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!metadataMap.containsKey(index)) {
            throw new PokedexException("Invalid Pokemon index: " + index);
        }
        return metadataMap.get(index);
    }
}
