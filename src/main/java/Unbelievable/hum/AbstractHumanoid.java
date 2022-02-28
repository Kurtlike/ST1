package Unbelievable.hum;

import java.util.ArrayList;

public class AbstractHumanoid {
    public AbstractHumanoid(String name, ArrayList<Head> heads, ArrayList<Hand> hands) {
        this.name = name;
        this.heads = heads;
        this.hands = hands;
    }

    public String name;
    public ArrayList<Head> heads;
    public ArrayList<Hand> hands;

    public AbstractHumanoid() {}
}
