package co.bagga.pokedesk.Models;

/**
 * Created by bagga on 2017-07-13.
 */

public class PokemonModel {

    private Evolutions[] evolutions;

    public Evolutions[] getEvolutions() {
        return evolutions;
    }

    public void setEvolutions(Evolutions[] evolutions) {
        this.evolutions = evolutions;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHeight() {
        return height;
    }

    private int attack;
    private int defense;
    private String height;
    private Description[] descriptions;

    public Description[] getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(Description[] descriptions) {
        this.descriptions = descriptions;
    }

    public int getPkdx_id() {
        return pkdx_id;
    }

    public void setPkdx_id(int pkdx_id) {
        this.pkdx_id = pkdx_id;
    }

    private int pkdx_id;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    private String weight;

    private Type types[];

    public Type[] getTypes() {
        return types;
    }

    public void setTypes(Type[] types) {
        this.types = types;
    }

    public static class Type {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Description {
        private String resource_uri;

        public String getResource_uri() {
            return resource_uri;
        }

        public void setResource_uri(String resource_uri) {
            this.resource_uri = resource_uri;
        }
    }

    public static class Evolutions {
        private String to;
        private String detail;

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }
    }
}
