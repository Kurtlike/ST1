package Unbelievable.hum;

import java.util.ArrayList;

public class Humanoid extends AbstractHumanoid{
    public Humanoid(String name) {
        super.hands = new ArrayList<>();
        super.heads = new ArrayList<>();
        super.name = name;
        hands.add(new Hand(this, "левая"));
        hands.add(new Hand(this, "правая"));
        heads.add(new Head("левая", this));
        heads.add(new Head("правая", this));
    }
}
