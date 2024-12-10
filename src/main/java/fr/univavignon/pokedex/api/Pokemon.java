package fr.univavignon.pokedex.api;

/**
 * Represents a Pokemon, extending its basic metadata with additional details
 * such as combat points (CP), hit points (HP), and evolution requirements.
 * This class is immutable and is a final representation of a Pokemon.
 *
 * <p>
 * Example usage:
 * <pre>
 *     Pokemon pokemon = new Pokemon(1, "Bulbasaur", 49, 49, 45, 300, 100, 2000, 50, 80.0);
 *     int cp = pokemon.getCp();
 * </pre>
 * </p>
 *
 * @see PokemonMetadata
 * @author fv
 */
public final class Pokemon extends PokemonMetadata {

	/** Combat points (CP) of the Pokemon. */
	private final int cp;

	/** Hit points (HP) of the Pokemon. */
	private final int hp;

	/** Stardust required for upgrading the Pokemon. */
	private final int dust;

	/** Candy required for upgrading the Pokemon. */
	private final int candy;

	/** IV perfection percentage of the Pokemon. */
	private final double iv;

	/**
	 * Constructs a new {@link Pokemon} instance.
	 *
	 * @param index   Pokemon index.
	 * @param name    Pokemon name.
	 * @param attack  Pokemon attack level.
	 * @param defense Pokemon defense level.
	 * @param stamina Pokemon stamina level.
	 * @param cp      Combat points (CP) of the Pokemon.
	 * @param hp      Hit points (HP) of the Pokemon.
	 * @param dust    Stardust required for upgrading this Pokemon.
	 * @param candy   Candy required for upgrading this Pokemon.
	 * @param iv      IV perfection percentage of the Pokemon.
	 */
	public Pokemon(
			final int index,
			final String name,
			final int attack,
			final int defense,
			final int stamina,
			final int cp,
			final int hp,
			final int dust,
			final int candy,
			final double iv) {
		super(index, name, attack, defense, stamina);
		this.cp = cp;
		this.hp = hp;
		this.dust = dust;
		this.candy = candy;
		this.iv = iv;
	}

	/**
	 * Returns the combat points (CP) of the Pokemon.
	 *
	 * @return Combat points (CP) of the Pokemon.
	 */
	public int getCp() {
		return cp;
	}

	/**
	 * Returns the hit points (HP) of the Pokemon.
	 *
	 * @return Hit points (HP) of the Pokemon.
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Returns the amount of Stardust required to upgrade the Pokemon.
	 *
	 * @return Stardust required for upgrading the Pokemon.
	 */
	public int getDust() {
		return dust;
	}

	/**
	 * Returns the amount of Candy required to upgrade the Pokemon.
	 *
	 * @return Candy required for upgrading the Pokemon.
	 */
	public int getCandy() {
		return candy;
	}

	/**
	 * Returns the IV perfection percentage of the Pokemon.
	 *
	 * @return IV perfection percentage of the Pokemon.
	 */
	public double getIv() {
		return iv;
	}

}
