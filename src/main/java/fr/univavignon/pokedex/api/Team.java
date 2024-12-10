package fr.univavignon.pokedex.api;

/**
 * Enumeration representing the different teams a Pokemon Trainer can belong to.
 *
 * <p>
 * Each team represents a faction in the Pokemon world, with unique philosophies:
 * </p>
 * <ul>
 *     <li><b>MYSTIC</b>: Focuses on wisdom and evolution.</li>
 *     <li><b>INSTINCT</b>: Values trust in one's instincts.</li>
 *     <li><b>VALOR</b>: Emphasizes strength and courage.</li>
 * </ul>
 *
 * <p>
 * Example usage:
 * <pre>
 *     Team team = Team.MYSTIC;
 *     System.out.println(team); // Output: MYSTIC
 * </pre>
 * </p>
 *
 * @author fv
 */
public enum Team {

	/** Team Mystic: Focused on wisdom and evolution. */
	MYSTIC,

	/** Team Instinct: Values trust in one's instincts. */
	INSTINCT,

	/** Team Valor: Emphasizes strength and courage. */
	VALOR

}
