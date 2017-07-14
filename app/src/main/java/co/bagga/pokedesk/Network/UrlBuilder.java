package co.bagga.pokedesk.Network;

public class UrlBuilder {

    public static String getBaseUrl() {
        return "http://pokeapi.co/";
    }

    public static String buildPokeUrlByPokemonId(int id) {
       return getBaseUrl() + "api/v1/pokemon/" + id + "/";
    }
}
