package co.bagga.pikedesk.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.bagga.pikedesk.Activities.PokemonDetailActivity;
import co.bagga.pikedesk.Constants;
import co.bagga.pikedesk.Models.Pokemon;
import co.bagga.pikedesk.R;
import co.bagga.pikedesk.ViewHolders.PokemonViewHolder;

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
    public void onBindViewHolder(final PokemonViewHolder holder, int position) {
        final Pokemon pokemon = pokemonArrayList.get(position);
        holder.updateView(pokemon);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPokemonDetailActivity(holder.itemView.getContext(), pokemon);
            }
        });
    }

    private void startPokemonDetailActivity(Context context, Pokemon pokemon) {
        Intent i = new Intent(context, PokemonDetailActivity.class);
        i.putExtra(Constants.POKEMON_BUNDLE_ID, pokemon);
        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return 718;
    }
}
