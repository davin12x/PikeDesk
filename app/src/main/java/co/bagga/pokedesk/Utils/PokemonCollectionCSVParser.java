package co.bagga.pokedesk.Utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import co.bagga.pokedesk.Models.Pokemon;

/**
 * Created by bagga on 2017-07-13.
 *
 *Parser only for pokemon collection
 */

public class PokemonCollectionCSVParser {

    public static ArrayList<Pokemon> parsePokemon(Context context) {
        ArrayList<Pokemon> pokemonArrayList = new ArrayList<>();
        InputStreamReader inputStreamReader;
        String line;
        try {
            inputStreamReader = new InputStreamReader(context.getAssets().open("pokemon.csv"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] pokemon = line.split(",");
                int resourceId = context.getResources().getIdentifier("pokemon_" + pokemon[0] , "drawable", context.getPackageName());
                pokemonArrayList.add(new Pokemon(resourceId, Integer.valueOf(pokemon[0]), pokemon[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pokemonArrayList;
    }
}
