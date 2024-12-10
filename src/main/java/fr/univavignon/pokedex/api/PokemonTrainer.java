package fr.univavignon.pokedex.api;

/**
 * Represents a Pokemon Trainer in the application.
 * A trainer has a name, belongs to a specific team, and possesses a Pokedex
 * containing information about captured Pokemon.
 *
 * <p>
 * Example usage:
 * <pre>
 *     Team team = Team.MYSTIC;
 *     IPokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);
 *     PokemonTrainer trainer = new PokemonTrainer("Ash", team, pokedex);
 *     System.out.println(trainer.getName()); // Output: Ash
 * </pre>
 * </p>
 *
 * @see Team
 * @see IPokedex
 * @author fv
 */
public class PokemonTrainer {

	/** The name of the trainer. */
	private final String name;

	/** The team to which the trainer belongs. */
	private final Team team;

	/** The Pokedex associated with the trainer. */
	private final IPokedex pokedex;

	/**
	 * Constructs a new {@link PokemonTrainer} instance with the specified name,
	 * team, and Pokedex.
	 *
	 * @param name    The name of the trainer.
	 * @param team    The team to which the trainer belongs.
	 * @param pokedex The Pokedex associated with the trainer.
	 */
	public PokemonTrainer(final String name, final Team team, final IPokedex pokedex) {
		this.name = name;
		this.team = team;
		this.pokedex = pokedex;
	}

	/**
	 * Returns the name of the trainer.
	 *
	 * @return The trainer's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the team to which the trainer belongs.
	 *
	 * @return The trainer's team.
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * Returns the Pokedex associated with the trainer.
	 *
	 * @return The trainer's Pokedex.
	 */
	public IPokedex getPokedex() {
		return pokedex;
	}
}
