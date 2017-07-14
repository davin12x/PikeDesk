package co.bagga.pokedesk.Activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import co.bagga.pokedesk.Adapters.PokemonCollectionAdapter;
import co.bagga.pokedesk.R;
import co.bagga.pokedesk.Utils.PokemonCollectionCSVParser;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.pokemon_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new PokemonCollectionAdapter(PokemonCollectionCSVParser.parsePokemon(this)));

        setFontToTitle();
    }

    private void setFontToTitle() {
        TextView titleView = (TextView)findViewById(R.id.toolbar_title);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "solid.ttf");
        titleView.setTypeface(custom_font);

    }
}
