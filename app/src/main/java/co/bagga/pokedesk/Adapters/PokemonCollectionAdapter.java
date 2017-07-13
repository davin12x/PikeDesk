package co.bagga.pokedesk.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.bagga.pokedesk.Pokemon;
import co.bagga.pokedesk.R;
import co.bagga.pokedesk.ViewHolders.PokemonViewHolder;

/**
 * Created by bagga on 2017-07-13.
 *
 * Adapter represents pokemon collection view cell
 */

public class PokemonCollectionAdapter extends RecyclerView.Adapter<PokemonViewHolder> {
    private ArrayList<Pokemon> pokemonArrayList;

    public PokemonCollectionAdapter(ArrayList<Pokemon> pokemonArrayList) {
        this.pokemonArrayList = pokemonArrayList;
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_cell, parent, false);
        return new PokemonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        holder.updateView(pokemonArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemonArrayList.size();
    }
}
