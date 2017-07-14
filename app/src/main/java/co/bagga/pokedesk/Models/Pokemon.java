package co.bagga.pokedesk.Models;

import java.io.Serializable;

/**
 * Created by bagga on 2017-07-13.
 *
 * Pokemon Model Object
 */

public class Pokemon implements Serializable{
    private int imageView;
    private String name;
    private int id;

    public Pokemon(int imageView, int id, String name) {
        this.imageView = imageView;
        this.name = name;
        this.id = id;
    }

    public int getImageView() {
        return imageView;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
