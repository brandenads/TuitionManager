package PokeDatabase;

import java.util.HashMap;
import java.util.Map;

import PokeModels.Pokemon;

public class FakeDB {
	
	public static Map<Integer, Pokemon> pokemonteam = new HashMap<Integer,Pokemon>();

	static {
		
		Pokemon p1 = new Pokemon(1,"Bulbasaur","Grass/Poision");
		Pokemon p2 = new Pokemon(2,"Pikachu","Electric");
		Pokemon p3 = new Pokemon(3,"Jygglypuff","Fairy");
		
		pokemonteam.put(p1.getId(), p1);
		pokemonteam.put(p2.getId(), p2);
		pokemonteam.put(p3.getId(), p3);
		
		
	}
}
