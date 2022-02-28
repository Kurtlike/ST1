package Unbelievable.hum;

import Unbelievable.hum.AbstractHumanoid;

public class Head {
    private String side;
    public Head(String side, AbstractHumanoid humanoid) {
        this.side = side;
        this.humanoid = humanoid;
    }
    public String getSide() {
        return side;
    }
    public Head(AbstractHumanoid humanoid) {
        this.humanoid = humanoid;
        this.side = "единственная";
    }
    AbstractHumanoid humanoid;
    public void getSmiled(){
        System.out.println(humanoid.name + " улыбнулся");
    }
    public void getSurprised(){
        System.out.println(humanoid.name + " удивился");
    }
    private void getJawDropped(){
        System.out.println("Челюсть "+ humanoid.name + " Отвисла");
    }
}
