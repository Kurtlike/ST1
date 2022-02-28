package Unbelievable.hum;

import java.util.ArrayList;

public class Human extends AbstractHumanoid{
    public Human(String name) {
        super.hands = new ArrayList<>();
        super.heads = new ArrayList<>();
        super.name = name;
        hands.add(new Hand(this, "левая"));
        hands.add(new Hand(this, "правая"));
        heads.add(new Head(this));
    }
}
