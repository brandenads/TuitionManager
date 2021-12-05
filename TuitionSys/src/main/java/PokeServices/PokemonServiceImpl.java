package PokeServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import PokeDatabase.FakeDB;
import PokeModels.Pokemon;

public class PokemonServiceImpl implements PokemonService{

	@Override
	public Pokemon getPokemon(int id) {
		// TODO Auto-generated method stub
		return FakeDB.pokemonteam.get(id);
	}

	@Override
	public void addPokemon(Pokemon p) {
		// TODO Auto-generated method stub
		FakeDB.pokemonteam.put(p.getId(),p);
		
	}

	@Override
	public List<Pokemon> getAllPokemon() {
		// TODO Auto-generated method stub
		Set<Integer> keys = FakeDB.pokemonteam.keySet();
		List<Pokemon> pokeList = new ArrayList<Pokemon>();
		
		for(Integer key: keys) {
			pokeList.add(FakeDB.pokemonteam.get(key));
		}
		return pokeList;
	}

}
