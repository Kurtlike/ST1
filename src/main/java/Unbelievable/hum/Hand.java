package Unbelievable.hum;

import Unbelievable.hum.AbstractHumanoid;

public class Hand {
    public Hand(AbstractHumanoid humanoid, String side) {
        this.humanoid = humanoid;
        this.side = side;
    }
    AbstractHumanoid humanoid;
    public String side;
    public void teethClean(int head){
        if(humanoid.heads.size() <= head){
            System.out.println(side + " рука "+ humanoid.name + " ковыряется в зубах воображаемой головы");
        }
        else {
            System.out.println(side + " рука " + humanoid.name + " ковыряется в зубах " + humanoid.heads.get(head).getSide() + " головы");
        }
    }
}
