package PokeServices;

import java.util.List;

import PokeModels.Pokemon;

public interface PokemonService {

	public Pokemon getPokemon(int id);
	public void addPokemon(Pokemon p);
	public List<Pokemon> getAllPokemon();
}
