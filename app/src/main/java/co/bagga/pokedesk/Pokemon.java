package co.bagga.pokedesk;

/**
 * Created by bagga on 2017-07-13.
 *
 * Pokemon Model Object
 */

public class Pokemon {
    private int imageView;
    private String name;

    public Pokemon(int imageView, String name) {
        this.imageView = imageView;
        this.name = name;
    }

    public int getImageView() {
        return imageView;
    }

    public String getName() {
        return name;
    }
}
