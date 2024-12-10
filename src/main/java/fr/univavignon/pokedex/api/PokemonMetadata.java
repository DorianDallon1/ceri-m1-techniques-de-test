package fr.univavignon.pokedex.api;

/**
 * Represents the metadata of a Pokemon.
 * The metadata includes the Pokemon's index, name, and base statistics such as
 * attack, defense, and stamina levels.
 * This class is immutable and provides a standardized way to access the core
 * attributes of a Pokemon.
 *
 * <p>
 * Example usage:
 * <pre>
 *     PokemonMetadata metadata = new PokemonMetadata(1, "Bulbasaur", 49, 49, 45);
 *     int attack = metadata.getAttack();
 * </pre>
 * </p>
 *
 * @author fv
 */
public class PokemonMetadata {

	/** Index of the Pokemon in the Pokedex. */
	private final int index;

	/** Name of the Pokemon. */
	private final String name;

	/** Base attack level of the Pokemon. */
	private final int attack;

	/** Base defense level of the Pokemon. */
	private final int defense;

	/** Base stamina level of the Pokemon. */
	private final int stamina;

	/**
	 * Constructs a new {@link PokemonMetadata} instance.
	 *
	 * @param index   The index of the Pokemon in the Pokedex.
	 * @param name    The name of the Pokemon.
	 * @param attack  The base attack level of the Pokemon.
	 * @param defense The base defense level of the Pokemon.
	 * @param stamina The base stamina level of the Pokemon.
	 */
	public PokemonMetadata(final int index, final String name, final int attack, final int defense, final int stamina) {
		this.index = index;
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.stamina = stamina;
	}

	/**
	 * Returns the index of the Pokemon in the Pokedex.
	 *
	 * @return The Pokemon index.
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Returns the name of the Pokemon.
	 *
	 * @return The Pokemon name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the base attack level of the Pokemon.
	 *
	 * @return The Pokemon attack level.
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * Returns the base defense level of the Pokemon.
	 *
	 * @return The Pokemon defense level.
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * Returns the base stamina level of the Pokemon.
	 *
	 * @return The Pokemon stamina level.
	 */
	public int getStamina() {
		return stamina;
	}

}
