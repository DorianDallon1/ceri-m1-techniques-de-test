package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        try {
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);

            int individualAttack = generateIndividualValue();
            int individualDefense = generateIndividualValue();
            int individualStamina = generateIndividualValue();

            int totalIV = individualAttack + individualDefense + individualStamina;
            double maxIV = 3 * 15;
            double iv = (totalIV / maxIV) * 100;

            return new Pokemon(
                    index,
                    metadata.getName(),
                    metadata.getAttack() + individualAttack,
                    metadata.getDefense() + individualDefense,
                    metadata.getStamina() + individualStamina,
                    cp,
                    hp,
                    dust,
                    candy,
                    iv
            );
        } catch (PokedexException e) {
            throw new IllegalArgumentException("Failed to create Pokemon due to invalid index.", e);
        }
    }

    private int generateIndividualValue() {
        return (int) (Math.random() * 16);
    }
}
