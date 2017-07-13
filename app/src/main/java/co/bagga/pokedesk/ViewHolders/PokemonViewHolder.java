package co.bagga.pokedesk.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import co.bagga.pokedesk.Pokemon;
import co.bagga.pokedesk.R;

/**
 * Created by bagga on 2017-07-13.
 *
 * Represents Pokemon Cell
 */

public class PokemonViewHolder extends RecyclerView.ViewHolder {
    private ImageView pokemonImage;
    private TextView pokemonNameTextView;

    public PokemonViewHolder(View itemView) {
        super(itemView);
        pokemonImage = itemView.findViewById(R.id.pokemon_image_view);
        pokemonNameTextView = itemView.findViewById(R.id.pokemon_name_textview);
    }

    public void updateView(Pokemon pokemon) {
        pokemonImage.setImageResource(pokemon.getImageView());
        pokemonNameTextView.setText(pokemon.getName());
    }
}
