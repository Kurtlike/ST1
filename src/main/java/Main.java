import Unbelievable.hum.AbstractHumanoid;
import Unbelievable.hum.Human;
import Unbelievable.hum.Humanoid;
import Unbelievable.ship.SpaceShip;
import fibonacci.FibHeap;
import fibonacci.Node;

public class Main {
    public static void main(String[] args) {
        AbstractHumanoid captain = new Humanoid("Неизвестный");
        AbstractHumanoid artur = new Human("Артур");
        SpaceShip ship = new SpaceShip(captain, 100, 30,30);

        captain.hands.get(1).teethClean(1);
        captain.heads.get(0).getSmiled();
        artur.heads.get(0).getSurprised();
    }
}
