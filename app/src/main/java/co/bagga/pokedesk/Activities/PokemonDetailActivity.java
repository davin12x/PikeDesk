package co.bagga.pokedesk.Activities;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

import co.bagga.pokedesk.Constants;
import co.bagga.pokedesk.Models.Pokemon;
import co.bagga.pokedesk.Models.PokemonDescription;
import co.bagga.pokedesk.Network.HttpCallBack;
import co.bagga.pokedesk.Network.RequestGenerator;
import co.bagga.pokedesk.Models.PokemonModel;
import co.bagga.pokedesk.R;
import co.bagga.pokedesk.Utils.PokemonCollectionCSVParser;

public class PokemonDetailActivity extends AppCompatActivity {
    private ImageView currentPokemon, evolutionPokemonImageView;
    private TextView pokemonDesc, pokeType, pokeDefense, height, weight, id, baseAttack, evolutionName;
    private Pokemon selectedPokemon;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);
        prepareView();
        if (getIntent().hasExtra(Constants.POKEMON_BUNDLE_ID)) {
            selectedPokemon = (Pokemon) getIntent().getSerializableExtra(Constants.POKEMON_BUNDLE_ID);
            currentPokemon.setImageResource(selectedPokemon.getImageView());
            generateSelectedPokemon(selectedPokemon.getId());
        } else {
            throw new RuntimeException("Must pass id");
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(selectedPokemon.getName().toUpperCase());
        }
    }

    private void prepareView() {
        currentPokemon = (ImageView)findViewById(R.id.current_pokemon_image);
        evolutionPokemonImageView = (ImageView)findViewById(R.id.evolution_image_view);
        pokemonDesc = (TextView)findViewById(R.id.pokiDesc);
        pokeType = (TextView)findViewById(R.id.poke_type);
        pokeDefense = (TextView)findViewById(R.id.poke_defense);
        height = (TextView)findViewById(R.id.poke_height);
        weight = (TextView)findViewById(R.id.poke_weight);
        id = (TextView)findViewById(R.id.id);
        baseAttack = (TextView)findViewById(R.id.attack);
        evolutionName = (TextView)findViewById(R.id.evolution_name);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
    }

    private void generateSelectedPokemon(int id) {
        RequestGenerator.getInstance(this).generatePokemonIdentityRequest(id, new HttpCallBack() {
            @Override
            public void onHttpRequestSuccess(String response, int responseCode) {
                PokemonModel pokemonModel = new Gson().fromJson(response, PokemonModel.class);
                fetchPokemonDescription(pokemonModel);
                updateView(pokemonModel);
            }

            @Override
            public void onHttpRequestError(String response, int responseCode) {
            }
        });
    }

    private void fetchPokemonDescription(PokemonModel pokemonModel) {
        String url = pokemonModel.getDescriptions()[0].getResource_uri();
        RequestGenerator.getInstance(this).generatePokemonDescriptionByUrl(url, new HttpCallBack() {
            @Override
            public void onHttpRequestSuccess(String response, int responseCode) {
                PokemonDescription pokemonDescription =  new Gson().fromJson(response, PokemonDescription.class);
                pokemonDesc.setText(pokemonDescription.getDescription());
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onHttpRequestError(String response, int responseCode) {

            }
        });
    }

    private void updateView(PokemonModel pokemonModel) {
        pokeDefense.setText(String.valueOf(pokemonModel.getDefense()));
        height.setText(pokemonModel.getHeight());
        weight.setText(pokemonModel.getWeight());
        baseAttack.setText(String.valueOf(pokemonModel.getAttack()));
        StringBuilder pokeTypeBuffer = new StringBuilder();
        for (PokemonModel.Type type:pokemonModel.getTypes()) {
            pokeTypeBuffer.append(type.getName()).append("/");
        }
        pokeType.setText(pokeTypeBuffer.toString());
        id.setText(String.valueOf(pokemonModel.getPkdx_id()));
        ArrayList<Pokemon> pokemonArrayList = PokemonCollectionCSVParser.parsePokemon(getApplicationContext());
        for (Pokemon pokemon: pokemonArrayList) {
            if (pokemonModel.getEvolutions() != null && pokemonModel.getEvolutions().length >= 1
                    &&  pokemon.getName().toLowerCase().equals(pokemonModel.getEvolutions()[0].getTo().toLowerCase())) {
                evolutionName.setText(pokemon.getName().toUpperCase());
                if (pokemonModel.getEvolutions()[0].getDetail() != null && pokemonModel.getEvolutions()[0].getDetail().equals("mega")) {
                    evolutionName.setText("No Evolution");
                } else {
                    evolutionPokemonImageView.setImageResource(pokemon.getImageView());
                    evolutionName.setText(pokemon.getName().toUpperCase());
                }

            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
