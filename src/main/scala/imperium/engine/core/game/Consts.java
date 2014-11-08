package imperium.engine.core.game;

/*
 * Created by DelavaR on 07.11.2014.
 */
public enum Consts {

    MAP_PATH("maps/map.tmx");

    private String value;

    private Consts(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
