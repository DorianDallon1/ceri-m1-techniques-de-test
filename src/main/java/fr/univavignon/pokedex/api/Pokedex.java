package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implementation of the {@link IPokedex} interface.
 * The Pokedex is used to manage and store information about Pokemon.
 * It allows adding, retrieving, and listing Pokemon, as well as accessing their metadata.
 *
 * @author fv
 */
public class Pokedex implements IPokedex {

    /** List of Pokemon in the Pokedex. */
    private final List<Pokemon> pokemons;

    /** Metadata provider for accessing Pokemon metadata. */
    private final IPokemonMetadataProvider metadataProvider;

    /** Factory for creating new Pokemon instances. */
    private final IPokemonFactory pokemonFactory;

    /**
     * Constructs a new Pokedex with the specified metadata provider and Pokemon factory.
     *
     * @param metadataProvider The metadata provider to use for retrieving Pokemon metadata.
     * @param pokemonFactory The factory to use for creating new Pokemon instances.
     */
    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
        this.pokemons = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     *
     * @return The number of Pokemon in the Pokedex.
     */
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * {@inheritDoc}
     *
     * @param pokemon The Pokemon to add to the Pokedex.
     * @return The index of the added Pokemon in the Pokedex.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.indexOf(pokemon);
    }

    /**
     * {@inheritDoc}
     *
     * @param id The unique identifier of the Pokemon to retrieve.
     * @return The Pokemon with the specified identifier.
     * @throws PokedexException If the given ID is invalid.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("Invalid Pokemon ID: " + id);
        }
        return pokemons.get(id);
    }

    /**
     * {@inheritDoc}
     *
     * @return An unmodifiable list of all Pokemon in the Pokedex.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    /**
     * {@inheritDoc}
     *
     * @param order The comparator to use for sorting the Pokemon list.
     * @return A sorted, unmodifiable list of Pokemon in the Pokedex.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        if (order != null) {
            sortedPokemons.sort(order);
        }
        return Collections.unmodifiableList(sortedPokemons);
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the Pokemon.
     * @param cp The combat power of the Pokemon.
     * @param hp The hit points of the Pokemon.
     * @param dust The amount of dust required to upgrade the Pokemon.
     * @param candy The amount of candy required to upgrade the Pokemon.
     * @return The created Pokemon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    /**
     * {@inheritDoc}
     *
     * @param index The index of the Pokemon metadata to retrieve.
     * @return The metadata of the Pokemon with the specified index.
     * @throws PokedexException If the given index is invalid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }
}
